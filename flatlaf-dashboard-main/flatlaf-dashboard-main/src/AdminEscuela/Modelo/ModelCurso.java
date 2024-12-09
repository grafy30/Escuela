package AdminEscuela.Modelo;

/**
 * @author Wilson
 */
public class ModelCurso {
    private int CursoID;
    private String Nombre;
    private String Descripcion;
    private String Grado;

    public ModelCurso() {
    }

    public int getCursoID() {
        return CursoID;
    }

    public void setCursoID(int CursoID) {
        this.CursoID = CursoID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getGrado() {
        return Grado;
    }

    public void setGrado(String Grado) {
        this.Grado = Grado;
    }
    public ModelCurso(int CursoID, String Nombre, String Descripcion, String Grado) {
        this.CursoID = CursoID;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Grado = Grado;
    }
    
}
