# Python Flask / Jinja 

A basic CRUD app to demonstrate Flask framework / Jinja templating    

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Support](#support)
- [Contributing](#contributing)

## Installation

Download to your project directory, install dependencies:

```sh
Flask           2.2.3 
Jinja2          3.1.2
psycopg2        2.9.5

```

## Usage

- Installation instructions
  - Navigate to project root
  - Create a database:: createdb coach_athlete 
  - Run: 
        psql -d coach_athlete -f db/coach_athlete.sql
        python3 console.py
        flask run
- Usage instructions:
        - home page - static data
        - coaches page - data rendered from backend / select coach to see clients
        - athletes page - links to individual athletes for more details and editing options
        - Phoenix - (No Coach) - shows conditional rendering when an athlete has no coach
        - session plans page - lists all sessions / create, edit, delete options
        - create session page - filters Phoenix - (No Coach) so cannot be selected
        - edit session page - athlete field disabled 
        - all lists sorted alphabetically

- Support instructions
        - demo content data comes from the console.py file 
        - run_sql.py is a helper file for writing SQL queries
        - .flaskenv file to change port number
- Contributing instructions
        - Feel free to clone and adapt for your own project.

## Support

Demo project for course work, you can check my website for more information: 
Includes resume, current projects and research interests [tony-doyle.com](http://tony-doyle.com) 

## Contributing

You can contribute using [Github Flow](https://guides.github.com/introduction/flow/). Create a branch, add commits, and experiment.