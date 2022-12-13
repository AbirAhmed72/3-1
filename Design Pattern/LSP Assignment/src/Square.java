public class Square implements IShape{

    int x, y, length;
    String color;
    @Override
    public int getArea() {
        return length*length;
    }

    @Override
    public void setTopLeft(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setSize(int length){
        this.length = length;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String draw() {
        return "red";
    }
}
