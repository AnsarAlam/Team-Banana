package com.heritagegame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MapTestScene extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        // Load map background
        ImageView mapView = new ImageView(new Image(getClass().getResource("/map.png").toExternalForm()));
        mapView.setFitWidth(800);
        mapView.setFitHeight(600);
        root.getChildren().add(mapView);

        // Load and place guide characters (adjust X/Y based on where they should appear)
        ImageView guide1 = makeImage("/guide1.png", 120, 400);  // Merdeka Square
        ImageView guide2 = makeImage("/guide2.png", 300, 370);  // Kellie’s Castle
        ImageView guide3 = makeImage("/guide3.png", 600, 150);  // Gunung Mulu
        ImageView guide4 = makeImage("/guide4.png", 250, 100);  // Dutch Square
        ImageView guide5 = makeImage("/guide5.png", 500, 250);  // Khoo Kongsi

        // Load player sprite
        ImageView player = makeImage("/player.png", 100, 100);

        // Add all to root
        root.getChildren().addAll(guide1, guide2, guide3, guide4, guide5, player);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Map with Guide Characters");
        primaryStage.show();
    }

    private ImageView makeImage(String path, double x, double y) {
        Image img = new Image(getClass().getResource(path).toExternalForm());
        ImageView view = new ImageView(img);
        view.setX(x);
        view.setY(y);
        view.setFitWidth(64);
        view.setFitHeight(64);
        return view;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
