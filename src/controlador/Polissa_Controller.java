/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import modelo.*;

/**
 *
 * @author Jorge
 */
public class Polissa_Controller {

    public boolean Insertar(Polissa p) throws RollbackException {
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        System.out.println("persist");
        em.persist(p);
        etx.commit();
        System.out.println("close");
        em.close();
        return true;
    }

    public Polissa Buscar(String numero) throws NoResultException {
        //Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();
        Polissa p = null;
        System.out.println("busqueda");
        Query query = em.createNamedQuery("polissaXNumero", Polissa.class);
        query.setParameter("numero", numero);
        p = (Polissa) query.getSingleResult();
        System.out.println("close");
        em.close();
        return p;
    }
    
    
        public Polissa Buscar(Vehicle v) throws NoResultException {
        //Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();
        Polissa p = null;
        System.out.println("busqueda");
        Query query = em.createNamedQuery("polissaXVehicle", Polissa.class);
        query.setParameter("vehicle", v);
        p = (Polissa) query.getSingleResult();
        System.out.println("close");
        em.close();
        return p;
    }

    public void Modificar(Polissa p) {
        //Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(p);

        System.out.println("commit");
        //em.getTransaction().commit();
        
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public boolean Eliminar(Polissa p) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        em.remove(em.contains(p) ? p : em.merge(p));

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
        return true;
    }

    public List<Polissa> ConsultaTots() {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();
        System.out.println("Consulta");
        //List<Persona> lista = (List<Persona>) em.createQuery("FROM Persona").getResultList();
        Query q = em.createQuery("FROM Polissa");
        List<Polissa> lista = (List<Polissa>) q.getResultList();
        System.out.println("close");
        em.close();
        return lista;
    }
    
    
        public List<Polissa> ConsultaXClient(Client c) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();
        System.out.println("Consulta");
        //List<Persona> lista = (List<Persona>) em.createQuery("FROM Persona").getResultList();
        Query query = em.createNamedQuery("polissaXPrenedor", Polissa.class);
        query.setParameter("prenedor", c);
        List<Polissa> lista = (List<Polissa>) query.getResultList();
        System.out.println("close");
        em.close();
        return lista;
    }
        
        
           public List<Polissa> ConsultaXVehicle(Vehicle v) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();
        System.out.println("Consulta");
        //List<Persona> lista = (List<Persona>) em.createQuery("FROM Persona").getResultList();
        Query query = em.createNamedQuery("polissaXVehicle", Polissa.class);
        query.setParameter("vehicle", v);
        List<Polissa> lista = (List<Polissa>) query.getResultList();
        System.out.println("close");
        em.close();
        return lista;
    }

}
