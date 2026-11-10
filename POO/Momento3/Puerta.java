package Momento3;

public class Puerta {
    
    public static final String[] ESTADOS_PUERTA = {"ABIERTA", "CERRADA"};
    public static final int ABIERTA = 0;
    public static final int CERRADA = 1;

    private Sensor sensor;      
    private boolean obstaculo;
    private int estado;          

    
    public Puerta(boolean obstaculo, int estado) {
        this.sensor = new Sensor(obstaculo);
        this.obstaculo = obstaculo;
        this.estado = estado;
    }

    public void abrir() {
        estado = ABIERTA;
    }

    public void mantenerAbierta() {
        estado = ABIERTA;
    }

    public void setObstaculo(boolean valor) {
        sensor.setObstaculo(valor);
    }

    public int getEstado() {
        return estado;
    }

    public void cerrar() {
        if (estado == CERRADA) {
            return;
        }
        obstaculo = sensor.detectar();
        if (obstaculo) {
            System.out.println("Obstáculo detectado: la puerta sigue abierta");
            mantenerAbierta();
        } else {
            estado = CERRADA;
        }
    }
}