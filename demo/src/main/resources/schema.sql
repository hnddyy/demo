DROP TABLE IF EXISTS coupon,user;
 
CREATE TABLE coupon (
  couponCode VARCHAR(250) PRIMARY KEY,
  useYn VARCHAR(1) NOT NULL,
  giveYn VARCHAR(1) NOT NULL,
  userId VARCHAR(30),
  expireDate DATE NOT NULL,
  expireAlarmYn VARCHAR(1) NOT NULL,
  makeDate DATETIME NOT NULL
);

CREATE TABLE user (
  userId VARCHAR(30) PRIMARY KEY,
  userPassword VARCHAR(100) NOT NULL
);

INSERT INTO USER (userId, userPassword) VALUES ('user', 'testgogo');

INSERT INTO COUPON (
couponCode, useYn, giveYn, makeDate, expireDate, expireAlarmYn)
VALUES (
'1e842a90-1bf3-4d1f-9cb3-1ad3c6c182a1','N','N',NOW(),TODAY()+10,'N');