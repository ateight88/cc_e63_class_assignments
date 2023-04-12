import React, { useState, useEffect } from 'react';

const MusicData = () => {
  const [itunesData, setItunesdata] = useState([]);
  const [genre, setGenre] = useState('All');
  const [isLoading, setIsLoading] = useState(false);

  const Loader = () => {
    return <h1 className='message'>Loading...</h1>;
  };

  const genres = [
    { id: 2, name: 'Blues' },
    { id: 8, name: 'Christmas Music' },
    { id: 5, name: 'Classical' },
    { id: 9, name: 'Classical-Opera' },
    { id: 6, name: 'Country' },
    { id: 7, name: 'Electronic' },
    { id: 11, name: 'Jazz' },
    { id: 12, name: 'Latin' },
    { id: 13, name: 'New Age' },
    { id: 10, name: 'Singer-SongWriter' },
  ];

  useEffect(() => {
    const fetchTopSongs = async () => {
      setIsLoading(true);

      try {
        const response = await fetch(
          genre !== 'All'
            ? `https://itunes.apple.com/gb/rss/topsongs/limit=20/genre=${genre}/json`
            : 'https://itunes.apple.com/gb/rss/topsongs/limit=20/json'
        );
        const data = await response.json();
        const entries = data.feed.entry;

        const songList = entries.map(entry => {
          const { label: title } = entry.title;
          const { label: artist } = entry['im:artist'];
          const { label: price } = entry['im:price'];
          const { label: duration } = entry.link[1]['im:duration'];
          const { label: image } = entry['im:image'][2];

          return {
            title,
            artist,
            image,
            price,
            duration,
          };
        });

        setIsLoading(false);
        setItunesdata(songList);
        console.log(songList);
      } catch (error) {
        console.error(error);
      }
    };

    fetchTopSongs();
  }, [genre]);

  const convertMsToSec = milliseconds => {
    const seconds = Math.floor(((milliseconds % 360000) % 60000) / 1000);
    return `${seconds}s`;
  };

  return (
    <>
      {isLoading ? (
        <Loader />
      ) : (
        <div>
          <br />
          <h2>Genre</h2>
          <select value={genre} onChange={e => setGenre(e.target.value)}>
            <option value='All'>All</option>
            {genres.map((gen, idx) => (
              <option key={idx} value={gen.id}>
                {gen.name}
              </option>
            ))}
          </select>
          <div className='card-list'>
            {itunesData.map((item, index) => (
              <div className='card' key={index}>
                <img src={item.image} alt={item.title} className='card-image' />
                <div className='card-details'>
                  <h2>{item.title}</h2>
                  <p>Preview Duration: {convertMsToSec(item.duration)}</p>
                  <p>Artist: {item.artist}</p>
                  <p>Price: {item.price}</p>
                </div>
              </div>
            ))}
          </div>
        </div>
      )}
    </>
  );
};

export default MusicData;
