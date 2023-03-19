class Book:
    def __init__(self, title, author, genre, abstract, checked_out):
        self.title = title
        self.author = author
        self.genre = genre
        self.abstract = abstract
        self.checked_out = checked_out

    def toggle_check_out(self, checked_out):
        self.checked_out = checked_out

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