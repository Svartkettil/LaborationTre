package se.iths.svartkettil.laborationtre;

import javafx.scene.paint.Color;

public class ShapeFactory {
    //Ändra metod till switch

    Shape getNewShape(PaintModel model, Position position, Color color, Integer size) {
        if (model.isCircleSelected())
            return new Circle(position, color, size);
        else if (model.isSquareSelected())
            return new Square(position, color, size);
        return null;
    }

}
