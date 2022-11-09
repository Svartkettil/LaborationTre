package se.iths.svartkettil.laborationtre;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import static se.iths.svartkettil.laborationtre.ShapeType.CIRCLE;
import static se.iths.svartkettil.laborationtre.ShapeType.SQUARE;


public class PaintStudioController {
    public Spinner<Integer> sizeSetter;
    public ColorPicker colorPicker;
    public ToggleButton selectButton;
    public ToggleGroup shapeToggle;
    PaintModel model = new PaintModel();
    public ToggleButton circleChoiceButton;
    public ToggleButton squareChoiceButton;
    public Button regretButton;
    public ShapeFactory shapeFactory = new ShapeFactory();
    public Position position;


    @FXML
    Canvas paintStudioCanvas = new Canvas();

    public GraphicsContext daVinci;

    public void initialize(){
        daVinci = paintStudioCanvas.getGraphicsContext2D();
        sizeSetter.getValueFactory().valueProperty().bindBidirectional(model.sizeProperty());
        colorPicker.valueProperty().bindBidirectional(model.colorProperty());
    }

    public void canvasClicked(MouseEvent mouseEvent) {
        if(selectButton.isSelected())
            updateSelectedShape(mouseEvent);
        else {
            final int halfSize = model.getSize() / 2;
            position = new Position(mouseEvent.getX() - halfSize, mouseEvent.getY() - halfSize);
            model.listOfShapes.add(shapeFactory.getNewShape(position, model.getColor(), model.getSize(), model.getShapeType()));
        }
        printListOfShapes();

    }
    public void circleChoiceClicked(){
        model.setShapeType(CIRCLE);
    }
    public void squareChoiceClicked(){
        model.setShapeType(SQUARE);
    }
    public void regret(){
        model.listOfShapes.remove(model.listOfShapes.size()-1);
        daVinci.clearRect(0.0,0.0, paintStudioCanvas.getWidth(), paintStudioCanvas.getHeight());
        printListOfShapes();
    }
    public void printListOfShapes(){
        daVinci.clearRect(0.0,0.0, paintStudioCanvas.getWidth(), paintStudioCanvas.getHeight());
        model.listOfShapes.forEach(shape -> shape.drawShape(daVinci));
    }
    public void updateSelectedShape(MouseEvent mouseEvent){
        model.listOfShapes.stream()
                .filter(shape -> shape.isInsideClickPosition(mouseEvent))
                .reduce((first, second) -> second)
                .ifPresent(shape -> shape.updateShape(model.getColor(), model.getSize()));
    }


}

