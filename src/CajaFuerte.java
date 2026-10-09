public class CajaFuerte
{
    private String numeroSerie;
    private String modelo;
    private int claveAcceso;
    private boolean estado;
    private byte intentosFallidos;
    private double capacidadMaxima;
    private double saldoActual;
    private boolean alarmaActivada; // NUEVO ATRIBUTO

    public CajaFuerte(String numeroSerie, String modelo,
                      int claveAcceso, double capacidadMaxima)
    {
        this.numeroSerie = numeroSerie;
        this.modelo = modelo;
        this.claveAcceso = claveAcceso;
        this.capacidadMaxima = capacidadMaxima;
        this.estado = false;
        this.intentosFallidos = 0;
        this.saldoActual = 0.0;
        this.alarmaActivada = false; // La alarma inicia en false
    }

    // Metodo para abrir
    public void abrir(int claveIngresada)
    {
        if (intentosFallidos >= 3)
        {
            System.out.println("Caja fuerte bloqueada");
            return;
        }
        if (estado)
        {
            System.out.println("La caja fuerte ya esta abierta");
            return;
        }
        if (claveIngresada == claveAcceso)
        {
            estado = true;
            intentosFallidos = 0;
            System.out.println("Acceso autorizado");
        } else {
            intentosFallidos++; // Suma 1 a intentos fallidos

            System.out.println("Clave incorrecta. Intentos restantes: " + (3 - intentosFallidos));

            if (intentosFallidos >= 3)
            {
                estado = false;
                alarmaActivada = true; // SE ACTIVA LA ALARMA AL LLEGAR A 3 INTENTOS
                System.out.println("Caja fuerte bloqueada");
            }
        }
    }

    // Metodo para cerrar
    public void cerrar()
    {
        if (estado)
        {
            estado = false;
            System.out.println("Se ha cerrado la caja");
        } else {
            System.out.println("La caja ya esta cerrada");
        }
    }

    public void depositar(double cantidad){
        if (!estado){
            System.out.println("Primero abre la caja");
            return;
        }

        if (cantidad <= 0 || saldoActual + cantidad > capacidadMaxima){
            System.out.println("Depósito no permitido");
            return;
        }

        saldoActual += cantidad;
        System.out.println("Depósito realizado");
    }

    public void retirar(double cantidad){
        if (!estado){
            System.out.println("Primero abre la caja");
            return;
        }

        if (cantidad <= 0 || cantidad > saldoActual){
            System.out.println("Retiro no permitido");
            return;
        }

        saldoActual -= cantidad;
        System.out.println("Retiro realizado");
    }

    public void mostrarEstado(){
        System.out.println("Modelo: " + modelo);
        System.out.println("Numero Serie: " + numeroSerie);
        System.out.print("La caja esta: " );

        if (estado){
            System.out.println("abierta");
        }else{
            System.out.println("cerrada");
        }

        System.out.println("Intentos fallidos: " + intentosFallidos);

        // Muestra el valor de la alarma en el estado
        System.out.println("Alarma activada: " + alarmaActivada);

        if (estado){
            System.out.println("Saldo: " + saldoActual);
        }else{
            System.out.println("Saldo: información protegida");
        }
    }
}