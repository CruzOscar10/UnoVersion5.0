package UNO5_0;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * Clase principal que controla la lógica del juego UNO.
 *
 * <p>Gestiona jugadores, mazo, reglas, turnos y la interfaz gráfica.</p>
 *
 * <p>También coordina la ejecución de turnos de la IA y del jugador humano.</p>
 */
public class Game {

    /** Mazo principal del juego */
    private Deck deck = new Deck();

    /** Lista de jugadores en la partida */
    private List<Player> jugadores =
            new ArrayList<>();

    /** Controlador de turnos y dirección del juego */
    private TurnManager turnManager =
            new TurnManager();

    /** Motor de reglas del juego UNO */
    private RuleEngine ruleEngine =
            new RuleEngine();

    /** Pila de cartas descartadas (mesa de juego) */
    private java.util.Stack<Card> discardPile =
            new java.util.Stack<>();

    /** Interfaz gráfica del juego */
    private UnoGUI gui;

    /**
     * Inicia la partida en modo GUI.
     *
     * <p>Crea jugadores, reparte cartas y coloca la primera carta válida
     * en la mesa.</p>
     *
     * @param nombre nombre del jugador humano
     */
    public void iniciarGUI(String nombre) {

        jugadores.add(new Player(nombre, true));
        jugadores.add(new Player("Pepe", false));
        jugadores.add(new Player("Toña", false));
        jugadores.add(new Player("Mari", false));

        repartir();

        Card inicial;

        do {

            inicial = deck.robarCarta();

        } while (
                inicial.getColor().equals("negro")
                ||
                inicial.getTipo() != Card.Tipo.NUMERO
        );

        discardPile.push(inicial);

        gui = new UnoGUI(this);

        gui.actualizarColorActual(inicial.getColor());
    }

    /**
     * Reparte 7 cartas a cada jugador al inicio del juego.
     */
    private void repartir() {

        for (int i = 0; i < 7; i++) {

            for (Player p : jugadores) {

                p.robarCarta(deck);
            }
        }
    }

    /**
     * Ejecuta la acción de jugar una carta.
     *
     * @param jugador jugador que realiza la jugada
     * @param carta carta jugada
     */
    public void jugarCarta(Player jugador, Card carta) {

        discardPile.push(carta);

        gui.actualizarColorActual(carta.getColor());

        ruleEngine.aplicarEfecto(carta, jugador, this);
    }

    /**
     * Permite que el jugador elija un color cuando juega un comodín.
     *
     * @param jugador jugador actual
     */
    public void elegirColor(Player jugador) {

        String color;

        if (jugador.esHumano()) {

            color = (String) JOptionPane.showInputDialog(
                    gui,
                    "Elige color",
                    "Color",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    new String[]{
                        "rojo",
                        "azul",
                        "verde",
                        "amarillo"
                    },
                    "rojo"
            );

        } else {

            color = jugador.elegirColorIA();

            gui.agregarEvento(
                    jugador.getNombre()
                    + " eligió "
                    + color.toUpperCase()
            );
        }

        getCartaMesa().setColor(color);

        gui.actualizarColorActual(color);
    }

    /**
     * Ejecuta el turno del siguiente jugador en modo GUI.
     *
     * <p>Si el jugador es IA, se ejecuta automáticamente con un delay.</p>
     */
    public void siguienteTurnoGUI() {

        Player actual =
                turnManager.actual(jugadores);

        if (!actual.esHumano()) {

            Timer timer = new Timer(
                    1500,
                    e -> {

                        actual.jugarTurno(this);

                        if (actual.getMano().vacia()) {

                            JOptionPane.showMessageDialog(
                                    gui,
                                    actual.getNombre() + " gana!"
                            );

                            System.exit(0);
                        }

                        turnManager.avanzar(jugadores);

                        gui.actualizar();

                        siguienteTurnoGUI();
                    }
            );

            timer.setRepeats(false);

            timer.start();
        }
    }

    /**
     * Obtiene la carta actual en la mesa.
     *
     * @return carta superior del descarte
     */
    public Card getCartaMesa() {

        return discardPile.peek();
    }

    /** @return mazo del juego */
    public Deck getDeck() {

        return deck;
    }

    /** @return motor de reglas */
    public RuleEngine getRuleEngine() {

        return ruleEngine;
    }

    /** @return manejador de turnos */
    public TurnManager getTurnManager() {

        return turnManager;
    }

    /** @return lista de jugadores */
    public List<Player> getJugadores() {

        return jugadores;
    }

    /** @return interfaz gráfica */
    public UnoGUI getGui() {

        return gui;
    }
}