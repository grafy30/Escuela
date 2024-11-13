package AdminEscuela.Modelo;

import java.util.Date;
/**
 * @author Wilson
 */
public class ModelEstudiante {
    private int EstudianteID;
    private String Nombre;
    private String Apellido;
    private Date FechaNacimiento;
    private String Dni;
    private String Grado;
    private String Direccion;
    private String Telefono;
    private String Email;
    private Date FechaRegistro;
    private byte [] Foto;

    public ModelEstudiante() {
    }
        
    public int getEstudianteID() {
        return EstudianteID;
    }

    public void setEstudianteID(int EstudianteID) {
        this.EstudianteID = EstudianteID;
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
        if (Dni != null && Dni.length() == 8 && Dni.matches("\\d+")) {
            this.Dni = Dni;
        } else {
            throw new IllegalArgumentException("El DNI debe tener exactamente 8 dígitos numéricos.");
        }
    }

    public String getGrado() {
        return Grado;
    }

    public void setGrado(String Grado) {
        this.Grado = Grado;
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

    public ModelEstudiante(int EstudianteID, String Nombre, String Apellido, Date FechaNacimiento, String Dni, String Grado, String Direccion, String Telefono, String Email, Date FechaRegistro, byte[] Foto) {
        this.EstudianteID = EstudianteID;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.FechaNacimiento = FechaNacimiento;
        this.Dni = Dni;
        this.Grado = Grado;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Email = Email;
        this.FechaRegistro = FechaRegistro;
        this.Foto = Foto;
    }                
}
