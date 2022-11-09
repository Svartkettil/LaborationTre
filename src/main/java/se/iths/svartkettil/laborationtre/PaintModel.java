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
import static se.iths.svartkettil.laborationtre.ShapeType.CIRCLE;


public class PaintModel {
    private final ObservableList<Shape> listOfShapes;
    private final Deque<Deque<Shape>> listOfRegrets;
    private final Deque<Deque<Shape>> listOfInsists;
    private final ObjectProperty<ShapeType> shapeType;
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
        this.shapeType = new SimpleObjectProperty<>(CIRCLE);
        this.listOfShapes = FXCollections.observableArrayList();
        this.listOfRegrets = new ArrayDeque<>();
        this.listOfInsists = new ArrayDeque<>();
    }

    public Deque<Deque<Shape>> getListOfRegrets() {
        return listOfRegrets;
    }

    public Deque<Deque<Shape>> getListOfInsists() {
        return listOfInsists;
    }

    public ShapeType getShapeType() {
        return shapeType.get();
    }

    public ObjectProperty<ShapeType> shapeTypeProperty() {
        return shapeType;
    }

    public void setShapeType(ShapeType shapeType) {
        this.shapeType.set(shapeType);
    }

    public boolean isCircleToggle() {
        return circleToggle.get();
    }

    public BooleanProperty circleToggleProperty() {
        return circleToggle;
    }

    public void setCircleToggle(boolean circleToggle) {
        this.circleToggle.set(circleToggle);
    }

    public boolean isSquareToggle() {
        return squareToggle.get();
    }

    public BooleanProperty squareToggleProperty() {
        return squareToggle;
    }

    public void setSquareToggle(boolean squareToggle) {
        this.squareToggle.set(squareToggle);
    }

    public boolean isSelectToggle() {
        return selectToggle.get();
    }

    public BooleanProperty selectToggleProperty() {
        return selectToggle;
    }

    public void setSelectToggle(boolean selectToggle) {
        this.selectToggle.set(selectToggle);
    }

    public ObservableList<Shape> getListOfShapes() {
        return listOfShapes;
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



    public void regret() {
        if (listOfRegrets.isEmpty())
            return;
        listOfInsists.addLast(getTempList());
        listOfShapes.clear();
        listOfShapes.addAll(listOfRegrets.removeLast());

    }
    public Deque<Shape> getTempList() {
        Deque<Shape> tempList = new ArrayDeque<>();

        for (Shape shape : listOfShapes) {
            tempList.add(shape.copyOf(shape));
        }
        return tempList;
    }

    public void insist() {
        if (listOfInsists.isEmpty())
            return;
        listOfRegrets.addLast(getTempList());
        listOfShapes.clear();
        listOfShapes.addAll(listOfInsists.removeLast());
    }
}
