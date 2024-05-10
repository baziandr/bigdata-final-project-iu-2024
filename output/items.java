// ORM class for table 'items'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Wed May 08 21:42:13 MSK 2024
// For connector: org.apache.sqoop.manager.PostgresqlManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import org.apache.sqoop.lib.JdbcWritableBridge;
import org.apache.sqoop.lib.DelimiterSet;
import org.apache.sqoop.lib.FieldFormatter;
import org.apache.sqoop.lib.RecordParser;
import org.apache.sqoop.lib.BooleanParser;
import org.apache.sqoop.lib.BlobRef;
import org.apache.sqoop.lib.ClobRef;
import org.apache.sqoop.lib.LargeObjectLoader;
import org.apache.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class items extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("itemid", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        items.this.itemid = (Integer)value;
      }
    });
    setters.put("shopid", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        items.this.shopid = (Integer)value;
      }
    });
    setters.put("item_name", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        items.this.item_name = (String)value;
      }
    });
    setters.put("item_description", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        items.this.item_description = (String)value;
      }
    });
    setters.put("item_variation", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        items.this.item_variation = (String)value;
      }
    });
    setters.put("price", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        items.this.price = (Double)value;
      }
    });
    setters.put("stock", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        items.this.stock = (Integer)value;
      }
    });
    setters.put("category", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        items.this.category = (String)value;
      }
    });
    setters.put("cb_option", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        items.this.cb_option = (Boolean)value;
      }
    });
    setters.put("is_preferred", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        items.this.is_preferred = (Boolean)value;
      }
    });
    setters.put("sold_count", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        items.this.sold_count = (Integer)value;
      }
    });
    setters.put("item_creation_date", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        items.this.item_creation_date = (java.sql.Timestamp)value;
      }
    });
  }
  public items() {
    init0();
  }
  private Integer itemid;
  public Integer get_itemid() {
    return itemid;
  }
  public void set_itemid(Integer itemid) {
    this.itemid = itemid;
  }
  public items with_itemid(Integer itemid) {
    this.itemid = itemid;
    return this;
  }
  private Integer shopid;
  public Integer get_shopid() {
    return shopid;
  }
  public void set_shopid(Integer shopid) {
    this.shopid = shopid;
  }
  public items with_shopid(Integer shopid) {
    this.shopid = shopid;
    return this;
  }
  private String item_name;
  public String get_item_name() {
    return item_name;
  }
  public void set_item_name(String item_name) {
    this.item_name = item_name;
  }
  public items with_item_name(String item_name) {
    this.item_name = item_name;
    return this;
  }
  private String item_description;
  public String get_item_description() {
    return item_description;
  }
  public void set_item_description(String item_description) {
    this.item_description = item_description;
  }
  public items with_item_description(String item_description) {
    this.item_description = item_description;
    return this;
  }
  private String item_variation;
  public String get_item_variation() {
    return item_variation;
  }
  public void set_item_variation(String item_variation) {
    this.item_variation = item_variation;
  }
  public items with_item_variation(String item_variation) {
    this.item_variation = item_variation;
    return this;
  }
  private Double price;
  public Double get_price() {
    return price;
  }
  public void set_price(Double price) {
    this.price = price;
  }
  public items with_price(Double price) {
    this.price = price;
    return this;
  }
  private Integer stock;
  public Integer get_stock() {
    return stock;
  }
  public void set_stock(Integer stock) {
    this.stock = stock;
  }
  public items with_stock(Integer stock) {
    this.stock = stock;
    return this;
  }
  private String category;
  public String get_category() {
    return category;
  }
  public void set_category(String category) {
    this.category = category;
  }
  public items with_category(String category) {
    this.category = category;
    return this;
  }
  private Boolean cb_option;
  public Boolean get_cb_option() {
    return cb_option;
  }
  public void set_cb_option(Boolean cb_option) {
    this.cb_option = cb_option;
  }
  public items with_cb_option(Boolean cb_option) {
    this.cb_option = cb_option;
    return this;
  }
  private Boolean is_preferred;
  public Boolean get_is_preferred() {
    return is_preferred;
  }
  public void set_is_preferred(Boolean is_preferred) {
    this.is_preferred = is_preferred;
  }
  public items with_is_preferred(Boolean is_preferred) {
    this.is_preferred = is_preferred;
    return this;
  }
  private Integer sold_count;
  public Integer get_sold_count() {
    return sold_count;
  }
  public void set_sold_count(Integer sold_count) {
    this.sold_count = sold_count;
  }
  public items with_sold_count(Integer sold_count) {
    this.sold_count = sold_count;
    return this;
  }
  private java.sql.Timestamp item_creation_date;
  public java.sql.Timestamp get_item_creation_date() {
    return item_creation_date;
  }
  public void set_item_creation_date(java.sql.Timestamp item_creation_date) {
    this.item_creation_date = item_creation_date;
  }
  public items with_item_creation_date(java.sql.Timestamp item_creation_date) {
    this.item_creation_date = item_creation_date;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof items)) {
      return false;
    }
    items that = (items) o;
    boolean equal = true;
    equal = equal && (this.itemid == null ? that.itemid == null : this.itemid.equals(that.itemid));
    equal = equal && (this.shopid == null ? that.shopid == null : this.shopid.equals(that.shopid));
    equal = equal && (this.item_name == null ? that.item_name == null : this.item_name.equals(that.item_name));
    equal = equal && (this.item_description == null ? that.item_description == null : this.item_description.equals(that.item_description));
    equal = equal && (this.item_variation == null ? that.item_variation == null : this.item_variation.equals(that.item_variation));
    equal = equal && (this.price == null ? that.price == null : this.price.equals(that.price));
    equal = equal && (this.stock == null ? that.stock == null : this.stock.equals(that.stock));
    equal = equal && (this.category == null ? that.category == null : this.category.equals(that.category));
    equal = equal && (this.cb_option == null ? that.cb_option == null : this.cb_option.equals(that.cb_option));
    equal = equal && (this.is_preferred == null ? that.is_preferred == null : this.is_preferred.equals(that.is_preferred));
    equal = equal && (this.sold_count == null ? that.sold_count == null : this.sold_count.equals(that.sold_count));
    equal = equal && (this.item_creation_date == null ? that.item_creation_date == null : this.item_creation_date.equals(that.item_creation_date));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof items)) {
      return false;
    }
    items that = (items) o;
    boolean equal = true;
    equal = equal && (this.itemid == null ? that.itemid == null : this.itemid.equals(that.itemid));
    equal = equal && (this.shopid == null ? that.shopid == null : this.shopid.equals(that.shopid));
    equal = equal && (this.item_name == null ? that.item_name == null : this.item_name.equals(that.item_name));
    equal = equal && (this.item_description == null ? that.item_description == null : this.item_description.equals(that.item_description));
    equal = equal && (this.item_variation == null ? that.item_variation == null : this.item_variation.equals(that.item_variation));
    equal = equal && (this.price == null ? that.price == null : this.price.equals(that.price));
    equal = equal && (this.stock == null ? that.stock == null : this.stock.equals(that.stock));
    equal = equal && (this.category == null ? that.category == null : this.category.equals(that.category));
    equal = equal && (this.cb_option == null ? that.cb_option == null : this.cb_option.equals(that.cb_option));
    equal = equal && (this.is_preferred == null ? that.is_preferred == null : this.is_preferred.equals(that.is_preferred));
    equal = equal && (this.sold_count == null ? that.sold_count == null : this.sold_count.equals(that.sold_count));
    equal = equal && (this.item_creation_date == null ? that.item_creation_date == null : this.item_creation_date.equals(that.item_creation_date));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.itemid = JdbcWritableBridge.readInteger(1, __dbResults);
    this.shopid = JdbcWritableBridge.readInteger(2, __dbResults);
    this.item_name = JdbcWritableBridge.readString(3, __dbResults);
    this.item_description = JdbcWritableBridge.readString(4, __dbResults);
    this.item_variation = JdbcWritableBridge.readString(5, __dbResults);
    this.price = JdbcWritableBridge.readDouble(6, __dbResults);
    this.stock = JdbcWritableBridge.readInteger(7, __dbResults);
    this.category = JdbcWritableBridge.readString(8, __dbResults);
    this.cb_option = JdbcWritableBridge.readBoolean(9, __dbResults);
    this.is_preferred = JdbcWritableBridge.readBoolean(10, __dbResults);
    this.sold_count = JdbcWritableBridge.readInteger(11, __dbResults);
    this.item_creation_date = JdbcWritableBridge.readTimestamp(12, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.itemid = JdbcWritableBridge.readInteger(1, __dbResults);
    this.shopid = JdbcWritableBridge.readInteger(2, __dbResults);
    this.item_name = JdbcWritableBridge.readString(3, __dbResults);
    this.item_description = JdbcWritableBridge.readString(4, __dbResults);
    this.item_variation = JdbcWritableBridge.readString(5, __dbResults);
    this.price = JdbcWritableBridge.readDouble(6, __dbResults);
    this.stock = JdbcWritableBridge.readInteger(7, __dbResults);
    this.category = JdbcWritableBridge.readString(8, __dbResults);
    this.cb_option = JdbcWritableBridge.readBoolean(9, __dbResults);
    this.is_preferred = JdbcWritableBridge.readBoolean(10, __dbResults);
    this.sold_count = JdbcWritableBridge.readInteger(11, __dbResults);
    this.item_creation_date = JdbcWritableBridge.readTimestamp(12, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(itemid, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(shopid, 2 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(item_name, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(item_description, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(item_variation, 5 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeDouble(price, 6 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeInteger(stock, 7 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(category, 8 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBoolean(cb_option, 9 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeBoolean(is_preferred, 10 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeInteger(sold_count, 11 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeTimestamp(item_creation_date, 12 + __off, 93, __dbStmt);
    return 12;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(itemid, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(shopid, 2 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(item_name, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(item_description, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(item_variation, 5 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeDouble(price, 6 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeInteger(stock, 7 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(category, 8 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBoolean(cb_option, 9 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeBoolean(is_preferred, 10 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeInteger(sold_count, 11 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeTimestamp(item_creation_date, 12 + __off, 93, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.itemid = null;
    } else {
    this.itemid = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.shopid = null;
    } else {
    this.shopid = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.item_name = null;
    } else {
    this.item_name = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.item_description = null;
    } else {
    this.item_description = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.item_variation = null;
    } else {
    this.item_variation = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.price = null;
    } else {
    this.price = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.stock = null;
    } else {
    this.stock = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.category = null;
    } else {
    this.category = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.cb_option = null;
    } else {
    this.cb_option = Boolean.valueOf(__dataIn.readBoolean());
    }
    if (__dataIn.readBoolean()) { 
        this.is_preferred = null;
    } else {
    this.is_preferred = Boolean.valueOf(__dataIn.readBoolean());
    }
    if (__dataIn.readBoolean()) { 
        this.sold_count = null;
    } else {
    this.sold_count = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.item_creation_date = null;
    } else {
    this.item_creation_date = new Timestamp(__dataIn.readLong());
    this.item_creation_date.setNanos(__dataIn.readInt());
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.itemid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.itemid);
    }
    if (null == this.shopid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.shopid);
    }
    if (null == this.item_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, item_name);
    }
    if (null == this.item_description) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, item_description);
    }
    if (null == this.item_variation) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, item_variation);
    }
    if (null == this.price) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.price);
    }
    if (null == this.stock) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.stock);
    }
    if (null == this.category) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, category);
    }
    if (null == this.cb_option) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.cb_option);
    }
    if (null == this.is_preferred) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.is_preferred);
    }
    if (null == this.sold_count) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.sold_count);
    }
    if (null == this.item_creation_date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.item_creation_date.getTime());
    __dataOut.writeInt(this.item_creation_date.getNanos());
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.itemid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.itemid);
    }
    if (null == this.shopid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.shopid);
    }
    if (null == this.item_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, item_name);
    }
    if (null == this.item_description) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, item_description);
    }
    if (null == this.item_variation) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, item_variation);
    }
    if (null == this.price) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.price);
    }
    if (null == this.stock) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.stock);
    }
    if (null == this.category) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, category);
    }
    if (null == this.cb_option) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.cb_option);
    }
    if (null == this.is_preferred) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.is_preferred);
    }
    if (null == this.sold_count) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.sold_count);
    }
    if (null == this.item_creation_date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.item_creation_date.getTime());
    __dataOut.writeInt(this.item_creation_date.getNanos());
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(itemid==null?"null":"" + itemid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(shopid==null?"null":"" + shopid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(item_name==null?"null":item_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(item_description==null?"null":item_description, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(item_variation==null?"null":item_variation, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(price==null?"null":"" + price, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(stock==null?"null":"" + stock, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(category==null?"null":category, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(cb_option==null?"null":"" + cb_option, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(is_preferred==null?"null":"" + is_preferred, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(sold_count==null?"null":"" + sold_count, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(item_creation_date==null?"null":"" + item_creation_date, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(itemid==null?"null":"" + itemid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(shopid==null?"null":"" + shopid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(item_name==null?"null":item_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(item_description==null?"null":item_description, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(item_variation==null?"null":item_variation, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(price==null?"null":"" + price, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(stock==null?"null":"" + stock, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(category==null?"null":category, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(cb_option==null?"null":"" + cb_option, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(is_preferred==null?"null":"" + is_preferred, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(sold_count==null?"null":"" + sold_count, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(item_creation_date==null?"null":"" + item_creation_date, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.itemid = null; } else {
      this.itemid = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.shopid = null; } else {
      this.shopid = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.item_name = null; } else {
      this.item_name = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.item_description = null; } else {
      this.item_description = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.item_variation = null; } else {
      this.item_variation = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.price = null; } else {
      this.price = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.stock = null; } else {
      this.stock = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.category = null; } else {
      this.category = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.cb_option = null; } else {
      this.cb_option = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.is_preferred = null; } else {
      this.is_preferred = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.sold_count = null; } else {
      this.sold_count = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.item_creation_date = null; } else {
      this.item_creation_date = java.sql.Timestamp.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.itemid = null; } else {
      this.itemid = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.shopid = null; } else {
      this.shopid = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.item_name = null; } else {
      this.item_name = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.item_description = null; } else {
      this.item_description = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.item_variation = null; } else {
      this.item_variation = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.price = null; } else {
      this.price = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.stock = null; } else {
      this.stock = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.category = null; } else {
      this.category = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.cb_option = null; } else {
      this.cb_option = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.is_preferred = null; } else {
      this.is_preferred = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.sold_count = null; } else {
      this.sold_count = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.item_creation_date = null; } else {
      this.item_creation_date = java.sql.Timestamp.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    items o = (items) super.clone();
    o.item_creation_date = (o.item_creation_date != null) ? (java.sql.Timestamp) o.item_creation_date.clone() : null;
    return o;
  }

  public void clone0(items o) throws CloneNotSupportedException {
    o.item_creation_date = (o.item_creation_date != null) ? (java.sql.Timestamp) o.item_creation_date.clone() : null;
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("itemid", this.itemid);
    __sqoop$field_map.put("shopid", this.shopid);
    __sqoop$field_map.put("item_name", this.item_name);
    __sqoop$field_map.put("item_description", this.item_description);
    __sqoop$field_map.put("item_variation", this.item_variation);
    __sqoop$field_map.put("price", this.price);
    __sqoop$field_map.put("stock", this.stock);
    __sqoop$field_map.put("category", this.category);
    __sqoop$field_map.put("cb_option", this.cb_option);
    __sqoop$field_map.put("is_preferred", this.is_preferred);
    __sqoop$field_map.put("sold_count", this.sold_count);
    __sqoop$field_map.put("item_creation_date", this.item_creation_date);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("itemid", this.itemid);
    __sqoop$field_map.put("shopid", this.shopid);
    __sqoop$field_map.put("item_name", this.item_name);
    __sqoop$field_map.put("item_description", this.item_description);
    __sqoop$field_map.put("item_variation", this.item_variation);
    __sqoop$field_map.put("price", this.price);
    __sqoop$field_map.put("stock", this.stock);
    __sqoop$field_map.put("category", this.category);
    __sqoop$field_map.put("cb_option", this.cb_option);
    __sqoop$field_map.put("is_preferred", this.is_preferred);
    __sqoop$field_map.put("sold_count", this.sold_count);
    __sqoop$field_map.put("item_creation_date", this.item_creation_date);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
