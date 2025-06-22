package com.heritagegame;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class DutchSquareLevel extends PlatformerLevel {

    public void start(Stage stage) {
        super.start(stage, "/The Dutch Square.png");
    }

    @Override
    public void showQuiz() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                "What is Dutch Square in Melaka known for?\n\n" +
                "A) Blue houses\nB) Red Dutch buildings\n" +
                "C) Zoos\nD) Beaches\n\n" +
                "Correct Answer: B", ButtonType.OK);
        alert.setHeaderText("Quiz: Dutch Square");
        alert.showAndWait();
    }
}
