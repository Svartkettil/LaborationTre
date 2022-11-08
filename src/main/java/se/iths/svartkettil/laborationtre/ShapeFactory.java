package se.iths.svartkettil.laborationtre;

import javafx.scene.paint.Color;

public class ShapeFactory {

    Shape getNewShape(Position position, Color color, Integer size, ShapeType shapeType) {
        return switch (shapeType) {
            case CIRCLE -> new Circle(position, color, size);
            case SQUARE -> new Square(position, color, size);
        };

    }
}



