import React from 'react';
import { Link } from 'react-router-dom';

const NavBar = () => {
  return (
    <nav>
      <ul>
        <li>
          <Link to='/'>About</Link>
        </li>
        <li>
          <Link to='/news'>News</Link>
        </li>

        <li>
          <Link to='/stock'>Stock</Link>
        </li>
        <li>
          <Link to='/filtered-search'>Filtered Search</Link>
        </li>
        <li>
          <Link to='/filtered-search-db'>Filtered Search DB</Link>
        </li>
        <li>
          <Link to='/stock-chart'>Stock Chart</Link>
        </li>
        <li>
          <Link to='/pie-chart'>Pie Chart</Link>
        </li>
        <li>
          <Link to='/stock-chart-all'>Stock Chart All</Link>
        </li>
        <li>
          <Link to='/stock-multi-axis'>Stock Multi Axis</Link>
        </li>
        <li>
          <Link to='/highcharts-stock'>Highcharts Stock</Link>
        </li>
        <li>
          <Link to='/stock-combined'>Stock Combined</Link>
        </li>
      </ul>
    </nav>
  );
};

export default NavBar;
