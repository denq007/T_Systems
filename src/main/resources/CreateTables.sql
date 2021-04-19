CREATE DATABASE  eCare_db;
USE eCare_db;


CREATE TABLE options (  
  id int NOT NULL AUTO_INCREMENT,
  name varchar(15),
  price DOUBLE,
  connection_cost DOUBLE,
  PRIMARY KEY (id)
);

CREATE TABLE tariff (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(15),
  price DOUBLE,
  option_id int,
  PRIMARY KEY (id),
  FOREIGN KEY(option_id) REFERENCES eCare_db.options(id)
);

CREATE TABLE tariff_option(
	tariff_id int,
    option_id int,
    PRIMARY KEY(tariff_id,option_id),
    FOREIGN KEY (tariff_id) REFERENCES eCare_db.tariff(id),
    FOREIGN KEY (option_id) REFERENCES eCare_db.options(id)
);

CREATE TABLE сontract(
	id int NOT NULL AUTO_INCREMENT,
	number varchar(20),
    tariff_id int,
    option_id int,  
    PRIMARY KEY(id),
    FOREIGN KEY (tariff_id) REFERENCES eCare_db.tariff(id),
    FOREIGN KEY (option_id) REFERENCES eCare_db.options(id)    
);
/*TO DO about customer_details  */
CREATE TABLE customer(
    id int NOT NULL AUTO_INCREMENT,
	name varchar(25),
	surname varchar(25),
	birth_date DATE,
	passport_details varchar(150),
    address  varchar(150),
    сontract_id int,
    email varchar(25),
    customer_password VARCHAR(60),   
    enabled tinyint(1),
	PRIMARY KEY (id),
    FOREIGN KEY(сontract_id) REFERENCES eCare_db.сontract(id)
);

/* to do after will study security
CREATE TABLE authorities (
  username varchar(15),
  authority varchar(25),
  PRIMARY KEY(),
  FOREIGN KEY (username) references users(username)
);*/