CREATE TABLE bookstore (
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   bookname VARCHAR(255) NOT NULL,
   author VARCHAR(255) NOT NULL,
   year INT,
   version BIGINT
);
