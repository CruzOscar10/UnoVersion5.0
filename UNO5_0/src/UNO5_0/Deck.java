package UNO5_0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Representa el mazo de cartas del juego UNO.
 *
 * <p>Se encarga de crear todas las cartas del juego, barajarlas
 * y permitir robar cartas durante la partida.</p>
 *
 * <p>Incluye cartas numéricas, especiales y comodines.</p>
 */
public class Deck {

    /**
     * Lista de cartas disponibles en el mazo.
     */
    private List<Card> cartas = new ArrayList<>();

    /**
     * Constructor del mazo.
     *
     * <p>Crea todas las cartas y las baraja automáticamente.</p>
     */
    public Deck() {

        crear();

        barajar();
    }

    /**
     * Crea todas las cartas del juego UNO.
     *
     * <p>Incluye:
     * <ul>
     *     <li>Cartas numéricas (0-9)</li>
     *     <li>Cartas especiales (salto, reversa, robar 2)</li>
     *     <li>Cartas comodín y robar 4</li>
     * </ul>
     * </p>
     */
    private void crear() {

        String[] colores = {
            "rojo",
            "azul",
            "verde",
            "amarillo"
        };

        for (String color : colores) {

            cartas.add(new Card(color, 0));

            for (int i = 1; i <= 9; i++) {

                cartas.add(new Card(color, i));
                cartas.add(new Card(color, i));
            }

            for (int i = 0; i < 2; i++) {

                cartas.add(new Card(color, Card.Tipo.SALTO));

                cartas.add(new Card(color, Card.Tipo.REVERSA));

                cartas.add(new Card(color, Card.Tipo.ROBA2));
            }
        }

        for (int i = 0; i < 4; i++) {

            cartas.add(new Card("negro", Card.Tipo.COMODIN));

            cartas.add(new Card("negro", Card.Tipo.ROBA4));
        }
    }

    /**
     * Mezcla aleatoriamente las cartas del mazo.
     */
    public void barajar() {

        Collections.shuffle(cartas);
    }

    /**
     * Roba la carta superior del mazo.
     *
     * @return carta robada
     * @throws RuntimeException si no hay cartas disponibles
     */
    public Card robarCarta() {

        if (cartas.isEmpty()) {

            throw new RuntimeException(
                    "No hay cartas"
            );
        }

        return cartas.remove(0);
    }
}