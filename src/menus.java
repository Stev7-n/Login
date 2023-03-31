import java.util.Scanner;

public class menus {

    static void menuUsuario(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nElige una opción:");
            System.out.println("1. Ver perfil");
            System.out.println("2. Cambiar contraseña");
            System.out.println("3. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    Usuario.verPerfil(usuario.getNombreUsuario());
                    break;
                case 2:
                    System.out.print("Ingrese la nueva contraseña:");
                    String nuevaContrasenia = scanner.nextLine();
                    usuario.setContrasenia(nuevaContrasenia);
                    usuario.getTipoUsuario();
                    System.out.println("\nContraseña actualizada exitosamente.");
                    break;
                case 3:
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
            System.out.println("1. Ver lista de usuarios");
            System.out.println("2. Crear usuario");
            System.out.println("3. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    verListaUsuarios();
                    break;
                case 2:
                    System.out.print("Ingrese el nombre de usuario:");
                    String nombreUsuario = scanner.nextLine();
                    System.out.print("Ingrese la contraseña:");
                    String contrasenia = scanner.nextLine();
                    Usuario nuevoUsuario = new Usuario(nombreUsuario, contrasenia, "usuario");
                    agregarUsuario(nuevoUsuario);
                    System.out.println("\nUsuario creado exitosamente.");
                    break;
                case 3:
                    System.out.println("Hasta luego.");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void agregarUsuario(Usuario nuevoUsuario) {
    }

    private static void verListaUsuarios() {
    }


}







