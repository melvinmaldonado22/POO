package pago_online;
import pago_online.clases.pagpPaypal;
import pago_online.clases.pagpTarjeta;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Ingrese una opción");
        System.out.println("1. Pago con tarjeta");
        System.out.println("2. Pago con Paypal");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if(opcion == 1){
            pagpTarjeta tarjeta2 = new pagpTarjeta();
            System.out.println("Ingrese el usuario");
            String usuario = scanner.nextLine();
            System.out.println("Ingrese la contraseña");
            String contraseña = scanner.nextLine();
            if(tarjeta2.login(usuario, contraseña)){
                System.out.println("Autenticacion exitosa");
                System.out.println("Ingrese el nombre del titular de la tarjeta");
                String nombre = scanner.nextLine();
                tarjeta2.setTitular(nombre);
                System.out.println("Ingrese el numero de la tarjeta");
                String numero = scanner.nextLine();
                tarjeta2.setNumero(numero);
                System.out.println("Ingrese la fecha de vencimiento de la tarjeta");
                String fechaVencimiento = scanner.nextLine();
                tarjeta2.setFechaVencimiento(fechaVencimiento);
                System.out.println("Ingrese el codigo de seguridad de la tarjeta");
                String codigoSeguridad = scanner.nextLine();
                tarjeta2.setCodigoSeguridad(codigoSeguridad);
                System.out.println("Ingrese nombre del titular de la tarjeta");
                String tutular = scanner.nextLine();
                tarjeta2.setTitular(tutular);
                System.out.println("Ingrese el monto a pagar");
                double monto = scanner.nextDouble();
                tarjeta2.procesar_pago(monto);
                scanner.close();
                return;
            }
            System.out.println("Usuario o contraseña incorrectos");
            scanner.close();
            return;
        }

        if(opcion == 2){
            pagpPaypal pagoPaypal = new pagpPaypal();
            System.out.println("Ingrese el correo de Paypal");
            String correo = scanner.nextLine();
            pagoPaypal.setEmail(correo);
            System.out.println("Ingrese la contraseña de Paypal");
            String contraseña = scanner.nextLine();
            pagoPaypal.setPassword(contraseña);
            if(pagoPaypal.login(correo, contraseña)){
                System.out.println("Autenticacion exitosa");
                System.out.println(pagoPaypal.toString());
                System.out.println("Ingrese el monto a pagar");
                double monto = scanner.nextDouble();
                pagoPaypal.procesar_pago(monto);
                scanner.close();
                return;
            }
            System.out.println("Correo o contraseña incorrectos");
            scanner.close();
            return;
        }
        scanner.close();
    }
}