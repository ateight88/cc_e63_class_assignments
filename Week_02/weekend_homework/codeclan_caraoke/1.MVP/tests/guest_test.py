import unittest
from src.room import Room

class TestGuest(unittest.TestCase):
      def test_init(self):
        #   pass
          room = Room(101, "Ocean View")
          self.assertEqual(room.name, "Ocean View")
          self.assertEqual(room.room_number, 101)
          
