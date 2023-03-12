import unittest
from src.guest import Guest
from src.room import Room

class TestGuest(unittest.TestCase):
      def test_init(self):
        #   pass
        guest = Guest("Alice", 50)
        self.assertEqual(guest.name, "Alice")
        self.assertEqual(guest.money, 50)
        self.assertIsNone(guest.room)
          
