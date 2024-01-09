package capas.reportesincidentes.logica;

import capas.reportesincidentes.logica.Incidente;
import capas.reportesincidentes.logica.Servicio;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-01-06T12:11:32", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Tecnico.class)
public class Tecnico_ { 

    public static volatile SingularAttribute<Tecnico, String> Nombre;
    public static volatile ListAttribute<Tecnico, Incidente> incidentes;
    public static volatile SingularAttribute<Tecnico, Integer> id;
    public static volatile ListAttribute<Tecnico, Servicio> especialidad;

}