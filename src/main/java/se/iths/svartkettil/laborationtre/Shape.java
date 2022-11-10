package se.iths.svartkettil.laborationtre;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public abstract class Shape {
    private Position position;
    private Color color;
    private int size;

    public String getColorAsString() {
        return getColor().toString().substring(2, 10);
    }

    public Shape(Position position, Color color, int size) {
        this.color = color;
        this.size = size;
        this.position = position;
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

    abstract public boolean isInsideClickPosition(MouseEvent mouseEvent);

    public void updateShape(Color color, int size) {
        setSize(size);
        setColor(color);
    }

    abstract public Shape copyOf(Shape shape);


    abstract public String toString();
}