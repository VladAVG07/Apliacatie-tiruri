/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.ArrayList;
import models.Marca;
import models.Stare;
import models.Tir;

/**
 *
 * @author Stefan
 */
public interface TiruriRepository {
    public boolean adaugaTir(Tir tir);
    public void stergeTir(Tir tir);
    public ArrayList<Tir> getAll();
    public ArrayList<Tir> getTiruriByStare(Stare stare);
    public Tir getTirByNumarInmatriculare(String nrInmatriculare);
    public Tir getTirById(int id);
}
