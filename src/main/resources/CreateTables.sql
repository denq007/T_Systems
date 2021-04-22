CREATE
DATABASE  eCare_db;
USE
eCare_db;


CREATE TABLE options
(
    id              int NOT NULL AUTO_INCREMENT,
    name            varchar(255),
    price           DOUBLE,
    connection_cost DOUBLE,
    PRIMARY KEY (id)
);

CREATE TABLE tariff
(
    id    int NOT NULL AUTO_INCREMENT,
    name  varchar(255),
    price DOUBLE,
    PRIMARY KEY (id)
);

CREATE TABLE tariff_option
(
    tariff_id int,
    option_id int,
    PRIMARY KEY (tariff_id, option_id),
    FOREIGN KEY (tariff_id) REFERENCES eCare_db.tariff (id),
    FOREIGN KEY (option_id) REFERENCES eCare_db.options (id)
);
CREATE TABLE customer
(
    id                int NOT NULL AUTO_INCREMENT,
    name              varchar(255),
    surname           varchar(255),
    birth_date        DATE,
    passport_details  varchar(255),
    address           varchar(255),
    email             varchar(255),
    customer_password VARCHAR(255),
    enabled           tinyint(1),
    PRIMARY KEY (id)
);
CREATE TABLE сontract
(
    id          int NOT NULL AUTO_INCREMENT,
    number      varchar(255),
    tariff_id   int,
    customer_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (tariff_id) REFERENCES eCare_db.tariff (id),
    FOREIGN KEY (customer_id) REFERENCES eCare_db.customer (id)
);
