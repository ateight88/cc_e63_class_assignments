from db.run_sql import run_sql

from models.coach import Coach
from models.user import User

def save(coach):
    sql = "INSERT INTO coaches(name, sport, img) VALUES ( %s, %s, %s ) RETURNING id"
    values = [coach.name, coach.sport, coach.img]
    results = run_sql( sql, values )
    coach.id = results[0]['id']
    return coach


def select_all():
    coaches = []

    sql = "SELECT * FROM coaches"
    results = run_sql(sql)

    for row in results:
        coach = Coach(row['name'], row['sport'], row['img'], row['id'])
        coaches.append(coach)
    return coaches


def select(id):
    coach = None
    sql = "SELECT * FROM coaches WHERE id = %s"
    values = [id]
    result = run_sql(sql, values)[0]

    if result is not None:
        coach = Coach(result['name'], result['sport'], result['id'] )
    return coach


def users(coach):
    users = []

    sql = "SELECT users.* FROM users INNER JOIN session_plans ON session_plans.user_id = users.id WHERE coach_id = %s"
    values = [coach.id]
    results = run_sql(sql, values)

    for row in results:
        user = User(row['name'], row['experience'], row['level'], row['bio'], row['id'])
        users.append(user)

    return users



def delete_all():
    sql = "DELETE FROM coaches"
    run_sql(sql)
