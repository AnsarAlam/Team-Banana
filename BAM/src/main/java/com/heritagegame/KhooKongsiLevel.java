package com.heritagegame;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class KhooKongsiLevel extends PlatformerLevel {

    public void start(Stage stage) {
        super.start(stage, "/Khoo Kongsi.png");
    }

    @Override
    public void showQuiz() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                "Where is Khoo Kongsi located?\n\n" +
                "A) Ipoh\nB) Melaka\nC) George Town\nD) Johor Bahru\n\n" +
                "Correct Answer: C", ButtonType.OK);
        alert.setHeaderText("Quiz: Khoo Kongsi");
        alert.showAndWait();
    }
}
