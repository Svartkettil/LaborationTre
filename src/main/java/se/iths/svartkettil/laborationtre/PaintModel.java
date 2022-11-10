package se.iths.svartkettil.laborationtre;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import java.util.ArrayDeque;
import java.util.Deque;


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
    public void setShapeType(ShapeType shapeType) {
        this.shapeType.set(shapeType);
    }
    public BooleanProperty circleToggleProperty() {
        return circleToggle;
    }
    public BooleanProperty squareToggleProperty() {
        return squareToggle;
    }
    public BooleanProperty selectToggleProperty() {
        return selectToggle;
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
    public Color getColor() {
        return color.get();
    }
    public ObjectProperty<Color> colorProperty() {
        return color;
    }
    public Deque<Shape> getTempList() {
        Deque<Shape> tempList = new ArrayDeque<>();

        for (Shape shape : listOfShapes) {
            tempList.add(shape.copyOf(shape));
        }
        return tempList;
    }
    public void regret() {
        if (listOfRegrets.isEmpty())
            return;
        listOfInsists.addLast(getTempList());
        listOfShapes.clear();
        listOfShapes.addAll(listOfRegrets.removeLast());
    }
    public void insist() {
        if (listOfInsists.isEmpty())
            return;
        listOfRegrets.addLast(getTempList());
        listOfShapes.clear();
        listOfShapes.addAll(listOfInsists.removeLast());
    }
    public void updateListOfShapes(){
        Deque<Shape> tempList = getTempList();
        listOfShapes.clear();
        listOfShapes.addAll(tempList);
    }
}
