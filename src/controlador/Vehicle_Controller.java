/*
 * Author Roger G. Coscojuela
 */
package controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import modelo.Client;
import modelo.Polissa;
import modelo.Vehicle;

/**
 *
 * @author Roger G. Coscojuela
 */
public class Vehicle_Controller {

    public void Insertar(Vehicle c) throws PersistenceException {

        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();
        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(c);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public void Modificar(Vehicle c) {
        //Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(c);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public boolean Eliminar(Vehicle c) {
        // Recupera el entity manager
        Polissa_Controller pc = new Polissa_Controller();
        
        //Polissa[] polisses = pc.
        
        
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        em.remove(em.contains(c) ? c : em.merge(c));

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
        return true;
    }
//

    public Vehicle Buscar(String matricula) throws javax.persistence.NoResultException {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();
        System.out.println("busqueda");
        Query query = em.createNamedQuery("VehicleMatricula", Vehicle.class);
        query.setParameter("matricula", matricula);
        Vehicle c = (Vehicle) query.getSingleResult();
        System.out.println("close");
        //em.close();

        return c;
    }

    public List<Vehicle> ConsultaTots() {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("Consulta");
        //List<Persona> lista = (List<Persona>) em.createQuery("FROM Persona").getResultList();
        Query q = em.createQuery("FROM Vehicle");
        List<Vehicle> lista = (List<Vehicle>) q.getResultList();
        System.out.println("close");
        em.close();
        return lista;
    }
    
    
    public List<Vehicle> ConsultaXClient(Client c) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();
        System.out.println("Consulta");
        //List<Persona> lista = (List<Persona>) em.createQuery("FROM Persona").getResultList();
        Query query = em.createNamedQuery("vehiclesXClient", Vehicle.class);
        query.setParameter("propietari", c);
        List<Vehicle> lista = (List<Vehicle>) query.getResultList();
        System.out.println("close");
        em.close();
        return lista;
    }
}
