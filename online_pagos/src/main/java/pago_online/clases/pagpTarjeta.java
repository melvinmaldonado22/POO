package pago_online.clases;
import pago_online.interfaces.autenticar;
public class pagpTarjeta extends procesarPago implements autenticar {
    private String numero;
    private String fechaVencimiento;
    private String codigoSeguridad;
    private String titular;

    public pagpTarjeta(String numero, String fechaVencimiento, String codigoSeguridad, String titular) {
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
        this.codigoSeguridad = codigoSeguridad;
        this.titular = titular;
    }
    public pagpTarjeta(){}

    public String getNumero() {
        return numero;
    }   
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }
    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }
    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }
    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    public String toString(){
        return "Numero: " + numero + "\nFecha de vencimiento: " + fechaVencimiento + "\nCodigo de seguridad: " + codigoSeguridad + "\nTitular: " + titular;
    }
    @Override
    public Boolean login(String usuario, String contraseña) {
        try{
            System.out.println("Autenticando con Tarjeta...");
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return usuario.equals("admin") && contraseña.equals("admin");
    }
    @Override
    public void procesar_pago(double monto){
        try{
            super.pagar(monto);
            Thread.sleep(3000);
            System.out.println("Pago realizado con exito");
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

// try{
//     System.out.println("mensaje");
//     Thread.sleep(1000);
//     System.out.println("mensaje2");
// }catch(InterruptedException e){
//     e.printStackTrace();
// }
