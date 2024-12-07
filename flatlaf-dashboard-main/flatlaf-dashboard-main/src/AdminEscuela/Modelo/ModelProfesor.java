package AdminEscuela.Modelo;

import java.util.Date;

/**
 * @author Wilson
 */
public class ModelProfesor {
    
    private int ProfesorID;
    private String Nombre;
    private String Apellido;
    private Date FechaNacimiento;
    private String Dni;
    private String Especialidad;
    private String Direccion;
    private String Telefono;
    private String Email;
    private Date FechaRegistro;
    private byte [] Foto;
    private String Rutfo;

    public ModelProfesor() {
    }

    public int getProfesorID() {
        return ProfesorID;
    }

    public void setProfesorID(int ProfesorID) {
        this.ProfesorID = ProfesorID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Date getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(Date FechaRegistro) {
        this.FechaRegistro = FechaRegistro;
    }

    public byte[] getFoto() {
        return Foto;
    }

    public void setFoto(byte[] Foto) {
        this.Foto = Foto;
    }

    public String getRutfo() {
        return Rutfo;
    }

    public void setRutfo(String Rutfo) {
        this.Rutfo = Rutfo;
    }

    public ModelProfesor(int ProfesorID, String Nombre, String Apellido, Date FechaNacimiento, String Dni, String Especialidad, String Direccion, String Telefono, String Email, Date FechaRegistro, byte[] Foto, String Rutfo) {
        this.ProfesorID = ProfesorID;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.FechaNacimiento = FechaNacimiento;
        this.Dni = Dni;
        this.Especialidad = Especialidad;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Email = Email;
        this.FechaRegistro = FechaRegistro;
        this.Foto = Foto;
        this.Rutfo = Rutfo;
    }        
}
