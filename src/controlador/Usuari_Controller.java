/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.SQLIntegrityConstraintViolationException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import modelo.Usuari;

/**
 *
 * @author Jorge
 */
public class Usuari_Controller {

    public boolean Insertar(Usuari u) throws RollbackException{
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        System.out.println("persist");
        em.persist(u);
        etx.commit();
        System.out.println("close");
        em.close();
        return true;
    }

    public Usuari Buscar(String nom) throws NoResultException{
        //Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();
        Usuari u = null;
        System.out.println("busqueda");
        Query query = em.createNamedQuery("userPerNom", Usuari.class);
        query.setParameter("nom", nom);
        u = (Usuari) query.getSingleResult();
        System.out.println("close");
        em.close();
        return u;
    }

}
