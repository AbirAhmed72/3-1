function BtnClk(){
    const clickHandler = () => console.log("I'm being clicked!");
    return (
        
        <button type="button" onClick ={clickHandler} >
            Click Abir
        </button>
        
    );
}

function BtnHov(){
    const clickHandler = () => console.log("I'm being hovered!");
    return (
        
        <button type="button" onMouseOver ={clickHandler} >
            Hover Abir
        </button>
        
    );
}

export {BtnClk};
export default BtnHov;