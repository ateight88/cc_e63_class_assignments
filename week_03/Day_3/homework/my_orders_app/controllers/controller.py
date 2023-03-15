from flask import render_template
from app import app
from models.orders_list import orders

    # important to name folder templates
@app.route('/orders')
def index():
    return render_template('index.html', title='Book Shop', orders_list=orders)

@app.route('/orders/<index>')
def single_order(index):
  single_order = orders[int(index)]
  
  return render_template('order.html', order=single_order)
















# @app.route('/')
# def index():
#     return "Hello World"

# @app.route('/<name>')
# def greet(name):
#     return f"Hello {name}"

# @app.route('/tasks')
# def get_all(task):
#     return f"Tasks: {task}"

# @app.route('/tasks/{id}')
# def get_task_by_id(task_id):
#     return f"Task by ID: {task_id}"



