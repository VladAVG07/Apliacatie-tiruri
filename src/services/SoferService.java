/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import models.Sofer;

/**
 *
 * @author Stefan
 */
public interface SoferService {
    public boolean adaugaSofer(Sofer sofer);
    public void stergeSofer(Sofer sofer);
    public Sofer getSoferById(int id);
    public Sofer getSoferByCNP(String cnp);
    public ArrayList<Sofer> getAll();
}
