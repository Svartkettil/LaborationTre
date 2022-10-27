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
import javafx.scene.paint.Paint;


public class PaintStudioController {
    public Spinner<Integer> sizeSetter;
    public ColorPicker colorPicker;
    PaintModel model = new PaintModel();
    public Button circleChoiceButton;
    public Button squareChoiceButton;
    public ShapeFactory shapeFactory;


    @FXML
    Canvas paintStudioCanvas = new Canvas();

    public GraphicsContext daVinci;
    String selectedShape;



    public void initialize(){
        daVinci = paintStudioCanvas.getGraphicsContext2D();
    }

    public void canvasClicked(MouseEvent mouseEvent) {
        printSelectedShape(mouseEvent);
    }

    private void printSelectedShape(MouseEvent mouseEvent) {
        if (selectedShape.equals("circle"))
        printCircleOnCanvas(mouseEvent);
        else if (selectedShape.equals("square"))
        printSquareOnCanvas(mouseEvent);
    }

    public Color pickColor() {
        return colorPicker.getValue();
   }

    public void printCircleOnCanvas(MouseEvent mouseEvent) {
        Position position = new Position(mouseEvent.getX(), mouseEvent.getY());
        Circle circle = new Circle(position, pickColor(), sizeSetter.getValue());
        circle.drawShape(position, daVinci, sizeSetter, pickColor());
    }
    public void printSquareOnCanvas(MouseEvent mouseEvent){
        Position position = new Position(mouseEvent.getX(), mouseEvent.getY());
        Square square = new Square(position, pickColor(), sizeSetter.getValue());
        square.drawShape(position, daVinci, sizeSetter, pickColor());
    }
    public void circleChoiceClicked(ActionEvent actionEvent){
        selectedShape = "circle";
    }
    public void squareChoiceClicked(ActionEvent actionEvent){
        selectedShape = "square";
    }

}