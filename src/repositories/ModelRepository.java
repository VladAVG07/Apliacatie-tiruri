/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.ArrayList;
import models.Model;
import models.Tir;

/**
 *
 * @author Vlad
 */
public interface ModelRepository {
    public boolean adaugaModel(Model model);
    public void stergeModel(Model model);
    public ArrayList<Model> getAll();
    public ArrayList<Tir> getTiruriByModel(Model model);
    public Model getModelById(int id);
}
