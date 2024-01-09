package capas.reportesincidentes.logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String razonSocial;
    private String cuit;
    private String telefono;
    private String email;
    @ManyToMany
    private List<Servicio>servicios;
    @OneToMany(mappedBy = "cliente")
    private List<Incidente>incidentes;

    public Cliente() {
    }

    public Cliente(int id, String razonSocial, String cuit, String telefono, String email, List<Servicio> servicios, List<Incidente> incidentes) {
        this.id = id;
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.telefono = telefono;
        this.email = email;
        this.servicios = servicios;
        this.incidentes = incidentes;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public List<Incidente> getIncidentes() {
        return incidentes;
    }

    public void setIncidentes(List<Incidente> incidentes) {
        this.incidentes = incidentes;
    }

    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
