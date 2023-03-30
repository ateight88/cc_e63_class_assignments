from db.run_sql import run_sql

from models.coach import Coach
from models.user import User

def save(user):
    sql = "INSERT INTO users( name, experience, level, bio ) VALUES ( %s, %s, %s, %s ) RETURNING id"
    values = [user.name, user.experience, user.level, user.bio]
    results = run_sql( sql, values )
    user.id = results[0]['id']
    return user

def select_all():
    users = []

    sql = "SELECT * FROM users"
    results = run_sql(sql)
    for row in results:
        user = User(row['name'], row['experience'], row['level'], row['bio'], row['id'])
        users.append(user)
    return users


def select(id):
    user = None
    sql = "SELECT * FROM users WHERE id = %s"
    values = [id]
    results = run_sql(sql, values)

    if results:
        result = results[0]
        user = User(result['name'], result['experience'], result['level'], result['bio'], result['id'] )
    return user


def coaches(user):
    coaches = []

    sql = "SELECT coaches.* FROM coaches INNER JOIN session_plans ON session_plans.coach_id = coaches.id WHERE user_id = %s"
    values = [user.id]
    results = run_sql(sql, values)

    for row in results:
        coach = Coach(row['name'], row['sport'], row['id'])
        coaches.append(coach)

    return coaches


def delete_all():
    sql = "DELETE FROM users"
    run_sql(sql)
