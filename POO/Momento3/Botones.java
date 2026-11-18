package Momento3;

public abstract class Botones {
    
    private boolean iluminado;
    private boolean presionado;   

    public Botones() {
        this.iluminado = false;
        this.presionado = false;
    }

    public void iluminar() {
        iluminado = true;
    }

    public void apagar() {
        iluminado = false;
        presionado = false;
    }

    public void sonido() {
        System.out.println("   *beep*");
    }

    public boolean isIluminado() {
        return iluminado;
    }

    public boolean isPresionado() {
        return presionado;
    }

    public void setPresionado(boolean presionado) {
        this.presionado = presionado;
        if (presionado) {
            iluminar();
            sonido();
        }
    }
}
    
 
