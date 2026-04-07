import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * CardDisplay - JavaFX Application
 * Miguel Fernandez Module 1.1
 */
public class Main extends Application {

    // display dimensions
    private static final double CARD_WIDTH  = 160;
    private static final double CARD_HEIGHT = 220;

    // Number of cards to show
    private static final int CARDS_TO_DISPLAY = 5;

    // cards in the deck
    private static final int DECK_TOTAL = 55;

    // HBox that holds the four card ImageViews
    private HBox cardBox;

    @Override
    public void start(Stage primaryStage) {

        // four ImageView placeholders
        List<ImageView> imageViews = new ArrayList<>();
        for (int i = 0; i < CARDS_TO_DISPLAY; i++) {
            ImageView iv = new ImageView();
            iv.setFitWidth(CARD_WIDTH);
            iv.setFitHeight(CARD_HEIGHT);
            iv.setPreserveRatio(true);
            imageViews.add(iv);
        }

        cardBox = new HBox(20, imageViews.toArray(new ImageView[0]));
        cardBox.setAlignment(Pos.CENTER);
        cardBox.setPadding(new Insets(35));

        // Refresh Button Lambda
        Button refreshBtn = new Button("🔀  Refresh Cards");
        refreshBtn.setStyle(
                "-fx-font-size: 16px;" +
                        "-fx-padding: 10 24 10 24;" +
                        "-fx-background-color: #B22222;" +
                        "-fx-text-fill: white;" +
                        "-fx-background-radius: 8;" +
                        "-fx-cursor: hand;"
        );

        // show new random cards
        refreshBtn.setOnAction(e -> displayRandomCards(imageViews));

        // Root
        VBox root = new VBox(20, cardBox, refreshBtn);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #F8F8FF;");

        // Load initial four cards
        displayRandomCards(imageViews);

        // Scene & Stage
        Scene scene = new Scene(root, 790, 355);
        primaryStage.setTitle("Random Card Dealer");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * Randomly selects 4 unique card numbers from 1-52
     */
    private void displayRandomCards(List<ImageView> imageViews) {

        // Build deck
        List<Integer> deck = new ArrayList<>();
        for (int i = 1; i <= DECK_TOTAL; i++) {
            deck.add(i);
        }
        Collections.shuffle(deck);

        // first CARDS_TO_SHOW numbers
        List<Integer> selected = deck.subList(0, CARDS_TO_DISPLAY);

        // assign each selected card image
        for (int i = 0; i < CARDS_TO_DISPLAY; i++) {
            int cardNum = selected.get(i);
            ImageView iv = imageViews.get(i);

            String path = "cards/" + cardNum + ".png";

            try {
                // Load from the local "cards" subdirectory
                Image img = new Image(
                        getClass().getResource(path).toExternalForm()
                );
                iv.setImage(img);
            } catch (Exception ex) {
                // Fallback: try loading as a file path directly
                try {
                    Image img = new Image("file:cards/" + cardNum + ".png");
                    iv.setImage(img);
                } catch (Exception ex2) {
                    System.err.println("Could not loaf " + path);
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
