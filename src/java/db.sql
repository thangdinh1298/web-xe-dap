create database if not exists XeDap;
use XeDap;
 
 CREATE TABLE if not exists USERS (
 USERID VARCHAR(255) NOT NULL,
 PASSWORD VARCHAR(255) NOT NULL,
 PRIMARY KEY (USERID)
);
  
CREATE TABLE if not exists USERS_GROUPS (
  GROUPID VARCHAR(20) NOT NULL,
  USERID VARCHAR(255) NOT NULL,
  PRIMARY KEY (GROUPID)
);

CREATE TABLE if not exists XeDap (
   id INT(11) NOT NULL AUTO_INCREMENT,
   code INT(11) NOT NULL UNIQUE,
   des VARCHAR(255) NOT NULL,
   yearManufactured INT(11),
   price FLOAT,
	img_url VARCHAR(255),
   PRIMARY KEY(id)
);

