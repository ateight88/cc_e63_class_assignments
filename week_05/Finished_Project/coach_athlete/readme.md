# Python Flask / Jinja

A basic CRUD app to demonstrate Flask framework / Jinja templating

## Table of Contents

- [Python Flask / Jinja](#python-flask--jinja)
  - [Table of Contents](#table-of-contents)
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
  - Run: <br />
    - psql -d coach_athlete -f db/coach_athlete.sql <br />
    - python3 console.py <br />
    - flask run <br />
- Usage instructions: <br />

  - home page - static data <br />
  - coaches page - data rendered from backend / select coach to see clients <br />
  - athletes page - links to individual athletes for more details and editing options <br />
  - Phoenix - (No Coach) - shows conditional rendering when an athlete has no coach <br />
  - session plans page - lists all sessions / create, edit, delete options <br />
  - create session page - filters Phoenix - (No Coach) so cannot be selected <br />
  - edit session page - athlete field disabled - all lists sorted alphabetically <br />

- Support instructions - demo content data comes from the console.py file <br />
- run_sql.py is a helper file for writing SQL queries <br />
- .flaskenv file to change port number<br />
- Contributing instructions <br />
- Feel free to clone and adapt for your own project.<br />

## Support

Demo project for course work, you can check my website for more information:<br />
Includes resume, current projects and research interests [tony-doyle.com](http://tony-doyle.com)<br />

## Contributing

You can contribute using [Github Flow](https://guides.github.com/introduction/flow/). Create a branch, add commits, and experiment.
