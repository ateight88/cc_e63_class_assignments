import styled from 'styled-components';

const CountriesList = ({ countries, handleCountryClick, bucketList }) => {
  const countryElements = countries.map((country, i) => {
    const isInBucketList = bucketList.find(c => {
      return c.ccn3 === country.ccn3;
    });

    const color = isInBucketList ? 'green' : 'grey';

    return (
      <li key={i} onClick={() => handleCountryClick(country)}>
        <Anchor colour={color}>{country.name.common}</Anchor>
      </li>
    );
  });

  return (
    <Wrapper>
      <h3>List:</h3>
      <List>{countryElements}</List>
    </Wrapper>
  );
};

const Anchor = styled.a`
  cursor: pointer;
  color: ${({ colour }) => colour};
`;

const List = styled.ul`
  list-style: none;
`;

const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
`;
export default CountriesList;
