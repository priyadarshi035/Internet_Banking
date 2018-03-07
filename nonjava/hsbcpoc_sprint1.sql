CREATE TABLE ARPANROY_IN_IBM_COM.Customer
(custid BIGINT NOT NULL,
customer_name varchar(100),
customer_address varchar(200),
customer_type varchar(50),
PRIMARY KEY(custid));

CREATE TABLE ARPANROY_IN_IBM_COM.USER
(USERID BIGINT NOT NULL,
username varchar(100),
password varchar(100),
last_updated varchar(100),
custid BIGINT,
PRIMARY KEY(USERID));

CREATE TABLE ARPANROY_IN_IBM_COM.UserSession
(sessionid BIGINT NOT NULL,
userid BIGINT,
logintime varchar(100),
logouttime varchar(100),
isactive varchar(10),
PRIMARY KEY(sessionid));



INSERT INTO ARPANROY_IN_IBM_COM.USER(USERID ,USERNAME ,PASSWORD,LAST_UPDATED,CUSTID ) 
VALUES(01,'Demo','Demo',SYSDATE,001 );