package se.iths.svartkettil.laborationtre;
import javafx.geometry.Pos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Circle extends Shape{
    public Circle(Position position, Color color, int size) {
        super(position, color, size);
    }
    public Circle(){
    }
    public double radius = getSize()/2;
    @Override
    public void drawShape(GraphicsContext daVinci) {
        daVinci.setFill(getColor());
        daVinci.fillOval(getPosition().getX(), getPosition().getY(),getSize(), getSize());
    }

    public boolean isInsideClickPosition(MouseEvent mouseEvent) {
        double distX = mouseEvent.getX() - (getPosition().getX() + radius);
        double distY = mouseEvent.getY() - (getPosition().getY() + radius);
        double distance = (distX * distX) + (distY * distY);
        return distance <= Math.pow(radius, 2);
    }

    @Override
    public Shape copyOf(Shape shape) {
        return new Circle(
                shape.getPosition(),
                shape.getColor(),
                shape.getSize());
    }


}
