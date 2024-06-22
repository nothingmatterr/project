package BridgePattern.Ex7;

public interface Shape {
    void move(double x, double y);
    void draw();
    void accept(Visitor v);
}
