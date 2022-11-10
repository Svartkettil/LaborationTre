package se.iths.svartkettil.laborationtre;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaintModelTest {
    PaintStudioController controller = new PaintStudioController();
    Position position = new Position(100, 100);
    Circle circle = new Circle(position, Color.BLACK, 60);
    Circle circle2 = new Circle(position, Color.BLACK, 60);
    Circle circle3 = new Circle(position, Color.BLACK, 60);
    Square square = new Square(position, Color.BLACK, 60);
    Square square2 = new Square(position, Color.BLACK, 60);
    void addFiveShapesToList(){
        controller.model.getListOfRegrets().add(controller.model.getTempList());
        controller.model.getListOfShapes().add(circle);
        controller.model.getListOfRegrets().add(controller.model.getTempList());
        controller.model.getListOfShapes().add(circle2);
        controller.model.getListOfRegrets().add(controller.model.getTempList());
        controller.model.getListOfShapes().add(circle3);
        controller.model.getListOfRegrets().add(controller.model.getTempList());
        controller.model.getListOfShapes().add(square);
        controller.model.getListOfRegrets().add(controller.model.getTempList());
        controller.model.getListOfShapes().add(square2);
    }
    @Test
    void sizeListOfInsistsEqualsToRegretUsesSubtractedWithUsesOfInsist(){
        addFiveShapesToList();
        controller.model.regret();
        controller.model.regret();
        controller.model.regret();
        controller.model.insist();
        controller.model.insist();

        int actual = controller.model.getListOfInsists().size();
        assertEquals(1, actual, "listOfInsists should be empty");
    }
    @Test
    void modelReturnsShapeTypeSquareWhenSquareIsChosenShape(){
        controller.squareChoiceClicked();
        ShapeType actual = controller.model.getShapeType();

        assertEquals(ShapeType.SQUARE, actual, "ShapeType should be square");
    }

}