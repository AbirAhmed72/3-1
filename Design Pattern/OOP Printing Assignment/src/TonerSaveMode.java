public class TonerSaveMode extends PrintMode{
    
    public String tonerSavingLevel;

    @Override
    public void applyModes() {
        if(tonerSavingLevel == "High"){
            setColorIntensity(1);
        }
        else if (tonerSavingLevel == "Medium"){
            setColorIntensity(5);
        }
        else setColorIntensity(10);
    }

}
