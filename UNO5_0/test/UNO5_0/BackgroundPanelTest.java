package UNO5_0;

import static org.junit.Assert.*;
import org.junit.Test;

import java.awt.Image;
import java.lang.reflect.Field;

public class BackgroundPanelTest {

    @Test
    public void testImagenNoNull() throws Exception {

        BackgroundPanel panel = new BackgroundPanel();

        Field field = BackgroundPanel.class.getDeclaredField("imagen");
        field.setAccessible(true);

        Image img = (Image) field.get(panel);

        assertNotNull(img);
    }

    @Test
    public void testPanelSeCrea() {

        BackgroundPanel panel = new BackgroundPanel();

        assertNotNull(panel);
    }
}