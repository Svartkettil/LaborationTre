package se.iths.svartkettil.laborationtre;

import javafx.beans.Observable;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static javafx.scene.paint.Color.BLACK;


public class PaintModel {
    ObservableList<Shape> listOfShapes;
    Deque<Deque<Shape>> listOfRegrets;
    Deque<Deque<Shape>> listOfInsists;
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
        this.listOfShapes = FXCollections.observableArrayList();
        this.listOfRegrets = new ArrayDeque<>();
        this.listOfInsists = new ArrayDeque<>();
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
