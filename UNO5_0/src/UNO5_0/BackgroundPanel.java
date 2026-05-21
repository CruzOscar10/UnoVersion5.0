package UNO5_0;

import java.awt.*;
import javax.swing.*;

/**
 * Panel personalizado que representa el fondo del juego UNO.
 *
 * <p>Este panel carga una imagen de mesa de juego y la escala automáticamente
 * para adaptarse al tamaño de la ventana.</p>
 *
 * <p>Además aplica un overlay oscuro para mejorar el contraste visual
 * de los elementos del juego (cartas, botones y textos).</p>
 *
 * <p>Se utiliza como contenedor principal del JFrame del juego.</p>
 *
 * @author UNO5_0
 * @version 1.0
 */
public class BackgroundPanel extends JPanel {

    /**
     * Imagen de fondo del tablero del juego.
     */
    private Image imagen;

    /**
     * Constructor del panel de fondo.
     *
     * <p>Carga la imagen desde el recurso local "img/mesa.jpg"
     * y configura el layout del panel.</p>
     */
    public BackgroundPanel() {

    	imagen = new ImageIcon(
    	        getClass().getResource("/img/mesa.jpg")
    	).getImage();

        setLayout(new BorderLayout());
    }

    /**
     * Dibuja el fondo del panel.
     *
     * <p>Se encarga de:
     * <ul>
     *     <li>Renderizar la imagen escalada al tamaño del panel</li>
     *     <li>Aplicar un filtro oscuro semi-transparente</li>
     * </ul>
     * </p>
     *
     * @param g objeto Graphics usado para renderizar el componente
     */
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        g2.drawImage(
                imagen,
                0,
                0,
                getWidth(),
                getHeight(),
                this
        );

        // Overlay oscuro estilo juego moderno
        g2.setColor(new Color(0,0,0,70));

        g2.fillRect(
                0,
                0,
                getWidth(),
                getHeight()
        );
    }
}