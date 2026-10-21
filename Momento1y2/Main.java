
public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Juan Perez", "1005123456");

        Foto[] foto1 =  new Foto[] { new Foto("vacaciones.jpg") };
        Impresion impresion1 = new Impresion(5, 1000, "Color", foto1[0]);
        Camara camara1 = new Camara(2, 1200000, "Canon", "EOS 250D");

        Producto[] productos = { impresion1, camara1 };
        Pago[] pagos = new Pago[] { new Efectivo("Efectivo", 50000), new TarjetaDeCredito("Tarjeta de crédito", "1234567890123456", "12/25", "123"), new Transferencia("Transferencia", 100000, "001234567890") };
        Pedido pedido1 = new Pedido(cliente1, productos[0], "19/10/2026", pagos[0]);

    
        
        System.out.println("Cliente: " + pedido1.getCliente());
        System.out.println("Fecha: " + pedido1.getFecha());
        System.out.println("Forma de pago: " + pedido1.getPago().getFormaPago());

        System.out.println(pedido1.getProducto());

        double total = pedido1.getProducto().calcularCosto();

        System.out.println("TOTAL A PAGAR: " + total);
        
    }
}