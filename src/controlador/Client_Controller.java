/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import modelo.Client;


/**
 *
 * @author Jorge
 */
public class Client_Controller {

    public void Insertar(Client c) throws PersistenceException {
      
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

    public void Modificar(Client c) {
         //Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(c);

        System.out.println("commit");
        em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public boolean Eliminar(Client c) {
        // Recupera el entity manager
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
    public Client Buscar(String nif) throws javax.persistence.NoResultException{
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();
        System.out.println("busqueda");
        Query query = em.createNamedQuery("ClientNif",Client.class);
        query.setParameter("nif", nif);
        Client c = (Client) query.getSingleResult();
        System.out.println("close");
        em.close();

        return c;
    }
    
        public List<Client> ConsultaTots() {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("Consulta");
        //List<Persona> lista = (List<Persona>) em.createQuery("FROM Persona").getResultList();
        Query q = em.createQuery("FROM Client");
        List<Client> lista = (List<Client>) q.getResultList();
        System.out.println("close");
        em.close();
        return lista;
    }
//
//    public void Consulta() {
//        // Recupera el entity manager
//        EntityManager em = new EM_Controller().getEntityManager();
//
//        System.out.println("Consulta");
//        //List<Persona> lista = (List<Persona>) em.createQuery("FROM Persona").getResultList();
//        Query q = em.createQuery("FROM Persona");
//        List<Persona> lista = (List<Persona>) q.getResultList();
//        imprimirLista(lista);
//
//        System.out.println("close");
//        em.close();
//    }
//
//    public void imprimirLista(List<Persona> lista) {
//        System.out.println("Numero d'empleats= " + lista.size());
//        for (int i = 0; i < lista.size(); i++) {
//            System.out.println(lista.get(i));
//        }
//    }
//
//    public void imprimirPersona(Persona p) {
//        System.out.println(p);
//    }

}
