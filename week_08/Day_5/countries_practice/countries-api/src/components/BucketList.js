import React, { useEffect } from 'react';
import styled from 'styled-components';

const BucketList = ({ bucketList, errorMessage }) => {
  useEffect(() => {}, [bucketList.length]);

  return (
    <>
      <h4>There are {bucketList.length} countries in your wishlist</h4>
      <ErrorMessage>{errorMessage}</ErrorMessage>
    </>
  );
};

const ErrorMessage = styled.p`
  color: red;
  font-size: 1.5rem;
`;
export default BucketList;
