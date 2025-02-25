package ss7_lop_truu_tuong_va_interface.bai_tap.colorable;

import ss7_lop_truu_tuong_va_interface.bai_tap.resizeable.Resizeable;

public class Circle extends Shape implements Colorable, Resizeable {
    private double radius = 1.0;

    public Circle() {
        this.radius = Math.random() * 99;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        this.radius += this.radius * percent / 100;
    }

    @Override
    public void howToColor() {
        if (isFilled())
            System.out.println("Color the circleline");
    }
}
