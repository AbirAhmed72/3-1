import logo from './logo.svg';
import './App.css';
import BtnClk from './components/Btn';
import BtnHov from './components/Btn';
import ModeToggler from './components/ModeToggler';

function Header(){
	return <h1> This is Abir trying react </h1>
}

function App() {								//root
	return (
	// <Header/>
	// <BtnClk/>
	// <BtnHov/>
	<ModeToggler/>

	);
}

export default App;
