public class PageSaveMode extends PrintMode{
    
    private void adjustPageSize(){
        //algorithm to adjust page size only
    }

    private void adjustPageOrientation(){
        //algorithm to adjust page orientation only
    }

    private void reduceNumberOfPages(){
        //algorithm to reduce number of pages only
    }
    
    @Override
    public void applyModes(){
        adjustPageSize();
        adjustPageOrientation();
        reduceNumberOfPages();
    }
    
    
}
