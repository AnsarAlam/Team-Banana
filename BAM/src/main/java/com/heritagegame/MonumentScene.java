package com.heritagegame;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import com.heritagegame.Monument;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
// ... other necessary JavaFX imports

public class MonumentScene extends Scene {

    public MonumentScene(Monument monument, double width, double height) {
        // Create an AnchorPane root and initialize Scene with specified size
        super(new AnchorPane(), width, height);
        AnchorPane root = (AnchorPane) this.getRoot();

        // 1. Background Image (fills the entire scene)
        Image bgImage = new Image(monument.getBackgroundImage());
        ImageView bgImageView = new ImageView(bgImage);
        // Anchor the background to all sides to stretch it to full scene size
        AnchorPane.setTopAnchor(bgImageView, 0.0);
        AnchorPane.setBottomAnchor(bgImageView, 0.0);
        AnchorPane.setLeftAnchor(bgImageView, 0.0);
        AnchorPane.setRightAnchor(bgImageView, 0.0);
        // (By anchoring all sides and not preserving ratio, the image will scale to fill the scene)
        bgImageView.setPreserveRatio(false);
        root.getChildren().add(bgImageView);

        // 2. Guide Sprite (character image at bottom-left)
        Image guideImg = new Image(monument.getGuideImage());
        ImageView guideImageView = new ImageView(guideImg);
        // Optionally, scale the sprite if needed (for example, to a fixed height)
        // guideImageView.setFitHeight(150);
        // guideImageView.setPreserveRatio(true);
        // Position at bottom-left with a small margin from edges
        AnchorPane.setLeftAnchor(guideImageView, 0.0);
        AnchorPane.setBottomAnchor(guideImageView, 0.0);
        root.getChildren().add(guideImageView);

        // 3. Descriptions Panel (scrollable list of facts)
        VBox factsBox = new VBox(8);  // vertical box with 8px spacing between items
        factsBox.setPadding(new Insets(10, 10, 10, 10));
        factsBox.setFillWidth(true);  // allow children to expand horizontally
        // Add monument name as a title label at the top of the facts box
        Label titleLabel = new Label(monument.getName());
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setWrapText(true);
        factsBox.getChildren().add(titleLabel);
        // Add each description as a bullet-point label
        for (String fact : monument.getDescriptions()) {
            Label factLabel = new Label("• " + fact);
            factLabel.setWrapText(true);
            factLabel.setStyle("-fx-font-size: 14px;");  // set a readable font size for facts
            factsBox.getChildren().add(factLabel);
        }
        // Put the VBox of facts into a ScrollPane for scrolling if content is long
        ScrollPane scrollPane = new ScrollPane(factsBox);
        scrollPane.setFitToWidth(true);    // make scrollpane content width match its own width
        scrollPane.setPannable(true);
        // Style the scroll pane with a translucent background for readability
        scrollPane.setStyle("-fx-background-color: rgba(255, 255, 255, 0.7);");
        // Position the scrollPane (e.g., as a panel on the right side with some margins)
        AnchorPane.setTopAnchor(scrollPane, 50.0);
        AnchorPane.setBottomAnchor(scrollPane, 100.0);
        AnchorPane.setLeftAnchor(scrollPane, 200.0);
        AnchorPane.setRightAnchor(scrollPane, 50.0);
        root.getChildren().add(scrollPane);

        // 4. "Start Quiz" Button (visible and styled at bottom-right)
        Button startQuizButton = new Button("Start Quiz");
        startQuizButton.setStyle(
            "-fx-font-size: 16px; -fx-font-weight: bold; " +
            "-fx-text-fill: white; -fx-background-color: #28a745; " +  // green background
            "-fx-background-radius: 10px; -fx-padding: 8 16 8 16;"
        );
        // Position the button at bottom-right with some margin
        AnchorPane.setBottomAnchor(startQuizButton, 20.0);
        AnchorPane.setRightAnchor(startQuizButton, 30.0);
        // Placeholder action for now (to be wired to the quiz scene later)
        startQuizButton.setOnAction(e -> {
            System.out.println("Quiz starting for " + monument.getName());
            // Example for future integration: 
            // Stage stage = (Stage) this.getWindow();
            // stage.setScene(new QuizScene(monument));
        });
        root.getChildren().add(startQuizButton);
    }
}
