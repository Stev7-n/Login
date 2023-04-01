import java.io.*;
import java.util.Scanner;

public class menus {

    static void menuUsuario(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nElige una opción:");
            System.out.println("1. Ver productos.");
            System.out.println("2. Ver historial.");
            System.out.println("3. Salir");


            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    verProductosGuardados();
                    break;

                case 2:
                    break;
                case 3:
                    System.out.println("Hasta luego.");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    public static void verProductosGuardados() {
        try {
            File archivo = new File("productos.txt");
            Scanner scanner = new Scanner(archivo);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();

                if (linea.trim().isEmpty()) {  // Si la línea está en blanco, saltamos a la siguiente
                    continue;
                }

                String[] partes = linea.split(", ");
                String nombreProducto = partes[0];
                String descripcion = partes[1];
                String categoria = partes[2];
                double precio = Double.parseDouble(partes[3]);

                System.out.println("Nombre del producto: " + nombreProducto);
                System.out.println("Descripción: " + descripcion);
                System.out.println("Categoría: " + categoria);
                System.out.println("Precio: " + precio);
                System.out.println();
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
            archivo.write(productos.getNombreProducto() + ", " + productos.getDescripcion() + ", " + productos.getCategoria()
                    + ", " + productos.getPrecio() + "\n");
            archivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void agregarUsuario(Usuario nuevoUsuario) {
    }

    private static void verListaUsuarios() {
    }


}







