package Momento3;

public class Boton {
    private boolean iluminado= false;

    public boolean isIluminado() {
        return iluminado;
    }

    public void setIluminado(boolean iluminado) {
        this.iluminado = iluminado;
    }

    public void encender() {
        iluminado = true;
    }

    public void apagar() {
        iluminado = false;
    }

    public void presionar() {
        if (iluminado) {
            apagar();
        } else {
            encender();
        }
    }
    public void sonido() {
        if (iluminado) {
            System.out.println("El botón está iluminado y hace un sonido.");
        } else {
            System.out.println("El botón no está iluminado y no hace sonido.");
        }
    }
}

    
 
