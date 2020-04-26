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
  userPassword VARCHAR(50) NOT NULL
);