module se.iths.svartkettil.laborationtre {
    requires javafx.controls;
    requires javafx.fxml;


    opens se.iths.svartkettil.laborationtre to javafx.fxml;
    exports se.iths.svartkettil.laborationtre;
}