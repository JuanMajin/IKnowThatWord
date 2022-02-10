package myProject;

import java.util.ArrayList;

public class ModelGame {
    String nombreJugador;
    int nivel,aciertos,palabrasRecordar,palabrasTotales;
    private Palabras palabras;
    private ArrayList<String>  palabrasNivel;
    private ArrayList<String> palabrasMemorizar;

    public ModelGame(String nombreJugador){
        palabras= new Palabras();
        palabrasNivel= new ArrayList<String>();
        palabrasMemorizar= new ArrayList<String>();
        nivel=1;
        aciertos=0;
        palabrasRecordar=10;
        palabrasTotales=20;
    }

   // public ArrayList<String> getPalabrasNivel(int palabrasTotales){
      // return palabras.getPalabrasTotales(palabrasNivel);
    //}

   // public ArrayList<String> getPalabrasMemorizar(int palabrasRecordar){
     //   return palabras.getPalabrasRecordar(palabrasMemorizar);
    //}

    private void palabras(){
        String palabra;
        boolean recuerda;
        return;
    }

    public boolean siEsta(){
        String palabra="";
        for (int i = 0; i < palabrasMemorizar.size(); i++) {
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
            palabrasTotales = 20;
            palabrasRecordar = 10;
        }else{
            if (aciertos >= 14){
                nivel = 2;
                palabrasTotales = 40;
                palabrasRecordar = 20;
            }else{
                if (aciertos >=28){
                    nivel = 3;
                    palabrasTotales = 50;
                    palabrasRecordar=25;
                }else{
                    if (aciertos >=38){
                        nivel = 4;
                        palabrasTotales = 60;
                        palabrasRecordar=30;
                    }else{
                        if (aciertos >=48){
                            nivel = 5;
                            palabrasTotales = 70;
                            palabrasRecordar=35;
                        }else{
                            if (aciertos >=56){
                                nivel = 6;
                                palabrasTotales = 80;
                                palabrasRecordar=40;
                            }else{
                                if (aciertos >=68){
                                    nivel = 7;
                                    palabrasTotales = 100;
                                    palabrasRecordar=50;
                                }else{
                                    if (aciertos >=90){
                                        nivel = 8;
                                        palabrasTotales= 120;
                                        palabrasRecordar=60;
                                    }else{
                                        if (aciertos >=108){
                                            nivel = 9;
                                            palabrasTotales = 140;
                                            palabrasRecordar=70;
                                        }else{
                                            if (aciertos >=133){
                                                nivel = 10;
                                                palabrasTotales= 200;
                                                palabrasRecordar=100;
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
        return "Nombre:"+nombreJugador+
                "\nNivel: "+nivel+
                "\nAciertos: "+aciertos+
                "\nPalabras a memorizar: "+palabrasRecordar+
                "\nPalabras Nivel: "+palabrasTotales;

    }
}
