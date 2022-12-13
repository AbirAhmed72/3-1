public class Rectangle implements IShape{

    int x, y, width, height;
    String color;
    public int getArea(){
        return width*height;
    }
    public void setTopLeft(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setSize(int width, int height){
        this.width = width;
        this.height = height;
    }

    public void setColor(String color){
        this.color = color;
    }
    public String draw(){
        return "Green";
    }
}
