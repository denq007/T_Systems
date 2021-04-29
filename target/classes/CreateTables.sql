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
    group_id int,
    PRIMARY KEY (id)
);

CREATE TABLE tariff
(
    id    int NOT NULL AUTO_INCREMENT,
    name  varchar(255),
    price DOUBLE,
    old BOOL,
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
/* 1 -ok, 0-blocked by User,2 - blocked by Admin*/
CREATE TABLE customer
(
    id                int NOT NULL AUTO_INCREMENT,
    name              varchar(255),
    surname           varchar(255),
    birth_date        DATE,
    passport_details  varchar(255),
    address           varchar(255),
    email             varchar(255),
    PRIMARY KEY (id)
);
CREATE TABLE сontract
(
    id          int NOT NULL AUTO_INCREMENT,
    number      varchar(255),
    tariff_id   int,
    customer_id int,
    blocked_by_user tinyint(1),
    blocked_by_admin tinyint(1),
    PRIMARY KEY (id),
    FOREIGN KEY (tariff_id) REFERENCES eCare_db.tariff (id),
    FOREIGN KEY (customer_id) REFERENCES eCare_db.customer (id)
);
CREATE TABLE user(
    id          int NOT NULL AUTO_INCREMENT,
    customer_id int ,
    login varchar(255),
    password VARCHAR(255),
    blocked tinyint(1),
    PRIMARY KEY(id),
    FOREIGN KEY(customer_id) REFERENCES eCare_db.customer (id)
);

CREATE TABLE user_role
(
    customer_id int NOT NULL,
    roles enum("Customer","Admin","Employee"),
    PRIMARY KEY(customer_id,roles),
    FOREIGN KEY(customer_id) REFERENCES eCare_db.user(customer_id)
);
