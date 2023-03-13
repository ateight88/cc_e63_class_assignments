import unittest
from src.room import Room
from src.guest import Guest
from src.song import Song

class TestRoom(unittest.TestCase):
    def setUp(self):
        # pass
        self.room = Room(101, "Karaoke Room 1", 5, 10)

        self.guest1 = Guest("John", 15)
        self.guest2 = Guest("Jane", 10)
        self.guest3 = Guest("Mike", 5)
        self.guest4 = Guest("Samantha", 20)

        self.song1 = Song("Bohemian Rhapsody", "Queen")
        self.song2 = Song("Sweet Caroline", "Neil Diamond")
        self.song3 = Song("Livin' on a Prayer", "Bon Jovi")


    def test_checkIn(self):
        self.assertTrue(self.room.checkIn(self.guest1))
        self.assertTrue(self.room.checkIn(self.guest2))
        self.assertTrue(self.room.checkIn(self.guest3))
        self.assertTrue(self.room.checkIn(self.guest4))
        self.assertEqual(4, len(self.room.guests))  

    def test_checkOut(self):
        guest1 = Guest("John", 15)
        guest2 = Guest("Jane", 10)
        guest3 = Guest("Mike", 5)
        guest4 = Guest("Samantha", 20)
        self.room.checkIn(guest1)
        self.room.checkIn(guest2)
        self.room.checkIn(guest3)
        self.assertTrue(self.room.checkOut(guest1))
        self.assertFalse(self.room.checkOut(guest4))
        self.assertEqual(2, len(self.room.guests))

    def test_addSongs(self):
        self.room.addSongs(self.song1)
        self.room.addSongs(self.song2)
        self.room.addSongs(self.song3)
        self.assertEqual(3, len(self.room.songs))
        self.assertIn(self.song1, self.room.songs)
        self.assertIn(self.song2, self.room.songs)
        self.assertIn(self.song3, self.room.songs)

    def test_chargeEntryFee(self):
        self.assertTrue(self.room.chargeEntryFee(self.guest1))
        self.assertTrue(self.room.chargeEntryFee(self.guest2))
        self.assertEqual(5, self.guest1.money)
        self.assertEqual(0, self.guest2.money)
        self.assertEqual(20, self.room.total_earnings)    
    
