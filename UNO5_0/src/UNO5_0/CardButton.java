package UNO5_0;

import java.awt.*;
import java.net.URL;
import javax.swing.*;

/**
 * Botón visual que representa una carta del juego UNO.
 *
 * <p>Este componente extiende {@link JButton} y está asociado a una
 * instancia de {@link Card}. Se encarga de mostrar la imagen de la carta
 * y manejar su tamaño visual (normal o agrandado).</p>
 *
 * <p>La imagen se obtiene mediante {@code ImageManager}.</p>
 */
public class CardButton extends JButton {

    /**
     * Carta asociada a este botón.
     */
    private Card carta;

    /**
     * Constructor del botón de carta.
     *
     * @param carta carta que será representada visualmente
     */
    public CardButton(Card carta) {

        this.carta = carta;

        setCursor(new Cursor(Cursor.HAND_CURSOR));

        setContentAreaFilled(false);

        setFocusPainted(false);

        setBorderPainted(false);

        setOpaque(false);

        normal();
    }

    /**
     * Agranda el tamaño visual de la carta.
     *
     * <p>Se usa típicamente cuando el usuario pasa el mouse por encima.</p>
     */
    public void agrandar() {

        cambiarTamano(110, 170);
    }

    /**
     * Restaura el tamaño normal de la carta.
     */
    public void normal() {

        cambiarTamano(90, 140);
    }

    /**
     * Cambia el tamaño del icono de la carta.
     *
     * @param w ancho de la imagen
     * @param h alto de la imagen
     */
    private void cambiarTamano(int w, int h) {

        String ruta = ImageManager.obtenerRuta(carta);

        URL url = getClass().getResource(ruta);

        if (url == null) {
            System.out.println("❌ Imagen no encontrada: " + ruta);
            return;
        }

        ImageIcon icon = new ImageIcon(url);

        Image img = icon.getImage()
                .getScaledInstance(w, h, Image.SCALE_SMOOTH);

        setIcon(new ImageIcon(img));
    }

    /**
     * Obtiene la carta asociada a este botón.
     *
     * @return carta del botón
     */
    public Card getCarta() {

        return carta;
    }
}