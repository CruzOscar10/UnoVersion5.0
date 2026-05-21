package UNO5_0;

import static org.junit.Assert.*;
import org.junit.Test;

public class CardTest {

    @Test
    public void testCartaNumero() {

        Card c = new Card("ROJO", 5);

        assertEquals("ROJO", c.getColor());
        assertEquals(5, c.getNumero());
        assertEquals(Card.Tipo.NUMERO, c.getTipo());
    }

    @Test
    public void testCartaEspecial() {

        Card c = new Card("AZUL", Card.Tipo.SALTO);

        assertEquals("AZUL", c.getColor());
        assertEquals(Card.Tipo.SALTO, c.getTipo());
        assertEquals(-1, c.getNumero());
    }

    @Test
    public void testSetColor() {

        Card c = new Card("VERDE", 3);

        c.setColor("ROJO");

        assertEquals("ROJO", c.getColor());
    }

    @Test
    public void testToStringNumero() {

        Card c = new Card("ROJO", 7);

        assertEquals("ROJO 7", c.toString());
    }

    @Test
    public void testToStringEspecial() {

        Card c = new Card("AMARILLO", Card.Tipo.REVERSA);

        assertEquals("AMARILLO REVERSA", c.toString());
    }
}