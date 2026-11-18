package Momento3;

public class BotonPiso extends Botones {
    private int numeroPiso;
    private int direccion;

    public BotonPiso(int numeroPiso, int direccion) {
        super();
        this.numeroPiso = numeroPiso;
        this.direccion = direccion;
    }

    public int getNumeroPiso() {
        return numeroPiso;
    }

    public int getDireccion() {
        return direccion;
    }
}