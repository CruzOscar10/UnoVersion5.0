package UNO5_0;

import javax.swing.ImageIcon;
import java.net.URL;

/**
 * Clase utilitaria encargada de gestionar las rutas de imágenes
 * del juego UNO.
 */
public class ImageManager {

    /**
     * Devuelve la ruta interna del recurso según la carta.
     */
    public static String obtenerRuta(Card c) {

    	if (c.getTipo() == Card.Tipo.COMODIN) {
    	    return "/img/Comodin.png";
    	}

    	if (c.getTipo() == Card.Tipo.ROBA4) {
    	    return "/img/C4.png";
    	}

        String color = "";

        switch (c.getColor()) {

            case "amarillo":
                color = "AM";
                break;

            case "azul":
                color = "AZ";
                break;

            case "rojo":
                color = "R";
                break;

            case "verde":
                color = "V";
                break;

            default:
                color = "R";
                break;
        }

        if (c.getTipo() == Card.Tipo.NUMERO) {
            return "/img/" + color + c.getNumero() + ".png";
        }

        if (c.getTipo() == Card.Tipo.SALTO) {
            return "/img/" + color + "S.png";
        }

        if (c.getTipo() == Card.Tipo.REVERSA) {
            return "/img/" + color + "R.png";
        }

        if (c.getTipo() == Card.Tipo.ROBA2) {
            return "/img/" + color + "mas2.png";
        }

        return "/img/reverso.png";
    }

    /**
     * Convierte una carta en su imagen lista para Swing (JAR SAFE).
     */
    public static ImageIcon obtenerIcono(Card c) {

        String ruta = obtenerRuta(c);

        URL url = ImageManager.class.getResource(ruta);

        if (url == null) {
            System.out.println("❌ No encontrada: " + ruta);
            return null;
        }

        return new ImageIcon(url);
    }

    /**
     * Carga un icono desde una ruta directa (uso general).
     */
    public static ImageIcon cargar(String ruta) {

        URL url = ImageManager.class.getResource(ruta);

        if (url == null) {
            System.out.println("❌ No encontrada: " + ruta);
            return null;
        }

        return new ImageIcon(url);
    }
}