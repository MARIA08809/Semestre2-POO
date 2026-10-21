public class Efectivo extends Pago{
    
    private double monto;

    public Efectivo(String formaPago, double monto) {
        super(formaPago);
        this.monto = monto;
    }

    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }
    public String toString() {
        return "Efectivo [monto=" + monto + "]";
    }
}