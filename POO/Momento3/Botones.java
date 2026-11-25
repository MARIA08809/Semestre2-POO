package Momento3;

public class Botones {

    private boolean iluminado;
    private boolean presionado;

    public Botones() {
        this.iluminado = false;
        this.presionado = false;
    }

    public void presionar(int piso, int direccion) {
        encender();
    }

    public void encender() {
        cambiar(true);
    }

    public void apagar() {
        cambiar(false);
    }

    private void cambiar(boolean encendido) {
        iluminado = encendido;
        presionado = encendido;
        if (encendido) {
            sonido();
        }
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
}
    
 
