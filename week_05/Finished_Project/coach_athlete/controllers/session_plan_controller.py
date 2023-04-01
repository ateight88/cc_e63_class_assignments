from flask import Flask, render_template, request, redirect
from flask import Blueprint
from models.session_plan import SessionPlan
import repositories.session_plan_repository as session_plan_repository
import repositories.athlete_repository as athlete_repository
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
    athletes = athlete_repository.select_all()
    coaches = coach_repository.select_all()
    session_plans = session_plan_repository.select_all()
    return render_template("sessions/new.html", athletes = athletes, coaches = coaches, session_plans=session_plans)

# CREATE
# POST '/session_plans'
@session_plans_blueprint.route("/sessions",  methods=['POST'])
def create_sessions():
    athlete_id = request.form['athlete_id']
    coach_id = request.form['coach_id']
    session_type = request.form['new_session']
    print(f'form_sub_value: {session_type}')
    guidance = request.form['guidance']
    athlete = athlete_repository.select(athlete_id)
    coach = coach_repository.select(coach_id)
    session_plan = SessionPlan(athlete, coach, session_type, guidance)
    print(f'form_submission: {session_plan.session_type}')
    session_plan_repository.save(session_plan)
    return redirect('/sessions')

# DELETE
# DELETE '/session_plans/<id>'
@session_plans_blueprint.route("/sessions/<id>/delete", methods=['POST'])
def delete_session(id):
    session_plan_repository.delete(id)
    return redirect('/sessions')

# EDIT 'session_plans/<id>/edit'
@session_plans_blueprint.route('/sessions/<id>/edit')
def edit_session(id):
    session_plan = session_plan_repository.select(id)
    athletes = athlete_repository.select_all()
    coaches = coach_repository.select_all()
    return render_template('sessions/edit.html', session_plan=session_plan, athletes=athletes, coaches=coaches)

# UPDATE
# PUT '/session_plans/<id>/update'
@session_plans_blueprint.route('/sessions/<id>/update', methods=['POST'])
def update_session(id):
    session = session_plan_repository.select(id)
    athlete_id = request.form['athlete_id']
    coach_id = request.form['coach_id']
    session_type = request.form['session_type']
    guidance = request.form['guidance']
    athlete = athlete_repository.select(athlete_id)
    coach = coach_repository.select(coach_id)
    session_plan = SessionPlan(athlete, coach, session_type, guidance, session.id)
    session_plan_repository.update(session_plan)
    return redirect('/sessions')
