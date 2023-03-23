DROP TABLE IF EXISTS authors CASCADE;
DROP TABLE IF EXISTS books;

CREATE TABLE authors (
  id SERIAL PRIMARY KEY,
  first_name VARCHAR(255),
  last_name VARCHAR(255)
);

CREATE TABLE books (
  id SERIAL PRIMARY KEY,
  title VARCHAR(255),
  author VARCHAR(255),
  genre VARCHAR(255),
  checked_out BOOLEAN,
  author_id INT NOT NULL REFERENCES authors(id)
);

INSERT INTO authors (first_name, last_name) 
VALUES ('Charles', 'Dickens');

INSERT INTO authors (first_name, last_name) 
VALUES ('Herman', 'Melville');


INSERT INTO books (title, author_id, genre, checked_out, author) 
VALUES ('Oliver Twist', 1, 'Classic', 'f', 'Charles Dickens');

INSERT INTO books (title, author_id, genre, checked_out, author) 
VALUES ('Moby Dick', 2, 'Classic', 'f', 'Herman Melville');
