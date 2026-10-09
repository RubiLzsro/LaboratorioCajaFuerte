import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        CajaFuerte caja = new CajaFuerte("20260001L",
        "SecureBox A1", 1234, 50000.0);

        int opcion;

        do {
            System.out.println("\n=== CAJA FUERTE ===");
            System.out.println("1. Abrir");
            System.out.println("2. Cerrar");
            System.out.println("3. Depositar");
            System.out.println("4. Retirar");
            System.out.println("5. Consultar estado");
            System.out.println("6. Salir");
            System.out.print("Opción: ");

            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Clave: ");
                    caja.abrir(teclado.nextInt());
                    break;
                case 2:
                    caja.cerrar();
                    break;
                case 3:
                    System.out.print("Cantidad a depositar: ");
                    caja.depositar(teclado.nextDouble());
                    break;
                case 4:
                    System.out.print("Cantidad a retirar: ");
                    caja.retirar(teclado.nextDouble());
                    break;
                case 5:
                    caja.mostrarEstado();
                    break;
                case 6:
                    System.out.println("Programa terminado.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
        teclado.close();
    }
}
