
public class Pago {
    
    private String formaPago;

    public Pago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }
    public void mostrarFormaPago() {
        System.out.println("Forma de pago: " + formaPago);
    }
}
