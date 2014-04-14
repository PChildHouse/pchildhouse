DROP TABLE IF EXISTS PCH_USER;

CREATE TABLE PCH_USER (
  ID INT NOT NULL AUTO_INCREMENT ,
  USERNAME VARCHAR2 (20) UNIQUE ,
  PASSWORD VARCHAR2 (20) NOT NULL ,
  CREATED_DATE DATE NOT NULL ,
  PRIMARY KEY (ID)
)