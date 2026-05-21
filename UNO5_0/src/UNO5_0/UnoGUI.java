package UNO5_0;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 * Clase que representa la interfaz gráfica principal (GUI) para el juego UNO 5.0.
 * Hereda de {@link JFrame} y gestiona la visualización del tablero, los bots, 
 * las cartas del jugador humano y el registro de eventos en tiempo real.
 * * @author TuNombre o Equipo
 * @version 5.0
 */
public class UnoGUI extends JFrame {

    /** Instancia del motor lógico del juego que contiene el estado actual. */
    private Game game;

    /** Panel inferior donde se muestran las cartas del jugador humano. */
    private JPanel panelJugador;

    /** Panel superior destinado a la visualización del bot Toña. */
    private JPanel topBot;

    /** Panel izquierdo destinado a la visualización del bot Mari. */
    private JPanel leftBot;
    
    /** Panel derecho destinado a la visualización del bot Pepe. */
    private JPanel rightBot;

    /** Etiqueta encargada de renderizar la imagen de la carta actual en la mesa. */
    private JLabel cartaMesa;

    /** Panel que funciona como indicador visual del color activo en la partida. */
    private JPanel indicadorColor;

    /** Etiqueta que muestra el nombre del jugador que posee el turno actual. */
    private JLabel turno;

    /** Etiqueta que muestra el sentido de rotación del juego (Normal o Reversa). */
    private JLabel direccion;

    /** Área de texto para registrar y listar cronológicamente las acciones del juego. */
    private JTextArea eventos;

    /**
     * Constructor principal de la interfaz gráfica.
     * Configura las propiedades de la ventana, establece el fondo personalizado
     * e inicializa las regiones principales de la pantalla.
     * * @param game Instancia de la clase {@link Game} con la lógica activa.
     */
    public UnoGUI(Game game) {

        this.game = game;

        setTitle("UNO 5.0");

        setSize(1600, 900);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setContentPane(new BackgroundPanel());

        crearCentro();

        crearBottom();

        actualizar();

        setVisible(true);
    }

    /**
     * Inicializa y organiza el panel central de la aplicación.
     * Distribuye los paneles para los tres bots en los extremos (Norte, Este, Oeste)
     * y la mesa de juego en el centro con el mazo de robo, la carta descartada,
     * el indicador de color y la bitácora de eventos.
     */
    private void crearCentro() {

        JPanel centro =
                new JPanel(
                        new BorderLayout()
                );

        centro.setOpaque(false);

        //--------------------------------
        // BOTS
        //--------------------------------

        topBot = new JPanel();

        topBot.setOpaque(false);

        topBot.setPreferredSize(
                new Dimension(100,180)
        );

        leftBot = new JPanel();

        leftBot.setOpaque(false);

        leftBot.setPreferredSize(
                new Dimension(200,100)
        );

        rightBot = new JPanel();

        rightBot.setOpaque(false);

        rightBot.setPreferredSize(
                new Dimension(200,100)
        );

        //--------------------------------
        // MESA
        //--------------------------------

        JPanel mesa =
                new JPanel();

        mesa.setOpaque(false);

        mesa.setLayout(
                new FlowLayout(
                        FlowLayout.CENTER,
                        60,
                        35
                )
            );

        //--------------------------------
        // MAZO
        //--------------------------------

        JButton mazo =
                new JButton();

        ImageIcon reverso = new ImageIcon(
                getClass().getResource("/img/mazo.png")
        );

        Image img =
                reverso.getImage()
                        .getScaledInstance(
                                190,
                                270,
                                Image.SCALE_SMOOTH
                        );

        mazo.setIcon(
                new ImageIcon(img)
        );

        mazo.setBorderPainted(false);

        mazo.setContentAreaFilled(false);

        mazo.setFocusPainted(false);

        //--------------------------------
        // BOTON ROBAR
        //--------------------------------

        JButton robar =
                new JButton(
                        "ROBAR CARTA"
                );

        robar.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );

        robar.setBackground(
                new Color(220,40,40)
        );

        robar.setForeground(Color.WHITE);

        robar.setFocusPainted(false);

        robar.setBorderPainted(false);

        robar.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        robar.setPreferredSize(
                new Dimension(180,50)
        );

        //--------------------------------
        // PANEL MAZO
        //--------------------------------

        JPanel zonaMazo =
                new JPanel();

        zonaMazo.setOpaque(false);

        zonaMazo.setLayout(
                new BoxLayout(
                        zonaMazo,
                        BoxLayout.Y_AXIS
                )
        );

        mazo.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        robar.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        zonaMazo.add(mazo);

        zonaMazo.add(
                Box.createVerticalStrut(15)
        );

        zonaMazo.add(robar);

        //--------------------------------
        // CARTA CENTRAL Y INDICADOR
        //--------------------------------

        cartaMesa =
                new JLabel();

        indicadorColor = new JPanel();
        indicadorColor.setPreferredSize(new Dimension(55, 55));
        indicadorColor.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        indicadorColor.setBackground(Color.GRAY);

        JPanel filaCarta = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        filaCarta.setOpaque(false);
        filaCarta.add(cartaMesa);
        filaCarta.add(indicadorColor);

        //--------------------------------
        // INFO TURNO
        //--------------------------------

        JPanel infoTurno =
                new JPanel();

        infoTurno.setOpaque(false);

        infoTurno.setLayout(
                new GridLayout(2,1)
        );

        turno =
                new JLabel(
                        "",
                        SwingConstants.CENTER
                );

        turno.setForeground(Color.WHITE);

        turno.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24
                )
        );

        direccion =
                new JLabel(
                        "",
                        SwingConstants.CENTER
                );

        direccion.setForeground(
                new Color(255,220,0)
        );

        direccion.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );

        infoTurno.add(turno);

        infoTurno.add(direccion);

        //--------------------------------
        // CENTRO MESA
        //--------------------------------

        JPanel centroMesa =
                new JPanel();

        centroMesa.setOpaque(false);

        centroMesa.setLayout(
                new BoxLayout(
                        centroMesa,
                        BoxLayout.Y_AXIS
                )
        );

        filaCarta.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        infoTurno.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        centroMesa.add(filaCarta);

        centroMesa.add(
                Box.createVerticalStrut(10)
        );

        centroMesa.add(infoTurno);

        //--------------------------------
        // EVENTOS
        //--------------------------------

        eventos =
                new JTextArea(
                        10,
                        16
                );

        eventos.setEditable(false);

        eventos.setBackground(
                new Color(15,15,15,220)
        );

        eventos.setForeground(Color.WHITE);

        eventos.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        JScrollPane scroll =
                new JScrollPane(eventos);

        //--------------------------------
        // AGREGAR
        //--------------------------------

        mesa.add(zonaMazo);

        mesa.add(centroMesa);

        mesa.add(scroll);

        centro.add(
                topBot,
                BorderLayout.NORTH
        );

        centro.add(
                leftBot,
                BorderLayout.WEST
        );

        centro.add(
                rightBot,
                BorderLayout.EAST
        );

        centro.add(
                mesa,
                BorderLayout.CENTER
            );

        add(
                centro,
                BorderLayout.CENTER
        );

        //--------------------------------
        // ROBAR CARTA
        //--------------------------------

        robar.addActionListener(e -> {

            Player actual =
                    game.getTurnManager()
                            .actual(
                                    game.getJugadores()
                            );

            if (!actual.esHumano()) {

                return;
            }

            Card robada =
                    game.getDeck()
                            .robarCarta();

            actual.getMano()
                    .agregar(robada);

            agregarEvento(
                    actual.getNombre()
                    +
                    " roba carta"
            );

            game.getTurnManager()
                    .avanzar(
                            game.getJugadores()
                    );

            actualizar();

            game.siguienteTurnoGUI();
        });
    }

    /**
     * Inicializa y define las dimensiones del panel inferior (Sur),
     * el cual se encargará de contener y posicionar de forma absoluta
     * las cartas jugables del usuario humano.
     */
    private void crearBottom() {

        panelJugador =
                new JPanel();

        panelJugador.setOpaque(false);

        panelJugador.setPreferredSize(
                new Dimension(100,240)
        );

        panelJugador.setLayout(null);

        add(
                panelJugador,
                BorderLayout.SOUTH
        );
    }

    /**
     * Sincroniza y redibuja la totalidad de los componentes visuales de la interfaz
     * invocando las actualizaciones particulares de la mesa, la mano del jugador
     * y los mazos ocultos de los bots.
     */
    public void actualizar() {

        actualizarMesa();

        actualizarJugador();

        actualizarBots();

        repaint();

        revalidate();
    }

    /**
     * Actualiza los elementos textuales e icónicos de la zona central, tales como
     * el rótulo del turno actual, la flecha de dirección de la ronda y el reajuste
     * gráfico de la carta que se encuentra en la cima de la pila de descarte.
     */
    private void actualizarMesa() {

        Player actual =
                game.getTurnManager()
                        .actual(
                                game.getJugadores()
                        );

        turno.setText("TURNO: " + actual.getNombre());

        if (game.getTurnManager().getDireccion() == 1) {
            direccion.setText("↻ NORMAL");
        } else {
            direccion.setText("↺ REVERSA");
        }

        Card mesa = game.getCartaMesa();

        if (mesa == null) {
            cartaMesa.setIcon(null);
            return;
        }

        ImageIcon icon = ImageManager.obtenerIcono(mesa);

        if (icon == null) {
            System.out.println("❌ No hay icono para carta en mesa");
            cartaMesa.setIcon(null);
            return;
        }

        Image img = icon.getImage()
                .getScaledInstance(160, 230, Image.SCALE_SMOOTH);

        cartaMesa.setIcon(new ImageIcon(img));
    }

    /**
     * Renderiza de forma dinámica las cartas en la mano del jugador humano.
     * Calcula la distribución centrada, aplica un ligero desfase en el eje Y
     * para emular un abanico curvo, inyecta las animaciones de desplazamiento 
     * vertical (hover) mediante eventos del ratón y gestiona la validación 
     * de reglas al clickear para realizar una jugada.
     */
    private void actualizarJugador() {

        panelJugador.removeAll();

        Player jugador =
                game.getJugadores().get(0);

        int total =
                jugador.getMano().size();

        int separacion = 55;

        int anchoCarta = 90;

        int anchoTotal =
                (total - 1) * separacion
                + anchoCarta;

        int panelWidth =
                panelJugador.getWidth();

        if (panelWidth == 0) {

            panelWidth = 1600;
        }

        JLabel lblNombreHumano =
                new JLabel(
                        jugador.getNombre()
                        + " ("
                        + jugador.getMano().size()
                        + ")",
                        SwingConstants.CENTER
                );

        lblNombreHumano.setForeground(Color.WHITE);

        lblNombreHumano.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        lblNombreHumano.setBounds(
                0,
                195,
                panelWidth,
                30
        );

        panelJugador.add(lblNombreHumano);

        int inicioX =
                (panelWidth - anchoTotal) / 2;

        int y = 20;

        for (int i = 0; i < total; i++) {

            Card c =
                    jugador.getMano()
                            .getCartas()
                            .get(i);

            CardButton btn =
                    new CardButton(c);

            int curva =
                    Math.abs(
                            i - total / 2
                    ) * 5;

            int x =
                    inicioX
                    +
                    (i * separacion);

            btn.setBounds(
                    x,
                    y + curva,
                    90,
                    140
            );

            final int originalY =
                    y + curva;

            btn.addMouseListener(
                    new MouseAdapter() {

                        @Override
                        public void mouseEntered(
                                MouseEvent e
                        ) {

                            btn.setLocation(
                                    btn.getX(),
                                    originalY - 25
                            );
                        }

                        @Override
                        public void mouseExited(
                                MouseEvent e
                        ) {

                            btn.setLocation(
                                    btn.getX(),
                                    originalY
                            );
                        }
                    });

            btn.addActionListener(e -> {

                Player actual =
                        game.getTurnManager()
                                .actual(
                                        game.getJugadores()
                                );

                if (!actual.esHumano()) {

                    return;
                }

                if (
                        game.getRuleEngine()
                                .esJugadaValida(
                                        c,
                                        game.getCartaMesa()
                                )
                ) {

                    jugador.getMano()
                            .getCartas()
                            .remove(c);

                    game.jugarCarta(
                            jugador,
                            c
                    );

                    agregarEvento(
                            jugador.getNombre()
                            +
                            " juega "
                            +
                            c
                    );

                    //--------------------------------
                    // DECIR UNO
                    //--------------------------------

                    if (
                            jugador.getMano().size() == 1
                    ) {

                        int opcion =
                                JOptionPane.showConfirmDialog(
                                        this,
                                        "¿Decir UNO?",
                                        "UNO",
                                        JOptionPane.YES_NO_OPTION
                                );

                        if (
                                opcion == JOptionPane.NO_OPTION
                        ) {

                            agregarEvento(
                                    jugador.getNombre()
                                    + " olvidó decir UNO (+2)"
                            );

                            jugador.getMano()
                                    .agregar(
                                            game.getDeck()
                                                    .robarCarta()
                                    );

                            jugador.getMano()
                                    .agregar(
                                            game.getDeck()
                                                    .robarCarta()
                                    );

                        } else {

                            agregarEvento(
                                    jugador.getNombre()
                                    + " dice UNO!"
                            );
                        }
                    }

                    if (
                            jugador.getMano()
                                    .vacia()
                    ) {

                        JOptionPane.showMessageDialog(
                                this,
                                "GANASTE"
                        );

                        System.exit(0);
                    }

                    game.getTurnManager()
                            .avanzar(
                                    game.getJugadores()
                            );

                    actualizar();

                    game.siguienteTurnoGUI();

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "Movimiento inválido"
                    );
                }
            });

            panelJugador.add(btn);
        }

        panelJugador.repaint();

        panelJugador.revalidate();
    }

    /**
     * Limpia y reconstruye los paneles gráficos pertenecientes a los tres oponentes
     * controlados por la IA (Pepe, Toña y Mari), asignando a cada uno su respectiva
     * orientación espacial.
     */
    private void actualizarBots() {

        topBot.removeAll();

        leftBot.removeAll();

        rightBot.removeAll();

        Player pepe =
                game.getJugadores().get(1);

        Player tona =
                game.getJugadores().get(2);

        Player mari =
                game.getJugadores().get(3);

        agregarCartasBot(
                topBot,
                tona,
                false
        );

        agregarCartasBot(
                leftBot,
                mari,
                true
        );

        agregarCartasBot(
                rightBot,
                pepe,
                true
        );
    }

    /**
     * Método auxiliar encargado de poblar el panel de un oponente de la IA con imágenes 
     * fijas de reversos de cartas. Organiza los reversos verticalmente para los laterales
     * u horizontalmente solapados para el bot de la zona superior.
     * * @param panel    El contenedor {@link JPanel} del bot que va a ser modificado.
     * @param bot      La instancia {@link Player} que representa los datos del bot.
     * @param vertical Booleano que define si la alineación estructural es vertical (true) u horizontal (false).
     */
    private void agregarCartasBot(
            JPanel panel,
            Player bot,
            boolean vertical
    ) {

        panel.removeAll();

        panel.setOpaque(false);

        JPanel panelCartas = null;

        if (vertical) {

            panel.setLayout(
                    new BoxLayout(
                            panel,
                            BoxLayout.Y_AXIS
                    )
            );

        } else {

            panel.setLayout(
                    new BorderLayout()
            );

            panelCartas =
                    new JPanel(
                            new FlowLayout(
                                    FlowLayout.CENTER,
                                    -65,
                                    15
                            )
                    );

            panelCartas.setOpaque(false);
        }

        JLabel nombre =
                new JLabel(
                        bot.getNombre()
                        +
                        " ("
                        +
                        bot.getMano().size()
                        +
                        ")",
                        SwingConstants.CENTER
                );

        nombre.setForeground(Color.WHITE);

        nombre.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        if (vertical) {

            panel.add(nombre);
        }

        for (int i = 0;
                i < bot.getMano().size();
                i++) {

            ImageIcon icon;

            if (vertical) {
                icon = new ImageIcon(getClass().getResource("/img/reverso.png"));
            } else {
                icon = new ImageIcon(getClass().getResource("/img/reverso.png"));
            }

            Image img;

            if (vertical) {

                img =
                        icon.getImage()
                                .getScaledInstance(
                                        180,
                                        80,
                                        Image.SCALE_SMOOTH
                                );

            } else {

                img =
                        icon.getImage()
                                .getScaledInstance(
                                        115,
                                        145,
                                        Image.SCALE_SMOOTH
                                );
            }

            JLabel carta =
                    new JLabel(
                            new ImageIcon(img)
                    );

            if (vertical) {

                carta.setAlignmentX(
                        Component.CENTER_ALIGNMENT
                );

                panel.add(carta);

                panel.add(
                        Box.createVerticalStrut(-35)
                );

            } else {

                panelCartas.add(carta);
            }
        }

        if (!vertical) {

            panel.add(
                    panelCartas,
                    BorderLayout.CENTER
            );

            panel.add(
                    nombre,
                    BorderLayout.SOUTH
            );
        }
    }

    /**
     * Agrega un nuevo registro de texto seguido de un salto de línea en el área
     * informativa (bitácora de sucesos) situada a la derecha de la mesa.
     * * @param txt Cadena de texto describiendo el suceso que acaba de acontecer.
     */
    public void agregarEvento(
            String txt
    ) {

        eventos.append(
                txt + "\n"
        );
    }

    /**
     * Modifica dinámicamente el color de fondo del cuadro indicador presente en la mesa,
     * evaluando cadenas válidas en español o inglés para igualar el color actual del juego.
     *
     * @param color El nombre del color objetivo (ej. "ROJO", "RED", "VERDE", etc.).
     */
    public void actualizarColorActual(
            String color
    ) {
        if (color == null || indicadorColor == null) {
            return;
        }

        switch (color.toUpperCase()) {
            case "ROJO":
            case "RED":
                indicadorColor.setBackground(new Color(220, 40, 40));
                break;
            case "AZUL":
            case "BLUE":
                indicadorColor.setBackground(new Color(40, 40, 220));
                break;
            case "VERDE":
            case "GREEN":
                indicadorColor.setBackground(new Color(40, 180, 40));
                break;
            case "AMARILLO":
            case "YELLOW":
                indicadorColor.setBackground(new Color(255, 220, 0));
                break;
            default:
                indicadorColor.setBackground(Color.GRAY);
                break;
        }
        
        indicadorColor.repaint();
    }
}