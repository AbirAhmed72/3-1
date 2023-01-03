public abstract class PrintMode {
    private int pgNumber;
    private int pgSize;
    private char pgOrientation;
    private int colorIntensity;
    private int costPerPage;


    public int getPgNumber(){
        return pgNumber;
    }

    public void setPgNumber(int pgNumber) {
        this.pgNumber = pgNumber;
    }


    public int getPgSize(){
        return pgSize;
    }
    public void setPgSize(int pgSize) {
        this.pgSize = pgSize;
    }

    public char getPgOrientation(){
        return pgOrientation;
    }
    public void setPgOrientation(char pgOrientation) {
        this.pgOrientation = pgOrientation;
    }

    public int getColorIntensity(){
        return colorIntensity;
    }
    public void setColorIntensity(int colorIntensity) {
        this.colorIntensity = colorIntensity;
    }

    public int getCostPerPage(){
        return costPerPage;
    }
    public void setCostPerPage(int costPerPage) {
        this.costPerPage = costPerPage;
    }

    public abstract void applyModes();


}
