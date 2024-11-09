package AdminEscuela.Modelo;

public class ModelUsuario {
    private int Id_Usuario;
    private String Nombre_Usuario;
    private String Email;
    private String Contraseña;
    private int Id_Rol;

    public int getId_usuario() {
        return Id_Usuario;
    }

    public void setId_usuario(int Id_usuario) {
        this.Id_Usuario = Id_usuario;
    }

    public String getNombres_Usuario() {
        return Nombre_Usuario;
    }

    public void setNombres_Usuario(String Nombres_Usuario) {
        this.Nombre_Usuario = Nombres_Usuario;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public int getId_Rol() {
        return Id_Rol;
    }

    public void setId_Rol(int Id_Rol) {
        this.Id_Rol = Id_Rol;
    }
    
    //Constructor de la clase
    public ModelUsuario(int id,String nombre,String email,String contra,int id_rol){
        this.Id_Usuario=id;
        this.Nombre_Usuario=nombre;       
        this.Email=email;
        this.Contraseña=contra;
        this.Id_Rol=id_rol;                        
    }
    
}
