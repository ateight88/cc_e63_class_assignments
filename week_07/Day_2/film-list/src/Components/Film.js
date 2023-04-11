import React from 'react';

const Film = ({ film }) => {
  return (
    <>
      <li className='film'>
        <p>{film.name}</p>
        <span className='tag'>{film.category}</span>
        <a className='source' href={film.url} target='_blank' rel='noreferrer'>
          (Source)
        </a>
      </li>
    </>
  );
};

export default Film;
