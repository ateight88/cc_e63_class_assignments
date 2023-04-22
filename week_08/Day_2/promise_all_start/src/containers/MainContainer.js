import React, { useState, useEffect } from 'react';
import CharacterSelect from '../components/CharacterSelect';
import CharacterDetail from '../components/CharacterDetail';
import './MainContainer.css';

const MainContainer = () => {
  const [characters, setCharacters] = useState([]);
  const [selectedCharacter, setSelectedCharacter] = useState(null);

  const [episodes, setEpisodes] = useState([]);

  // useEffect(() => {
  //   fetch('https://rickandmortyapi.com/api/character/')
  //     .then(res => res.json())
  //     .then(data => setCharacters(data.results));
  // }, []);

  // const handleSelectChange = character => {
  //   const episodePromises = character.episode.map(episode => {
  //     return fetch(episode).then(res => res.json());
  //   });
  //   Promise.all(episodePromises).then(data => {
  //     setEpisodes(data);
  //     // console.log(data);
  //     setSelectedCharacter(character);
  //   });
  // };
  useEffect(() => {
    async function fetchData() {
      try {
        const response = await fetch(
          'https://rickandmortyapi.com/api/character/'
        );
        const data = await response.json();
        setCharacters(data.results);
      } catch (error) {
        console.error(error);
      }
    }

    fetchData();
  }, []);

  const handleSelectChange = async character => {
    const episodePromises = character.episode.map(episode => {
      return fetch(episode).then(res => res.json());
    });
    try {
      const data = await Promise.all(episodePromises);
      setEpisodes(data);
      setSelectedCharacter(character);
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div>
      <h1>Characters</h1>
      <CharacterSelect
        characters={characters}
        handleSelectChange={handleSelectChange}
      />
      {selectedCharacter ? (
        <CharacterDetail character={selectedCharacter} episodes={episodes} />
      ) : null}
    </div>
  );
};

export default MainContainer;
