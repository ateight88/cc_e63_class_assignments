from db.run_sql import run_sql

from models.coach import Coach
from models.athlete import Athlete
from models.session_plan import SessionPlan

def save(athlete):
    sql = "INSERT INTO athletes( name, experience, level, bio, img ) VALUES ( %s, %s, %s, %s, %s ) RETURNING id"
    values = [athlete.name, athlete.experience, athlete.level, athlete.bio, athlete.img]
    results = run_sql( sql, values )
    athlete.id = results[0]['id']
    return athlete

def update(athlete):
    sql = "UPDATE athletes SET (name, experience, level, bio) = (%s, %s, %s, %s) WHERE id = %s"
    values = [athlete.name, athlete.experience, athlete.level, athlete.bio, athlete.id]
    print(f'update_values: {values}')
    run_sql(sql, values)


def select_all():
    athletes = []

    sql = "SELECT * FROM athletes"
    results = run_sql(sql)
    for row in results:
        athlete = Athlete(row['name'], row['experience'], row['level'], row['bio'], row['img'], row['id'])
        athletes.append(athlete)
    return athletes


def select(id):
    athlete = None
    sql = "SELECT * FROM athletes WHERE id = %s"
    values = [id]
    results = run_sql(sql, values)

    if results:
        result = results[0]
        athlete = Athlete(result['name'], result['experience'], result['level'], result['bio'], result['img'], result['id'] )
    return athlete


def coaches(athlete):
    coaches = []

    sql = "SELECT coaches.* FROM coaches INNER JOIN session_plans ON session_plans.coach_id = coaches.id WHERE athlete_id = %s"
    values = [athlete.id]
    results = run_sql(sql, values)

    for row in results:
        coach = Coach(row['name'], row['sport'], row['id'])
        coaches.append(coach)

    return coaches


def delete_all():
    sql = "DELETE FROM athletes"
    run_sql(sql)
