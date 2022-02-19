package myProject;

import java.io.*;
import java.util.ArrayList;

/**Lee y escribe en los txt*/

public class FileManager {

    private FileReader fileReader;
    private BufferedReader input;
    private FileWriter fileWriter;
    private BufferedWriter output;

    /**lee las palabras y las contiene en un arraylist*/
    public ArrayList<String> lecturaFile() {
        ArrayList<String> palabras = new ArrayList<String>();

        try {
            fileReader = new FileReader("src/myProject/files/palabras.txt");
            input = new BufferedReader(fileReader);
            String line = input.readLine();
            while(line!=null){
                palabras.add(line);
                //texto+=line;
                //texto+="\n";
                line=input.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return palabras;
    }

    /**Lee los nombres y los almacena en un arraylist*/
    public ArrayList<String>nombrelecturaFile() {
        ArrayList<String> nombres = new ArrayList<String>();

        try {
            fileReader = new FileReader("src/myProject/files/nombre.txt");
            input = new BufferedReader(fileReader);
            String line = input.readLine();
            while(line!=null){
                nombres.add(line);
                line=input.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return nombres;
    }

    /**Escribe los nombres de los jugadores*/
    public void escribirTexto(String linea){
        try {
            fileWriter = new FileWriter("src/myProject/files/nombre.txt",true);
            output = new BufferedWriter(fileWriter);
            output.write(linea);
            output.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*public void nivelAprobado( int nivel, int posicion){
        try {
            ArrayList<String> actualizar= nombrelecturaFile();
            String jugador = actualizar.get(posicion);
            String jugadorActualizado = jugador.substring(0, jugador.lastIndexOf(":")+1) +  nivel;
            actualizar.remove(posicion);
            actualizar.add(posicion,jugadorActualizado);
            fileWriter = new FileWriter("src/myProject/files/nombre.txt",false);
            output = new BufferedWriter(fileWriter);
            for (int i=0;i<actualizar.size();i++){
                output.write(actualizar.get(i));
                output.newLine();
            }
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

}