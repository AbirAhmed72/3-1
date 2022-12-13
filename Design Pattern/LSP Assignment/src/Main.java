/*
As of the slide, square didn't do same things as a rectangle so that failed LSP

In my soln, both Square and Rectangle separately implements the Shape interface and the differentiating
method is being defined separately. Now all the methods of the interface can be implementend without any
problem.

Abir Ahmed
BSSE 1229
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Rectangle rect1 = new Rectangle();
        Square square1 = new Square();


        System.out.println(rect1.draw());
        rect1.setSize(3,9);
        System.out.println(rect1.getArea());

        System.out.println(square1.draw());
        square1.setSize(4);
        System.out.println(square1.getArea());
    }
}