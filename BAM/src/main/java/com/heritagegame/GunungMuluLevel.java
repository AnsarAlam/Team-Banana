package com.heritagegame;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class GunungMuluLevel extends PlatformerLevel {

    public void start(Stage stage) {
        super.start(stage, "/Gunung Mulu.png");
    }

    @Override
    public void showQuiz() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                "What is Gunung Mulu known for?\n\n" +
                "A) Coral reefs\nB) Limestone caves\n" +
                "C) Volcanoes\nD) Deserts\n\n" +
                "Correct Answer: B", ButtonType.OK);
        alert.setHeaderText("Quiz: Gunung Mulu");
        alert.showAndWait();
    }
}
