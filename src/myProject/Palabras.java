package myProject;

import java.util.ArrayList;
import java.util.Random;

public class Palabras {

    private ArrayList<String>palabrasRecordar= new ArrayList<String>();
    private ArrayList<String>palabrasTotales= new ArrayList<String>();

    public Palabras(){
        FileManager fileManager= new FileManager();
        palabrasRecordar= fileManager.lecturaFile();
        palabrasTotales= fileManager.lecturaFile();
    }

    public String getPalabrasRecordar(int palabrasMemorizar){
        Random aleatorio= new Random();
        return palabrasRecordar.get(aleatorio.nextInt(palabrasRecordar.size()));
    }

    public String getPalabrasTotales(int palabrasNivel){
        Random aleatorio= new Random();
        return palabrasTotales.get(aleatorio.nextInt(palabrasTotales.size()));
    }

}

