package AdminEscuela.Modelo;

public class ModelUsuario {
    private int UsuarioID;
    private String NombreUsuario;
    private String Contraseña;    
    private int RolID;
    private int EstudianteID;
    private int ProfesorID;
    private byte [] Foto;    
    private String NombreCompleto;

    public ModelUsuario() {
    }       

    public int getUsuarioID() {
        return UsuarioID;
    }

    public void setUsuarioID(int UsuarioID) {
        this.UsuarioID = UsuarioID;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public int getRolID() {
        return RolID;
    }

    public void setRolID(int RolID) {
        this.RolID = RolID;
    }

    public int getEstudianteID() {
        return EstudianteID;
    }

    public void setEstudianteID(int EstudianteID) {
        this.EstudianteID = EstudianteID;
    }

    public int getProfesorID() {
        return ProfesorID;
    }

    public void setProfesorID(int ProfesorID) {
        this.ProfesorID = ProfesorID;
    }

    public byte[] getFoto() {
        return Foto;
    }

    public void setFoto(byte[] Foto) {
        this.Foto = Foto;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }
        
    //Constructor de la clase      
    public ModelUsuario(int UsuarioID, String NombreUsuario, String Contraseña, int RolID, byte[] Foto, int EstudianteID, int ProfesorID, String NombreCompleto) {
        this.UsuarioID = UsuarioID;
        this.NombreUsuario = NombreUsuario;
        this.Contraseña = Contraseña;
        this.RolID = RolID;
        this.Foto = Foto;
        this.EstudianteID = EstudianteID;
        this.ProfesorID = ProfesorID;
        this.NombreCompleto = NombreCompleto;
    }   
}
