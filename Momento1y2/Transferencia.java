public class Transferencia extends Pago{
    
    private double monto;
    private String numeroCuenta;

    public Transferencia(String formaPago, double monto, String numeroCuenta) {
        super(formaPago);
        this.monto = monto;
        this.numeroCuenta = numeroCuenta;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public String toString() {
        return "Transferencia [monto=" + monto + ", numeroCuenta=" + numeroCuenta + "]";
    }
}