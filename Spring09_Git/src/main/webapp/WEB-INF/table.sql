CREATE TABLE client_account
(id VARCHAR2(100) PRIMARY KEY,
balance NUMBER CHECK(balance >= 0),
bonusPoint NUMBER CHECK(bonusPoint >=0));