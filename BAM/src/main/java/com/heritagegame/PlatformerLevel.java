package com.heritagegame;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public abstract class PlatformerLevel {

    protected ImageView player;
    protected List<ImageView> obstacles = new ArrayList<>();
    protected Pane root;
    protected Timeline gameLoop;

    private double velocityY = 0;
    private boolean jumping = false;

    public void start(Stage stage, String backgroundPath) {
        Image bgImage = new Image(getClass().getResourceAsStream(backgroundPath));
        ImageView bgView = new ImageView(bgImage);
        bgView.setFitWidth(800);
        bgView.setFitHeight(600);

        root = new Pane(bgView);

        Image playerImg = new Image(getClass().getResourceAsStream("/player.png"));
        player = new ImageView(playerImg);
        player.setFitWidth(50);
        player.setFitHeight(50);
        player.setX(100);
        player.setY(500);
        root.getChildren().add(player);

        createObstacles();

        Scene scene = new Scene(root, 800, 600);

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE && !jumping) {
                velocityY = -10;
                jumping = true;
            }
        });

        gameLoop = new Timeline(new KeyFrame(Duration.millis(16), e -> update()));
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        gameLoop.play();

        stage.setScene(scene);
    }

    private void update() {
        velocityY += 0.5;
        player.setY(player.getY() + velocityY);

        if (player.getY() >= 500) {
            player.setY(500);
            velocityY = 0;
            jumping = false;
        }

        for (ImageView obs : obstacles) {
            obs.setX(obs.getX() - 4);
            if (obs.getBoundsInParent().intersects(player.getBoundsInParent())) {
                gameLoop.stop();
                showQuiz();
                break;
            }
        }
    }

    protected void createObstacles() {
        for (int i = 0; i < 3; i++) {
            ImageView obs = new ImageView(new Image(getClass().getResourceAsStream("/obstacle.png")));
            obs.setFitWidth(40);
            obs.setFitHeight(40);
            obs.setX(800 + i * 300);
            obs.setY(520);
            obstacles.add(obs);
            root.getChildren().add(obs);
        }
    }

    public abstract void showQuiz();
}
