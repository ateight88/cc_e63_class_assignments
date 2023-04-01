from db.run_sql import run_sql

from models.coach import Coach
from models.athlete import Athlete

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
    print(f'coach_repo: {result}')

    if result is not None:
        coach = Coach(result['name'], result['sport'], result['img'], result['id'] )
    return coach


def athletes(coach):
    athletes = []

    sql = "SELECT athletes.* FROM athletes INNER JOIN session_plans ON session_plans.athlete_id = athletes.id WHERE coach_id = %s"
    values = [coach.id]
    results = run_sql(sql, values)

    for row in results:
        athlete = Athlete(row['name'], row['experience'], row['level'], row['bio'], row['img'], row['id'])
        athletes.append(athlete)

    return athletes


def delete_all():
    sql = "DELETE FROM coaches"
    run_sql(sql)
