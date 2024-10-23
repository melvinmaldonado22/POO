package pagos_online;

import pagos_online.clases.Pago_Tarjeta;
import pagos_online.clases.Pago_Paypal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n:::::::::::Pagos Online:::::::::::\n");
        System.out.println("\nBienvenido al sistema de pagos online\n");
        System.out.println("Elija el tipo de pago:\n1. Tarjeta\n2. Paypal\n");
        Scanner scanner = new Scanner(System.in);
        int tipo_pago = scanner.nextInt();
        if (tipo_pago == 1) {
            Pago_Tarjeta pago_tarjeta = new Pago_Tarjeta();

            // Ingresar el usuario y la contraseña para iniciar sesión
            System.out.println("Ingrese un usuario: ");
            String usuario = scanner.next();
            System.out.println("Ingrese una contraseña: ");
            String contraseña = scanner.next();
            if (pago_tarjeta.login(usuario, contraseña)) {
                System.out.println("Login exitoso");

                // Ingresar los datos de la tarjeta
                System.out.println("Ingrese el numero de la tarjeta: ");
                String numero_tarjeta = scanner.next();
                pago_tarjeta.setNumero_tarjeta(numero_tarjeta);
                System.out.println("Ingrese el nombre del titular de la tarjeta: ");
                String nombre_titular = scanner.next();
                pago_tarjeta.setNombre_titular(nombre_titular);
                System.out.println("Ingrese el cvv de la tarjeta: ");
                String cvv = scanner.next();
                pago_tarjeta.setCvv(cvv);
                System.out.println("Ingrese la fecha de expiracion de la tarjeta: ");
                String fecha_expiracion = scanner.next();
                pago_tarjeta.setFecha_expiracion(fecha_expiracion);
                System.out.println("Ingrese el monto del pago: ");
                double pago = scanner.nextDouble();
                pago_tarjeta.procesar_pago(pago);

                // Mostrar el estado de la tarjeta
                System.out.println(pago_tarjeta.toString());

                // Cerrar el scanner
                scanner.close();
                return;
            }
            System.out.println("Login fallido");
            scanner.close();
            return;
        }
        
        if (tipo_pago == 2) {
            Pago_Paypal pago_paypal2 = new Pago_Paypal();
            System.out.println("Ingrese un usuario: ");
            String usuario = scanner.next();
            System.out.println("Ingrese una contraseña: ");
            String contraseña = scanner.next();
            if (pago_paypal2.login(usuario, contraseña)) {
                System.out.println("Login exitoso");

                // Ingresar el email del usuario
                System.out.println("Ingrese el email del usuario: ");
                String email = scanner.next();
                pago_paypal2.setEmail(email);

                // Ingresar el password del usuario
                System.out.println("Ingrese el password del usuario: ");
                String password = scanner.next();
                pago_paypal2.setPassword(password);

                // Ingresar el monto del pago
                System.out.println("Ingrese el monto del pago: ");
                double pago = scanner.nextDouble();
                pago_paypal2.procesar_pago(pago);

                // Mostrar el estado del pago
                System.out.println(pago_paypal2.toString());

                // Cerrar el scanner
                scanner.close();
                return;
            }
            System.out.println("Login fallido");
            scanner.close();
            return;
        }

        scanner.close();
        System.out.println("\n:::::::::::Pagos Online:::::::::::\n");
    }
}