from flask import Flask, render_template, request, redirect
from flask import Blueprint
from models.session_plan import SessionPlan
import repositories.session_plan_repository as session_plan_repository
import repositories.user_repository as user_repository
import repositories.coach_repository as coach_repository

session_plans_blueprint = Blueprint("session_plans", __name__)

@session_plans_blueprint.route("/sessions")
def session_plans():
    session_plans = session_plan_repository.select_all() # NEW
    return render_template("sessions/index.html", session_plans = session_plans)

# NEW
# GET '/session_plans/new'
@session_plans_blueprint.route("/sessions/new", methods=['GET'])
def new_session():
    users = user_repository.select_all()
    coaches = coach_repository.select_all()
    session_plans = session_plan_repository.select_all()
    return render_template("sessions/new.html", users = users, coaches = coaches, session_plans=session_plans)

# CREATE
# POST '/session_plans'
@session_plans_blueprint.route("/sessions",  methods=['POST'])
def create_session():
    user_id = request.form['user_id']
    coach_id = request.form['coach_id']
    session_type = request.form['session_type']
    guidance = request.form['guidance']
    user = user_repository.select(user_id)
    coach = coach_repository.select(coach_id)
    session_plan = SessionPlan(user, coach, session_type, guidance)
    session_plan_repository.save(session_plan)
    return redirect('/sessions')


# DELETE
# DELETE '/session_plans/<id>'
@session_plans_blueprint.route("/sessions/<id>/delete", methods=['POST'])
def delete_session(id):
    session_plan_repository.delete(id)
    return redirect('/sessions')