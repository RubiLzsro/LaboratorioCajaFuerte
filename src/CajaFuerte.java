public class CajaFuerte
{
    private String numeroSerie;
    private String modelo;
    private int claveAcceso;
    private boolean estado;
    private byte intentosFallidos;
    private double capacidadMaxima;
    private double saldoActual;

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
    }

    //Metodo para abrir
    public void abrir(int claveIngresada)
    {
        if (intentosFallidos >= 3)
        {
            System.out.println("Caja fuerte bloqueada");
            return;
        }
        if (estado)
        { // Si ya está abierta
            System.out.println("La caja fuerte ya esta abierta");
            return;
        }
        if (claveIngresada == claveAcceso)
        {
            estado = true; // La caja ha sido abierta
            intentosFallidos = 0; // Reinicia contador
            System.out.println("Acceso autorizado");
        } else {
            intentosFallidos++; // Suma 1 a intentos fallidos
            System.out.println("Clave incorrecta. Intentos restantes: " + (3 - intentosFallidos));
            if (intentosFallidos >= 3)
            {
                estado = false;
                System.out.println("Caja fuerte bloqueada");
            }
        }
    }

    //Metodo para cerrar
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
}