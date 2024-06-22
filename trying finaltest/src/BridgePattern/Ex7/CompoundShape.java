package BridgePattern.Ex7;

public class CompoundShape implements Shape {
    private double x = 0, y = 0;
    private String color;

    public void move(double x1, double y1) {
        System.out.print("this CompoundShape move from (" + x + "," + y + ")");
        this.x = this.moveX(x1);
        this.y = this.moveY(y1);
        System.out.print("to (" + x + "," + y + ")");
    }

    public void draw() {

    }

    private double moveX(double x0) {
        x = x + x0;
        return x;
    }

    private double moveY(double y0) {
        y = y + y0;
        return y;
    }

    @Override
    public void accept(Visitor v) {
        v.visitCompoundShape(this);
    }
}
