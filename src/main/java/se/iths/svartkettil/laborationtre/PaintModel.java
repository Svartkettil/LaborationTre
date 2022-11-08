package se.iths.svartkettil.laborationtre;

import javafx.beans.property.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

import static javafx.scene.paint.Color.BLACK;


public class PaintModel {
    List<Shape> listOfShapes = new ArrayList<>();
    ShapeType shapeType;
    private final ObjectProperty<Integer> size;
    private final ObjectProperty<Color> color;
    private final BooleanProperty circleToggle;
    private final BooleanProperty squareToggle;
    private final BooleanProperty selectToggle;

/**Todo;
 * Lägg till undoDeque
 * Gör en tempList och lägg in i UndoDeque precis innan du lägger till en ny shape i listan
 * UndoClicked;
 * Töm shapeList och lägg till senaste listan från undoDeque
 * */
    public PaintModel() {
        this.circleToggle = new SimpleBooleanProperty(true);
        this.squareToggle = new SimpleBooleanProperty(false);
        this.selectToggle = new SimpleBooleanProperty(false);
        this.size = new SimpleObjectProperty<>(20);
        this.color = new SimpleObjectProperty<>(BLACK);
    }

    public List<Shape> getListOfShapes() {
        return listOfShapes;
    }

    public void setListOfShapes(List<Shape> listOfShapes) {
        this.listOfShapes = listOfShapes;
    }

    public Integer getSize() {
        return size.get();
    }

    public ObjectProperty<Integer> sizeProperty() {
        return size;
    }

    public void setSize(Integer size) {
        this.size.set(size);
    }

    public Color getColor() {
        return color.get();
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }

    public void setColor(Color color) {
        this.color.set(color);
    }

    public ShapeType getShapeType() {
        return shapeType;
    }
    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }
}
