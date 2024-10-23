package pagos_online.clases;

import pagos_online.interfaces.Autentication;

public class Pago_Paypal extends Procesar_Pago implements Autentication {
    private String email;
    private String password;

    public Pago_Paypal(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public Pago_Paypal() {}
    
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }   
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public Boolean login(String email, String password) {
        try {
            System.out.println("Iniciando sesión...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return email.equals("admin@gmail.com") && password.equals("admin");
    }

    @Override
    public void procesar_pago(double pago) {
        System.out.println("Procesando pago de: Lps." + pago + "...");
    }
    public String toString() {
        return "{\n" +
                "   \"email\": \"" + email + "\",\n" +
                "   \"password\": \"" + password + "\"\n" +
                "}";
    }
}
