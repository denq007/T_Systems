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
    group_id        int,
    PRIMARY KEY (id)
);

CREATE TABLE tariff
(
    id    int NOT NULL AUTO_INCREMENT,
    name  varchar(255),
    price DOUBLE,
    old   BOOL,
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
CREATE TABLE user
(
    id       int NOT NULL AUTO_INCREMENT,
    login    varchar(255),
    password VARCHAR(255),
    blocked  tinyint(1),
    PRIMARY KEY (id)
);
CREATE TABLE customer
(
    id               int NOT NULL AUTO_INCREMENT,
    user_id          int,
    name             varchar(255),
    surname          varchar(255),
    birth_date       DATE,
    passport_details varchar(255),
    address          varchar(255),
    email            varchar(255),
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES eCare_db.user (id)
);
CREATE TABLE сontract
(
    id               int NOT NULL AUTO_INCREMENT,
    number           int,
    tariff_id        int,
    customer_id      int,
    blocked_by_user  tinyint(1),
    blocked_by_admin tinyint(1),
    PRIMARY KEY (id),
    FOREIGN KEY (tariff_id) REFERENCES eCare_db.tariff (id),
    FOREIGN KEY (customer_id) REFERENCES eCare_db.customer (id)
);

CREATE TABLE user_role
(
    user_id int NOT NULL,
    roles   enum("Customer","Admin","Employee"),
    PRIMARY KEY (user_id, roles),
    FOREIGN KEY (user_id) REFERENCES eCare_db.user (id)
);

create table phonenumber_seq
(
    id  int AUTO_INCREMENT,
    nextPhonenumber bigint null,
        PRIMARY KEY(id)
)
ALTER TABLE phonenumber_seq AUTO_INCREMENT=9210010000;
/*

create table options
(
    id              int auto_increment
        primary key,
    name            varchar(255) null,
    price           double       null,
    connection_cost double       null,
    group_id        int          null
);

create table phonenumber_seq
(
    id              bigint auto_increment
        primary key,
    nextPhonenumber bigint null
);

create table tariff
(
    id    int auto_increment
        primary key,
    name  varchar(255) null,
    price double       null,
    old   tinyint(1)   null
);

create table tariff_option
(
    tariff_id int not null,
    option_id int not null,
    primary key (tariff_id, option_id),
    constraint tariff_option_ibfk_1
        foreign key (tariff_id) references tariff (id),
    constraint tariff_option_ibfk_2
        foreign key (option_id) references options (id)
);

create index option_id
    on tariff_option (option_id);

create table user
(
    id       int auto_increment
        primary key,
    login    varchar(255) null,
    password varchar(255) null,
    blocked  tinyint(1)   null
);

create table customer
(
    id               int auto_increment
        primary key,
    user_id          int          null,
    name             varchar(255) null,
    surname          varchar(255) null,
    birth_date       date         null,
    passport_details varchar(255) null,
    address          varchar(255) null,
    email            varchar(255) null,
    constraint customer_ibfk_1
        foreign key (user_id) references user (id)
);

create index user_id
    on customer (user_id);

create table user_role
(
    user_id int                                                   not null,
    roles   enum ('ROLE_CUSTOMER', 'ROLE_ADMIN', 'ROLE_EMPLOYEE') not null,
    primary key (user_id, roles),
    constraint user_role_ibfk_1
        foreign key (user_id) references user (id)
);

create table сontract
(
    id               int auto_increment
        primary key,
    number           varchar(255) null,
    tariff_id        int          null,
    customer_id      int          null,
    blocked_by_user  tinyint(1)   null,
    blocked_by_admin tinyint(1)   null,
    constraint сontract_ibfk_1
        foreign key (tariff_id) references tariff (id),
    constraint сontract_ibfk_2
        foreign key (customer_id) references customer (id)
);

create index customer_id
    on сontract (customer_id);

create index tariff_id
    on сontract (tariff_id);*/
