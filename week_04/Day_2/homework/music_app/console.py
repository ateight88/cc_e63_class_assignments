from models.album import Album
from models.artist import Artist
import repositories.album_repository as album_repository
import repositories.artist_repository as artist_repository

# clear
album_repository.delete_all()
artist_repository.delete_all()

# create
artist1 = Artist('Roger', 'Waters')
artist_repository.save(artist1)

album1 = Album('Dark Side Of The Moon', '10 Tracks', artist1)
album_repository.save(album1)

artist1_albums = album_repository.albums_by_artist(artist1)
print(f"{artist1.first_name} {artist1.last_name}'s albums: ")
for artist in artist1_albums:
    print(f"{album1.title}") 