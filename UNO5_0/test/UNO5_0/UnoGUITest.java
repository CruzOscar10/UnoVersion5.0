package UNO5_0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.Color;
import java.lang.reflect.Field;

public class UnoGUITest {

    @Test
    public void testCrearGUI() {

        Game game = new Game();

        game.iniciarGUI("Test");

        UnoGUI gui = game.getGui();

        assertNotNull(gui);
    }

    @Test
    public void testAgregarEvento() throws Exception {

        Game game = new Game();
        game.iniciarGUI("Test");

        UnoGUI gui = game.getGui();

        gui.agregarEvento("Movimiento de prueba");

        Field f = UnoGUI.class.getDeclaredField("eventos");
        f.setAccessible(true);

        JTextArea area = (JTextArea) f.get(gui);

        assertTrue(area.getText().contains("Movimiento de prueba"));
    }

    @Test
    public void testActualizarColorRojo() throws Exception {

        Game game = new Game();
        game.iniciarGUI("Test");

        UnoGUI gui = game.getGui();

        gui.actualizarColorActual("ROJO");

        Field f = UnoGUI.class.getDeclaredField("indicadorColor");
        f.setAccessible(true);

        JPanel panel = (JPanel) f.get(gui);

        assertEquals(new Color(220, 40, 40), panel.getBackground());
    }

    @Test
    public void testActualizarColorAzul() throws Exception {

        Game game = new Game();
        game.iniciarGUI("Test");

        UnoGUI gui = game.getGui();

        gui.actualizarColorActual("AZUL");

        Field f = UnoGUI.class.getDeclaredField("indicadorColor");
        f.setAccessible(true);

        JPanel panel = (JPanel) f.get(gui);

        assertEquals(new Color(40, 40, 220), panel.getBackground());
    }

    @Test
    public void testColorDefault() throws Exception {

        Game game = new Game();
        game.iniciarGUI("Test");

        UnoGUI gui = game.getGui();

        gui.actualizarColorActual("INEXISTENTE");

        Field f = UnoGUI.class.getDeclaredField("indicadorColor");
        f.setAccessible(true);

        JPanel panel = (JPanel) f.get(gui);

        assertEquals(Color.GRAY, panel.getBackground());
    }
}