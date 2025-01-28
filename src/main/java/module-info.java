module com.example.comp2522202510termprojectgamename {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.example.comp2522202510termprojectgamename to javafx.fxml;
    exports com.example.comp2522202510termprojectgamename;
}