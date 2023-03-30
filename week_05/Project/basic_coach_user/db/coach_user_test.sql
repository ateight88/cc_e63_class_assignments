DROP TABLE session_plans;
DROP TABLE users;
DROP TABLE coaches;

CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255),
  experience INT,
  level VARCHAR(255),
  bio TEXT  
);

CREATE TABLE coaches (
  id SERIAL PRIMARY KEY,
  sport VARCHAR(255),
  img VARCHAR(255),
  name VARCHAR(255)
);

CREATE TABLE session_plans (
  id SERIAL PRIMARY KEY,
  user_id INT REFERENCES users(id) ON DELETE CASCADE,
  coach_id INT NOT NULL REFERENCES coaches(id) ON DELETE CASCADE,
  session_type VARCHAR(255),
  guidance TEXT
);
