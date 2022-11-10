package se.iths.svartkettil.laborationtre;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class SvgFileWriter {
    FileChooser fileChooser = new FileChooser();
    Path filePath;
    public void saveToFile(PaintModel model, Stage stage){
        fileChooser.setInitialFileName("new daVinciProject");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("bajs", "*.svg"));
        filePath = fileChooser.showSaveDialog(stage.getOwner()).toPath();
        try {
            Files.write(filePath, getSvgAsString(model));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static List<String> getSvgAsString(PaintModel model){
        List<String> svgStrings = new ArrayList<>();
        svgStrings.add("<svg width=\"500.0\" height=\"500.0\" xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\">");
        model.getListOfShapes().forEach(shape -> svgStrings.add(String.join(" ", shape.toString())));
        svgStrings.add("</svg>");
        return svgStrings;
    }


}
