/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.ArrayList;
import java.util.Date;
import models.Inregistrare;
import models.SoferiTiruri;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author Stefan
 */
public class InregistrariHibernateRepository implements InregistrariRepository{

    Session session = null;

    public InregistrariHibernateRepository() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }
    
    
    
    @Override
    public boolean adaugaInregistrare(Inregistrare inregistrare) {
        org.hibernate.Transaction tx = session.beginTransaction();

        if (inregistrare != null && inregistrare.getId() > 0) {
            session.saveOrUpdate(inregistrare);
            tx.commit();
            return true;
        }
        int id = (int) session.save(inregistrare);
        inregistrare.setId(id);
        if (id > 0) {
            tx.commit();
        } else {
            tx.rollback();
        }
        return id > 0;
    }

    @Override
    public void stergeInregistrare(Inregistrare inregistrare) {
        org.hibernate.Transaction tx = session.beginTransaction();
        session.delete(inregistrare);
        tx.commit();
    }

    @Override
    public ArrayList<Inregistrare> getAll() {
        ArrayList<Inregistrare> listaInregistrari = new ArrayList<>();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Inregistrare");
        listaInregistrari = (ArrayList<Inregistrare>) q.list();
        tx.commit();
        return listaInregistrari;
    }

    @Override
    public ArrayList<Inregistrare> getInregistrariBySoferiTiruri(SoferiTiruri soferTir) {
        ArrayList<Inregistrare> listaInregistrari = new ArrayList<>();
        org.hibernate.Transaction tx = session.beginTransaction();
        Inregistrare inregistrare = new Inregistrare();
        inregistrare.setSoferTir(soferTir);
        Query q = session.createQuery("from Inregistrare where idSoferTir = :idSoferTir").setProperties(inregistrare);
        listaInregistrari = (ArrayList<Inregistrare>) q.list();
        tx.commit();
        return listaInregistrari;
    }

    @Override
    public ArrayList<Inregistrare> getInregistrariByDataSosire(Date dataSosire) {
        ArrayList<Inregistrare> listaInregistrari = new ArrayList<>();
        org.hibernate.Transaction tx = session.beginTransaction();
        Inregistrare inregistrare = new Inregistrare();
        inregistrare.setDataSosire(dataSosire);
        Query q = session.createQuery("from Inregistrare where dataSosire = :dataSosire").setProperties(inregistrare);
        listaInregistrari = (ArrayList<Inregistrare>) q.list();
        tx.commit();
        return listaInregistrari;
    }

    @Override
    public ArrayList<Inregistrare> getInregistrareByDataPlecare(Date dataPlecare) {
        ArrayList<Inregistrare> listaInregistrari = new ArrayList<>();
        org.hibernate.Transaction tx = session.beginTransaction();
        Inregistrare inregistrare = new Inregistrare();
        inregistrare.setDataPlecare(dataPlecare);
        Query q = session.createQuery("from Inregistrare where dataPlecare = :dataPlecare").setProperties(inregistrare);
        listaInregistrari = (ArrayList<Inregistrare>) q.list();
        tx.commit();
        return listaInregistrari;
    }

    @Override
    public ArrayList<Inregistrare> getInregistrareByNoPlecare() {
        ArrayList<Inregistrare> listaInregistrari = new ArrayList<>();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Inregistrare where dataPlecare = null");
        listaInregistrari = (ArrayList<Inregistrare>) q.list();
        tx.commit();
        return listaInregistrari;
    }
    
    @Override
    public Inregistrare getInregistrareById(int id) {
        Inregistrare inregistrare = null;
        org.hibernate.Transaction tx = session.beginTransaction();
        String hql = "from Inregistrare i where i.id = :id";
        inregistrare = (Inregistrare) session.createQuery(hql).setParameter("id", id).uniqueResult();
        tx.commit();
        return inregistrare;
    }
    
    public static void main(String[] args) {
        InregistrariRepository inregistrariRepository = new InregistrariHibernateRepository();
        System.out.println(inregistrariRepository.getInregistrareByNoPlecare());
    }

    
}
