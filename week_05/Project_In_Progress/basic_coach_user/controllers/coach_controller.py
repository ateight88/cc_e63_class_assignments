from flask import Flask, render_template, request, redirect
from flask import Blueprint
from models.coach import Coach
import repositories.coach_repository as coach_repository

coaches_blueprint = Blueprint("coaches", __name__)


@coaches_blueprint.route("/coaches")
def coaches():
    coaches = coach_repository.select_all() # NEW
    return render_template("coaches/index.html", coaches = coaches)

@coaches_blueprint.route("/coaches/<id>")
def show(id):
    coach = coach_repository.select(id)
    users = coach_repository.users(coach)
    return render_template("coaches/show.html", coach=coach, users=users)
