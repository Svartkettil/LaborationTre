package se.iths.svartkettil.laborationtre;

import javafx.beans.property.*;
import javafx.scene.control.Spinner;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;


public class PaintModel {
    List<Shape> listOfShapes = new ArrayList<>();
    ShapeType shapeType;
    private Property<Integer> sizeProperty;
    private Property<Color> colorProperty;


    public PaintModel() {
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

    public ShapeType getShapeType() {
        return shapeType;
    }
    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }
}
