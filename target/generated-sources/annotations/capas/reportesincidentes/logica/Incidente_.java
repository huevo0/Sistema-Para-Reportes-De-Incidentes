package capas.reportesincidentes.logica;

import capas.reportesincidentes.logica.Cliente;
import capas.reportesincidentes.logica.Servicio;
import capas.reportesincidentes.logica.Tecnico;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-01-06T12:11:32", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Incidente.class)
public class Incidente_ { 

    public static volatile SingularAttribute<Incidente, String> descripcion;
    public static volatile SingularAttribute<Incidente, Cliente> cliente;
    public static volatile SingularAttribute<Incidente, String> estado;
    public static volatile SingularAttribute<Incidente, Servicio> servicio;
    public static volatile SingularAttribute<Incidente, String> fechaAlta;
    public static volatile SingularAttribute<Incidente, String> colchonHoras;
    public static volatile SingularAttribute<Incidente, String> tipoProblema;
    public static volatile SingularAttribute<Incidente, Integer> id;
    public static volatile SingularAttribute<Incidente, Tecnico> tecnico;
    public static volatile SingularAttribute<Incidente, String> fechaResolucion;
    public static volatile SingularAttribute<Incidente, String> dificultad;

}