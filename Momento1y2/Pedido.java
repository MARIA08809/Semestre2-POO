
public class Pedido {
    private Cliente cliente;
    private Producto producto;
    private String fecha;
    private Pago pago;
 


    public Pedido(Cliente cliente, Producto producto, String fecha, Pago pago) {
        this.cliente = cliente;
        this.producto = producto;
        this.fecha = fecha;
        this.pago = pago;
    }
 
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public Pago getPago() { return pago; }
    public void setPago(Pago pago) { this.pago = pago; }
    
 
  
}
