from flask import Flask, render_template, request, redirect
from repositories import book_repository
import repositories.author_repository as author_repository
from models.book import Book


from flask import Blueprint

books_blueprint = Blueprint("books", __name__)

# RESTful CRUD Routes

# INDEX
# GET '/books'
# book blueprint decorator
@books_blueprint.route("/books")
def books():
    books = book_repository.select_all() # NEW
    return render_template("books/index.html", all_books = books)


# NEW
# GET '/books/new'
# create route
@books_blueprint.route("/books/new")
# create function to select all
def new_book():
    authors = author_repository.select_all()
    return render_template("books/new.html", all_authors = authors)

# CREATE
# POST '/books'
@books_blueprint.route("/books",  methods=['POST'])
def create_book():
    # test output with print
    # print(request.form)
    title = request.form['title']
    author_id     = request.form['author_id']
    genre    = request.form['genre']
    checked_out   = request.form['checked_out']
    author        = author_repository.select(author_id)
    book        = Book(title, author, genre, checked_out)
    book_repository.save(book)
    return redirect('/books')


# SHOW
# GET '/books/<id>'
@books_blueprint.route("/books/<id>", methods=['GET'])
def show_book(id):
        # print(request.form)
        # select book
        book = book_repository.select(id)
        # render on it's own page
        return render_template("books/show.html", book=book)



# EDIT
# GET '/books/<id>/edit'
@books_blueprint.route("/books/<id>/edit", methods=['GET'])
def edit_book(id):
     book = book_repository.select(id)
     authors = author_repository.select_all()
     return render_template('books/edit.html', book = book, all_authors = authors)

# UPDATE
# PUT '/books/<id>'
@books_blueprint.route("/books/<id>", methods=['POST'])
def update_book(id):
    # print(request.form)
    title = request.form['title']
    author_id     = request.form['author_id']
    genre    = request.form['genre']
    checked_out   = request.form['checked_out']
    author = author_repository.select(author_id)
    book = Book(title, author, genre, checked_out, id)
    book_repository.update(book)
    return redirect('/books')

# DELETE
# DELETE '/books/<id>'
@books_blueprint.route("/books/<id>/delete", methods=['POST'])
def delete_book(id):
    book_repository.delete(id)
    return redirect('/books')