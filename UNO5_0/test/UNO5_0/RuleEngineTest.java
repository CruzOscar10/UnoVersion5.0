package UNO5_0;

import static org.junit.Assert.*;
import org.junit.Test;

public class RuleEngineTest {

    @Test
    public void testColorIgualValido() {

        RuleEngine r = new RuleEngine();

        Card mesa = new Card("rojo", 5);
        Card jugada = new Card("rojo", 9);

        assertTrue(r.esJugadaValida(jugada, mesa));
    }

    @Test
    public void testNumeroIgualValido() {

        RuleEngine r = new RuleEngine();

        Card mesa = new Card("azul", 7);
        Card jugada = new Card("rojo", 7);

        assertTrue(r.esJugadaValida(jugada, mesa));
    }

    @Test
    public void testCartaNegraSiempreValida() {

        RuleEngine r = new RuleEngine();

        Card mesa = new Card("verde", 3);
        Card jugada = new Card("negro", Card.Tipo.COMODIN);

        assertTrue(r.esJugadaValida(jugada, mesa));
    }

    @Test
    public void testTipoIgualValido() {

        RuleEngine r = new RuleEngine();

        Card mesa = new Card("rojo", Card.Tipo.SALTO);
        Card jugada = new Card("azul", Card.Tipo.SALTO);

        assertTrue(r.esJugadaValida(jugada, mesa));
    }

    @Test
    public void testJugadaInvalida() {

        RuleEngine r = new RuleEngine();

        Card mesa = new Card("rojo", 5);
        Card jugada = new Card("azul", 9);

        assertFalse(r.esJugadaValida(jugada, mesa));
    }
}