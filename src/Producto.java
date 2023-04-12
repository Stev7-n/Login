import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Producto {

    private String nombreProducto;
    private String descripcion;
    private String categoria;
    private double precio;

    public Producto(String nombreProducto, String descripcion, String categoria, double precio) {
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;

    }

    public String getNombreProducto() {

        return nombreProducto;
    }

    public String getDescripcion() {

        return descripcion;
    }

    public String getCategoria() {
        return categoria;
    }


    public double getPrecio() {
        return precio;
    }




}

   /* public static void filtrarPorUsuario(String usuario) {
        try {
            File archivo = new File("compras.txt");
            Scanner scanner = new Scanner(archivo);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();

                if (linea.trim().isEmpty()) {
                    continue;
                }

                String[] partes = linea.split(", ");
                String idCompra = partes[0];
                String usuarioDeCompra = partes[1];
                String productoComprado = partes[2];
                double cantidadComprada = Double.parseDouble(partes[3]);
                double precioTotal = Double.parseDouble(partes[4]);

                if (usuarioDeCompra.equals(usuario)) {
                    System.out.println("Id de la compra: " + idCompra);
                    System.out.println("Usuario: " + usuarioDeCompra);
                    System.out.println("Productos comprados: " + productoComprado);
                    System.out.println("Cantidad de productos: " + cantidadComprada);
                    System.out.println("Precio total de la compra: " + precioTotal);
                    System.out.println();
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }*/