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
        daVinci.fillRect(getPosition().getX() - getSize()/2, getPosition().getY() - getSize()/2, getSize(), getSize());
    }

    @Override
    public boolean isInsideClickPosition(MouseEvent mouseEvent) {
        return mouseEvent.getX() >= getPosition().getX() - getSize()/2 &&
                mouseEvent.getX() <= getPosition().getX() + getSize()/2 &&
                mouseEvent.getY() >= getPosition().getY() - getSize()/2 &&
                mouseEvent.getY() <= getPosition().getY() + getSize()/2;
    }
    @Override
    public Shape copyOf(Shape shape) {
        return new Square(
                shape.getPosition(),
                shape.getColor(),
                shape.getSize());
    }

    @Override
    public String toString() {
        return "<rect x=\"" + (getPosition().getX() - getSize()/2) + "\" " +
                "y=\"" + (getPosition().getY() - getSize()/2) + "\" " +
                "width=\"" + getSize() + "\" " +
                "height=\"" + getSize() + "\" " +
                "fill=\"#" + getColorAsString() + "\" />";
    }

}
