package myProject;

import javax.swing.*;
import java.awt.*;

/**
 * This class is used for ...
 * @autor Juan-J Majin-M juan.majin@correounivalle.edu.co
 * @version v.1.0.0 date:29/11/2021
 */
public class GUI extends JFrame {

    private Header headerProject;
    private JPanel panelNombre,panelPalabras;
    private JButton ayuda,salir,si,no;
    //private Timer timer;
    private Escucha escucha;
    private JTextField nombres;
    private FileManager fileManager;
    public static final String PATH_LECTURA_PALABRAS = "src/myProject/files/palabras.txt";
    public static final String PATH_LECTURA_NOMBRE = "src/myProject/files/nombres.txt";
    public static final String NOMBRE_JUGADOR = "Ingresa tu nombre";
    public static final String MENSAJE_INICIO= "Bienvenido a I Know That Word\n"
            +"El jugador deberá memorizar las palabras que van apareciendo"
            +"las palabras que van apareciendo.\n"
            +"\nTras la serie de palabras a memorizar, el juego presentará un listado con el doble de palabras que se "
            +"mostraron. Por cada una las palabras el jugador deberá indicar si la palabra estaba o no contenida en el "
            +"listado a memorizar y tendrá un tiempo de 7 segundos para responder, en caso de no hacerlo se tomará"
            +"como un error.";


    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("I Know That Word");
        this.setSize(200,100);
        //this.pack();
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
        escucha= new Escucha();
        fileManager=new FileManager();
        //Set up JComponents
        headerProject = new Header("I Know That Word", Color.BLACK);

        this.add(headerProject,BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout
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
    private class Escucha {

    }
}
