let email = "mail";
let pass = "pass";

for(i = 0; i < 5; i++){
    if(document.getElementById("m") == email && document.getElementById("p") == pass){
        console.log("HOME");
        document.write("DONE");
    }
    else{
        console.log(i+1);
        document.write("ERROR");
    }
}