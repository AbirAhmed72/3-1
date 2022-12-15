// console.log("I like pizza!!");
// window.alert("JS parbo IN SHA ALLAH!! Allah help me..");
// console.log("It's really hard matee :(");

let myName = "Abir";
let myAge = 22;
let myStatus = true;

if(myStatus){
    console.log("Hello " + myName + ", you're Aged " + myAge);
    document.getElementById("p2").innerHTML = "Hello " + myName + ", you're Aged " + myAge;
}

myName += " Ahmed";
myAge += 1;
myStatus = false;

if(!myStatus){
    console.log("You're now " + myName + " and your age is " + myAge);
    document.getElementById("p3").innerHTML = "You're now " + myName + " and your age is " + myAge ;

}

document.getElementById("p1").innerHTML = "You're now " + myName + " and your age is " + myAge ;



let userAge;

document.getElementById("myLabel").innerHTML = "Enter Age lah!";

document.getElementById("myButton1").onclick = function(){

    userAge = document.getElementById("myText").value;
    userAge = Number(userAge);
    console.log(userAge, typeof userAge);
    userAge += 10;
    document.getElementById("myLabel").innerHTML = "You're " + userAge;
}


document.getElementById("myButton2").onclick = function(){

    if(document.getElementById("myCheckBox").checked){
        console.log("You're Subscribed!");
    }
    else{
        console.log("not subscribed!!!!!!!");
    }
}

const visaBtn = document.getElementById("visaBtn");
const mastercardBtn = document.getElementById("mastercardBtn");
const bkashBtn = document.getElementById("bkashBtn");
const myBtn3 = document.getElementById("myButton3")

myBtn3.onclick = function(){
    
    if(visaBtn.checked){
        console.log("You selected VISA");
    }
    else if(mastercardBtn.checked){
        console.log("You selected Mastercard");
    }
    else if(bkashBtn.checked){
        console.log("You chose bKash!");
    }
    else{
        console.log("You must select a type!");
    }
}

// number guessing game!
let numOfGuesses = 0;
const answer = Math.floor((Math.random() * 10) + 1);

document.getElementById("guessSubmitButton").onclick = function(){
    let myGuess = document.getElementById("myGuessField").value;

    numOfGuesses++;

    if(myGuess == answer){
        alert(`${myGuess} is the correct number. ${numOfGuesses} guesses taken!`);
    }
    else if(myGuess < answer){
        alert(`${myGuess} is shorter than answer`)
    }
    else{
        alert(`${myGuess} is larger than answer`)
    }
}

// JS Async: callbacks

function sum(x, y, myCallback){
    myCallback(x+y);
}

function displayDOM(yo){
    alert(yo);
}

function displayConsole(dsp){
    console.log(dsp);
}

// sum(4, 19, displayDOM);
// sum(4, 19, displayConsole);

let nums = [1, 2, 3, 4, 5];
let numsCubed = nums.map(doCube);

function doCube(elements){
    return Math.pow(elements, 3);
}

// numsCubed.forEach(displayDOM);
// displayConsole(numsCubed);
// displayDOM(numsCubed);
