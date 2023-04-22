import React from 'react';

const Pricing = ({ prices }) => {
  const listItems = prices.map((price, idx) => {
    return (
      <li key={idx}>
        {price.level}: £{price.cost}
      </li>
    );
  });

  return (
    <div>
      <h4>Pricing</h4>
      <ul>{listItems}</ul>
    </div>
  );
};

export default Pricing;
