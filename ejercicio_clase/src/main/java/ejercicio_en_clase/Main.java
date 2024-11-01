package ejercicio_en_clase;

class Empleado {
    private String nombre;
    private double salario;

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre + ", Salario: " + salario);
    }
}
// Herencia
class Gerente extends Empleado {
    private String departamento;

    public Gerente(String nombre, double salario, String departamento) {
        super(nombre, salario);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Departamento: " + departamento);
    }
}
public class Main {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Luis", 3000, "Ventas");
        gerente.mostrarDatos();
    }
}