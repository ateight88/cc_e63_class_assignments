from flask import Flask, render_template

from controllers.session_plan_controller import session_plans_blueprint
from controllers.coach_controller import coaches_blueprint
from controllers.athlete_controller import athletes_blueprint

app = Flask(__name__)

app.register_blueprint(session_plans_blueprint)
app.register_blueprint(coaches_blueprint)
app.register_blueprint(athletes_blueprint)

@app.route('/')
def home():
    return render_template('index.html')

if __name__ == '__main__':
    app.run(debug=True)