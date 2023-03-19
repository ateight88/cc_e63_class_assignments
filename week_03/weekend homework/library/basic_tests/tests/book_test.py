import unittest
from io import StringIO
from src.book import Book

class TestBook(unittest.TestCase):
        
    def setUp(self):
        pass
        self.books = [
            Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", "A classic novel about the Jazz Age", False),
            Book("To Kill a Mockingbird", "Harper Lee", "Fiction", "A story about racial injustice in the Deep South", True)
        ] 

    def test_add_book(self):
            Book.add_book("1984", "George Orwell", "Fiction", "A dystopian novel about a totalitarian society", False, self.books)
            self.assertEqual(len(self.books), 3)
            self.assertEqual("1984", self.books[-1].title)
            self.assertEqual("George Orwell", self.books[-1].author)
            self.assertEqual("Fiction", self.books[-1].genre)

    def test_delete_book(self):
        index = Book.delete_book(0, self.books)
        self.assertEqual(1, len(self.books))
        self.assertEqual(0, index,)  

    def test_checked_out(self):
         self.assertEqual(False, self.books[0].checked_out)    
         self.assertEqual(True, self.books[1].checked_out) 

    def test_show_book(self):
        expected_output = "The Great Gatsby by F. Scott Fitzgerald (Fiction)"
        output = Book.show_book(0, self.books)
        self.assertEqual(f"{output[0]} by {output[1]} ({output[2]})", expected_output)