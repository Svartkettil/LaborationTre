package se.iths.svartkettil.laborationtre;

import javafx.beans.property.*;
import javafx.scene.control.Spinner;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PaintModel {
    List<Shape> listOfShapes = new ArrayList<>();
    //Position här?
    private final BooleanProperty circleSelected;
    private final BooleanProperty squareSelected;
    private Property<Integer> sizeProperty;
    private Property<Color> colorProperty;


    public PaintModel() {
        circleSelected = new SimpleBooleanProperty();
        squareSelected = new SimpleBooleanProperty();
        colorProperty = new SimpleObjectProperty<>();
    }

    public Color getColor(){
        return colorProperty.getValue();
    }

    public void setColorProperty(Property<Color> colorProperty) {
        this.colorProperty = colorProperty;
    }

    public Integer getSize(){
        return sizeProperty.getValue();
    }

    public void setSizeProperty(final Property<Integer> sizeProperty){
        this.sizeProperty = sizeProperty;
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
