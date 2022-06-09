/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.ArrayList;
import models.Marca;
import models.Model;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author Stefan
 */
public class MarcaHibernateRepository implements MarcaRepository {

    Session session = null;

    public MarcaHibernateRepository() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public boolean adaugaMarca(Marca marca) {
        org.hibernate.Transaction tx = session.beginTransaction();

        if (marca != null && marca.getId() > 0) {
            session.saveOrUpdate(marca);
            tx.commit();
            return true;
        }
        int id = (int) session.save(marca);
        marca.setId(id);
        if (id > 0) {
            tx.commit();
        } else {
            tx.rollback();
        }
        return id > 0;
    }

    @Override
    public void stergeMarca(Marca marca) {
        org.hibernate.Transaction tx = session.beginTransaction();
        session.delete(marca);
        tx.commit();
    }

    @Override
    public ArrayList<Marca> getAll() {
        ArrayList<Marca> listaMarci = new ArrayList<>();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Marca");
        listaMarci = (ArrayList<Marca>) q.list();
        tx.commit();
        return listaMarci;
    }

    @Override
    public ArrayList<Model> getModele(Marca marca) {
        ArrayList<Model> listaModele = null;
        org.hibernate.Transaction tx = session.beginTransaction();
        String hql = "from Modele m where m.marca=:marca";
        listaModele = (ArrayList<Model>) session.createQuery(hql).setParameter("marca", marca).list();
        tx.commit();
        return listaModele;
    }

    @Override
    public Marca getMarcaById(int id) {
        Marca marca = null;
        org.hibernate.Transaction tx = session.beginTransaction();
        String hql = "from Marca m where m.id=:id";
        marca = (Marca) session.createQuery(hql)
                .setParameter("id", id).uniqueResult();
        tx.commit();
        return marca;
    }

    public static void main(String[] args) {
        MarcaRepository marcaRepository = new MarcaHibernateRepository();
        //System.out.println(marcaRepository.getMarcaById(1).getModele());
        Marca marca = new Marca();
        marca.setId(1);
        System.out.println(marcaRepository.getModele(marca));
    }
}
