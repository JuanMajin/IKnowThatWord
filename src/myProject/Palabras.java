package myProject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * guarda las palabras a recordar y totales en un arraylist
 *
 */

public class Palabras {

    private  ArrayList<String>palabras=new ArrayList<String>();
    private ArrayList<String>palabrasRecordar= new ArrayList<String>();
    private ArrayList<String>palabrasTotales= new ArrayList<String>();

    private FileManager fileManager;
    /**
     * constructor de la clase Palabras
     * */
    public Palabras(){
        FileManager fileManager= new FileManager();
        palabras=fileManager.lecturaFile();
    }

    /**
     * Arraylist que retorna las palabras a recordar*/
    public ArrayList<String> getPalabrasRecordar(int palabrasMemorizar){
        if(palabrasRecordar.size()>0){
            palabrasRecordar= new ArrayList<>();
        }
        for(int i=0;i<palabrasMemorizar;i++ ){
            Random aleatorio= new Random();
            int numAleatorio=aleatorio.nextInt(palabras.size());
            palabrasRecordar.add(palabras.get(numAleatorio));
            palabras.remove(numAleatorio);
        }
        return palabrasRecordar;
    }

    /**
     * arraylist que retorna las palabras totales del nivel*/
    public ArrayList<String> getPalabrasTotales(int palabrasNivel){
        if(palabrasTotales.size()>0){
            palabrasTotales= new ArrayList<>();
        }
        for(int i=0;i<palabrasNivel;i++ ){
            Random aleatorio= new Random();
            int numAleatorio=aleatorio.nextInt(palabras.size());
            palabrasTotales.add(palabras.get(numAleatorio));
            palabras.remove(numAleatorio);
        }
        return palabrasTotales;
    }

}

