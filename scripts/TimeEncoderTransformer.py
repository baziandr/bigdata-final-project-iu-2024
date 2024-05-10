from pyspark import keyword_only
from pyspark.ml import Transformer
from pyspark.ml.param.shared import HasInputCol, HasOutputCol, Param, Params, TypeConverters
from pyspark.ml.util import DefaultParamsReadable, DefaultParamsWritable
from pyspark.sql import DataFrame
from pyspark.sql.types import DoubleType
import pyspark.sql.functions as F
import math


class TimeEncoderTransformer(
    Transformer,
    HasInputCol,
    HasOutputCol,
    DefaultParamsReadable,
    DefaultParamsWritable
):
    input_col = Param(
        Params._dummy(),
        "input_col",
        "input column name.",
        typeConverter=TypeConverters.toString
    )
    output_col_sin = Param(
        Params._dummy(),
        "output_col_sin",
        "output column name for sin wave.",
        typeConverter=TypeConverters.toString
    )
    output_col_cos = Param(
        Params._dummy(),
        "output_col_cos",
        "output column name for cos wave.",
        typeConverter=TypeConverters.toString
    )
    timestamp_part = Param(
        Params._dummy(),
        "timestamp_part",
        "part of the timestamp like month, day, hour, minute",
        typeConverter=TypeConverters.toString
    )

    @keyword_only
    def __init__(
        self,
        input_col: str = "input",
        output_col_sin: str = "sin",
        output_col_cos: str = "cos",
        timestamp_part: str = "month"
    ):
        super(TimeEncoderTransformer, self).__init__()
        self._setDefault(
            input_col=None,
            output_col_sin=None,
            output_col_cos=None,
            timestamp_part=None
        )
        kwargs = self._input_kwargs
        self.set_params(**kwargs)

    @keyword_only
    def set_params(
        self,
        input_col: str = "input",
        output_col_sin: str = "sin",
        output_col_cos: str = "cos",
        timestamp_part: str = "month"
    ):
        kwargs = self._input_kwargs
        self._set(**kwargs)

    def get_input_col(self):
        return self.getOrDefault(self.input_col)

    def get_output_col_sin(self):
        return self.getOrDefault(self.output_col_sin)

    def get_output_col_cos(self):
        return self.getOrDefault(self.output_col_cos)

    def get_timestamp_part(self):
        return self.getOrDefault(self.timestamp_part)

    def _transform(self, df: DataFrame):
        input_col = self.get_input_col()
        output_col_sin = self.get_output_col_sin()
        output_col_cos = self.get_output_col_cos()
        timestamp_part = self.get_timestamp_part()

        if timestamp_part == 'month':
            denominator = 12
        elif timestamp_part == 'day':
            denominator = 31
        elif timestamp_part in ['hour', 'minute']:
            denominator = 60
        else:
            raise Exception()

        sin_udf = F.udf(
            lambda x: math.sin(2 * math.pi * x / denominator),
            DoubleType()
        )
        cos_udf = F.udf(
            lambda x: math.cos(2 * math.pi * x / denominator),
            DoubleType()
        )

        df = df.withColumn(output_col_sin, sin_udf(F.col(input_col)))
        df = df.withColumn(output_col_cos, cos_udf(F.col(input_col)))

        return df
