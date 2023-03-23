class Book:

    def __init__(self, title, author, genre, checked_out = False,  id = None, ):
        self.title = title
        self.author = author
        self.genre = genre
        self.checked_out = checked_out
        self.id = id

    def mark_checked_out(self):
        self.checked_outd = True
