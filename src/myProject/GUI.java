package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 * This class is used for ...
 * @autor Juan-J Majin-M juan.majin@correounivalle.edu.co
 * @author Diana Cadena diana.marcela.cadena@correounivalle
 * @version v.1.0.0 date:18/02/2022
 */
public class GUI extends JFrame {

    private Header headerProject;
    private JPanel panelNombre, panelPalabras, panelResultados;
    private JButton iniciar, si, no, continuar, ayuda,siguiente,salir;
    private JTextArea mensajeSalida, palabrasMemoria,palabrasTotales;
    private Timer timer,timerTotales;
    private Escucha escucha;
    private JTextField nombres;
    private FileManager fileManager;
    private ModelGame modelGame;
    private Palabras palabras;
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
    String palabra="";
    int i=0;



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
        modelGame = new ModelGame();
        palabras = new Palabras();
        //Set up JComponents
        headerProject = new Header("I Know That Word", Color.BLACK);
        this.add(headerProject, BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout

        iniciar = new JButton("Iniciar");
        iniciar.addMouseListener(escucha);

        nombres = new JTextField();
        nombres.addMouseListener(escucha);
        nombres.setPreferredSize(new Dimension(200, 20));

        panelNombre = new JPanel();
        panelNombre.setBorder(BorderFactory.createTitledBorder("Ingresa tu nombre"));
        panelNombre.setPreferredSize(new Dimension(420, 180));
        this.add(panelNombre, BorderLayout.CENTER);
        panelNombre.add(nombres);
        //panelNombre.add(nombre);
        panelNombre.add(iniciar);


        ayuda = new JButton("Ayuda");
        ayuda.addMouseListener(escucha);
        //panelNombre.add(ayuda);

        mensajeSalida = new JTextArea(4, 18);
        //mensajeSalida.setText(fileManager.nombrelecturaFile());
        mensajeSalida.setOpaque(false);
        mensajeSalida.setBackground(new Color(0));
        mensajeSalida.setEditable(false);


        panelResultados = new JPanel();
        panelResultados.setBorder(BorderFactory.createTitledBorder("Que debes hacer "));
        panelResultados.setPreferredSize(new Dimension(420, 180));
        panelResultados.add(ayuda);
        this.add(panelResultados, BorderLayout.EAST);


        panelPalabras = new JPanel();
        panelPalabras.setBorder(BorderFactory.createTitledBorder("Memoriza "));
        panelPalabras.setPreferredSize(new Dimension(420, 180));
        this.add(panelPalabras, BorderLayout.SOUTH);

        //int i=0;
        palabrasMemoria = new JTextArea(7, 38);
        palabrasMemoria.setOpaque(false);
        palabrasMemoria.setBackground(new Color(0));
        palabrasMemoria.setEditable(false);
        palabrasMemoria.setFont(new Font(Font.DIALOG,Font.BOLD,20));
        //palabrasMemoria.setText(modelGame.getPalabrasMemorizar().get(i));

        palabrasTotales= new JTextArea(7, 38);
        palabrasTotales.setOpaque(false);
        palabrasTotales.setBackground(new Color(0));
        palabrasTotales.setEditable(false);
        palabrasTotales.setFont(new Font(Font.DIALOG,Font.BOLD,20));


        timer = new Timer(5000, escucha);                                                                                                                                                                                                                                      //este codigo es de juan Majin y diana cadena <3
        timerTotales=new Timer(7000,escucha);
        //timer.start();

        si = new JButton("SI");
        //si.addMouseListener(escucha);
        no = new JButton("NO");
        //no.addMouseListener(escucha);

        continuar = new JButton("Continuar");
        //continuar.addMouseListener(escucha);
        siguiente=new JButton("Siguiente");
        siguiente.addMouseListener(escucha);

        salir= new JButton("Salir");
        salir.addMouseListener(escucha);

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
    private class Escucha implements ActionListener, MouseListener {
        /*private class Escucha() {
        }*/

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == timer) {
                if (i <modelGame.getPalabrasMemorizar().size()) {
                    palabra = modelGame.getPalabrasMemorizar().get(i);
                    palabrasMemoria.setText(palabra);
                    i++;
                }else{
                    timer.stop();
                    i=0;
                    continuar.addMouseListener(escucha);
                    panelPalabras.add(continuar);
                    panelPalabras.revalidate();
                    panelPalabras.repaint();
                }
            }else if (e.getSource() == timerTotales) {
                if (i < modelGame.getPalabrasNivel().size()) {
                    palabra = modelGame.getPalabrasNivel().get(i);
                    palabrasTotales.setText(palabra);
                    i++;
                }else{
                    timerTotales.stop();
                    modelGame.determinarNivel(modelGame.getAciertos());
                    if(modelGame.nivelAprobado()){
                        JOptionPane.showMessageDialog(null,"Felicitaciones! aprobaste el nivel");
                        panelPalabras.removeAll();
                        panelPalabras.repaint();
                        panelPalabras.revalidate();
                        panelResultados.revalidate();
                        panelResultados.repaint();
                        //fileManager.nivelAprobado(modelGame.getNivel(), modelGame.validarNombre());
                        panelPalabras.add(siguiente);
                    }else{
                        //fileManager.nivelAprobado(modelGame.getNivel(), modelGame.validarNombre());
                        panelPalabras.removeAll();
                        panelPalabras.repaint();
                        panelPalabras.revalidate();
                        panelNombre.add(iniciar);
                        JOptionPane.showMessageDialog(null,"Sigue intentando");
                    }
                    repaint();
                    revalidate();
                }
                repaint();
                repaint();
            }
            repaint();
            repaint();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == ayuda) {
                JOptionPane.showMessageDialog(null, MENSAJE_INICIO);
                revalidate();
                repaint();

            }else if(e.getSource()==siguiente){
                timer.start();
                panelPalabras.remove(continuar);
                panelPalabras.remove(palabrasMemoria);
                panelPalabras.add(palabrasMemoria);
                panelPalabras.remove(siguiente);
                panelPalabras.remove(continuar);
                modelGame.palabrasNivel();
                modelGame.setPalabrasMemorizar();
                modelGame.setPalabrasTotales();

                panelResultados.setBorder(BorderFactory.createTitledBorder("Resultados "));
                mensajeSalida.setText(modelGame.getEstadoToString());
                panelResultados.add(mensajeSalida);
                revalidate();
                repaint();

            }else if (e.getSource() == iniciar && nombres.getText() != null && nombres.getText().equals("")) {
                JOptionPane.showMessageDialog(null, ALERTA, "ALERTA", JOptionPane.WARNING_MESSAGE);

                revalidate();
                repaint();

            }/*else if(e.getSource()==iniciar && nombres.getText().equals(nombres.getText())){
                modelGame.getNivelAprobado();
                mensajeSalida.setText(modelGame.getEstadoToString());


            }*/else if(e.getSource()==iniciar){

                JOptionPane.showMessageDialog(null,"Preparate,las palabras se mostraran en unos segundos");
                modelGame.palabrasNivel();
                modelGame.setPalabrasMemorizar();
                modelGame.setPalabrasTotales();
                modelGame.setNombreJugador("");
                panelPalabras.add(palabrasMemoria,BorderLayout.CENTER);
                panelResultados.remove(ayuda);
                panelNombre.remove(iniciar);
                panelNombre.remove(nombres);
                panelNombre.add(salir);
                panelNombre.add(ayuda);

                panelResultados.setBorder(BorderFactory.createTitledBorder("Resultados "));
                mensajeSalida.setText(modelGame.getEstadoToString());
                panelResultados.add(mensajeSalida);

                panelNombre.setBorder(BorderFactory.createTitledBorder(" "));
                fileManager.escribirTexto(nombres.getText()+" "+modelGame.getNivel());
                //panelResultados.add(nombre);
                timer.start();
                repaint();
                revalidate();
            } if(e.getSource() == continuar){
                panelPalabras.remove(continuar);
                panelPalabras.remove(palabrasMemoria);
                timerTotales.start();
                panelPalabras.add(palabrasTotales);
                panelPalabras.add(si);
                panelPalabras.add(no);
                si.addMouseListener(escucha);
                no.addMouseListener(escucha);
                repaint();
                revalidate();
            }else if(e.getSource()==si){
                if(modelGame.siEsta().get(i)==true){
                    modelGame.actualizarAciertos(true);
                    mensajeSalida.setText(modelGame.getEstadoToString());
                }else if (modelGame.siEsta().get(i)==false){
                    modelGame.actualizarAciertos(false);
                }else{
                    modelGame.actualizarAciertos(false);
                }
                repaint();
                repaint();
            }else if(e.getSource()==no){
                if(modelGame.siEsta().get(i)==false){
                    modelGame.actualizarAciertos(true);
                    mensajeSalida.setText(modelGame.getEstadoToString());
                }else if(modelGame.siEsta().get(i)==true){
                    modelGame.actualizarAciertos(false);
                }
                else{
                    modelGame.actualizarAciertos(false);
                }
                repaint();
                repaint();
            }else if(e.getSource()==salir){
                System.exit(0);
            }
            repaint();
            repaint();
        }


        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}


