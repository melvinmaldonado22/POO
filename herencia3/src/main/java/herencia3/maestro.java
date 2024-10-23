package herencia3;

public class maestro extends persona {
    private String materia;

    public maestro(){
        super();
    }

    public String getMateria(){
        return materia;
    }   

    public void setMateria(String materia){
        this.materia = materia;
    }

    public String toString(){
        return super.toString() + " Materia: " + materia;
    }
}
