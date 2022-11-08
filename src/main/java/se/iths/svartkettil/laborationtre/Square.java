package se.iths.svartkettil.laborationtre;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Spinner;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Square extends Shape{
    public Square(Position position, Color color, int size) {
        super(position, color, size);
    }
    public Square(){
    }

    @Override
    public void drawShape(GraphicsContext daVinci) {
        daVinci.setFill(getColor());
        daVinci.fillRect(getPosition().getX(), getPosition().getY(),getSize(), getSize());
    }

    @Override
    public boolean isInsideClickPosition(MouseEvent mouseEvent) {
        return mouseEvent.getX() >= getPosition().getX() &&
                mouseEvent.getX() <= getPosition().getX() + getSize() &&
                mouseEvent.getY() >= getPosition().getY() &&
                mouseEvent.getY() <= getPosition().getY() + getSize();
    }
}
