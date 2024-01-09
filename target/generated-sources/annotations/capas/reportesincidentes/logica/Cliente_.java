package capas.reportesincidentes.logica;

import capas.reportesincidentes.logica.Incidente;
import capas.reportesincidentes.logica.Servicio;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-01-06T12:11:32", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile ListAttribute<Cliente, Servicio> servicios;
    public static volatile ListAttribute<Cliente, Incidente> incidentes;
    public static volatile SingularAttribute<Cliente, String> razonSocial;
    public static volatile SingularAttribute<Cliente, String> cuit;
    public static volatile SingularAttribute<Cliente, Integer> id;
    public static volatile SingularAttribute<Cliente, String> telefono;
    public static volatile SingularAttribute<Cliente, String> email;

}