package se.iths.svartkettil.laborationtre;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Spinner;
import javafx.scene.paint.Color;

public class Circle extends Shape{
    public Circle(Position position, Color color, int size) {
        super(position, color, size);
    }
    public Circle(){
    }

    @Override
    public void drawShape(GraphicsContext daVinci) {
        daVinci.setFill(getColor());
        daVinci.fillOval(getPosition().getX(), getPosition().getY(),getSize(), getSize());
    }


}
