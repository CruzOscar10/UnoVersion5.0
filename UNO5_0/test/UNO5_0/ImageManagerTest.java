package UNO5_0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ImageManagerTest {

    // ----------------------------
    // TEST 1: ruta nunca es null
    // ----------------------------
    @Test
    void testRutaNoNull() {

        Card c = obtenerCartaReal();

        String ruta = ImageManager.obtenerRuta(c);

        assertNotNull(ruta);
    }

    // ----------------------------
    // TEST 2: siempre empieza con /img/
    // ----------------------------
    @Test
    void testFormatoRuta() {

        Card c = obtenerCartaReal();

        String ruta = ImageManager.obtenerRuta(c);

        assertTrue(ruta.startsWith("/img/"));
    }

    // ----------------------------
    // TEST 3: no rompe obtenerIcono
    // ----------------------------
    @Test
    void testObtenerIconoNoRompe() {

        Card c = obtenerCartaReal();

        assertDoesNotThrow(() -> {
            ImageManager.obtenerIcono(c);
        });
    }

    // ----------------------------
    // TEST 4: cargar no rompe
    // ----------------------------
    @Test
    void testCargarNoRompe() {

        assertDoesNotThrow(() -> {
            ImageManager.cargar("/img/reverso.png");
        });
    }

    private Card obtenerCartaReal() {

        try {
            Game game = new Game(); 
            return game.getDeck().robarCarta();
        } catch (Exception e) {
            throw new RuntimeException("No se pudo obtener carta real del juego");
        }
    }
}