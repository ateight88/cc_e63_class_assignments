from flask import Flask, render_template, request, redirect
from flask import Blueprint
from models.athlete import Athlete
import repositories.athlete_repository as athlete_repository
import repositories.session_plan_repository as session_plan_repository

athletes_blueprint = Blueprint("athletes", __name__)

@athletes_blueprint.route("/athletes")
def athletes():
    athletes = athlete_repository.select_all() # NEW
    return render_template("athletes/index.html", athletes = athletes)

@athletes_blueprint.route("/athletes/<id>")
def show(id):
    athlete = athlete_repository.select(id)
    coaches = athlete_repository.coaches(athlete)
    session_plans = session_plan_repository.select_all()

    return render_template("athletes/show.html", athlete=athlete, coaches=coaches, session_plans=session_plans)

@athletes_blueprint.route('/athletes/<id>/edit', methods=['GET'])
def edit(id):
    athlete = athlete_repository.select(id)
    return render_template('athletes/edit.html', athlete=athlete)

@athletes_blueprint.route('/athletes/<id>', methods=['POST'])
def update(id):
    athlete = athlete_repository.select(id)
    name = request.form['name']
    experience = request.form['experience']
    level = request.form['level']
    bio = request.form['bio']
    img = request.form['img']
    updated_athlete = Athlete(name, experience, level, bio, img, athlete.id)
    athlete_repository.update(updated_athlete)
    return redirect('/athletes')


