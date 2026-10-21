public class TarjetaDeCredito extends Pago {
    
    private String numeroTarjeta;
    private String fechaVencimiento;
    private String codigoSeguridad;

    public TarjetaDeCredito(String formaPago, String numeroTarjeta, String fechaVencimiento, String codigoSeguridad) {
        super(formaPago);
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.codigoSeguridad = codigoSeguridad;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    @Override
    public String toString() {
        return "TarjetaDeCredito [numeroTarjeta=" + numeroTarjeta + ", fechaVencimiento=" + fechaVencimiento
                + ", codigoSeguridad=" + codigoSeguridad + "]";
    }

    

   
    
}