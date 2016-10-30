package com.geekhub.homework2.shape.rectangle;

import com.geekhub.homework2.shape.Shape;
import com.geekhub.homework2.shape.Triangle;

public abstract class Rectangular extends Shape {
    protected double sideA;
    protected double sideB;
    protected Triangle triangle;

    public Rectangular(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.triangle = new Triangle(sideA, sideB, Math.sqrt((sideA * sideA) + (sideB * sideB)));
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

    public Triangle getTriangle() {
        return triangle;
    }

    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
    }
}
