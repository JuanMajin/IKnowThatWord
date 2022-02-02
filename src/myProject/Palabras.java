package myProject;

import java.util.ArrayList;
import java.util.Random;

public class Palabras {

    private ArrayList<String>palabras= new ArrayList<String>();

    public Palabras(){
        FileManager fileManager= new FileManager();
        palabras= fileManager.lecturaFile();
    }
    public String getFrase(){
        Random aleatorio= new Random();
        return palabras.get(aleatorio.nextInt(palabras.size()));
    }

}

