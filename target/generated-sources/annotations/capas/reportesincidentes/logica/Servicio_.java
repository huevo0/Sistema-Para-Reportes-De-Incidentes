package capas.reportesincidentes.logica;

import capas.reportesincidentes.logica.Incidente;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-01-06T12:11:32", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Servicio.class)
public class Servicio_ { 

    public static volatile ListAttribute<Servicio, Incidente> incidentes;
    public static volatile SingularAttribute<Servicio, String> tipo;
    public static volatile SingularAttribute<Servicio, Integer> id;
    public static volatile SingularAttribute<Servicio, String> nombre;

}