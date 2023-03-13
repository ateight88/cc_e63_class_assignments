import unittest
from src.guest import Guest
from src.room import Room

class TestGuest(unittest.TestCase):
      def test_init(self):
        #   pass
        guest = Guest("Alice", 50)
        self.assertEqual("Alice", guest.name)
        self.assertEqual(50, guest.money)
        self.assertIsNone(guest.room)
          
