import React, { useState, useEffect } from 'react';

function Filter({onChange})  {
  const [searchTerm, setSearchTerm] = useState("");

  const changeSearchTerm = (event) => {
    event.preventDefault();
    setSearchTerm(event.target.value);
  }

  useEffect(() => {
    onChange(searchTerm);
  }, [searchTerm]);

  const handleSubmit = (event) => {
    event.preventDefault();
  }

  return (
    <form onSubmit={handleSubmit}>
      <input
        onChange={changeSearchTerm}
        type="text"
        name="searchTerm"
        placeholder="Filter Stories"
        value={searchTerm} />
    </form>
  );
}

export default Filter;
