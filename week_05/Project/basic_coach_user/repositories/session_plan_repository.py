from db.run_sql import run_sql

from models.session_plan import SessionPlan
from models.coach import Coach
from models.user import User
import repositories.user_repository as user_repository
import repositories.coach_repository as coach_repository

def save(session_plan):
    sql = "INSERT INTO session_plans ( user_id, coach_id, session_type, guidance ) VALUES ( %s, %s, %s, %s ) RETURNING id"
    values = [session_plan.user.id, session_plan.coach.id, session_plan.session_type, session_plan.guidance]
    results = run_sql( sql, values )
    if results:
        session_plan.id = results[0]['id']
        print(session_plan)
        return session_plan


def select_all():
    session_plans = []

    sql = "SELECT * FROM session_plans"
    results = run_sql(sql)

    for row in results:
        user = user_repository.select(row['user_id'])
        coach = coach_repository.select(row['coach_id'])
        session_plan = SessionPlan(user, coach, row['session_type'], row['guidance'],  row['id'])
        session_plans.append(session_plan)
    return session_plans


def coach(session_plan):
    sql = "SELECT * FROM coaches WHERE id = %s"
    values = [session_plan.coach.id]
    results = run_sql(sql, values)[0]
    coach = Coach(results['name'], results['sport'], results['img'], results['id'])
    return coach


def user(session_plan):
    sql = "SELECT * FROM users WHERE id = %s"
    values = [session_plan.user.id]
    results = run_sql(sql, values)[0]
    user = User(results['name'], results['id'])
    return user


def delete_all():
    sql = "DELETE FROM session_plans"
    run_sql(sql)

def delete(id):
    sql = "DELETE FROM session_plans WHERE id = %s"
    values = [id]
    run_sql(sql, values)
