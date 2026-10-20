package Momento1y2;

public class Pedido {
    private Cliente cliente;
    private Producto producto;
    private String fecha;
 

    private String[] formasPago = { "Tarjeta de crédito", "Tarjeta débito", "Efectivo" };
    private String formaPagoElegida;
 
    public Pedido(Cliente cliente, Producto producto, String fecha) {
        this.cliente = cliente;
        this.producto = producto;
        this.fecha = fecha;
    }
 
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public String[] getFormasPago() { return formasPago; }
    public String getFormaPagoElegida() { return formaPagoElegida; }
 
    // Muestra las 3 opciones numeradas
    public void mostrarFormasPago() {
        for (int i = 0; i < formasPago.length; i++) {
            System.out.println((i + 1) + formasPago[i]);
        }
    }
 
    // Guarda la forma de pago escogida (1, 2 o 3). Devuelve true si fue valida
    public boolean elegirFormaPago(int opcion) {
        if (opcion < 1 || opcion > formasPago.length) {
            return false;
        } 
            formaPagoElegida = formasPago[opcion - 1];
            return true;
        
    }
}
