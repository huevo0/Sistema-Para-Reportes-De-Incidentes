package capas.reportesincidentes.persistencia;

import capas.reportesincidentes.logica.Cliente;
import capas.reportesincidentes.logica.Incidente;
import capas.reportesincidentes.logica.Servicio;
import capas.reportesincidentes.logica.Tecnico;
import capas.reportesincidentes.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {

       ClienteJpaController clienteJpa = new ClienteJpaController();
       IncidenteJpaController incidenteJpa = new IncidenteJpaController();
       ServicioJpaController servicioJpa = new ServicioJpaController();
       TecnicoJpaController tecnicoJpa = new TecnicoJpaController();

    public List<Servicio> traerServicios() {
        return servicioJpa.findServicioEntities();
    
    }

    public void guardarCliente(Cliente cliente) {
        clienteJpa.create(cliente);
    }

    public void guardarServicio(Servicio servicio) {
        servicioJpa.create(servicio);
    }

    public List<Cliente> traerClientes() {
         return clienteJpa.findClienteEntities();
    }

    public void eliminarServicio(int idServicio) {
           try {
               servicioJpa.destroy(idServicio);
           } catch (NonexistentEntityException ex) {
               Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
           }
    }

    public void eliminarCliente(int idCliente) {
           try {
               clienteJpa.destroy(idCliente);
           } catch (NonexistentEntityException ex) {
               Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
           }
    }

    public Cliente traerUnCliente(int idCliente) {
          return clienteJpa.findCliente(idCliente);
    }

    public void modificaUnServicio(Cliente cliente) {
           try {
               clienteJpa.edit(cliente);
           } catch (Exception ex) {
               Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
           }
    }

    public Servicio traerUnServicio(int idServicio) {
        return servicioJpa.findServicio(idServicio);
    }

    public void editarUnServicio(Servicio servicio) {
           try {
               servicioJpa.edit(servicio);
           } catch (Exception ex) {
               Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
           }
    }

    public void editarCliente(Cliente cliente) {
           try {
               clienteJpa.edit(cliente);
           } catch (Exception ex) {
               Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
           }
    }

    public void crearTecnico(Tecnico tecnico) {
         tecnicoJpa.create(tecnico);
    }

    public List<Tecnico> traerTecnicos() {
        return tecnicoJpa.findTecnicoEntities();
    }

    public void eliminarTecnico(int idTecnico) {
           try {
               tecnicoJpa.destroy(idTecnico);
           } catch (NonexistentEntityException ex) {
               Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
           }
    }

    public Tecnico traerUnTecnico(int idTecnico) {
           return tecnicoJpa.findTecnico(idTecnico);
    }

    public void editarTecnico(Tecnico tecnico) {
           try {
               tecnicoJpa.edit(tecnico);
           } catch (Exception ex) {
               Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
           }
    }

    public List<Incidente> traerIncidente() {
            return incidenteJpa.findIncidenteEntities();
    }

    public void eliminarIncidente(int idIncidente) {
           try {
               incidenteJpa.destroy(idIncidente);
           } catch (NonexistentEntityException ex) {
               Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
           }
    }

    public void crearIncidente(Incidente incidente) {
        incidenteJpa.create(incidente);
    }

    public Incidente traerUnIncidente(int idIncidente) {
        return incidenteJpa.findIncidente(idIncidente);
    }

    public void editarIncidente(Incidente incidente) {
           try {
               incidenteJpa.edit(incidente);
           } catch (Exception ex) {
               Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
           }
    }

    

    

    
   
    

   
       
}
