import java.util.UUID;

public class Compra {
    private UUID compraId;
    public static String nombreUsuarioCompra;
    private String nombreProducto;
    private int cantidad;
    private double precioTotal;

    public Compra(UUID compraId, String nombreUsuarioCompra, String nombreProducto, int cantidad, double precioTotal) {
        this.compraId = compraId;
        this.nombreUsuarioCompra = nombreUsuarioCompra;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
    }

    public UUID getCompraId() {
        return compraId;
    }

    public String getNombreUsuarioCompra() {
        return nombreUsuarioCompra;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    @Override
    public String toString() {
        return compraId + "," + nombreUsuarioCompra + "," + nombreProducto + "," + cantidad + "," + precioTotal;
    }
}
