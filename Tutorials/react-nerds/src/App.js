import logo from './logo.svg';
import React, {useState} from 'react';
import './App.css';
import {BtnClk} from './components/Btn';
import BtnHov from './components/Btn';
import ModeToggler from './components/ModeToggler';
import Child from './components/Child';
import Header from './components/Header';
import {useReducer} from 'react';

import Homepage from './components/Homepage';
import AboutMe from './components/AboutMe';
import {Routes, Route, Link} from 'react-router-dom';
import Login from './components/login';
import Registration from './components/reg';

const topDesserts = [
  {
    id: "1",
    title: "Tiramisu",
    description: "The best tiramisu in town",
    image: "https://picsum.photos/20Ø/3ØØ/?random" ,
    price: "$5.00",
    
  },
  {
    id: "2",
    title: "Lemon Ice Cream",
    description: "Mind blowing taste",
    image: "https://picsum.photos/20Ø/3ØØ/?random" ,
    price: "$4.50",
    
  },
  {
    id: "3",
    title: "Chocolate mousse",
    description: "Unexplored flavour",
    image: "https://picsum.photos/20Ø/3ØØ/?random" ,
    price: "$6.50",
    
  }
];

// function Header(){
// 	return <h1> This is Abir trying react </h1>
// }

// const reducer = (state, action) => {
// 	if(action.type === 'Buy') return {games: state.games + 1};
// 	if(action.type === 'Sell') return {games: state.games - 1};
// }

function App() {								//root
	
	// //================useState=======================================
	// const [Word, setWord] = React.useState("Using stateful thing!!");
	// const [Khabar, setKhabar] = useState("BHAAT");

	// function handleClick(){
	// 	Khabar = "BHAAT" ? setKhabar("BIRIYANI") : setKhabar("BHAAT");
	// }
	// //================useState=======================================

	// //================useReducer=======================================
	// const initialGames = {games: 5};
	// const [state, transaction] = useReducer(reducer, initialGames);
	// //================useReducer=======================================
		
    const listItems = topDesserts.map(dessert => {
      const itemText = `${dessert.title} - ${dessert.price}`
      return <li>{itemText}</li>
    })
	return (	
	<div>
		{/* <BtnClk/>
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
		</div> */}
    {/* <div className='App'>
      <nav className='nav'>
        <Link to='/' className ='nav-item'>Homepage</Link>
        <Link to='/about-me' className ='nav-item'>About Me</Link>
      </nav>
      <Routes>
        <Route path='/' element={<Homepage/>}/>
        <Route path='/about-me' element={<AboutMe/>}/>
      </Routes>
    </div> */}
    {/* <div>
      <ol>
        {listItems}
      </ol>
    </div> */}
    <div>
      <Login></Login>
    </div>
	</div>

	

	);
}

export default App;
