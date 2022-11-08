package se.iths.svartkettil.laborationtre;

import javafx.css.Size;
import javafx.geometry.Pos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Spinner;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public abstract class Shape {
    private Position position;
    private Color color;
    private int size;

    public Shape(Position position, Color color, int size) {
        this.position = position;
        this.color = color;
        this.size = size;
    }

    public Shape() {
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    abstract public void drawShape(GraphicsContext daVinci);

    @Override
    public String toString() {
        return "Shape{" +
                "position=" + position +
                ", color=" + color +
                ", size=" + size +
                '}';
    }

    abstract public boolean isInsideClickPosition(MouseEvent mouseEvent);

    public void updateShape(Color color, int size) {
        this.size = size;
        this.color = color;
    }

}