package com.geekhub.homework2;

import com.geekhub.homework2.shape.*;
import com.geekhub.homework2.shape.rectangle.Rectangle;
import com.geekhub.homework2.shape.rectangle.Rectangular;
import com.geekhub.homework2.shape.rectangle.Square;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Application {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ShapeType shapeType = initShapeType();
        Shape shape = initShape(shapeType);

        shape.displayProperties();
        displayInnerShape(shape);
    }

    private static ShapeType initShapeType() {
        ShapeType shapeType;
        do {
            System.out.println("Please, enter the type of geometric figure: ");
            String userShapeType = scanner.nextLine();
            shapeType = defineShapeType(userShapeType);
        } while (null == shapeType);
        return shapeType;
    }

    private static Shape initShape(ShapeType shapeType) {
        Shape shape = null;
        switch (shapeType) {
            case TRIANGLE: {
                System.out.println("Enter the length of the side a:");
                double sideA = scanner.nextDouble();
                System.out.println("Enter the length of the side b:");
                double sideB = scanner.nextDouble();
                System.out.println("Enter the length of the side c:");
                double sideC = scanner.nextDouble();
                shape = new Triangle(sideA, sideB, sideC);
                break;
            }
            case SQUARE: {
                System.out.println("Enter the length of the square's side:");
                double side = scanner.nextDouble();
                shape = new Square(side);
                break;
            }
            case RECTANGLE: {
                System.out.println("Enter the length of the side a:");
                double sideA = scanner.nextDouble();
                System.out.println("Enter the length of the side b:");
                double sideB = scanner.nextDouble();
                shape = new Rectangle(sideA, sideB);
                break;
            }
            case CIRCLE: {
                System.out.println("Enter the length of the radius: ");
                double radius = scanner.nextDouble();
                shape = new Circle(radius);
            }
        }
        shape.setShapeType(shapeType);
        return shape;
    }

    private static void displayInnerShape(Shape shape) {
        if (shape instanceof Rectangular) {
            System.out.println("The shape consists of 2 equivalent triangles: ");
            Triangle triangleInner = ((Rectangular) shape).getTriangle();
            triangleInner.setShapeType(ShapeType.TRIANGLE);
            triangleInner.displayProperties();
        }
    }

    private static ShapeType defineShapeType(String userShapeType) {
        ShapeType shapeType = null;
        try {
            shapeType = ShapeType.valueOf(userShapeType.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Please, type one of available types: ");
            for (ShapeType type : ShapeType.values()) {
                System.out.println(type);
            }
        }
        return shapeType;
    }
}
