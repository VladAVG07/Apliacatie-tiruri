/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import models.Marca;
import models.Model;
import repositories.MarcaHibernateRepository;
import repositories.MarcaRepository;

/**
 *
 * @author Stefan
 */
public class MarcaServiceImpl implements MarcaService {

    private final MarcaRepository marcaRepository = new MarcaHibernateRepository();
    
    @Override
    public boolean adaugaMarca(Marca marca) {
        return marcaRepository.adaugaMarca(marca);
    }

    @Override
    public void stergeMarca(Marca marca) {
        marcaRepository.stergeMarca(marca);
    }

    @Override
    public ArrayList<Marca> getAll() {
        return marcaRepository.getAll();
    }

    @Override
    public ArrayList<Model> getModele(Marca marca) {
        return marcaRepository.getModele(marca);
    }

    @Override
    public Marca getMarcaById(int id) {
        return marcaRepository.getMarcaById(id);
    }
    
}
