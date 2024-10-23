package herencia3;

public class Main {
    public static void main(String[] args) {
        maestro m1 = new maestro();
        m1.setNombre("Juan");
        m1.setEdad(20);
        m1.setMateria("Matematicas");
        System.out.println(m1.toString());
    }
}