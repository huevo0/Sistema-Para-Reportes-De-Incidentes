package capas.reportesincidentes.persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import capas.reportesincidentes.logica.Incidente;
import capas.reportesincidentes.logica.Servicio;
import capas.reportesincidentes.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ServicioJpaController implements Serializable {

    public ServicioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public ServicioJpaController() {
        emf = Persistence.createEntityManagerFactory("sistemariPU");
    }
    public void create(Servicio servicio) {
        if (servicio.getIncidentes() == null) {
            servicio.setIncidentes(new ArrayList<Incidente>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Incidente> attachedIncidentes = new ArrayList<Incidente>();
            for (Incidente incidentesIncidenteToAttach : servicio.getIncidentes()) {
                incidentesIncidenteToAttach = em.getReference(incidentesIncidenteToAttach.getClass(), incidentesIncidenteToAttach.getId());
                attachedIncidentes.add(incidentesIncidenteToAttach);
            }
            servicio.setIncidentes(attachedIncidentes);
            em.persist(servicio);
            for (Incidente incidentesIncidente : servicio.getIncidentes()) {
                Servicio oldServicioOfIncidentesIncidente = incidentesIncidente.getServicio();
                incidentesIncidente.setServicio(servicio);
                incidentesIncidente = em.merge(incidentesIncidente);
                if (oldServicioOfIncidentesIncidente != null) {
                    oldServicioOfIncidentesIncidente.getIncidentes().remove(incidentesIncidente);
                    oldServicioOfIncidentesIncidente = em.merge(oldServicioOfIncidentesIncidente);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Servicio servicio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Servicio persistentServicio = em.find(Servicio.class, servicio.getId());
            List<Incidente> incidentesOld = persistentServicio.getIncidentes();
            List<Incidente> incidentesNew = servicio.getIncidentes();
            List<Incidente> attachedIncidentesNew = new ArrayList<Incidente>();
            for (Incidente incidentesNewIncidenteToAttach : incidentesNew) {
                incidentesNewIncidenteToAttach = em.getReference(incidentesNewIncidenteToAttach.getClass(), incidentesNewIncidenteToAttach.getId());
                attachedIncidentesNew.add(incidentesNewIncidenteToAttach);
            }
            incidentesNew = attachedIncidentesNew;
            servicio.setIncidentes(incidentesNew);
            servicio = em.merge(servicio);
            for (Incidente incidentesOldIncidente : incidentesOld) {
                if (!incidentesNew.contains(incidentesOldIncidente)) {
                    incidentesOldIncidente.setServicio(null);
                    incidentesOldIncidente = em.merge(incidentesOldIncidente);
                }
            }
            for (Incidente incidentesNewIncidente : incidentesNew) {
                if (!incidentesOld.contains(incidentesNewIncidente)) {
                    Servicio oldServicioOfIncidentesNewIncidente = incidentesNewIncidente.getServicio();
                    incidentesNewIncidente.setServicio(servicio);
                    incidentesNewIncidente = em.merge(incidentesNewIncidente);
                    if (oldServicioOfIncidentesNewIncidente != null && !oldServicioOfIncidentesNewIncidente.equals(servicio)) {
                        oldServicioOfIncidentesNewIncidente.getIncidentes().remove(incidentesNewIncidente);
                        oldServicioOfIncidentesNewIncidente = em.merge(oldServicioOfIncidentesNewIncidente);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = servicio.getId();
                if (findServicio(id) == null) {
                    throw new NonexistentEntityException("The servicio with id " + id + " no longer exists.");
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
            Servicio servicio;
            try {
                servicio = em.getReference(Servicio.class, id);
                servicio.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The servicio with id " + id + " no longer exists.", enfe);
            }
            List<Incidente> incidentes = servicio.getIncidentes();
            for (Incidente incidentesIncidente : incidentes) {
                incidentesIncidente.setServicio(null);
                incidentesIncidente = em.merge(incidentesIncidente);
            }
            em.remove(servicio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Servicio> findServicioEntities() {
        return findServicioEntities(true, -1, -1);
    }

    public List<Servicio> findServicioEntities(int maxResults, int firstResult) {
        return findServicioEntities(false, maxResults, firstResult);
    }

    private List<Servicio> findServicioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Servicio.class));
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

    public Servicio findServicio(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Servicio.class, id);
        } finally {
            em.close();
        }
    }

    public int getServicioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Servicio> rt = cq.from(Servicio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
