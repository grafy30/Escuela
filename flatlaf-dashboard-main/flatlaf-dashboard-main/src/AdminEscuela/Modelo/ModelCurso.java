package AdminEscuela.Modelo;

/**
 * @author Wilson
 */
public class ModelCurso {
    private int CursoID;
    private String Nombre;
    private String Descripcion;

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

    public ModelCurso(int CursoID, String Nombre, String Descripcion) {
        this.CursoID = CursoID;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
    }            
}
