import styled from 'styled-components';

const LaunchSelector = ({ launchIncrease, launchDecrease }) => {
  return (
    <>
      <ButtonContainer>
        <Button onClick={launchDecrease}>Previous Launch</Button>
        <Button onClick={launchIncrease} background='#dcab9c'>
          Next Launch
        </Button>
      </ButtonContainer>
    </>
  );
};

const Button = styled.button`
  //NEW
  font-size: 1em;
  padding: 1em;
  margin: 0.5em;
  border: 2px solid #ced7e0;
  background: ${({ background }) => background || '#9ccddc'};
`;

const ButtonContainer = styled.div`
  //NEW
  display: flex;
  background: #054569;
  justify-content: space-evenly;
`;

export default LaunchSelector;
