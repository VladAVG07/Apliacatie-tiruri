/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import models.Model;
import models.Tir;
import repositories.ModelHibernateRepository;
import repositories.ModelRepository;

/**
 *
 * @author Vlad
 */
public class ModelServiceImpl implements ModelService{
    
    private final ModelRepository modelRepository = new ModelHibernateRepository();

    @Override
    public boolean adaugaModel(Model model) {
       return modelRepository.adaugaModel(model);
    }

    @Override
    public void stergeModel(Model model) {
        modelRepository.stergeModel(model);
    }

    @Override
    public ArrayList<Model> getAll() {
        return modelRepository.getAll();
    }

    @Override
    public ArrayList<Tir> getTiruriByModel(Model model) {
        return modelRepository.getTiruriByModel(model);
    }

    @Override
    public Model getModelById(int id) {
        return modelRepository.getModelById(id);
    }
    
}
