console.log("I like pizza!!");
window.alert("JS parbo IN SHA ALLAH!! Allah help me..");
console.log("It's really hard matee :(");

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

document.getElementById("myButton").onclick = function(){

    userAge = document.getElementById("myText").value;
    userAge = Number(userAge);
    console.log(userAge+1, typeof userAge);
    userAge += 10;
    document.getElementById("myLabel").innerHTML = "You're " + userAge;
}