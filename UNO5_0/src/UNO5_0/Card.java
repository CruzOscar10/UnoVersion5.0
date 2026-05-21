package UNO5_0;

/**
 * Representa una carta del juego UNO.
 *
 * <p>Una carta puede ser de tipo numérico o especial
 * (salto, reversa, robar, comodín).</p>
 *
 * <p>Cada carta tiene un color, un tipo y opcionalmente un número.</p>
 */
public class Card {

    /**
     * Tipos posibles de carta en UNO.
     */
    public enum Tipo {

        /** Carta numérica del 0 al 9 */
        NUMERO,

        /** Salta el turno del siguiente jugador */
        SALTO,

        /** Invierte el orden del juego */
        REVERSA,

        /** Hace que el siguiente jugador robe 2 cartas */
        ROBA2,

        /** Hace que el siguiente jugador robe 4 cartas */
        ROBA4,

        /** Carta comodín (cambio de color) */
        COMODIN
    }

    /** Color de la carta (rojo, azul, verde, amarillo o comodín) */
    private String color;

    /** Tipo de la carta */
    private Tipo tipo;

    /** Número de la carta (solo si es NUMERO, si no es -1) */
    private int numero;

    /**
     * Constructor para cartas numéricas.
     *
     * @param color color de la carta
     * @param numero número de la carta (0-9)
     */
    public Card(String color, int numero) {

        this.color = color;
        this.numero = numero;
        this.tipo = Tipo.NUMERO;
    }

    /**
     * Constructor para cartas especiales.
     *
     * @param color color de la carta
     * @param tipo tipo de carta especial
     */
    public Card(String color, Tipo tipo) {

        this.color = color;
        this.tipo = tipo;
        this.numero = -1;
    }

    /**
     * Obtiene el color de la carta.
     *
     * @return color de la carta
     */
    public String getColor() {
        return color;
    }

    /**
     * Cambia el color de la carta.
     *
     * @param color nuevo color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Obtiene el tipo de la carta.
     *
     * @return tipo de carta
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * Obtiene el número de la carta.
     *
     * @return número si es carta NUMERO, -1 si es especial
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Representación en texto de la carta.
     *
     * @return texto legible de la carta
     */
    @Override
    public String toString() {

        return tipo == Tipo.NUMERO
                ? color + " " + numero
                : color + " " + tipo;
    }
}