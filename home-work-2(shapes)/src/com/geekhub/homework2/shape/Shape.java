package com.geekhub.homework2.shape;

import java.math.BigDecimal;
import java.math.RoundingMode;

public strictfp abstract class Shape {
    protected double area;
    protected double perimeter;
    protected ShapeType shapeType;

    public abstract void calculateArea();

    public double fetchArea() {
        calculateArea();
        return area;
    }

    public abstract void calculatePerimeter();

    public void displayProperties() {
        System.out.println("The area of your " + getShapeType() + ": " + getRoundedNumber(this.fetchArea()));
        System.out.println("The perimeter of your " + getShapeType() + ": " + getRoundedNumber(this.fetchPerimeter()));
    }

    public double fetchPerimeter() {
        calculatePerimeter();
        return perimeter;
    }

    public static double getRoundedNumber(double number) {
        return new BigDecimal(number).setScale(2, RoundingMode.HALF_UP).doubleValue();
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

    public ShapeType getShapeType() {
        return shapeType;
    }

    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }
}
