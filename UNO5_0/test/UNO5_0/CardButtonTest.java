package UNO5_0;

import static org.junit.Assert.*;
import org.junit.Test;

import javax.swing.Icon;

public class CardButtonTest {

    @Test
    public void testCreacionBoton() {

        Card c = new Card("ROJO", 5);

        CardButton btn = new CardButton(c);

        assertNotNull(btn);
        assertEquals(c, btn.getCarta());
    }

    @Test
    public void testGetCarta() {

        Card c = new Card("AZUL", Card.Tipo.SALTO);

        CardButton btn = new CardButton(c);

        assertEquals("AZUL", btn.getCarta().getColor());
        assertEquals(Card.Tipo.SALTO, btn.getCarta().getTipo());
    }

    @Test
    public void testNormalNoNullIcon() {

        Card c = new Card("VERDE", 2);

        CardButton btn = new CardButton(c);

        btn.normal();

        Icon icon = btn.getIcon();

        assertNotNull(icon);
    }

    @Test
    public void testAgrandarNoNullIcon() {

        Card c = new Card("AMARILLO", 9);

        CardButton btn = new CardButton(c);

        btn.agrandar();

        Icon icon = btn.getIcon();

        assertNotNull(icon);
    }
}