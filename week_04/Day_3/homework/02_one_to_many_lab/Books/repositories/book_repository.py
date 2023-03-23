from db.run_sql import run_sql

from models.book import Book
from models.author import Author
import repositories.author_repository as author_repository


def save(book):
    sql = "INSERT INTO books (title, author_id, genre, checked_out) VALUES (%s, %s, %s, %s) RETURNING *"
    values = [book.title, book.author.id, book.genre, book.checked_out]
    results = run_sql(sql, values)
    id = results[0]['id']
    book.id = id
    return book


def select_all():
    books = []

    sql = "SELECT * FROM books"
    results = run_sql(sql)

    for row in results:
        author = author_repository.select(row['author_id'])
        book = Book(row['title'], author, row['genre'], row['checked_out'], row['id'] )
        books.append(book)
    return books



def select(id):
    book = None
    sql = "SELECT * FROM books WHERE id = %s"
    values = [id]
    results = run_sql(sql, values)

    # checking if the list returned by `run_sql(sql, values)` is empty. Empty lists are 'fasly' 
    # Could alternativly have..
    # if len(results) > 0 
    if results:
        result = results[0]
        author = author_repository.select(result['author_id'])
        # book = Book(results['title'], author, results['genre'], results['checked_out'], results['id'] )
        book = Book(results[0]['title'], author, results[0]['genre'], results[0]['checked_out'], results[0]['id'])

    return book


def delete_all():
    sql = "DELETE  FROM books"
    run_sql(sql)


def delete(id):
    sql = "DELETE  FROM books WHERE id = %s"
    values = [id]
    run_sql(sql, values)


def update(book):
    sql = "UPDATE books SET (title, author_id, genre, checked_out) = (%s, %s, %s, %s) WHERE id = %s"
    values = [book.title, book.author.id, book.genre, book.checked_out]
    run_sql(sql, values)

def books_by_author(author):
    books = []

    sql = "SELECT * FROM books WHERE author_id = %s"
    values = [author.id]
    results = run_sql(sql, values)

    for row in results:
        book = Book(row['title'], author, row['genre'], row['checked_out'], row['id'] )
        books.append(book)
    return books