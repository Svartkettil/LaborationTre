package se.iths.svartkettil.laborationtre;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PaintModel {
    List<Shape> listOfShapes = new ArrayList<>();
    private final BooleanProperty circleSelected;
    private final BooleanProperty squareSelected;

    public PaintModel() {
        this.circleSelected = new SimpleBooleanProperty();
        this.squareSelected = new SimpleBooleanProperty();
    }

    public boolean isCircleSelected() {
        return circleSelected.get();
    }

    public BooleanProperty circleSelectedProperty() {
        return circleSelected;
    }

    public void setCircleSelected(boolean circleSelected) {
        this.circleSelected.set(circleSelected);
    }

    public boolean isSquareSelected() {
        return squareSelected.get();
    }

    public BooleanProperty squareSelectedProperty() {
        return squareSelected;
    }

    public void setSquareSelected(boolean squareSelected) {
        this.squareSelected.set(squareSelected);
    }
}
