package UNO5_0;

import java.awt.*;
import javax.swing.*;

/**
 * Ventana principal del juego UNO 5.0.
 *
 * <p>Este menú es la pantalla inicial de la aplicación,
 * desde donde el jugador puede iniciar una partida.</p>
 *
 * <p>Contiene un botón de "JUGAR" que solicita el nombre del jugador
 * y lanza el juego principal.</p>
 */
public class MenuPrincipal extends JFrame {

    /**
     * Constructor del menú principal.
     *
     * <p>Configura la ventana, aplica el fondo y crea el botón de inicio
     * del juego.</p>
     */
    public MenuPrincipal() {

        setTitle("UNO 5.0");

        setSize(800, 500);

        setLocationRelativeTo(null);

        setResizable(false);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        BackgroundPanel fondo =
                new BackgroundPanel();

        fondo.setLayout(
                new GridBagLayout()
        );

        JButton jugar =
                new JButton("JUGAR");

        jugar.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        40
                )
        );

        jugar.setBackground(
                new Color(220,40,40)
        );

        jugar.setForeground(Color.WHITE);

        jugar.setFocusPainted(false);

        jugar.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        jugar.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        50,
                        20,
                        50
                )
        );

        jugar.addActionListener(e -> {

            String nombre =
                    JOptionPane.showInputDialog(
                            this,
                            "Ingresa tu nombre"
                    );

            if (
                    nombre != null
                    &&
                    !nombre.isEmpty()
            ) {

                dispose();

                Game game = new Game();

                game.iniciarGUI(nombre);
            }
        });

        fondo.add(jugar);

        setContentPane(fondo);

        setVisible(true);
    }
}