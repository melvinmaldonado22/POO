package herencia3;

public class persona {
    private String nombre;
    private int edad;

    public persona(){
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getEdad(){
        return edad;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }   

    public String toString(){
        return "Nombre: " + nombre + " Edad: " + edad;
    }
}
