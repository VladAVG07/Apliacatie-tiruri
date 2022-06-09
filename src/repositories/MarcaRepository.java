/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.ArrayList;
import models.Marca;
import models.Model;

/**
 *
 * @author Stefan
 */
public interface MarcaRepository {
    public boolean adaugaMarca(Marca marca);
    public void stergeMarca(Marca marca);
    public ArrayList<Marca> getAll();
    public ArrayList<Model> getModele(Marca marca);
    public Marca getMarcaById(int id);
}
