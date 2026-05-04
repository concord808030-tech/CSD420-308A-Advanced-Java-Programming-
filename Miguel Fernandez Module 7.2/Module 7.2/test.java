import javafx.scene.shape.Circle;
import javafx.scene.shape.Circle;
import static org.junit.Assert.*;
import org.junit.Test;

public class test {

    @Test
    public void testWhiteBlackClass() {
        Circle c = new Circle(50);
        c.getStyleClass().add("whiteblack");

        assertTrue(c.getStyleClass().contains("whiteblack"));
    }

    @Test
    public void testRedID() {
        Circle c = new Circle(50);
        c.setId("redfill");

        assertEquals("redfill", c.getId());
    }

    @Test
    public void testGreenID() {
        Circle c = new Circle(50);
        c.setId("greenfill");

        assertEquals("greenfill", c.getId());
    }
}
