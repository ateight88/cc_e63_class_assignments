import React from 'react';
import Film from './Film';
const FilmList = ({ films }) => {
  return (
    <>
      <h3>Film List...</h3>
      {films.map(film => (
        <Film key={film.id} film={film} />
      ))}
    </>
  );
};

export default FilmList;
