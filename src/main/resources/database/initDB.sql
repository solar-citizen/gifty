DROP TABLE IF EXISTS categories;
CREATE TABLE IF NOT EXISTS categories
(
    id   INTEGER PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);
CREATE SEQUENCE IF NOT EXISTS categories_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS gifts
(
    id         INTEGER PRIMARY KEY,
    name       VARCHAR(50)  NOT NULL,
    categories VARCHAR(255) NOT NULL
);
CREATE SEQUENCE IF NOT EXISTS gifts_id_seq START WITH 1 INCREMENT BY 1;


-- DROP TABLE IF EXISTS categories;
-- DROP SEQUENCE IF EXISTS categories_id_seq;