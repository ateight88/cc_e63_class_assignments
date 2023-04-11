import { useState } from 'react';
import FilmList from './Components/FilmList';
import { initialFilms } from './StaticData/data';
import './style.css';

const App = () => {
  const [films, setFilms] = useState(initialFilms);
  const url =
    'https://www.imdb.com/calendar/?region=gb](https://www.imdb.com/calendar/?region=gb';

  return (
    <>
      <div className='main'>
        <h1>Main App Page</h1>
        <FilmList films={films} />
      </div>
      <a href={url} target='_blank' rel='noreferrer'>
        <button className='btn-large'>View More...</button>
      </a>
    </>
  );
};

export default App;
