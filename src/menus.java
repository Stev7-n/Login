import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class menus {
    static void menuUsuario(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nElige una opción:");
            System.out.println("1. Ver productos.");
            System.out.println("2. Ver historial.");
            System.out.println("3. Comprar producto");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    filtros.verProductosGuardados();
                    System.out.println("¿Desea filtrar por categoría o por producto?");
                    System.out.println("1. Filtrar por categoría");
                    System.out.println("2. Filtrar por producto");
                    int filtro = scanner.nextInt();
                    scanner.nextLine();

                   //
                    switch (filtro) {
                        case 1:
                            System.out.println("Ingrese la categoría que desea filtrar:");
                            String categoria = scanner.nextLine();
                            filtros.verProductosGuardados(categoria);
                            break;
                        case 2:
                            String producto = null;
                            System.out.println("Ingrese el nombre del producto que desea filtrar:");
                            producto = scanner.nextLine();
                            filtros.filtrarPorProducto(producto);
                            break;

                        default:
                            System.out.println("Opción inválida.");
                    }
                    break;

                case 2:
                    break;

                case 3:
                    System.out.println("Ingrese los productos que desea comprar, separados por comas:");
                    String productosStr = scanner.nextLine();
                    String[] productosArr = productosStr.split(",");
                    HashMap<Producto, Integer> productosComprados = new HashMap<Producto, Integer>();
                    double total = 0.0;
                    for (String productoNombre : productosArr) {
                        System.out.println("Ingrese la cantidad que desea comprar de " + productoNombre.trim() + ":");
                        int cantidad = scanner.nextInt();
                        scanner.nextLine();
                        Producto producto = filtros.filtrarPorProducto(productoNombre.trim());
                        if (producto != null) {
                            productosComprados.put(producto, cantidad);
                            total += producto.getPrecioTotal(cantidad);
                        } else {
                            System.out.println("Producto no encontrado: " + productoNombre.trim());
                        }
                    }
                    System.out.println("Resumen de compra:");
                    for (Map.Entry<Producto, Integer> entry : productosComprados.entrySet()) {
                        Producto producto = entry.getKey();
                        int cantidad = entry.getValue();
                        System.out.println("- " + producto.getNombreProducto() + " x " + cantidad + ": " + producto.getPrecioTotal(cantidad));
                    }
                    System.out.println("Total: " + total);
                    System.out.println("¿Desea confirmar la compra? (s/n)");
                    String confirmacion = scanner.nextLine();
                    if (confirmacion.equalsIgnoreCase("s")) {
                        // Procesar la compra
                        // ...
                        System.out.println("Compra realizada exitosamente");
                    } else {
                        System.out.println("Compra cancelada");
                    }
                    break;


                case 4:
                    System.out.println("Hasta luego.");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
    static void menuAdmin(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nElige una opción:");
            System.out.println("1. Agregar productos.");
            System.out.println("2. Eliminar productos.");
            System.out.println("3. Informe de ventas.");
            System.out.println("4. Salir.");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:

                    System.out.print("Ingrese el nombre del producto:");
                    String nombreProducto = scanner.nextLine();
                    System.out.print("Ingrese la descripción del producto:");
                    String descripcion = scanner.nextLine();
                    System.out.println();
                    System.out.print("Ingrese la categoria del producto:");
                    String categoria = scanner.nextLine();
                    System.out.print("Ingrese el precio del producto:");
                    double precio = scanner.nextDouble();
                    scanner.nextLine();

                    Producto nuevoProducto = new Producto(nombreProducto, descripcion, categoria, precio);
                    agregarProductos(nuevoProducto);
                    System.out.println("\nProducto agregado exitosamente.");
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del producto a eliminar: ");
                    String productoAEliminar = scanner.nextLine();

                    File archivo = new File("productos.txt");
                    File archivoTemporal = new File("temp.txt");

                    try {
                        FileReader fr = new FileReader(archivo);
                        BufferedReader br = new BufferedReader(fr);

                        FileWriter fw = new FileWriter(archivoTemporal);
                        BufferedWriter bw = new BufferedWriter(fw);

                        String lineaActual;

                        while ((lineaActual = br.readLine()) != null) {


                            if (!lineaActual.contains(productoAEliminar)) {
                                bw.write(lineaActual);
                                bw.newLine();
                            }
                        }
                        bw.close();
                        br.close();
                        archivo.delete();
                        archivoTemporal.renameTo(archivo);

                        System.out.println("Producto eliminado exitosamente");

                    } catch (IOException e) {
                        System.out.println("Ocurrió un error al intentar eliminar el producto");
                        e.printStackTrace();
                    }
                    break;


                case 3:
                    break;

                case 4:
                    System.out.println("Hasta luego.");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
    public static void agregarProductos(Producto productos) {
        try {
            FileWriter archivo = new FileWriter("productos.txt", true);
            archivo.write(productos.getNombreProducto() + ", " + productos.getDescripcion() + ", " + productos.getCategoria() + ", " + productos.getPrecio() + "\n");
            archivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}







