package UNO5_0;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

public class TurnManagerTest {

    @Test
    public void testJugadorActualInicial() {

        TurnManager tm = new TurnManager();

        List<Player> jugadores = Arrays.asList(
                new Player("A", true),
                new Player("B", false),
                new Player("C", false)
        );

        assertEquals("A", tm.actual(jugadores).getNombre());
    }

    @Test
    public void testAvanzarTurno() {

        TurnManager tm = new TurnManager();

        List<Player> jugadores = Arrays.asList(
                new Player("A", true),
                new Player("B", false),
                new Player("C", false)
        );

        tm.avanzar(jugadores);

        assertEquals("B", tm.actual(jugadores).getNombre());

        tm.avanzar(jugadores);

        assertEquals("C", tm.actual(jugadores).getNombre());
    }

    @Test
    public void testCicloCircular() {

        TurnManager tm = new TurnManager();

        List<Player> jugadores = Arrays.asList(
                new Player("A", true),
                new Player("B", false),
                new Player("C", false)
        );

        tm.avanzar(jugadores);
        tm.avanzar(jugadores);
        tm.avanzar(jugadores);

        // debe volver al inicio
        assertEquals("A", tm.actual(jugadores).getNombre());
    }

    @Test
    public void testReversaCambiaDireccion() {

        TurnManager tm = new TurnManager();

        tm.reversa();

        assertEquals(-1, tm.getDireccion());
    }

    @Test
    public void testSiguienteJugadorNormal() {

        TurnManager tm = new TurnManager();

        List<Player> jugadores = Arrays.asList(
                new Player("A", true),
                new Player("B", false),
                new Player("C", false)
        );

        Player sig = tm.siguiente(jugadores);

        assertEquals("B", sig.getNombre());
    }

    @Test
    public void testSiguienteNoModificaTurno() {

        TurnManager tm = new TurnManager();

        List<Player> jugadores = Arrays.asList(
                new Player("A", true),
                new Player("B", false),
                new Player("C", false)
        );

        tm.siguiente(jugadores);

        // el turno sigue en A
        assertEquals("A", tm.actual(jugadores).getNombre());
    }
}