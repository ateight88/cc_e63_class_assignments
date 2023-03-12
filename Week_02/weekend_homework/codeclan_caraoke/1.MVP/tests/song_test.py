import unittest
from src.song import Song

class TestSong(unittest.TestCase):
      
      def test_song(self):
            song = Song("Shape of You", "Ed Sheeran")
            self.assertEqual(song.name, "Shape of You")
            self.assertEqual(song.artist, "Ed Sheeran")
