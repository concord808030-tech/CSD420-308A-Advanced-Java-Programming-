import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
//Miguel Fernandez
//5/3/2026
// Module 7.2
public class Main extends Application {

    @Override
    public void start(Stage stage) {

        // Circle1
        Circle c1 = new Circle(50);
        c1.getStyleClass().add("whiteblack");

        // Circle2
        Circle c2 = new Circle(50);
        c2.setId("redfill");

        // Circle3
        Circle c3 = new Circle(50);
        c3.setId("greenfill");

        // Circle4
        Circle c4 = new Circle(50);
        c4.getStyleClass().addAll("whiteblack", "circleborder");

        HBox root = new HBox(20, c1, c2, c3, c4);

        Scene scene = new Scene(root, 500, 200);

        // Load CSS
        scene.getStylesheets().add("mystyle.css");

        stage.setTitle("CSS Styling Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
