import React from 'react';

const NewsList = ({ newsData, pgNum }) => {
  const formatDate = dateStr => {
    const date = new Date(dateStr);
    const dayOfMonth = date.getDate();
    const monthStr = new Intl.DateTimeFormat('en-UK', { month: 'long' }).format(
      date
    );
    const year = date.getFullYear();
    return `${dayOfMonth} ${monthStr} ${year}`;
  };

  return (
    <>
      <div>
        <br />

        <div className='card-list'>
          {newsData?.slice(0, pgNum)?.map((item, index) => (
            <div className='card' key={index}>
              <img
                src={item.fields.thumbnail}
                alt={item.title}
                className='card-image'
              />
              <div className='card-details'>
                <h2>{item.webTitle.slice(0, 13) + '...'}</h2>
                <p>Date: {formatDate(item.webPublicationDate)}</p>
                <h3>{item.webTitle}</h3>
                <a href={item.webUrl} target='_blank' rel='noreferrer'>
                  Read Article...
                </a>
              </div>
            </div>
          ))}
        </div>
      </div>
    </>
  );
};

export default NewsList;
