package Momento3;

public class Alarma {
    // ---- Atributos ----
    private boolean activada;

    // ---- Constructor ----
    public Alarma() {
        this.activada = false;   // empieza apagada
    }

    // ---- Métodos simples ----
    public void activar() {
        activada = true;
        System.out.println("*** ALARMA SONANDO ***");
    }

    public void desactivar() {
        activada = false;
        System.out.println("Alarma apagada");
    }

    public boolean isActivada() {
        return activada;
    }
}