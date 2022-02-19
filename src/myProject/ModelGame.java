package myProject;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * La clase ModelGame se encarga de
 * -guardar los jugadores y su nivel
 * -mostrar las palabras a memorizar y las del nivel
 * -determinar los aciertos del jugador
 * -determinar el siguiente nivel*/

public class ModelGame {
    private String nombreJugador;
    private int nivel,aciertos,palabrasRecordar,palabrasTotales;
    private boolean nivelAprobado;
    private Palabras palabras;
    private ArrayList<String>  palabrasNivel;
    private ArrayList<String> palabrasMemorizar;
    private ArrayList<String>nombres=new ArrayList<String>();
    private ArrayList<Boolean> palabrasCorrectas;
    private FileManager fileManager;

    /**Constructor de la clase ModelGame*/
    public ModelGame(){
        palabras= new Palabras();
        //nombres=fileManager.nombrelecturaFile();
        palabrasMemorizar=new ArrayList<String>();
        palabrasNivel=new ArrayList<String>();
        palabrasCorrectas= new ArrayList<Boolean>();
        //this.nombreJugador=nombreJugador;
        nivel=1;
        aciertos=0;
    }

    /**determina los valores de las palabras para cada nivel*/
    public void palabrasNivel(){
        switch (nivel){
            case 1-> {
                palabrasRecordar=10;
                palabrasTotales=20;
            }
            case 2-> {
                palabrasRecordar=20;
                palabrasTotales=40;
            }
            case 3-> {
                palabrasRecordar=25;
                palabrasTotales=50;
            }
            case 4-> {
                palabrasRecordar=30;
                palabrasTotales=60;
            }
            case 5-> {
                palabrasRecordar=35;
                palabrasTotales=70;
            }
            case 6-> {
                palabrasRecordar=40;
                palabrasTotales=80;
            }
            case 7-> {
                palabrasRecordar=50;
                palabrasTotales=100;
            }
            case 8-> {
                palabrasRecordar=60;
                palabrasTotales=120;
            }
            case 9-> {
                palabrasRecordar=70;
                palabrasTotales=140;
            }
            case 10-> {
                palabrasRecordar=100;
                palabrasTotales=200;
            }
        }
    }

    /**
     * establece el nivel del jugador segun su cantidad de aciertos*/
    public void determinarNivel(int cantidadAciertos){
        if(nivel==1 && cantidadAciertos>=14) {
            nivel=2;
            nivelAprobado=true;
            aciertos=0;
        }else{
            if (nivel== 2 && cantidadAciertos >= 28){
                nivel = 3;
                nivelAprobado=true;
                aciertos=0;
            }else{
                if (nivel==3 && cantidadAciertos >=38){
                    nivel = 4;
                    nivelAprobado=true;
                    aciertos=0;
                }else{
                    if (nivel==4 && cantidadAciertos >=48){
                        nivel = 5;
                        nivelAprobado=true;
                        aciertos=0;
                    }else{
                        if (nivel==5 && cantidadAciertos >=56){
                            nivel = 6;
                            nivelAprobado=true;
                            aciertos=0;
                        }else{
                            if (nivel==6 && cantidadAciertos >=68){
                                nivel = 7;
                                nivelAprobado=true;
                                aciertos=0;
                            }else{
                                if (nivel==7 && cantidadAciertos >=90){
                                    nivel = 8;
                                    nivelAprobado=true;
                                    aciertos=0;
                                }else{
                                    if (nivel==8 && cantidadAciertos >=108){
                                        nivel = 9;
                                        nivelAprobado=true;
                                        aciertos=0;
                                    }else{
                                        if (nivel==9 && cantidadAciertos >=133){
                                            nivel = 10;
                                            nivelAprobado=true;
                                            aciertos=0;
                                        }else{
                                            if (nivel==10 && cantidadAciertos >=200){
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

    /**
     * retorna si el jugador obtuvo un acierto*/
    public ArrayList<Boolean> siEsta(){
        palabrasCorrectas.clear();
        for (String element: palabrasNivel){
            palabrasCorrectas.add(palabrasMemorizar.contains(element));
        }
        return palabrasCorrectas;
    }

    /**
     * Suma los aciertos del jugador*/
    public void actualizarAciertos(Boolean puntos){
        if(puntos){
            aciertos+=1;
        }else{
            aciertos+=0;
        }
    }

    /**getters and setters*/

    public ArrayList<String> getPalabrasNivel(){

        return palabrasNivel;
    }

    public ArrayList<String> getPalabrasMemorizar(){

        return palabrasMemorizar;
    }

    public void setPalabrasMemorizar(){

        palabrasMemorizar= palabras.getPalabrasRecordar(palabrasRecordar);
    }

    public void setPalabrasTotales(){

        palabrasNivel= palabras.getPalabrasTotales(palabrasTotales);
    }

    public int getAciertos(){

        return aciertos;
    }

    public String getNombreJugador() {

        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {

        this.nombreJugador = nombreJugador;
    }

    public int getNivel(){
        return nivel;
    }

    public void setNivel(int nivel) {

        this.nivel = nivel;

    }

    public boolean nivelAprobado(){

        return nivelAprobado;

    }

    public void setNivelAprobado(boolean siguienNivel){

        this.nivelAprobado=nivelAprobado;

    }

    /**
     * retorna el estado del juego
     * */
    public String getEstadoToString(){
        return "Nivel: "+nivel+
                "\nAciertos: "+aciertos+
                "\nPalabras a memorizar: "+palabrasRecordar+
                "\nPalabras Nivel: "+palabrasTotales;
    }
}
