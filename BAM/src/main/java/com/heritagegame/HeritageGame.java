package com.heritagegame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.InputStream;

public class HeritageGame extends Application {

    private static final double WIDTH = 800;
    private static final double HEIGHT = 600;
    private ImageView player;
    private double playerSpeed = 5;

    @Override
    public void start(Stage primaryStage) {
        try {
            // Try to load all resources
            Image backgroundImage = safeLoadImage("/map.png");
            Image playerImage = safeLoadImage("/player.png");
            
            // Create background (fallback if image fails)
            ImageView backgroundView = new ImageView(backgroundImage);
            backgroundView.setFitWidth(WIDTH);
            backgroundView.setFitHeight(HEIGHT);
            
            // Create player (with fallback)
            player = new ImageView(playerImage);
            player.setFitWidth(50);
            player.setFitHeight(50);
            player.setX(50);
            player.setY(400);

            // Create root pane
            Pane root = new Pane(backgroundView, player);
            
            // Add some default landmarks if the real ones fail to load
            createFallbackLandmarks(root);

            // Setup scene
            Scene scene = new Scene(root, WIDTH, HEIGHT);
            setupControls(scene, primaryStage);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Banana Heritage Adventure");
            primaryStage.show();
            
        } catch (Exception e) {
            showFatalErrorScreen(primaryStage, e);
        }
    }

    private Image safeLoadImage(String resourcePath) {
        try {
            InputStream is = getClass().getResourceAsStream(resourcePath);
            if (is != null) {
                return new Image(is);
            }
            System.err.println("Warning: Could not load " + resourcePath);
        } catch (Exception e) {
            System.err.println("Error loading " + resourcePath + ": " + e.getMessage());
        }
        return createFallbackImage();
    }

    private Image createFallbackImage() {
        int width = 50;
        int height = 50;
        WritableImage image = new WritableImage(width, height);
        PixelWriter writer = image.getPixelWriter();
        
        // Create a simple red placeholder with black border
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (x == 0 || y == 0 || x == width-1 || y == height-1) {
                    writer.setColor(x, y, Color.BLACK); // Border
                } else {
                    writer.setColor(x, y, Color.RED); // Fill
                }
            }
        }
        return image;
    }

    private void createFallbackLandmarks(Pane root) {
        Color[] colors = {Color.BLUE, Color.GREEN, Color.YELLOW, Color.PURPLE, Color.ORANGE};
        String[] landmarkNames = {"Kellie", "Dutch", "Merdeka", "Khoo", "Mulu"};
        
        for (int i = 0; i < 5; i++) {
            // Create landmark visual
            Rectangle landmark = new Rectangle(50, 50, colors[i]);
            landmark.setX(150 + i * 100);
            landmark.setY(400);
            landmark.setStroke(Color.BLACK);
            root.getChildren().add(landmark);
            
            // Add label
            Text label = new Text(landmarkNames[i]);
            label.setX(155 + i * 100);
            label.setY(430);
            root.getChildren().add(label);
        }
    }

    private void setupControls(Scene scene, Stage stage) {
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.RIGHT) {
                player.setX(Math.min(player.getX() + playerSpeed, WIDTH - 50));
            } else if (e.getCode() == KeyCode.LEFT) {
                player.setX(Math.max(player.getX() - playerSpeed, 0));
            } else if (e.getCode() == KeyCode.UP) {
                player.setY(Math.max(player.getY() - playerSpeed, 0));
            } else if (e.getCode() == KeyCode.DOWN) {
                player.setY(Math.min(player.getY() + playerSpeed, HEIGHT - 50));
            }
        });
    }

    private void showFatalErrorScreen(Stage stage, Exception e) {
        Pane errorPane = new Pane();
        errorPane.setStyle("-fx-background-color: #ffdddd; -fx-padding: 20;");
        
        Text errorText = new Text("Failed to start game:\n" + e.getMessage());
        errorText.setWrappingWidth(360);
        errorText.setX(20);
        errorText.setY(40);
        
        Text instructionText = new Text("Required files in src/main/resources/:\n"
                + "- map.png (background)\n"
                + "- player.png (character)\n\n"
                + "Check console for details");
        instructionText.setWrappingWidth(360);
        instructionText.setX(20);
        instructionText.setY(120);
        
        errorPane.getChildren().addAll(errorText, instructionText);
        
        Scene errorScene = new Scene(errorPane, 400, 200);
        stage.setScene(errorScene);
        stage.setTitle("Error - Banana Heritage Adventure");
        stage.show();
        
        e.printStackTrace();
    }

    public static void main(String[] args) {
        launch(args);
    }
}