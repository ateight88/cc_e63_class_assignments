import React from 'react';
import Story from './Story';

const StoryList = ({ stories }) => {
  const storyEls = stories.map((story, i) => {
    // console.log(`story: ${JSON.stringify(story)}`);
    return <Story key={i} details={story} position={i + 1} />;
  });

  return <ul>{storyEls}</ul>;
};

export default StoryList;
