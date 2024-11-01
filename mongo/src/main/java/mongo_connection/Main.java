package mongo_connection;
import org.bson.Document;
import java.util.List;
import java.util.Scanner;
import org.bson.json.JsonWriterSettings;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Crear una instancia del CRUD para la colección "preguntas"
        MongoCRUD crud = new MongoCRUD("clientes");
        String opcion = "";
        do {
            System.out.println("\nBienvenido al sistema de gestión de usuarios");
            System.out.println("---------------------------------------------");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Insertar un usuario");
            System.out.println("2. Obtener todos los usuarios");
            System.out.println("3. Actualizar un usuario");
            System.out.println("4. Eliminar un usuario");
            System.out.println("0. Salir");
            opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    System.out.println("\n:::::::::::::::: Insertar un usuario ::::::::::::::::");
                    System.out.println("Ingrese el nombre");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el apellido");
                    String apellido = scanner.nextLine();
                    System.out.println("Ingrese la edad");
                    int edad = Integer.parseInt(System.console().readLine());
                    System.out.println("Ingrese el email");
                    String email = scanner.nextLine();
                    System.out.println("Ingrese la contraseña");
                    String password = scanner.nextLine();
                    Document newDoc = new Document()
                        .append("nombre", nombre)
                        .append("apellido", apellido)
                        .append("edad", edad)
                        .append("email", email)
                        .append("password", password);
                    crud.insertDocument(newDoc);
                    break;
                case "2":
                    System.out.println("\n:::::::::::::::::: Obtener todos los usuarios ::::::::::::::::");
                    List<Document> documents = crud.getAllDocuments();
                    for (Document doc : documents) {
                        System.out.println(doc.toJson(JsonWriterSettings.builder()
                            .indent(true)
                            .build()));
                    }
                    break;
                case "3":
                    System.out.println("\n:::::::::::::::::: Actualizar un usuario ::::::::::::::::");
                    System.out.println("Ingrese el ID del usuario a actualizar");
                    String id = scanner.nextLine();
                    System.out.println("Ingrese el nuevo nombre");
                    String Unombre = scanner.nextLine();
                    System.out.println("Ingrese el nuevo apellido");
                    String Uapellido = scanner.nextLine();
                    System.out.println("Ingrese la nueva edad");
                    int Uedad = Integer.parseInt(System.console().readLine());
                    System.out.println("Ingrese el nuevo email");
                    String Uemail = scanner.nextLine();
                    System.out.println("Ingrese la nueva contraseña");
                    String Upassword = scanner.nextLine();
                    Document updateData = new Document()
                        .append("nombre", Unombre)
                        .append("apellido", Uapellido)
                        .append("edad", Uedad)
                        .append("email", Uemail)
                        .append("password", Upassword);
                    crud.updateDocument(id, updateData);
                    break;
                case "4":
                    System.out.println("\n:::::::::::::::::: Eliminar un usuario ::::::::::::::::");
                    System.out.println("Ingrese el ID del usuario a eliminar");
                    String Eid = scanner.nextLine();
                    crud.deleteDocument(Eid);   
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }while (!opcion.equals("0"));
        System.out.println(" :::::::::::::::: Iniciar sesión ::::::::::::::::");
        System.out.println("Ingrese su email");
        String email = scanner.nextLine();
        System.out.println("Ingrese su contraseña");
        String password = scanner.nextLine();
        Document loginData = new Document()
            .append("email", email)
            .append("password", password);
        crud.iniciar_sesion(loginData);
        scanner.close();
        mongo_connect.closeConnection();
    }

    public static boolean isNumber(String input){
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}