/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.ArrayList;
import models.Marca;
import models.Model;
import models.Stare;
import models.Tir;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author Stefan
 */
public class TiruriHibernateRepository implements TiruriRepository {

    Session session = null;

    public TiruriHibernateRepository() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }
    
    
    
    @Override
    public boolean adaugaTir(Tir tir) {
        org.hibernate.Transaction tx = session.beginTransaction();
       
        if (tir!=null && tir.getId()>0){
            session.saveOrUpdate(tir);
            tx.commit();
            return true;
        }
        int id = (int) session.save(tir);
        tir.setId(id);
        if (id > 0) {
            tx.commit();
        } else {
            tx.rollback();
        }
        return id > 0; 
    }

    @Override
    public void stergeTir(Tir tir) {
        org.hibernate.Transaction tx = session.beginTransaction();
        session.delete(tir);
        tx.commit();
    }

    @Override
    public ArrayList<Tir> getAll() {
        ArrayList<Tir> listaTiruri = new ArrayList<>();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Tir");
        listaTiruri = (ArrayList<Tir>) q.list();
        tx.commit();
        return listaTiruri;
    }

    

    @Override
    public ArrayList<Tir> getTiruriByStare(Stare stare) {
        ArrayList<Tir> listaTiruri = new ArrayList<>();
        org.hibernate.Transaction tx = session.beginTransaction();
        Tir t = new Tir();
        t.setStare(stare);
        Query q = session.createQuery("from Tir where stare= :stare").setProperties(t);
        listaTiruri = (ArrayList<Tir>) q.list();
        tx.commit();
        return listaTiruri;
    }

    @Override
    public Tir getTirByNumarInmatriculare(String nrInmatriculare) {
        org.hibernate.Transaction tx = session.beginTransaction();
        Tir tir = null;
        String hql = "from Tir t where t.nrInmatriculare = :nrInmatriculare";
        tir = (Tir) session.createQuery(hql).setParameter("nrInmatriculare", nrInmatriculare).uniqueResult();
        tx.commit();
        return tir;
    }
    
    @Override
    public Tir getTirById(int id) {
       Tir tir = null;
       org.hibernate.Transaction tx = session.beginTransaction();
       String hql = "from Tir t where t.id = :id";
       tir = (Tir) session.createQuery(hql).setParameter("id", id).uniqueResult();
       tx.commit();
       return tir;
    }
    
    public static void main(String[] args) {
        TiruriRepository tiruriRepository = new TiruriHibernateRepository();
        Model m = new Model();
        m.setId(4);
        Stare s = new Stare();
        s.setId(2);
        tiruriRepository.adaugaTir(new Tir(m, "CL24DFL", s));
        System.out.println(tiruriRepository.getAll());
    }
    
}
