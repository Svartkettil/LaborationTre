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
    public void drawShape(Position position, GraphicsContext daVinci, Spinner<Integer> size, Color color) {
        daVinci.setFill(color);
        daVinci.fillOval(position.x(), position.y(),getSize(size), getSize(size));
    }


}
