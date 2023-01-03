public class BoosterMode extends PrintMode{
    
    private int intensityThreshold;
    
    public void getIntensityThreshold(){
        return intensityThreshold;
    }
    public void setIntensityThreshold(int intensityThreshold){
        this.intensityThreshold = intensityThreshold;
    }

    @Override
    public void applyModes(){
        setColorIntensity(intensityThreshold);
    }
}
