package se.iths.svartkettil.laborationtre;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import static se.iths.svartkettil.laborationtre.ShapeType.CIRCLE;
import static se.iths.svartkettil.laborationtre.ShapeType.SQUARE;


public class PaintStudioController {
    public Spinner<Integer> sizeSetter;
    public ColorPicker colorPicker;
    public ToggleButton selectButton;
    public ToggleGroup shapeToggle;
    public Button saveButton;
    PaintModel model = new PaintModel();
    public ToggleButton circleChoiceButton;
    public ToggleButton squareChoiceButton;
    public Button regretButton;
    public Button insistButton;
    public ShapeFactory shapeFactory = new ShapeFactory();
    public Position position;
    SvgFileWriter writer = new SvgFileWriter();


    @FXML
    Canvas paintStudioCanvas = new Canvas();

    public GraphicsContext daVinci;
    private Stage stage;

    public void initialize(){
        daVinci = paintStudioCanvas.getGraphicsContext2D();
        sizeSetter.getValueFactory().valueProperty().bindBidirectional(model.sizeProperty());
        colorPicker.valueProperty().bindBidirectional(model.colorProperty());
        circleChoiceButton.selectedProperty().bindBidirectional(model.circleToggleProperty());
        squareChoiceButton.selectedProperty().bindBidirectional(model.squareToggleProperty());
        selectButton.selectedProperty().bindBidirectional(model.selectToggleProperty());
    }

    public void canvasClicked(MouseEvent mouseEvent) {
        model.getListOfRegrets().add(model.getTempList());
        if(selectButton.isSelected()) {
            updateSelectedShape(mouseEvent);
            model.updateListOfShapes();
        }
        else {
            position = new Position(mouseEvent.getX(), mouseEvent.getY());
            model.getListOfShapes().add(shapeFactory.getNewShape(position, model.getColor(), model.getSize(), model.getShapeType()));
        }
        prepareAndDraw();

    }

    public void prepareAndDraw() {
        model.getListOfInsists().clear();
        printListOfShapes();
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


    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void save(){
        writer.saveToFile(model, stage);

    }
}

