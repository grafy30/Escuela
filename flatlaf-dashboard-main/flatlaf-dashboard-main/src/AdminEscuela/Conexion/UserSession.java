package AdminEscuela.Conexion;
/**
 * @author Wilson
 */
public class UserSession {
    
    private static UserSession instancia;
    private static int UsuarioID;
    private static String NombreUsuario;
    private static int RolId;

    public static UserSession getInstancia() {
        if (instancia==null) {
            instancia =new UserSession();
        }
        return instancia;
    }

    public static void setInstancia(UserSession instancia) {
        UserSession.instancia = instancia;
    }

    public static int getUsuarioID() {
        return UsuarioID;
    }

    public static void setUsuarioID(int UsuarioID) {
        UserSession.UsuarioID = UsuarioID;
    }

    public static String getNombreUsuario() {
        return NombreUsuario;
    }

    public static void setNombreUsuario(String NombreUsuario) {
        UserSession.NombreUsuario = NombreUsuario;
    }

    public static int getRolId() {
        return RolId;
    }

    public static void setRolId(int RolId) {
        UserSession.RolId = RolId;
    }
    
    public void clearSession(){
        UsuarioID=0;
        NombreUsuario=null;
        RolId=0;
    }               
}
