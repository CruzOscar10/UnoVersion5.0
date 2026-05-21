package UNO5_0;

/**
 * Motor de reglas del juego UNO.
 *
 * <p>Se encarga de validar si una jugada es válida y de aplicar
 * los efectos de las cartas especiales durante el juego.</p>
 *
 * <p>Es el núcleo lógico del sistema, independiente de la interfaz gráfica.</p>
 */
public class RuleEngine {

    /**
     * Verifica si una carta puede ser jugada sobre la carta de la mesa.
     *
     * Reglas de validación:
     * <ul>
     *     <li>Las cartas negras siempre son válidas</li>
     *     <li>Se puede jugar si el color coincide</li>
     *     <li>Si ambas cartas son numéricas, deben coincidir en número</li>
     *     <li>Si no, deben coincidir en tipo</li>
     * </ul>
     * 
     *
     * @param c carta que se desea jugar
     * @param mesa carta actualmente en la mesa
     * @return true si la jugada es válida, false en caso contrario
     */
    public boolean esJugadaValida(Card c, Card mesa) {

        if (c.getColor().equals("negro")) {
            return true;
        }

        if (c.getColor().equals(mesa.getColor())) {
            return true;
        }

        if (c.getTipo() == Card.Tipo.NUMERO
                && mesa.getTipo() == Card.Tipo.NUMERO) {

            return c.getNumero() == mesa.getNumero();
        }

        return c.getTipo() == mesa.getTipo();
    }

    /**
     * Aplica el efecto de una carta especial en el estado del juego.
     *
     * Dependiendo del tipo de carta, puede:
     * <ul>
     *     <li>Saltarse el turno del siguiente jugador</li>
     *     <li>Invertir el orden de juego</li>
     *     <li>Hacer robar cartas a otros jugadores</li>
     *     <li>Forzar cambio de color</li>
     * </ul>
     *
     *
     * @param carta carta jugada
     * @param jugador jugador que realizó la jugada
     * @param game instancia principal del juego
     */
    public void aplicarEfecto(Card carta, Player jugador, Game game) {

        TurnManager tm = game.getTurnManager();

        switch (carta.getTipo()) {

            case SALTO:

                tm.avanzar(game.getJugadores());
                break;

            case REVERSA:

                tm.reversa();
                break;

            case ROBA2:

                Player sig = tm.siguiente(game.getJugadores());

                sig.robarCarta(game.getDeck());
                sig.robarCarta(game.getDeck());

                tm.avanzar(game.getJugadores());
                break;

            case ROBA4:

                Player sig4 = tm.siguiente(game.getJugadores());

                for (int i = 0; i < 4; i++) {
                    sig4.robarCarta(game.getDeck());
                }

                tm.avanzar(game.getJugadores());

                game.elegirColor(jugador);
                break;

            case COMODIN:

                game.elegirColor(jugador);
                break;

            default:
                break;
        }
    }
}