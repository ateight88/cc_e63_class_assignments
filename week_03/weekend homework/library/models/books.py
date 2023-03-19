from models.book import *

books = [
    Book("(Hard Coded) - To Kill a Mockingbird", "Harper Lee", "Classic", "Abstract", False),
    # Book("1984", "George Orwell", "Science Fiction", "Abstract", True),
    # Book("Pride and Prejudice", "Jane Austen", "Romance", "Abstract", True) 
    # Book("The Great Gatsby", "F. Scott Fitzgerald", "Classic", "Abstract", False),
    # Book("The Catcher in the Rye", "J.D. Salinger", "Fiction", "Abstract", True)
]

def list_all_books(books):
        for book in books:
            print(f"{book.title} by {book.author} ({book.genre}) {'(Checked Out)' if book.checked_out else ''}")

    
def show_book(index, books):
    book = books[index]
    print(f"{book.title} by {book.author} ({book.genre}) {'(Checked Out)' if book.checked_out else ''}")
    return (book.title, book.author, book.genre) 


def add_book(title, author, genre, abstract, checked_out, books):
    book = Book(title, author, genre, abstract, checked_out)
    books.append(book)


def delete_book(index, books):
    books.pop(index)
    return (index) 


