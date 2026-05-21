package UNO5_0;

import static org.junit.Assert.*;
import org.junit.Test;

public class HandTest {

    @Test
    public void testAgregarYSize() {

        Hand h = new Hand();

        h.agregar(new Card("ROJO", 5));
        h.agregar(new Card("AZUL", 2));

        assertEquals(2, h.size());
    }

    @Test
    public void testVacia() {

        Hand h = new Hand();

        assertTrue(h.vacia());

        h.agregar(new Card("VERDE", 3));

        assertFalse(h.vacia());
    }

    @Test
    public void testObtenerCarta() {

        Hand h = new Hand();

        Card c = new Card("ROJO", 7);

        h.agregar(c);

        assertEquals(c, h.obtenerCarta(0));
    }

    @Test
    public void testRemover() {

        Hand h = new Hand();

        h.agregar(new Card("ROJO", 1));
        h.agregar(new Card("AZUL", 2));

        h.remover(0);

        assertEquals(1, h.size());
    }

    @Test
    public void testGetCartas() {

        Hand h = new Hand();

        h.agregar(new Card("ROJO", 1));

        assertEquals(1, h.getCartas().size());
    }

    @Test
    public void testTieneJugadaValida() {

        Hand h = new Hand();

        RuleEngine r = new RuleEngine();

        Card mesa = new Card("ROJO", 5);

        h.agregar(new Card("ROJO", 7)); // válida
        h.agregar(new Card("AZUL", 1));

        assertTrue(h.tieneJugadaValida(r, mesa));
    }

    @Test
    public void testPrimeraValida() {

        Hand h = new Hand();

        RuleEngine r = new RuleEngine();

        Card mesa = new Card("ROJO", 5);

        h.agregar(new Card("AZUL", 1));
        h.agregar(new Card("ROJO", 7)); // válida

        Card result = h.primeraValida(r, mesa);

        assertNotNull(result);
        assertEquals(1, h.size());
    }

    @Test
    public void testPrimeraValidaNull() {

        Hand h = new Hand();

        RuleEngine r = new RuleEngine();

        Card mesa = new Card("ROJO", 5);

        h.agregar(new Card("AZUL", 1));
        h.agregar(new Card("VERDE", 2));

        Card result = h.primeraValida(r, mesa);

        assertNull(result);
    }
}