package myProject;

import java.util.ArrayList;

public class ModelGame {
    String nombreJugador;
    int nivel,aciertos,palabrasMemorizar,palabrasNivel;
    private ArrayList<Palabras> palabrasRecordar;
    private ArrayList<Palabras> palabrasTotales;

    public ModelGame(String nombreJugador){
        palabrasTotales= new ArrayList<Palabras>();
        palabrasRecordar= new ArrayList<>();
        nivel=1;
        aciertos=0;
        palabrasMemorizar=10;
        palabrasNivel=20;
    }

    public ArrayList<Palabras> getPalabrasTotales(){
       return palabrasTotales;
    }

    public ArrayList<Palabras> getPalabrasRecordar(){
        return palabrasRecordar;
    }

    private void palabras(){
        String palabra;
        boolean recuerda;
        return;
    }

    public boolean siEsta(){
        String palabra="";
        for (int i = 0; i < palabrasRecordar.size(); i++) {
            aciertos +=  aciertos;
        }
        if(palabra=="Humanidad") {/*recorre las palabrasRecordar y si estaba la palabra*/
            return true;
        }else{
            return false;
        }
    }


    public void actualizarAciertos(){
        aciertos+=1;
    }

    public void determinarNivel(){
        if(nivel==1) {
            palabrasNivel = 20;
            palabrasMemorizar = 10;
        }else{
            if (aciertos >= 14){
                nivel = 2;
                palabrasNivel = 40;
                palabrasMemorizar = 20;
            }else{
                if (aciertos >=28){
                    nivel = 3;
                    palabrasNivel = 50;
                    palabrasMemorizar=25;
                }else{
                    if (aciertos >=38){
                        nivel = 4;
                        palabrasNivel = 60;
                        palabrasMemorizar=30;
                    }else{
                        if (aciertos >=48){
                            nivel = 5;
                            palabrasNivel = 70;
                            palabrasMemorizar=35;
                        }else{
                            if (aciertos >=56){
                                nivel = 6;
                                palabrasNivel = 80;
                                palabrasMemorizar=40;
                            }else{
                                if (aciertos >=68){
                                    nivel = 7;
                                    palabrasNivel = 100;
                                    palabrasMemorizar=50;
                                }else{
                                    if (aciertos >=90){
                                        nivel = 8;
                                        palabrasNivel = 120;
                                        palabrasMemorizar=60;
                                    }else{
                                        if (aciertos >=108){
                                            nivel = 9;
                                            palabrasNivel = 140;
                                            palabrasMemorizar=70;
                                        }else{
                                            if (aciertos >=133){
                                                nivel = 10;
                                                palabrasNivel = 200;
                                                palabrasMemorizar=100;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getEstadoToString(){
        return "Nivel: "+nivel+
        "\nAciertos: "+aciertos+
        "\nPalabras a memorizar: "+palabrasMemorizar+
        "\nPalabras Nivel: "+palabrasNivel;

    }
}
