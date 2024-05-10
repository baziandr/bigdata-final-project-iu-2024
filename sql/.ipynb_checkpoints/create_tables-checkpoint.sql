START TRANSACTION;

DROP TABLE IF EXISTS items;

CREATE TABLE items (
    itemid INTEGER PRIMARY KEY,
    shopid INTEGER,
    item_name TEXT,
    item_description TEXT,
    item_variation TEXT, -- cannot be treated as json since it does not follow its syntax
    price FLOAT,
    stock INTEGER,
    category TEXT,
    cb_option BOOLEAN,
    is_preferred BOOLEAN,
    sold_count INTEGER,
    item_creation_date TEXT -- will be transformed to timestamp after insertion due to non-standard format of date in csv
);

COMMIT;