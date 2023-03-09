function ModeToggler(){
    let darkModeOn = false;
    let darkmode = <h1>darkmode is on</h1>
    let lightmode = <h1>lightmode is on</h1>

    function changeMode(){
        darkModeOn = !darkModeOn;
        darkModeOn ? console.log("darkmode on") : console.log("darkmode off");
    }

    return(
        <div>
            <button onClick={changeMode}>
                Toggle Modes
            </button>
            {darkModeOn ? darkmode : lightmode}
        </div>
    );

}

export default ModeToggler;