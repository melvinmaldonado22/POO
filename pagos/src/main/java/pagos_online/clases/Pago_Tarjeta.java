package pagos_online.clases;

import pagos_online.interfaces.Autentication;

public class Pago_Tarjeta extends Procesar_Pago implements Autentication {
    private String numero_tarjeta;
    private String fecha_expiracion;
    private String cvv;
    private String nombre_titular;

    public Pago_Tarjeta(String numero_tarjeta, String fecha_expiracion, String cvv, String nombre_titular) {
        this.numero_tarjeta = numero_tarjeta;
        this.fecha_expiracion = fecha_expiracion;
        this.cvv = cvv;
        this.nombre_titular = nombre_titular;
    }
    public Pago_Tarjeta(String numero_tarjeta, String cvv) {
        this.numero_tarjeta = numero_tarjeta;
        this.cvv = cvv;
    }

    public Pago_Tarjeta() {}

    public String getNumero_tarjeta() {
        return numero_tarjeta;
    }   
    public String getFecha_expiracion() {
        return fecha_expiracion;
    }
    public String getCvv() {
        return cvv;
    }
    public String getNombre_titular() {
        return nombre_titular;
    }               
    public void setNumero_tarjeta(String numero_tarjeta) {
        this.numero_tarjeta = numero_tarjeta;
    }   
    public void setFecha_expiracion(String fecha_expiracion) {
        this.fecha_expiracion = fecha_expiracion;
    }
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
    public void setNombre_titular(String nombre_titular) {
        this.nombre_titular = nombre_titular;
    }
    @Override
    public Boolean login(String username, String password) {
        try {
            System.out.println("Iniciando sesión...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return username.equals("admin") && password.equals("admin");
    }
    @Override
    public void procesar_pago(double pago) {
        try {
            System.out.println("Procesando pago de: Lps." + pago + "...");
            Thread.sleep(1000);
            System.out.println("Pago procesado exitosamente");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Error al procesar el pago");
        }
    }
    public String toString() {
        return "{\n" +
            "   \"numero_tarjeta\": \"" + numero_tarjeta + "\",\n" +
            "   \"fecha_expiracion\": \"" + fecha_expiracion + "\",\n" +
            "   \"cvv\": \"" + cvv + "\",\n" +
            "   \"nombre_titular\": \"" + nombre_titular + "\"\n" +
            "}";
    }
}
