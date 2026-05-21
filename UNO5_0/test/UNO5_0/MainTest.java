package UNO5_0;

import static org.junit.Assert.*;
import org.junit.Test;

public class MainTest {

    @Test
    public void testMainNoFalla() {

        try {

            Main.main(new String[]{});

            assertTrue(true);

        } catch (Exception e) {

            fail("Main lanzó excepción: " + e.getMessage());
        }
    }

    @Test
    public void testMainConArgs() {

        try {

            Main.main(new String[]{"test"});

            assertTrue(true);

        } catch (Exception e) {

            fail("Main no debería fallar con argumentos");
        }
    }
}