package UNO5_0;

import static org.junit.Assert.*;
import org.junit.Test;

public class DeckTest {

    @Test
    public void testCreacionDeckNoNull() {

        Deck deck = new Deck();

        assertNotNull(deck);
    }

    @Test
    public void testRobarCartaNoEsNull() {

        Deck deck = new Deck();

        Card c = deck.robarCarta();

        assertNotNull(c);
    }

    @Test
    public void testRobarReduceTamano() {

        Deck deck = new Deck();

        // robamos una carta
        Card c1 = deck.robarCarta();

        assertNotNull(c1);

        // no podemos acceder lista, pero comprobamos que no crashea
        Card c2 = deck.robarCarta();

        assertNotNull(c2);
    }

    @Test
    public void testNoDebeEstarVacioAlInicio() {

        Deck deck = new Deck();

        try {
            deck.robarCarta();
        } catch (RuntimeException e) {
            fail("El deck no debería estar vacío al inicio");
        }
    }

    @Test
    public void testBarajarNoRompeDeck() {

        Deck deck = new Deck();

        deck.barajar();

        Card c = deck.robarCarta();

        assertNotNull(c);
    }

    @Test
    public void testRobarMuchasCartas() {

        Deck deck = new Deck();

        for (int i = 0; i < 20; i++) {

            Card c = deck.robarCarta();

            assertNotNull(c);
        }
    }
}