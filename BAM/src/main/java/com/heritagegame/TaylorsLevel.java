package com.heritagegame;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class TaylorsLevel extends PlatformerLevel {

    public void start(Stage stage) {
        super.start(stage, "/Taylors.png");  // Make sure you have this image in `src/main/resources`
    }

    @Override
    public void showQuiz() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                "Where is Taylor’s University located?\n\n" +
                "A) Ipoh\nB) Selangor\nC) Johor\nD) Penang\n\n" +
                "Correct Answer: B", ButtonType.OK);
        alert.setHeaderText("Quiz: Taylor's University");
        alert.showAndWait();
    }
}
