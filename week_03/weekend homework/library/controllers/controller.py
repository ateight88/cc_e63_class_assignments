from flask import Flask, render_template, request, redirect
from app import app
from models.book import Book
from models.books import books, list_all_books, add_book, delete_book

    # important to name folder templates
@app.route('/')
def home():
    return render_template('index.html', title='Library')

@app.route('/books')
def index():
    return render_template('books.html', title='Books', books_list=books)

@app.route('/books/<index>')
def single_book(index):
  single_book = books[int(index)]
  return render_template('book.html', book=single_book)

@app.route('/books', methods=['POST'])
def add():
    title = request.form['title']
    author = request.form['author']
    genre = request.form['genre']
    abstract = request.form['abstract']
    checked_out = False
    add_book(title, author, genre, abstract, checked_out, books)
    return redirect('/books')

@app.route('/book-remove', methods=['POST'])
def remove_task_handler():
    title = request.form['title']
    author = request.form['author']
    genre = request.form['genre']
    abstract = request.form['abstract']
    checked_out = False
    book_to_remove = None
    for i, book in enumerate(books):
        if book.title == title and book.author == author and book.genre == genre and book.abstract == abstract and book.checked_out == checked_out:
            book_to_remove = i
            break
    if book_to_remove:
        delete_book(book_to_remove, books)
    return redirect('/books')

# @app.route("/books/delete/<int:index>", methods=["POST"])
# def books_delete(index):
#     delete_book(index)
#     return redirect("/books")


















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



