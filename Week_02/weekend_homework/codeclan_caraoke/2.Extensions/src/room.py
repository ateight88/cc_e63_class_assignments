from src.song import Song
# from guest import Guest

class Room:
    
    def __init__(self, room_number, name, capacity, entry_fee):
        self.room_number = room_number
        self.name = name
        self.guests = []
        self.songs = []
        self.capacity = capacity
        self.entry_fee = entry_fee
        self.total_earnings = 0
        
    def checkIn(self, guest):
        if len(self.guests) < self.capacity:
            self.guests.append(guest)
            return True
        else:
            return False
        
    def checkOut(self, guest):
        if guest in self.guests:
            self.guests.remove(guest)
            return True
        else:
            return False
        
    def addSongs(self, song):
        self.songs.append(song)
    
    def chargeEntryFee(self, guest):
        if guest.money >= self.entry_fee:
            guest.money -= self.entry_fee
            self.total_earnings += self.entry_fee
            return True
        else:
            return False
