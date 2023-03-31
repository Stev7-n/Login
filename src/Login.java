import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nElige una opción:");
            System.out.println("1. Ingresar");
            System.out.println("2. Crear usuario");
            System.out.println("3. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("\nIngrese su nombre de usuario:");
                    String usuario = scanner.nextLine();
                    System.out.print("Ingrese su contraseña:");
                    String contrasenia = scanner.nextLine();

                    if (verificarCredenciales(usuario, contrasenia)) {
                        System.out.println("Inicio de sesión exitoso.");
                    } else {
                        System.out.println("\nInicio de sesión fallido.");
                    }

                    break;
                case 2:
                    System.out.print("Ingrese el nombre de usuario:");
                    String nombreUsuario = scanner.nextLine();
                    System.out.print("Ingrese la contraseña:");
                    String clave = scanner.nextLine();
                    System.out.println("Elija el tipo de usuario:");
                    System.out.println("1. Admin");
                    System.out.println("2. Usuario");
                    String tipoUsuario = null;
                    int tipoUsuarioOpcion = scanner.nextInt();
                    switch (tipoUsuarioOpcion) {
                        case 1:
                            tipoUsuario = "admin";
                            System.out.print("Ingrese la contraseña de autorización:");
                            String autorizacion = scanner.next();
                            if (!autorizacion.equals("2002")) {
                                System.out.println("Contraseña de autorización incorrecta. No se puede crear el usuario.");
                                break;
                            }
                            break;
                        case 2:
                            tipoUsuario = "usuario";
                            break;
                        default:
                            System.out.println("Opción inválida.");
                            break;
                    }

                    if (tipoUsuario != null && verificarCredencialesregistro(nombreUsuario)) {
                        Usuario nuevoUsuario = new Usuario(nombreUsuario, clave, tipoUsuario);
                        agregarUsuario(nuevoUsuario);
                        System.out.println("\nUsuario creado exitosamente.");
                    } else {
                        System.out.println("\nEl usuario ya existe.");
                    }
                    break;

                case 3:
                    System.out.println("Hasta luego.");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    public static boolean verificarCredenciales(String usuario, String contrasenia) {
        if (usuario == null || contrasenia == null) {
            return false;
        }

        try {
            File archivo = new File("usuarios.txt");
            Scanner scanner = new Scanner(archivo);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] componentes = linea.split(",");

                if (componentes.length >= 2) {
                    String nombreUsuario = componentes[0];
                    String clave = componentes[1];

                    if (usuario.equals(nombreUsuario) && contrasenia.equals(clave)) {
                        scanner.close();
                        return true;
                    }
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void agregarUsuario(Usuario usuario) {
        try {
            FileWriter archivo = new FileWriter("usuarios.txt", true);
            archivo.write(usuario.getNombreUsuario() + "," + usuario.getContrasenia() + "," + usuario.getTipoUsuario() + "\n");
            archivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static boolean verificarCredencialesregistro(String nombreUsuariore) {
        try {
            File archivo = new File("usuarios.txt");
            Scanner scanner = new Scanner(archivo);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] componentes = linea.split(",");
                String nombreUsuario = componentes[0];

                if (nombreUsuariore.equals(nombreUsuario)) {
                    scanner.close();
                    return false;
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return true;
    }
}



