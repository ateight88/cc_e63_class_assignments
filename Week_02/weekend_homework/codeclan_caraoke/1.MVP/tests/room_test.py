import unittest
from src.room import Room
from src.guest import Guest
from src.song import Song

class TestRoom(unittest.TestCase):
    def setUp(self):
        self.room = Room(101, 'Double')
        self.guest = Guest('John')
        self.song = Song('Shape of You', 'Ed Sheeran')

    def test_checkIn(self):
        self.room.checkIn(self.guest)
        self.assertIn(self.guest, self.room.guests)

    def test_checkOut(self):
        self.room.checkIn(self.guest)
        self.room.checkOut(self.guest)
        self.assertNotIn(self.guest, self.room.guests)

    def test_addSongs(self):
        self.room.addSongs(self.song)
        self.assertIn(self.song, self.room.songs)