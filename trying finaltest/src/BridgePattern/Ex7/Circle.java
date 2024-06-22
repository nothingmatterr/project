package BridgePattern.Ex7;

public class Circle implements Shape {
    private double x = 0, y = 0;
    private String color;
    public void move(double x1, double y1) {
        System.out.print("this circle move from (" + x + "," + y + ")");
        this.x = this.moveX(x1);
        this.y = this.moveY(y1);
        System.out.print("to (" + x + "," + y +")");
    }
    public void draw() {
        color = "red";
        System.out.println("Circle + " + color);
    }
    @Override
    public void accept(Visitor v) {

    }
    private double moveX(double x0) {
        x = x + x0;
        return x;
    }
    private double moveY(double y0) {
        y = y + y0;
        return y;
    }
}
