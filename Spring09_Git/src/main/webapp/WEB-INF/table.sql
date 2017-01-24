CREATE TABLE client_account
(id VARCHAR2(100) PRIMARY KEY,
balance NUMBER CHECK(balance >= 0),
bonusPoint NUMBER CHECK(bonusPoint >=0));

-- sample 데이터 

INSERT INTO client_account VALUES('gura', 0, 0);