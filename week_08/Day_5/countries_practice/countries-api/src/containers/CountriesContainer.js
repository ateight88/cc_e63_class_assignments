import { useEffect, useState, useRef } from 'react';
import CountriesList from '../components/CountriesList';
import BucketList from '../components/BucketList';

const CountriesContainer = () => {
  const [countries, setCountries] = useState(null);
  const [bucketList, setBucketList] = useState([]);
  const [errorMessage, setErrorMessage] = useState(null);
  const renderAfterCalled = useRef(false);

  useEffect(() => {
    if (!renderAfterCalled.current) {
      const fetchCountries = async () => {
        try {
          const res = await fetch(
            'https://restcountries.com/v3.1/lang/spanish'
          );
          const data = await res.json();

          console.log(data);
          setCountries(data);
        } catch (err) {
          console.log(err);
        }
      };
      fetchCountries();
    }
    renderAfterCalled.current = true;
  }, []);

  const addToBucketList = country => {
    // filter
    const foundCountry = bucketList.find(c => {
      return c.ccn3 === country.ccn3;
    });
    // check
    if (!foundCountry) {
      const newBucketList = [...bucketList, country];
      setBucketList(newBucketList);
      setErrorMessage(null);
    } else {
      setErrorMessage('Already in list...');
    }
  };

  return (
    <>
      <h1>Spanish Countries </h1>
      <BucketList bucketList={bucketList} errorMessage={errorMessage} />
      {countries ? (
        <CountriesList
          countries={countries}
          handleCountryClick={addToBucketList}
          bucketList={bucketList}
        />
      ) : (
        'Loading...'
      )}
    </>
  );
};

export default CountriesContainer;
