package com.geekhub.homework2.shape.rectangle;

public class Square extends Rectangular {
    private double side;

    public Square(double side) {
        super(side, side);
        this.side = side;
    }

    @Override
    public void calculateArea() {
        area = side * side;
    }

    @Override
    public void calculatePerimeter() {
        perimeter = side * 4;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}
