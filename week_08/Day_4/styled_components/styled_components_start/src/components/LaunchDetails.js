import styled from 'styled-components';

const LaunchDetails = ({ launch }) => {
  if (!launch) {
    return <p>Loading...</p>;
  }

  return (
    <>
      <TextContainer>
        <BigParagraph>{launch.mission_name}</BigParagraph>
        <Paragraph>Flight Number: {launch.flight_number}</Paragraph>
        <Paragraph>Year: {launch.launch_year}</Paragraph>
        <Paragraph>Rocket: {launch.rocket.rocket_name}</Paragraph>
        <LastParagraph>Details of launch: {launch.details}</LastParagraph>
      </TextContainer>
    </>
  );
};

const TextContainer = styled.div`
  text-align: center;
  max-width: 50%;
  margin: 2rem 25%;
  border: 1px solid grey;
  border-radius: 1rem;
`;

const Paragraph = styled.p`
  margin: 0;
  padding: 1em;
  background-color: #ced7e0;
  color: #062c43;
  // border-radius: 1rem;
`;

const BigParagraph = styled(Paragraph)`
  //NEW
  font-size: 1.5em;
  padding: 0.5em;
  border-bottom: 1px solid #062c43;
  border-radius: 1rem 1rem 0 0;
`;

const LastParagraph = styled(Paragraph)`
  border-radius: 0 0 1rem 1rem;
`;

export default LaunchDetails;
