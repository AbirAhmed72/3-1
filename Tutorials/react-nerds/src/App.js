import logo from './logo.svg';
import React, {useState} from 'react';
import './App.css';
import {BtnClk} from './components/Btn';
import BtnHov from './components/Btn';
import ModeToggler from './components/ModeToggler';
import Child from './components/Child';
import Header from './components/Header';
import {useReducer} from 'react';

// function Header(){
// 	return <h1> This is Abir trying react </h1>
// }

const reducer = (state, action) => {
	if(action.type === 'Buy') return {games: state.games + 1};
	if(action.type === 'Sell') return {games: state.games - 1};
}

function App() {								//root
	
	//================useState=======================================
	const [Word, setWord] = React.useState("Using stateful thing!!");
	const [Khabar, setKhabar] = useState("BHAAT");

	function handleClick(){
		Khabar = "BHAAT" ? setKhabar("BIRIYANI") : setKhabar("BHAAT");
	}
	//================useState=======================================

	//================useReducer=======================================
	const initialGames = {games: 5};
	const [state, transaction] = useReducer(reducer, initialGames);
	//================useReducer=======================================
		
	return (	
	<div>
		<BtnClk/>
		<BtnHov/>
	 	<ModeToggler/>
		<Child message = {"Message has been passed through child component"} />
		<h1>A state example: {Word}</h1>
		<Header message = {"Plate e " + Khabar + " niye khacchi!"}/>
		<button onClick={handleClick}> Amake tipe khabar bodlao</button>

		<div>
			<h1> Number of Games: {state.games}</h1>
			<div>
				<button onClick={() => transaction({type: 'Buy'})}>Buy Games</button>
				<button onClick={() => transaction({type: 'Sell'})}>Sell Games</button>
			</div>
		</div>
	</div>

	

	);
}

export default App;
