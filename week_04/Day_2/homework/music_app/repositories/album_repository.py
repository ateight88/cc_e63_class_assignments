from db.run_sql import run_sql
from models.album import Album
import repositories.artist_repository as artist_repository

def select_all():
    albums = []
    sql = "SELECT * FROM albums"
    results = run_sql(sql)
    for row in results:
        artist = artist_repository.select(row['artist_id'])
        #create a new album object
        new_album = Album(
            row['title'],
            row['track'],
            artist,
            row['id']
        )
        #append to the list
        albums.append(new_album)
    return albums
#delete_all
def delete_all():
        sql = "DELETE FROM albums"
        run_sql(sql)
#delete(id)
def delete(id):
      sql = "DELETE FROM albums WHERE id = %s"
      values =[id]
      run_sql(sql, values)

#save(album)
def save(album):
    sql = "INSERT INTO albums (title, tracks, artist_id) VALUES (%s, %s, %s) RETURNING *"
    values = [album.title, album.tracks, album.artist.id]
    results = run_sql(sql, values)
    id = results[0]['id']
    album.id = id
    return album


#select(id)
def select(id):
    album = None
    sql = "SELECT * FROM albums WHERE id = %s"
    values = [id]
    results = run_sql(sql, values)
    if len(results) > 0:
        selected_album = results[0]
        artist = artist_repository.select(selected_album['artist.id'])
        album = Album(
            selected_album['title'],
            selected_album['tracks'],
            artist,
            selected_album['id']
        )
        return album
    
#update(album)
def update(album):
      sql = """UPDATE albums SET (description, artist_id, duration, completed)
      = (%s, %s, %s, %s) WHERE id = %s"""
      values = [album.title, album.tracks, album.artist.id,  album.id]
      run_sql(sql, values)

# artist album
def albums_by_artist(artist):
    sql = "SELECT * FROM albums WHERE artist_id = %s"
    values = [artist.id]
    results = run_sql(sql, values)

    artist_albums = []

    for row in results:
        album = Album(
            row['title'],
            row['tracks'],
            artist,
            row['id']
        )
        artist_albums.append(album)
    return artist_albums      