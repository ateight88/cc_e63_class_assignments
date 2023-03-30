DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS coaches CASCADE;
DROP TABLE IF EXISTS workouts CASCADE;
DROP TABLE IF EXISTS exercises CASCADE;
DROP TABLE IF EXISTS session_plans CASCADE;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    experience INTEGER NOT NULL
);

CREATE TABLE coaches (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    sport VARCHAR(50) NOT NULL
);

CREATE TABLE session_plans (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    user_id INTEGER NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    coach_id INTEGER NOT NULL REFERENCES coaches(id) ON DELETE CASCADE
);

CREATE TABLE workouts (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    session_plan_id INTEGER NOT NULL REFERENCES session_plans(id) ON DELETE CASCADE
);

CREATE TABLE exercises (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    reps INTEGER NOT NULL,
    sets INTEGER NOT NULL,
    is_completed BOOLEAN NOT NULL,
    workout_id INTEGER NOT NULL REFERENCES workouts(id) ON DELETE CASCADE
);


-- Seed data;

-- INSERT INTO coaches (name, sport) VALUES
--     ('Arthur  Lydiard', 'Running'),
--     ('Liz Colgan', 'Running');

-- INSERT INTO users (name, experience) VALUES
--     ('John', 10),
--     ('Jane', 20),
--     ('Tim', 10),
--     ('Isla', 20);

-- INSERT INTO session_plans (user_id, coach_id) VALUES
--     (1, 1),
--     (2, 1),
--     (3, 2),
--     (4, 2);

-- INSERT INTO workouts (name, session_plan_id) VALUES
--     ('Leg day', 1),
--     ('Chest day', 1),
--     ('Back day', 1),
--     ('Leg day', 2),
--     ('Chest day', 2),
--     ('Back day', 2);

-- INSERT INTO exercises (name, reps, sets, completed, workout_id) VALUES
--     ('Squats', 10, 3, true, 1),
--     ('Deadlifts', 8, 3, true, 1),
--     ('Bench press', 8, 3, true, 2),
--     ('Rows', 10, 3, true, 3),
--     ('Pull ups', 8, 3, true, 2),
--     ('Chin ups', 10, 3, true, 4),
--     ('Dumbell press', 8, 3, true, 5);

/*

Queries

------------------------------------------------
--1. All users who have completed a specific exercise:
------------------------------------------------
SELECT users.* FROM users
JOIN session_plans ON users.id = session_plans.user_id
JOIN workouts ON session_plans.id = workouts.session_plan_id
JOIN exercises ON workouts.id = exercises.workout_id
WHERE exercises.name = 'Squats' AND exercises.completed = true;


------------------------------------------------
--2. Number of completed sets and reps for a specific user:
------------------------------------------------
SELECT exercises.sets, exercises.reps
FROM users
JOIN session_plans ON users.id = session_plans.user_id
JOIN workouts ON session_plans.id = workouts.session_plan_id
JOIN exercises ON workouts.id = exercises.workout_id
WHERE users.id = 2 AND exercises.completed = true;



--for all users:
SELECT users.name, SUM(exercises.reps * exercises.sets) AS total_reps
FROM users
JOIN session_plans ON users.id = session_plans.user_id
JOIN workouts ON session_plans.id = workouts.session_plan_id
JOIN exercises ON workouts.id = exercises.workout_id
WHERE exercises.completed = true
GROUP BY users.id;

------------------------------------------------
--3. Coaches who have coached the most sessions:
------------------------------------------------
SELECT coaches.*, COUNT(session_plans.id) AS sessions_coached
FROM coaches
INNER JOIN session_plans ON session_plans.coach_id = coaches.id
GROUP BY coaches.id
ORDER BY sessions_coached DESC
LIMIT 5;
-- alternate...
SELECT coaches.*
FROM coaches
JOIN session_plans ON coaches.id = session_plans.coach_id
GROUP BY coaches.id
ORDER BY COUNT(*) DESC
LIMIT 1;

------------------------------------------------
--4. Most commonly completed exercise:
------------------------------------------------
SELECT exercises.name FROM exercises
WHERE completed = true
GROUP BY exercises.name
ORDER BY COUNT(*) DESC
LIMIT 5;


------------------------------------------------
--5. Users who completed the most workouts:
------------------------------------------------
SELECT users.* FROM users
JOIN session_plans ON users.id = session_plans.user_id
JOIN workouts ON session_plans.id = workouts.session_plan_id
JOIN exercises ON workouts.id = exercises.workout_id
WHERE exercises.completed = true
GROUP BY users.id
ORDER BY COUNT(DISTINCT workouts.id) DESC
LIMIT 5;

-- showing the workout name
SELECT users.name, workouts.name FROM users
JOIN session_plans ON users.id = session_plans.user_id
JOIN workouts ON session_plans.id = workouts.session_plan_id
JOIN exercises ON workouts.id = exercises.workout_id
WHERE exercises.completed = true
GROUP BY users.id, workouts.name 
ORDER BY COUNT(DISTINCT workouts.id) DESC
LIMIT 5;

-- show the workout details in addition...
SELECT users.name, workouts.name AS workout_name, workouts.session_plan_id, workouts.id AS workout_id, SUM(exercises.reps * exercises.sets) AS total_reps
FROM users
JOIN session_plans ON users.id = session_plans.user_id
JOIN workouts ON session_plans.id = workouts.session_plan_id
JOIN exercises ON workouts.id = exercises.workout_id
WHERE exercises.completed = true
GROUP BY users.id, workouts.name, workouts.session_plan_id, workouts.id
ORDER BY COUNT(DISTINCT workouts.id) DESC
LIMIT 5;

*/