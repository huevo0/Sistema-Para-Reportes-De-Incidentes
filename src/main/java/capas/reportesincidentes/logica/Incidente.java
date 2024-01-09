package capas.reportesincidentes.logica;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Incidente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @ManyToOne
    private Cliente cliente;
    private String descripcion;
    private String dificultad;
    private String tipoProblema;
    @ManyToOne
    private Tecnico tecnico;
    @ManyToOne
    private Servicio servicio;
    private String estado;
    private String fechaAlta;
    //@Temporal(TemporalType.DATE)
    private String fechaResolucion;
    //@Temporal(TemporalType.TIME)
    private String colchonHoras;
    
    
    
    

    public Incidente() {
    }

    public Incidente(int id, Cliente cliente, String descripcion, String dificultad, String tipoProblema, Tecnico tecnico, Servicio servicio, String estado, String fechaAlta, String fechaResolucion, String colchonHoras) {
        this.id = id;
        this.cliente = cliente;
        this.descripcion = descripcion;
        this.dificultad = dificultad;
        this.tipoProblema = tipoProblema;
        this.tecnico = tecnico;
        this.servicio = servicio;
        this.estado = estado;
        this.fechaAlta = fechaAlta;
        this.fechaResolucion = fechaResolucion;
        this.colchonHoras = colchonHoras;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getTipoProblema() {
        return tipoProblema;
    }

    public void setTipoProblema(String tipoProblema) {
        this.tipoProblema = tipoProblema;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(String fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public String getColchonHoras() {
        return colchonHoras;
    }

    public void setColchonHoras(String colchonHoras) {
        this.colchonHoras = colchonHoras;
    }

    
    
}
