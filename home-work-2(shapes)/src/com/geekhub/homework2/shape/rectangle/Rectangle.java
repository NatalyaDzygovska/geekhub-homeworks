package com.geekhub.homework2.shape.rectangle;

import com.geekhub.homework2.shape.Triangle;

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

    public Triangle getTriangle() {
        return triangle;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }
}
