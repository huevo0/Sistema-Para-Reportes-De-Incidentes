package capas.reportesincidentes.persistencia;

import capas.reportesincidentes.logica.Cliente;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import capas.reportesincidentes.logica.Incidente;
import capas.reportesincidentes.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ClienteJpaController implements Serializable {

    public ClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public ClienteJpaController() {
        emf = Persistence.createEntityManagerFactory("sistemariPU");
    }
    public void create(Cliente cliente) {
        if (cliente.getIncidentes() == null) {
            cliente.setIncidentes(new ArrayList<Incidente>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Incidente> attachedIncidentes = new ArrayList<Incidente>();
            for (Incidente incidentesIncidenteToAttach : cliente.getIncidentes()) {
                incidentesIncidenteToAttach = em.getReference(incidentesIncidenteToAttach.getClass(), incidentesIncidenteToAttach.getId());
                attachedIncidentes.add(incidentesIncidenteToAttach);
            }
            cliente.setIncidentes(attachedIncidentes);
            em.persist(cliente);
            for (Incidente incidentesIncidente : cliente.getIncidentes()) {
                Cliente oldClienteOfIncidentesIncidente = incidentesIncidente.getCliente();
                incidentesIncidente.setCliente(cliente);
                incidentesIncidente = em.merge(incidentesIncidente);
                if (oldClienteOfIncidentesIncidente != null) {
                    oldClienteOfIncidentesIncidente.getIncidentes().remove(incidentesIncidente);
                    oldClienteOfIncidentesIncidente = em.merge(oldClienteOfIncidentesIncidente);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cliente cliente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente persistentCliente = em.find(Cliente.class, cliente.getId());
            List<Incidente> incidentesOld = persistentCliente.getIncidentes();
            List<Incidente> incidentesNew = cliente.getIncidentes();
            List<Incidente> attachedIncidentesNew = new ArrayList<Incidente>();
            for (Incidente incidentesNewIncidenteToAttach : incidentesNew) {
                incidentesNewIncidenteToAttach = em.getReference(incidentesNewIncidenteToAttach.getClass(), incidentesNewIncidenteToAttach.getId());
                attachedIncidentesNew.add(incidentesNewIncidenteToAttach);
            }
            incidentesNew = attachedIncidentesNew;
            cliente.setIncidentes(incidentesNew);
            cliente = em.merge(cliente);
            for (Incidente incidentesOldIncidente : incidentesOld) {
                if (!incidentesNew.contains(incidentesOldIncidente)) {
                    incidentesOldIncidente.setCliente(null);
                    incidentesOldIncidente = em.merge(incidentesOldIncidente);
                }
            }
            for (Incidente incidentesNewIncidente : incidentesNew) {
                if (!incidentesOld.contains(incidentesNewIncidente)) {
                    Cliente oldClienteOfIncidentesNewIncidente = incidentesNewIncidente.getCliente();
                    incidentesNewIncidente.setCliente(cliente);
                    incidentesNewIncidente = em.merge(incidentesNewIncidente);
                    if (oldClienteOfIncidentesNewIncidente != null && !oldClienteOfIncidentesNewIncidente.equals(cliente)) {
                        oldClienteOfIncidentesNewIncidente.getIncidentes().remove(incidentesNewIncidente);
                        oldClienteOfIncidentesNewIncidente = em.merge(oldClienteOfIncidentesNewIncidente);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = cliente.getId();
                if (findCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
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
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }
            List<Incidente> incidentes = cliente.getIncidentes();
            for (Incidente incidentesIncidente : incidentes) {
                incidentesIncidente.setCliente(null);
                incidentesIncidente = em.merge(incidentesIncidente);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
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

    public Cliente findCliente(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
