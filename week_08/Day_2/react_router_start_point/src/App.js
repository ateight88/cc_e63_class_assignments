import React, { useState } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

import About from './components/About';
import Home from './components/Home';
import Pricing from './components/Pricing';
import NavBar from './components/NavBar';
import Contact from './components/Contact';
import Error from './components/Error';
import Choice from './components/Choice';

const App = () => {
  let initialPricing = [
    { level: 'Hobby', cost: 0 },
    { level: 'Startup', cost: 10 },
    { level: 'Enterprise', cost: 100 },
  ];

  const [pricing, setPricing] = useState(initialPricing);

  return (
    <>
      <Router>
        <NavBar />
        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/about' element={<About />} />
          <Route path='/pricing' element={<Pricing prices={pricing} />} />
          <Route path='/contact' element={<Contact />} />
          <Route path='/choices/:choice' element={<Choice />} />
          <Route path='*' element={<Error />} />
        </Routes>
      </Router>
    </>
  );
};

export default App;
