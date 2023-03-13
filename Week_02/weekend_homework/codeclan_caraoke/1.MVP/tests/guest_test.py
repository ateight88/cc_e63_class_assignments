import unittest
from src.room import Room

class TestGuest(unittest.TestCase):
      def test_init(self):
        #   pass
          room = Room(101, "Ocean View")
          self.assertEqual("Ocean View", room.name)
          self.assertEqual(101, room.room_number)
          
