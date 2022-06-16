/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.ArrayList;
import models.Marca;
import models.Model;
import models.Tir;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author Vlad
 */

//TODO: -modificat nume metode si clasa modele
public class ModelHibernateRepository implements ModelRepository{

    Session session = null;

    public ModelHibernateRepository() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }
    
    @Override
    public boolean adaugaModel(Model model) {
        org.hibernate.Transaction tx = session.beginTransaction();
        
        if(model != null && model.getId() > 0) {
            session.saveOrUpdate(model);
            tx.commit();
            return true;
        }
        int id = (int) session.save(model);
        model.setId(id);
        if(id > 0) {
            tx.commit();
        } else {
            tx.rollback();
        }
        return id > 0;
    }

    @Override
    public void stergeModel(Model model) {
        org.hibernate.Transaction tx = session.beginTransaction();
        session.delete(model);
        tx.commit();
    }

    @Override
    public ArrayList<Model> getAll() {
        ArrayList<Model> listaModele = new ArrayList<>();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Model");
        listaModele = (ArrayList<Model>) q.list();
        tx.commit();
        return listaModele;
    }
    
    
    @Override
    public Model getModelById(int id) {
        Model model = null;
        org.hibernate.Transaction tx = session.beginTransaction();
        String hql = "from Model m where m.id = :id";
        model = (Model) session.createQuery(hql).setParameter("id", id).uniqueResult();
        tx.commit();
        return model;
    }
    
    @Override
    public ArrayList<Tir> getTiruriByModel(Model model) {
        ArrayList<Tir> listaTiruri = null;
        org.hibernate.Transaction tx = session.beginTransaction();
        String hql = "from Tiruri t where t.model=:model";
        listaTiruri = (ArrayList<Tir>) session.createQuery(hql).setParameter("model", model).list();
        tx.commit();
        return listaTiruri;
    }
    
    
    public static void main(String[] args) {
        ModelRepository modelRepository = new ModelHibernateRepository();
        Marca marca=new Marca();
        marca.setId(1);
        //modelRepository.adaugaModel(new Model(marca, "C-CLASS"));
//        System.out.println(modelRepository.getAll());
//          System.out.println(modelRepository.getModelById(4).getTiruris());
    }    
}
