package Momento3;

 public class PuertaPiso extends Puerta {

    public static final String[] DIRECCIONES = {"SUBIENDO", "BAJANDO"};
    public static final int SUBIENDO = 0;
    public static final int BAJANDO = 1;

    private int numero;
    private boolean[] solicitudes;   

    
    public PuertaPiso(int numero, boolean obstaculo, int estadoPuerta) {
        super(obstaculo, estadoPuerta);   // llena la parte de Puerta
        this.numero = numero;
        this.solicitudes = new boolean[2];
    }

    
    public int getNumero() {
        return numero;
    }

    public void solicitarAscensor(int direccion) {
        solicitudes[direccion] = true;
        System.out.println("Piso " + numero + ": ascensor solicitado (" + DIRECCIONES[direccion] + ")");
    }
}
