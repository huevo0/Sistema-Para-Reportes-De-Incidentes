package capas.reportesincidentes.persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import capas.reportesincidentes.logica.Cliente;
import capas.reportesincidentes.logica.Incidente;
import capas.reportesincidentes.logica.Tecnico;
import capas.reportesincidentes.logica.Servicio;
import capas.reportesincidentes.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class IncidenteJpaController implements Serializable {

    public IncidenteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public IncidenteJpaController() {
        emf = Persistence.createEntityManagerFactory("sistemariPU");
    }
    public void create(Incidente incidente) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente cliente = incidente.getCliente();
            if (cliente != null) {
                cliente = em.getReference(cliente.getClass(), cliente.getId());
                incidente.setCliente(cliente);
            }
            Tecnico tecnico = incidente.getTecnico();
            if (tecnico != null) {
                tecnico = em.getReference(tecnico.getClass(), tecnico.getId());
                incidente.setTecnico(tecnico);
            }
            Servicio servicio = incidente.getServicio();
            if (servicio != null) {
                servicio = em.getReference(servicio.getClass(), servicio.getId());
                incidente.setServicio(servicio);
            }
            em.persist(incidente);
            if (cliente != null) {
                cliente.getIncidentes().add(incidente);
                cliente = em.merge(cliente);
            }
            if (tecnico != null) {
                tecnico.getIncidentes().add(incidente);
                tecnico = em.merge(tecnico);
            }
            if (servicio != null) {
                servicio.getIncidentes().add(incidente);
                servicio = em.merge(servicio);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Incidente incidente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Incidente persistentIncidente = em.find(Incidente.class, incidente.getId());
            Cliente clienteOld = persistentIncidente.getCliente();
            Cliente clienteNew = incidente.getCliente();
            Tecnico tecnicoOld = persistentIncidente.getTecnico();
            Tecnico tecnicoNew = incidente.getTecnico();
            Servicio servicioOld = persistentIncidente.getServicio();
            Servicio servicioNew = incidente.getServicio();
            if (clienteNew != null) {
                clienteNew = em.getReference(clienteNew.getClass(), clienteNew.getId());
                incidente.setCliente(clienteNew);
            }
            if (tecnicoNew != null) {
                tecnicoNew = em.getReference(tecnicoNew.getClass(), tecnicoNew.getId());
                incidente.setTecnico(tecnicoNew);
            }
            if (servicioNew != null) {
                servicioNew = em.getReference(servicioNew.getClass(), servicioNew.getId());
                incidente.setServicio(servicioNew);
            }
            incidente = em.merge(incidente);
            if (clienteOld != null && !clienteOld.equals(clienteNew)) {
                clienteOld.getIncidentes().remove(incidente);
                clienteOld = em.merge(clienteOld);
            }
            if (clienteNew != null && !clienteNew.equals(clienteOld)) {
                clienteNew.getIncidentes().add(incidente);
                clienteNew = em.merge(clienteNew);
            }
            if (tecnicoOld != null && !tecnicoOld.equals(tecnicoNew)) {
                tecnicoOld.getIncidentes().remove(incidente);
                tecnicoOld = em.merge(tecnicoOld);
            }
            if (tecnicoNew != null && !tecnicoNew.equals(tecnicoOld)) {
                tecnicoNew.getIncidentes().add(incidente);
                tecnicoNew = em.merge(tecnicoNew);
            }
            if (servicioOld != null && !servicioOld.equals(servicioNew)) {
                servicioOld.getIncidentes().remove(incidente);
                servicioOld = em.merge(servicioOld);
            }
            if (servicioNew != null && !servicioNew.equals(servicioOld)) {
                servicioNew.getIncidentes().add(incidente);
                servicioNew = em.merge(servicioNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = incidente.getId();
                if (findIncidente(id) == null) {
                    throw new NonexistentEntityException("The incidente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Incidente incidente;
            try {
                incidente = em.getReference(Incidente.class, id);
                incidente.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The incidente with id " + id + " no longer exists.", enfe);
            }
            Cliente cliente = incidente.getCliente();
            if (cliente != null) {
                cliente.getIncidentes().remove(incidente);
                cliente = em.merge(cliente);
            }
            Tecnico tecnico = incidente.getTecnico();
            if (tecnico != null) {
                tecnico.getIncidentes().remove(incidente);
                tecnico = em.merge(tecnico);
            }
            Servicio servicio = incidente.getServicio();
            if (servicio != null) {
                servicio.getIncidentes().remove(incidente);
                servicio = em.merge(servicio);
            }
            em.remove(incidente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Incidente> findIncidenteEntities() {
        return findIncidenteEntities(true, -1, -1);
    }

    public List<Incidente> findIncidenteEntities(int maxResults, int firstResult) {
        return findIncidenteEntities(false, maxResults, firstResult);
    }

    private List<Incidente> findIncidenteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Incidente.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Incidente findIncidente(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Incidente.class, id);
        } finally {
            em.close();
        }
    }

    public int getIncidenteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Incidente> rt = cq.from(Incidente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
