package com.geekhub.homework2.shape.rectangle;

public class Rectangle extends Rectangular {

    public Rectangle(double sideA, double sideB) {
        super(sideA, sideB);
    }

    @Override
    public void calculateArea() {
        area = sideA * sideB;
    }

    @Override
    public void calculatePerimeter() {
        perimeter = (sideA + sideB) * 2;
    }
}
