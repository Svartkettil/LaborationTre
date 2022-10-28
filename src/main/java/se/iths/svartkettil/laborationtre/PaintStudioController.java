package se.iths.svartkettil.laborationtre;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Spinner;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


public class PaintStudioController {
    public Spinner<Integer> sizeSetter;
    public ColorPicker colorPicker;
    PaintModel model = new PaintModel();
    public Button circleChoiceButton;
    public Button squareChoiceButton;
    public Button regretButton;
    public ShapeFactory shapeFactory = new ShapeFactory();
    public Position position;
    public int test;


    @FXML
    Canvas paintStudioCanvas = new Canvas();

    public GraphicsContext daVinci;

    public void initialize(){
        daVinci = paintStudioCanvas.getGraphicsContext2D();
    }

    public void canvasClicked(MouseEvent mouseEvent) {
        final int size = sizeSetter.getValue();
        final int halfSize = size / 2;
        position = new Position(mouseEvent.getX() - halfSize, mouseEvent.getY() - halfSize);
        model.listOfShapes.add(shapeFactory.getNewShape(model, position, pickColor(), size));
        printListOfShapes();

    }



    public Color pickColor() {
        return colorPicker.getValue();
   }

    public void printCircleOnCanvas(MouseEvent mouseEvent) {
        int i = model.listOfShapes.size();
        Position position = new Position(mouseEvent.getX(), mouseEvent.getY());
        model.listOfShapes.add(new Circle(position, pickColor(), sizeSetter.getValue()));
        model.listOfShapes.get(i).drawShape(daVinci);

    }
    public void printSquareOnCanvas(MouseEvent mouseEvent){
        int i = model.listOfShapes.size();
        position = new Position(mouseEvent.getX(), mouseEvent.getY());
        model.listOfShapes.add(new Square(position, pickColor(), sizeSetter.getValue()));
        model.listOfShapes.get(i).drawShape(daVinci);
    }
    public void circleChoiceClicked(ActionEvent actionEvent){
        model.setSquareSelected(false);
        model.setCircleSelected(true);
    }
    public void squareChoiceClicked(ActionEvent actionEvent){
        model.setSquareSelected(true);
        model.setCircleSelected(false);
    }
    public void goBack(ActionEvent actionEvent){
        model.listOfShapes.remove(model.listOfShapes.size()-1);
        daVinci.clearRect(0.0,0.0, paintStudioCanvas.getWidth(), paintStudioCanvas.getHeight());
        printListOfShapes();
    }
    public void printListOfShapes(){
        daVinci.clearRect(0.0,0.0, paintStudioCanvas.getWidth(), paintStudioCanvas.getHeight());
        model.listOfShapes.forEach(shape -> shape.drawShape(daVinci));
        
    }

}

