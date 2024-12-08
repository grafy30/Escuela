package AdminEscuela.Modelo;

/**
 * @author Wilson
 */
public class ModeloAsignarProfeCurs {
   
    private int ProfesorCursoID;
    private int ProfesorID;
    private int CursoID;

    public ModeloAsignarProfeCurs() {
    }

    public int getProfesorCursoID() {
        return ProfesorCursoID;
    }

    public void setProfesorCursoID(int ProfesorCursoID) {
        this.ProfesorCursoID = ProfesorCursoID;
    }

    public int getProfesorID() {
        return ProfesorID;
    }

    public void setProfesorID(int ProfesorID) {
        this.ProfesorID = ProfesorID;
    }

    public int getCursoID() {
        return CursoID;
    }

    public void setCursoID(int CursoID) {
        this.CursoID = CursoID;
    }

    public ModeloAsignarProfeCurs(int ProfesorCursoID, int ProfesorID, int CursoID) {
        this.ProfesorCursoID = ProfesorCursoID;
        this.ProfesorID = ProfesorID;
        this.CursoID = CursoID;
    }        
}
