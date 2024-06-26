DROP TABLE IF EXISTS categories;
DROP SEQUENCE IF EXISTS categoriesSeq;
DROP SEQUENCE IF EXISTS categories_seq;
DROP SEQUENCE IF EXISTS categories_id_seq;
CREATE TABLE IF NOT EXISTS categories
(
    id          INTEGER PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    description VARCHAR(200)
);
CREATE SEQUENCE IF NOT EXISTS categories_seq START WITH 6 INCREMENT BY 1;
ALTER SEQUENCE categories_seq INCREMENT BY 1;

DROP TABLE IF EXISTS gifts;
DROP SEQUENCE IF EXISTS giftsSeq;
DROP SEQUENCE IF EXISTS gifts_seq;
DROP SEQUENCE IF EXISTS gifts_id_seq;
CREATE TABLE IF NOT EXISTS gifts
(
    id          INTEGER PRIMARY KEY,
    name        VARCHAR(50)  NOT NULL,
    description VARCHAR(200) NOT NULL
);
CREATE SEQUENCE IF NOT EXISTS gifts_seq START WITH 1 INCREMENT BY 1;
ALTER SEQUENCE gifts_seq INCREMENT BY 1;

DROP TABLE IF EXISTS gift_categories;
CREATE TABLE IF NOT EXISTS gift_categories (
   gift_id INTEGER NOT NULL,
   category_id INTEGER NOT NULL,
   PRIMARY KEY (gift_id, category_id)
--     FOREIGN KEY (gift_id) REFERENCES gifts(id),
--     FOREIGN KEY (category_id) REFERENCES categories(id)
);