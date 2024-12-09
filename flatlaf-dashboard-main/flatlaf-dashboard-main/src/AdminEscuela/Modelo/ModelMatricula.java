/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdminEscuela.Modelo;

import java.util.Date;

/**
 *
 * @author Muguruza
 */
public class ModelMatricula {
    private int MatriculaID;
    private int EstudianteID;
    private int CursoID;
    private Date FechaMatricula;
    private String Estado;

    public ModelMatricula() {
    }

    public int getMatriculaID() {
        return MatriculaID;
    }

    public void setMatriculaID(int MatriculaID) {
        this.MatriculaID = MatriculaID;
    }

    public int getEstudianteID() {
        return EstudianteID;
    }

    public void setEstudianteID(int EstudianteID) {
        this.EstudianteID = EstudianteID;
    }

    public int getCursoID() {
        return CursoID;
    }

    public void setCursoID(int CursoID) {
        this.CursoID = CursoID;
    }

    public Date getFechaMatricula() {
        return FechaMatricula;
    }

    public void setFechaMatricula(Date FechaMatricula) {
        this.FechaMatricula = FechaMatricula;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    
}
