import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div className='App'>
      <header className='App-header'>
        <h3>Tony Doyle</h3>
        <p>Composer / Sound Designer / Developer</p>
        <img src={logo} className='App-logo' alt='logo' />
        <a
          className='App-link'
          href='http://tony-doyle.com'
          target='_blank'
          rel='noopener noreferrer'
        >
          Learn More
        </a>
      </header>
    </div>
  );
}

export default App;
