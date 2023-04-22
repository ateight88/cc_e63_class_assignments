import React, { useState, useEffect } from 'react';

function HackerNewsClient() {
  const [storyIds, setStoryIds] = useState([]);
  const [stories, setStories] = useState([]);
  const [filter, setFilter] = useState('');

  useEffect(() => {
    fetch('https://hacker-news.firebaseio.com/v0/topstories.json')
      .then(response => response.json())
      .then(data => setStoryIds(data));
  }, []);

  useEffect(
    () => {
      if (storyIds.length > 0) {
        Promise.all(
          storyIds
            .slice(0, 10)
            .map(id =>
              fetch(
                `https://hacker-news.firebaseio.com/v0/item/${id}.json`
              ).then(response => response.json())
            )
        ).then(data => setStories(data));
      }
    },
    [storyIds]
  );

  function handleFilterChange(event) {
    setFilter(event.target.value);
  }

  const filteredStories = stories.filter(story =>
    story.title.toLowerCase().includes(filter.toLowerCase())
  );

  return (
    <div>
      <form>
        <input type="text" value={filter} onChange={handleFilterChange} />
        <button type="submit">Search</button>
      </form>
      <StoryList stories={filteredStories} />
    </div>
  );
}

function StoryList(props) {
  return (
    <ul>
      {props.stories.map(story => (
        <li key={story.id}>
          <a href={story.url}>{story.title}</a>
        </li>
      ))}
    </ul>
  );
}

export default HackerNewsClient;
