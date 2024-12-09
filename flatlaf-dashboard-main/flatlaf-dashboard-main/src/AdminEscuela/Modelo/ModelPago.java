package AdminEscuela.Modelo;

import java.util.Date;

/**
 * @author Wilson
 */
public class ModelPago {
    private int PagoID;
    private int EstudianteID;
    private Double Monto;
    private String Cuota;
    private Date FechaRegistro;
    private String MetodoPago;
    private String Estado;    

    public ModelPago() {
    }

    public int getPagoID() {
        return PagoID;
    }

    public void setPagoID(int PagoID) {
        this.PagoID = PagoID;
    }

    public int getEstudianteID() {
        return EstudianteID;
    }

    public void setEstudianteID(int EstudianteID) {
        this.EstudianteID = EstudianteID;
    }

    public Double getMonto() {
        return Monto;
    }

    public void setMonto(Double Monto) {
        this.Monto = Monto;
    }

    public String getCuota() {
        return Cuota;
    }

    public void setCuota(String Cuota) {
        this.Cuota = Cuota;
    }

    public Date getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(Date FechaRegistro) {
        this.FechaRegistro = FechaRegistro;
    }

    public String getMetodoPago() {
        return MetodoPago;
    }

    public void setMetodoPago(String MetodoPago) {
        this.MetodoPago = MetodoPago;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public ModelPago(int PagoID, int EstudianteID, Double Monto, String Cuota, Date FechaRegistro, String MetodoPago, String Estado) {
        this.PagoID = PagoID;
        this.EstudianteID = EstudianteID;
        this.Monto = Monto;
        this.Cuota = Cuota;
        this.FechaRegistro = FechaRegistro;
        this.MetodoPago = MetodoPago;
        this.Estado = Estado;
    }        
}
