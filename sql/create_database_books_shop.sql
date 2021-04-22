CREATE DATABASE BOOKS_SHOP;

CREATE TABLE BOOKS(ID serial PRIMARY KEY, author VARCHAR(30), book_name VARCHAR(50), genre VARCHAR(20), amount INTEGER);

INSERT INTO BOOKS(author, book_name, genre, amount) VALUES('Tolstoy L.N.', 'War and Peace', 'Historical novel', 2);

SELECT * FROM BOOKS;

UPDATE BOOKS SET AMOUNT = 1;

DELETE FROM BOOKS;