package pago_online.clases;
import pago_online.interfaces.autenticar;
public class pagpPaypal extends procesarPago implements autenticar {
    private String email;
    private String password;

    public pagpPaypal(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public pagpPaypal(){}

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public Boolean login(String correo, String contraseña) {
        try{
            System.out.println("Autenticando con Paypal...");
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return correo.equals("admin@gmail.com") && contraseña.equals("admin");
    }

    public String toString(){
        return "Email: " + email + "\nPassword: " + password;
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
