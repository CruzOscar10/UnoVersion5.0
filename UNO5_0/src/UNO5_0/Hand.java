package UNO5_0;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa la mano de un jugador en el juego UNO.
 *
 * <p>Gestiona la colección de cartas que tiene un jugador,
 * permitiendo agregar, eliminar y consultar cartas.</p>
 *
 * <p>También contiene métodos para evaluar jugadas válidas
 * usando el {@link RuleEngine}.</p>
 */
public class Hand {

    /**
     * Lista de cartas en la mano del jugador.
     */
    private List<Card> cartas = new ArrayList<>();

    /**
     * Agrega una carta a la mano.
     *
     * @param c carta a agregar
     */
    public void agregar(Card c) {

        cartas.add(c);
    }

    /**
     * Obtiene una carta por índice.
     *
     * @param i índice de la carta
     * @return carta en la posición indicada
     */
    public Card obtenerCarta(int i) {

        return cartas.get(i);
    }

    /**
     * Elimina una carta de la mano por índice.
     *
     * @param i índice de la carta a eliminar
     */
    public void remover(int i) {

        cartas.remove(i);
    }

    /**
     * Verifica si la mano está vacía.
     *
     * @return true si no hay cartas, false en caso contrario
     */
    public boolean vacia() {

        return cartas.isEmpty();
    }

    /**
     * Obtiene la cantidad de cartas en la mano.
     *
     * @return número de cartas
     */
    public int size() {

        return cartas.size();
    }

    /**
     * Obtiene la lista completa de cartas.
     *
     * @return lista de cartas
     */
    public List<Card> getCartas() {

        return cartas;
    }

    /**
     * Verifica si el jugador tiene al menos una jugada válida.
     *
     * @param r motor de reglas del juego
     * @param mesa carta actual en la mesa
     * @return true si existe una jugada válida
     */
    public boolean tieneJugadaValida(
            RuleEngine r,
            Card mesa
    ) {

        return cartas.stream().anyMatch(
                c -> r.esJugadaValida(c, mesa)
        );
    }

    /**
     * Obtiene y elimina la primera carta válida de la mano.
     *
     * @param r motor de reglas del juego
     * @param mesa carta actual en la mesa
     * @return carta válida encontrada o null si no hay
     */
    public Card primeraValida(
            RuleEngine r,
            Card mesa
    ) {

        for (int i = 0; i < cartas.size(); i++) {

            if (r.esJugadaValida(
                    cartas.get(i),
                    mesa
            )) {

                return cartas.remove(i);
            }
        }

        return null;
    }
}