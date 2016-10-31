package com.geekhub.homework2.shape;

public class Triangle extends Shape {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public void calculateArea() {
        double semiperimeter = (sideA + sideB + sideC) / 2;
        area = (Math.sqrt(semiperimeter *
                (semiperimeter - sideA) *
                (semiperimeter - sideB) *
                (semiperimeter - sideC)));
    }

    @Override
    public void calculatePerimeter() {
        perimeter = sideA + sideB + sideC;
    }

    @Override
    public void displayProperties() {
        System.out.println("Side A = " + getRoundedNumber(sideA));
        System.out.println("Side B = " + getRoundedNumber(sideB));
        System.out.println("Side C = " + getRoundedNumber(sideC));
        super.displayProperties();
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

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }
}
