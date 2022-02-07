package myProject;

public class ModelGame {
    String nombreJugador;
    int nivel;

    public ModelGame(){
        nombreJugador="";
        nivel=0;
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
}
