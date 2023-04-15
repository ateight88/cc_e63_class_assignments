import React, { useState, useEffect } from 'react';
import NewsList from './NewsList';
import { categories } from '../categories';

const NewsData = () => {
  const newsLen = 6;
  const [newsData, setNewsData] = useState([]);
  const [item, setItem] = useState('technology');
  const [pgNum, setPgNum] = useState(newsLen);
  const [isLoading, setIsLoading] = useState(false);

  const Loader = () => {
    return <h1 className='message'>Loading...</h1>;
  };

  const handleLoadMore = () => {
    setPgNum(pgNum + newsLen);
  };

  useEffect(() => {
    const fetchTopNews = async () => {
      setIsLoading(true);

      try {
        const response = await fetch(
          `https://content.guardianapis.com/search?q=all&section=${item}&format=json&page-size=198&show-fields=thumbnail&api-key=test`
        );
        const data = await response.json();

        setIsLoading(false);
        setNewsData(data.response.results);
        console.log(data.response.results);
      } catch (error) {
        console.error(error);
      }
    };

    fetchTopNews();
  }, [item, pgNum]);

  return (
    <>
      <h2>News Category</h2>

      <select
        value={item}
        onChange={e => {
          setItem(e.target.value);
          setPgNum(newsLen);
        }}
      >
        {categories.map((cat, idx) => (
          <option key={idx} value={cat.id}>
            {cat.name}
          </option>
        ))}
      </select>

      {isLoading ? <Loader /> : <NewsList newsData={newsData} pgNum={pgNum} />}
      {pgNum < newsData?.length && (
        <div className='btn-container'>
          <button className='btn-load' onClick={handleLoadMore}>
            Load More
          </button>
        </div>
      )}
    </>
  );
};

export default NewsData;
