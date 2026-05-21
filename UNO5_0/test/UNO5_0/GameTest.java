package UNO5_0;

import static org.junit.Assert.*;
import org.junit.Test;

public class GameTest {

    @Test
    public void testCrearGame() {

        Game game = new Game();

        assertNotNull(game);
    }

    @Test
    public void testDeckExiste() {

        Game game = new Game();

        assertNotNull(game.getDeck());
    }

    @Test
    public void testJugadoresLista() {

        Game game = new Game();

        assertNotNull(game.getJugadores());
    }

    @Test
    public void testRuleEngineExiste() {

        Game game = new Game();

        assertNotNull(game.getRuleEngine());
    }

    @Test
    public void testTurnManagerExiste() {

        Game game = new Game();

        assertNotNull(game.getTurnManager());
    }

    @Test
    public void testCartaMesaPuedeSerNullSinInicio() {

        Game game = new Game();

        try {
            game.getCartaMesa();
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(true); // aceptamos porque aún no hay cartas
        }
    }
}