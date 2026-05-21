package UNO5_0;

import java.util.List;

/**
 * Controla el flujo de turnos del juego UNO.
 *
 * <p>Se encarga de manejar el jugador actual, el siguiente jugador,
 * el avance de turnos y la dirección del juego (normal o reversa).</p>
 *
 * <p>Es responsable de la lógica de orden de juego.</p>
 */
public class TurnManager {

    /** Índice del jugador actual */
    private int turno = 0;

    /** Dirección del juego: 1 = normal, -1 = reversa */
    private int direccion = 1;

    /**
     * Obtiene el jugador actual según el turno.
     *
     * @param jugadores lista de jugadores
     * @return jugador en turno actual
     */
    public Player actual(List<Player> jugadores) {

        return jugadores.get(turno);
    }

    /**
     * Avanza al siguiente turno según la dirección actual.
     *
     * <p>El cálculo es circular, por lo que vuelve al inicio o final
     * de la lista según corresponda.</p>
     *
     * @param jugadores lista de jugadores
     */
    public void avanzar(List<Player> jugadores) {

        turno = (
                turno
                + direccion
                + jugadores.size()
        ) % jugadores.size();
    }

    /**
     * Obtiene el siguiente jugador sin modificar el turno actual.
     *
     * @param jugadores lista de jugadores
     * @return siguiente jugador en el orden de juego
     */
    public Player siguiente(List<Player> jugadores) {

        int i = (
                turno
                + direccion
                + jugadores.size()
        ) % jugadores.size();

        return jugadores.get(i);
    }

    /**
     * Invierte la dirección del juego.
     *
     * <p>Cambia de sentido normal a reversa o viceversa.</p>
     */
    public void reversa() {

        direccion *= -1;
    }

    /**
     * Obtiene la dirección actual del juego.
     *
     * @return 1 si es normal, -1 si es reversa
     */
    public int getDireccion() {

        return direccion;
    }
}