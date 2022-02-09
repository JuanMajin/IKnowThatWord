package myProject;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private FileReader fileReader;
    private BufferedReader input;
    private FileWriter fileWriter;
    private BufferedWriter output;

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

    public String nombrelecturaFile() {
        String nombre = "";

        try {
            fileReader = new FileReader("src/myProject/files/nombre.txt");
            input = new BufferedReader(fileReader);
            String line = input.readLine();
            while(line!=null){
                nombre+=line;
                nombre+="\n";
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
        return nombre;
    }

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

}