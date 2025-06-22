package com.heritagegame;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class MerdekaSquareLevel extends PlatformerLevel {

    public void start(Stage stage) {
        super.start(stage, "/Merdeka square background.png");
    }

    @Override
    public void showQuiz() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                "What happened at Merdeka Square?\n\n" +
                "A) Malaysia's independence was declared\nB) A royal wedding\n" +
                "C) Olympics\nD) World Cup\n\n" +
                "Correct Answer: A", ButtonType.OK);
        alert.setHeaderText("Quiz: Merdeka Square");
        alert.showAndWait();
    }
}
