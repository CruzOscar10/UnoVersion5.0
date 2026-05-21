package UNO5_0;

import static org.junit.Assert.*;
import org.junit.Test;

public class PlayerTest {

    @Test
    public void testCrearJugadorHumano() {

        Player p = new Player("Oscar", true);

        assertEquals("Oscar", p.getNombre());
        assertTrue(p.esHumano());
    }

    @Test
    public void testCrearJugadorIA() {

        Player p = new Player("Bot", false);

        assertEquals("Bot", p.getNombre());
        assertFalse(p.esHumano());
    }

    @Test
    public void testManoInicialVacia() {

        Player p = new Player("Bot", false);

        assertEquals(0, p.getMano().size());
    }

    @Test
    public void testRobarCarta() {

        Player p = new Player("Bot", false);
        Deck d = new Deck();

        p.robarCarta(d);

        assertEquals(1, p.getMano().size());
    }

    @Test
    public void testDijoUnoInicialmenteFalse() {

        Player p = new Player("Bot", false);

        assertFalse(p.dijoUno());
    }

    @Test
    public void testSetDijoUno() {

        Player p = new Player("Bot", false);

        p.setDijoUno(true);

        assertTrue(p.dijoUno());
    }

    @Test
    public void testElegirColorIAValido() {

        Player p = new Player("Bot", false);

        String color = p.elegirColorIA();

        boolean valido =
                color.equals("rojo")
                || color.equals("azul")
                || color.equals("verde")
                || color.equals("amarillo");

        assertTrue(valido);
    }
}