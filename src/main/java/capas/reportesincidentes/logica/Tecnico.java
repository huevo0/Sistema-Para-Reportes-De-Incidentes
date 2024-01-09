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
public class Tecnico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String Nombre;
    @ManyToMany
    private List<Servicio>especialidad;
    @OneToMany(mappedBy = "tecnico")
    private List<Incidente>incidentes;
    

    public Tecnico() {
    }
    
    
    public Tecnico(int id, String Nombre, List<Servicio> especialidad, List<Incidente> incidentes) {
        this.id = id;
        this.Nombre = Nombre;
        this.especialidad = especialidad;
        this.incidentes = incidentes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public List<Servicio> getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(List<Servicio> especialidad) {
        this.especialidad = especialidad;
    }

    public List<Incidente> getIncidentes() {
        return incidentes;
    }

    public void setIncidentes(List<Incidente> incidentes) {
        this.incidentes = incidentes;
    }
    
    
}
