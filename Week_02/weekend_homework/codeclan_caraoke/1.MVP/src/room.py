from src.song import Song

class Room:
    
    def __init__(self, room_number, name):        
        
        self.room_number = room_number
        self.name = name
        self.guests = []
        self.songs = []

    def checkIn(self, guest):
        self.guests.append(guest)

    def checkOut(self, guest):
        self.guests.remove(guest)

    def addSongs(self, song):
        self.songs.append(song)   

