/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import utils.HibernateUtil;
import java.util.ArrayList;
import models.Sofer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Stefan
 */
public class SoferiHibernateRepository implements SoferiRepository {

    Session session = null;

    public SoferiHibernateRepository() {
        if (session == null || !session.isOpen()) {
            this.session = HibernateUtil.getSessionFactory().openSession();
        }
    }

    @Override
    public boolean adaugaSofer(Sofer sofer) {
        session.clear();
        org.hibernate.Transaction tx = session.beginTransaction();

        if (sofer != null && sofer.getId() > 0) {
            session.saveOrUpdate(sofer);
            tx.commit();
            session.clear();
            return true;
        }
        int id = (int) session.save(sofer);
        sofer.setId(id);
        if (id > 0) {
            tx.commit();
        } else {
            tx.rollback();
        }
        session.clear();
        return id > 0;
    }

    @Override
    public void stergeSofer(Sofer sofer) {
        org.hibernate.Transaction tx = session.beginTransaction();
        session.delete(sofer);
        tx.commit();
    }

    @Override
    public ArrayList<Sofer> getAll() {
        ArrayList<Sofer> listaSoferi = new ArrayList<>();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Sofer");
        listaSoferi = (ArrayList<Sofer>) q.list();
        tx.commit();
        session.clear();
        return listaSoferi;
    }

    @Override
    public Sofer getSoferById(int id) {
        Sofer sofer = null;
        org.hibernate.Transaction tx = session.beginTransaction();
        String hql = "from Sofer s where s.id = :id";
        sofer = (Sofer) session.createQuery(hql).setParameter("id", id).uniqueResult();
        tx.commit();
        session.clear();
        return sofer;
    }

    @Override
    public Sofer getSoferByCNP(String cnp) {
        Sofer sofer = null;
        org.hibernate.Transaction tx = session.beginTransaction();
        String hql = "from Sofer s where s.cnp = :cnp";
        sofer = (Sofer) session.createQuery(hql).setParameter("cnp", cnp).uniqueResult();
        tx.commit();
        return sofer;
    }

    public static void main(String[] args) {
        SoferiRepository soferiRepository = new SoferiHibernateRepository();
        System.out.println(soferiRepository.getSoferById(1));
        System.out.println(soferiRepository.getSoferByCNP("5050307510019"));
//        System.out.println(soferiRepository.getAll());
    }
}
