package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class is used for ...
 * @autor Juan-J Majin-M juan.majin@correounivalle.edu.co
 * @version v.1.0.0 date:29/11/2021
 */
public class GUI extends JFrame {

    private Header headerProject;
    private JPanel panelNombre, panelPalabras, panelResultados;
    private JButton iniciar, si, no, continuar, ayuda;
    private JTextArea mensajeSalida, nombre, palabrasMemoria;
    private Timer timer;
    private Escucha escucha;
    private JTextField nombres;
    private FileManager fileManager;
    private ModelGame modelGame;
    private Palabras palabras;
    public static final String PATH_LECTURA_PALABRAS = "src/myProject/files/palabras.txt";
    public static final String PATH_LECTURA_NOMBRE = "src/myProject/files/nombre.txt";
    public static final String MENSAJE_INICIO = "Bienvenido a I Know That Word\n"
            + "Ingresa tu nombre para iniciar el juego"
            + "\nEl jugador deberá memorizar las palabras que van apareciendo"
            + "\nTras la serie de palabras a memorizar, "
            + "\nel juego presentará un listado con "
            + "\nel doble de palabras que se mostraron."
            + "\nPor cada una las palabras el jugador deberá indicar "
            + "\nsi la palabra estaba o no contenida en el listado a memorizar "
            + "\ny tendrá un tiempo de 7 segundos para responder, "
            + "\nen caso de no hacerlo se tomará como un error.";
    public static final String ALERTA = "No puedes iniciar el juego, ingresa tu nombre";


    /**
     * Constructor of GUI class
     */
    public GUI() {
        initGUI();

        //Default JFrame configuration
        this.setTitle("I Know That Word");
        //this.setSize(200,100);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        //Create Listener Object and Control Object
        escucha = new Escucha();
        fileManager = new FileManager();
        modelGame = new ModelGame("");
        palabras = new Palabras();
        //Set up JComponents
        headerProject = new Header("I Know That Word", Color.BLACK);
        this.add(headerProject, BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout

        iniciar = new JButton("Iniciar");
        iniciar.addActionListener(escucha);

        nombres = new JTextField();
        nombres.addActionListener(escucha);
        nombres.setPreferredSize(new Dimension(200, 20));


        panelNombre = new JPanel();
        panelNombre.setBorder(BorderFactory.createTitledBorder("Ingresa tu nombre"));
        panelNombre.setPreferredSize(new Dimension(420, 180));
        this.add(panelNombre, BorderLayout.CENTER);
        panelNombre.add(nombres);
        //panelNombre.add(nombre);
        panelNombre.add(iniciar);


        ayuda = new JButton("Ayuda");
        ayuda.addActionListener(escucha);
        panelNombre.add(ayuda);

        mensajeSalida = new JTextArea(4, 18);
        mensajeSalida.setText(fileManager.nombrelecturaFile());
        mensajeSalida.setOpaque(false);
        mensajeSalida.setBackground(new Color(0));
        mensajeSalida.setEditable(false);


        panelResultados = new JPanel();
        panelResultados.setBorder(BorderFactory.createTitledBorder("Que debes hacer "));
        panelResultados.setPreferredSize(new Dimension(420, 180));
        this.add(panelResultados, BorderLayout.EAST);


        panelPalabras = new JPanel();
        panelPalabras.setBorder(BorderFactory.createTitledBorder("Memoriza "));
        panelPalabras.setPreferredSize(new Dimension(420, 180));
        this.add(panelPalabras, BorderLayout.SOUTH);

        palabrasMemoria = new JTextArea(7, 38);
        palabrasMemoria.setOpaque(false);
        palabrasMemoria.setBackground(new Color(0));
        palabrasMemoria.setEditable(false);
        palabrasMemoria.setFont(new Font(Font.DIALOG,Font.BOLD,20));



        timer = new Timer(5000, escucha);                                                                                                                                                                                                                                      //este codigo es de juan Majin y diana cadena <3
        //timer.start();

        si = new JButton("SI");
        si.addActionListener(escucha);
        no = new JButton("NO");
        no.addActionListener(escucha);

        continuar = new JButton("Continuar");
        continuar.addActionListener(escucha);
    }

    /**
     * Main process of the Java program
     *
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener {
        /*private class Escucha() {

        }*/
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == ayuda) {
                JOptionPane.showMessageDialog(null, MENSAJE_INICIO);
                revalidate();
                repaint();

            } else if (e.getSource() == iniciar && nombres.getText() != null && nombres.getText().equals("")) {
                JOptionPane.showMessageDialog(null, ALERTA, "ALERTA", JOptionPane.WARNING_MESSAGE);
                revalidate();
                repaint();
            } else {
                palabrasMemoria.setText(palabras.getPalabrasRecordar(modelGame.palabrasRecordar));
                panelPalabras.add(palabrasMemoria,BorderLayout.CENTER);
                timer.start();

                modelGame.determinarNivel();
                panelResultados.setBorder(BorderFactory.createTitledBorder("Resultados "));
                mensajeSalida.setText(modelGame.getEstadoToString());
                panelResultados.add(mensajeSalida);

                panelNombre.setBorder(BorderFactory.createTitledBorder("Jugador "));
                fileManager.escribirTexto(nombres.getText());
                //panelResultados.add(nombre);


                revalidate();
                repaint();
                //panelPalabras.add(si);
                //panelPalabras.add(no);
            }
        }
    }
}

