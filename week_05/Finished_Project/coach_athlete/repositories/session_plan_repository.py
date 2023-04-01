from db.run_sql import run_sql

from models.session_plan import SessionPlan
from models.coach import Coach
from models.athlete import Athlete
import repositories.athlete_repository as athlete_repository
import repositories.coach_repository as coach_repository

def save(session_plan):
    sql = "INSERT INTO session_plans ( athlete_id, coach_id, session_type, guidance ) VALUES ( %s, %s, %s, %s ) RETURNING id"
    values = [session_plan.athlete.id, session_plan.coach.id, session_plan.session_type, session_plan.guidance]
    print(f'session_plan_repo_values: {values} ')
    results = run_sql( sql, values )
    session_plan.id = results[0]['id']
    return session_plan



def select_all():
    session_plans = []

    sql = "SELECT * FROM session_plans"
    results = run_sql(sql)

    for row in results:
        athlete = athlete_repository.select(row['athlete_id'])
        coach = coach_repository.select(row['coach_id'])
        session_plan = SessionPlan(athlete, coach, row['session_type'], row['guidance'],  row['id'])
        session_plans.append(session_plan)
    return session_plans


def coach(session_plan):
    sql = "SELECT * FROM coaches WHERE id = %s"
    values = [session_plan.coach.id]
    results = run_sql(sql, values)[0]
    coach = Coach(results['name'], results['sport'], results['img'], results['id'])
    return coach


def athlete(session_plan):
    sql = "SELECT * FROM athletes WHERE id = %s"
    values = [session_plan.athlete.id]
    results = run_sql(sql, values)[0]
    athlete = Athlete(results['name'], results['id'])
    return athlete


def delete_all():
    sql = "DELETE FROM session_plans"
    run_sql(sql)

def delete(id):
    sql = "DELETE FROM session_plans WHERE id = %s"
    values = [id]
    run_sql(sql, values)

def select(id):
    session_plan = None
    sql = "SELECT * FROM session_plans WHERE id = %s"
    values = [id]
    results = run_sql(sql, values)

    if results:
        row = results[0]
        athlete = athlete_repository.select(row['athlete_id'])
        coach = coach_repository.select(row['coach_id'])
        session_plan = SessionPlan(athlete, coach, row['session_type'], row['guidance'], row['id'])
    return session_plan


def update(session_plan):
    sql = "UPDATE session_plans SET athlete_id = %s, coach_id = %s, session_type = %s, guidance = %s WHERE id = %s"
    values = [session_plan.athlete.id, session_plan.coach.id, session_plan.session_type, session_plan.guidance, session_plan.id]
    run_sql(sql, values)    
