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
    public Button insistButton;
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
        model.getListOfRegrets().add(model.getTempList());
        if(selectButton.isSelected())
            updateSelectedShape(mouseEvent);
        else {
            final int halfSize = model.getSize() / 2;
            position = new Position(mouseEvent.getX() - halfSize, mouseEvent.getY() - halfSize);
            model.getListOfShapes().add(shapeFactory.getNewShape(position, model.getColor(), model.getSize(), model.getShapeType()));
        }
        printListOfShapes();
        model.getListOfInsists().clear();

    }
    public void circleChoiceClicked(){
        model.setShapeType(CIRCLE);
    }
    public void squareChoiceClicked(){
        model.setShapeType(SQUARE);
    }
    public void regret(){
        model.regret();
        printListOfShapes();
    }
    public void printListOfShapes(){
        daVinci.clearRect(0.0,0.0, paintStudioCanvas.getWidth(), paintStudioCanvas.getHeight());
        model.getListOfShapes().forEach(shape -> shape.drawShape(daVinci));
    }

    public void updateSelectedShape(MouseEvent mouseEvent){
        model.getListOfShapes().stream()
                .filter(shape -> shape.isInsideClickPosition(mouseEvent))
                .reduce((first, second) -> second)
                .ifPresent(shape -> shape.updateShape(model.getColor(), model.getSize()));
    }
    public void insist(){
        model.insist();
        printListOfShapes();
    }



}

