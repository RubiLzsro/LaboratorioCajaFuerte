public class Main {
    public static void main(String[] args)
    {
        System.out.println("Iniciando simulador de caja fuerte");
        CajaFuerte caja = new CajaFuerte("20260001L", "SecureBox A1", 1234, 50000.0);
        System.out.println("Caja fuerte creada correctamente");

        //Llamadas temporales al metodo
        caja.abrir(1234);
        caja.depositar(1500);
        caja.retirar(500);
        caja.mostrarEstado();
        caja.cerrar();

    }
}
