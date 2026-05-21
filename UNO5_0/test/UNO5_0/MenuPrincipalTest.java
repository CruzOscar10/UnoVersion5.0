package UNO5_0;

import static org.junit.Assert.*;
import org.junit.Test;

public class MenuPrincipalTest {

    @Test
    public void testCreacionMenuNoFalla() {

        try {

            MenuPrincipal menu = new MenuPrincipal();

            assertNotNull(menu);

        } catch (Exception e) {

            fail("MenuPrincipal lanzó excepción: " + e.getMessage());
        }
    }

    @Test
    public void testVentanaVisible() {

        MenuPrincipal menu = new MenuPrincipal();

        assertTrue(menu.isVisible());
    }

    @Test
    public void testTituloCorrecto() {

        MenuPrincipal menu = new MenuPrincipal();

        assertEquals("UNO 5.0", menu.getTitle());
    }

    @Test
    public void testNoResizable() {

        MenuPrincipal menu = new MenuPrincipal();

        assertFalse(menu.isResizable());
    }
}