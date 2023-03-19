class Book:
    def __init__(self, title, author, genre, abstract, checked_out):
        self.title = title
        self.author = author
        self.genre = genre
        self.abstract = abstract
        self.checked_out = checked_out

    def toggle_check_out(self, checked_out):
        self.checked_out = checked_out




# class Book:
#     def __init__(self, title, author, genre, checked_out=False):
#         self.title = title
#         self.author = author
#         self.genre = genre
#         self.checked_out = checked_out