package Momento3;

public class Sensor {
    
    private boolean obstaculo;

    public Sensor(boolean obstaculo) {
        this.obstaculo = obstaculo;
    }

    public void setObstaculo(boolean obstaculo) {
        this.obstaculo = obstaculo;
    }

    public boolean detectar() {
        return obstaculo;
    }
}