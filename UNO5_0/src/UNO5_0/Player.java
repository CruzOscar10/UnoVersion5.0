package UNO5_0;

import java.util.Random;

/**
 * Representa un jugador dentro del juego UNO.
 *
 * <p>Puede ser humano o IA. Maneja su mano de cartas y su lógica de turno.</p>
 *
 * <p>La IA juega automáticamente siguiendo las reglas definidas en {@link RuleEngine}.</p>
 */
public class Player {

    /** Nombre del jugador */
    private String nombre;

    /** Mano de cartas del jugador */
    private Hand mano = new Hand();

    /** Indica si el jugador es humano o IA */
    private boolean humano;

    /** Indica si el jugador dijo UNO en su turno */
    private boolean dijoUno = false;

    /** Generador aleatorio para decisiones de IA */
    private Random random = new Random();

    /**
     * Constructor del jugador.
     *
     * @param nombre nombre del jugador
     * @param humano true si es jugador humano, false si es IA
     */
    public Player(String nombre, boolean humano) {

        this.nombre = nombre;
        this.humano = humano;
    }

    /**
     * Ejecuta el turno del jugador IA.
     *
     * <p>Busca una carta válida, juega una carta o roba según las reglas.</p>
     *
     * @param game instancia principal del juego
     */
    public void jugarTurno(Game game) {

        dijoUno = false;

        if (humano) {
            return;
        }

        Card carta = mano.primeraValida(
                game.getRuleEngine(),
                game.getCartaMesa()
        );

        if (carta != null) {

            game.getGui().agregarEvento(
                    nombre + " juega " + carta
            );

            game.jugarCarta(this, carta);

            if (mano.size() == 1) {

                dijoUno = true;

                game.getGui().agregarEvento(
                        nombre + " dice UNO!"
                );
            }

        } else {

            Card robada = game.getDeck().robarCarta();

            if (game.getRuleEngine()
                    .esJugadaValida(
                            robada,
                            game.getCartaMesa()
                    )) {

                game.getGui().agregarEvento(
                        nombre + " juega carta robada"
                );

                game.jugarCarta(this, robada);

            } else {

                mano.agregar(robada);

                game.getGui().agregarEvento(
                        nombre + " roba"
                );
            }
        }
    }

    /**
     * Roba una carta del mazo y la agrega a la mano.
     *
     * @param d mazo del juego
     */
    public void robarCarta(Deck d) {

        mano.agregar(d.robarCarta());
    }

    /**
     * Selecciona un color aleatorio para la IA.
     *
     * @return color elegido
     */
    public String elegirColorIA() {

        return new String[]{
                "rojo",
                "azul",
                "verde",
                "amarillo"
        }[random.nextInt(4)];
    }

    /** @return nombre del jugador */
    public String getNombre() {
        return nombre;
    }

    /** @return mano del jugador */
    public Hand getMano() {
        return mano;
    }

    /** @return true si es humano, false si es IA */
    public boolean esHumano() {
        return humano;
    }

    /** @return true si dijo UNO en su turno */
    public boolean dijoUno() {
        return dijoUno;
    }

    /**
     * Define si el jugador dijo UNO.
     *
     * @param dijoUno estado del UNO
     */
    public void setDijoUno(boolean dijoUno) {

        this.dijoUno = dijoUno;
    }
}