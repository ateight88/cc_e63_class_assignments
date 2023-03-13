import unittest
from src.song import Song

class TestSong(unittest.TestCase):
      
      def test_song(self):
            song = Song("Shape of You", "Ed Sheeran")
            self.assertEqual("Shape of You", song.name)
            self.assertEqual("Ed Sheeran", song.artist)
