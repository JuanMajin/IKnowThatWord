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
    private JPanel panelNombre,panelPalabras,panelResultados;
    private JButton iniciar,si,no,continuar;
    private JTextArea mensajeSalida,nombre;
    private Timer timer;
    private Escucha escucha;
    private JTextField nombres;
    private FileManager fileManager;
    private ModelGame modelGame;
    private Palabras palabras;
    public static final String PATH_LECTURA_PALABRAS = "src/myProject/files/palabras.txt";
    public static final String PATH_LECTURA_NOMBRE = "src/myProject/files/nombre.txt";
    public static final String MENSAJE_INICIO= "Bienvenido a I Know That Word\n"
            +"Ingresa tu nombre para iniciar el juego"
            +"\nEl jugador deberá memorizar las palabras que van apareciendo"
            +"\nTras la serie de palabras a memorizar, "
            + "\nel juego presentará un listado con "
            + "\nel doble de palabras que se mostraron."
            +"\nPor cada una las palabras el jugador deberá indicar "
            + "\nsi la palabra estaba o no contenida en el listado a memorizar "
            + "\ny tendrá un tiempo de 7 segundos para responder, "
            + "\nen caso de no hacerlo se tomará como un error.";


    /**
     * Constructor of GUI class
     */
    public GUI(){
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
        fileManager= new FileManager();
        modelGame= new ModelGame("");
        palabras= new Palabras();
        //Set up JComponents
        headerProject = new Header("I Know That Word", Color.BLACK);
        this.add(headerProject,BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout

        iniciar= new JButton("Iniciar");
        iniciar.addActionListener(escucha);

        nombres= new JTextField();
        nombres.addActionListener(escucha);
        nombres.setPreferredSize(new Dimension(200,20));

        nombre = new JTextArea(4,16);
        JScrollPane scroll2= new JScrollPane(nombre);
        add(scroll2,BorderLayout.CENTER);
        nombre.setText(fileManager.nombrelecturaFile());

        panelNombre= new JPanel();
        panelNombre.setBorder(BorderFactory.createTitledBorder("Ingresa tu nombre"));
        panelNombre.setPreferredSize(new Dimension(420,180));
        this.add(panelNombre,BorderLayout.CENTER);
        panelNombre.add(nombres);
        //panelNombre.add(nombre);
        panelNombre.add(iniciar);

        mensajeSalida= new JTextArea(7,35);
        mensajeSalida.setText(MENSAJE_INICIO);
        JScrollPane scroll= new JScrollPane(mensajeSalida);

        panelResultados= new JPanel();
        panelResultados.setBorder(BorderFactory.createTitledBorder("Que debes hacer "));
        panelResultados.add(scroll);
        panelResultados.setPreferredSize(new Dimension(420,180));
        this.add(panelResultados,BorderLayout.EAST);

        panelPalabras= new JPanel();
        panelPalabras.setBorder(BorderFactory.createTitledBorder("Memoriza "));
        panelPalabras.setPreferredSize(new Dimension(420,180));
        this.add(panelPalabras,BorderLayout.SOUTH);

        //timer= new Timer(1000,escucha);
        //timer.start();

        si= new JButton("SI");
        si.addActionListener(escucha);
        no=new JButton("NO");
        no.addActionListener(escucha);

        continuar= new JButton("Continuar");
        continuar.addActionListener(escucha);
    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener{
        /*private class Escucha() {

        }*/
        @Override
        public void actionPerformed(ActionEvent e) {
            modelGame.determinarNivel();

            panelResultados.removeAll();
            panelResultados.setBorder(BorderFactory.createTitledBorder("Resultados "));
            panelResultados.add(mensajeSalida);
            mensajeSalida.setText(modelGame.getEstadoToString());
            panelNombre.setBorder(BorderFactory.createTitledBorder("Jugador "));
            fileManager.escribirTexto(nombres.getText());
            nombre.setText(fileManager.nombrelecturaFile());


            /*ArrayList<Palabras> palabrasRecordar=modelGame.getPalabrasRecordar();

            fileManager.lecturaFile(modelGame.getPalabrasRecordar().get(0));
            panelPalabras.add(palabrasRecordar);*/

            revalidate();
            repaint();
        }
    }

}
