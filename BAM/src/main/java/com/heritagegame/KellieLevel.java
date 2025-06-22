package com.heritagegame;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class KellieLevel extends PlatformerLevel {

    public void start(Stage stage) {
        super.start(stage, "/Kellie's Castle.png");
    }

    @Override
    public void showQuiz() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                "Who built Kellie's Castle?\n\n" +
                "A) William Kellie Smith\nB) Sir Stamford Raffles\n" +
                "C) Francis Light\nD) James Brooke\n\n" +
                "Correct Answer: A", ButtonType.OK);
        alert.setHeaderText("Quiz: Kellie’s Castle");
        alert.showAndWait();
    }
}
