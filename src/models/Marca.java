package models;
// Generated May 12, 2022 5:57:09 PM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;




/**
 * Marca generated by hbm2java
 */
public class Marca  implements java.io.Serializable {


     private int id;
     private String nume;
     private int activa;
     private ArrayList<Model> listaModele;
    // private Set<Tir> tiruri = new HashSet<Tir>(0);
     private Set<Model> modele=new HashSet<>(0);
    public Marca() {
    }

    public Marca(int id, String nume) {
        this.id = id;
        this.nume = nume;
    }
    
    public Marca(int id, String nume, int activa) {
       this.id = id;
       this.nume = nume;
       this.activa = activa;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getNume() {
        return this.nume;
    }
    
    public void setNume(String nume) {
        this.nume = nume;
    }
    public int getActiva() {
        return this.activa;
    }
    
    public void setActiva(int activa) {
        this.activa = activa;
    }

//    public Set<Tir> getTiruri() {
//        return tiruri;
//    }
//
//    public void setTiruri(Set<Tir> tiruri) {
//        this.tiruri = tiruri;
//    }

    public ArrayList<Model> getListaModele() {
        return listaModele;
    }

    public void setListaModele(ArrayList<Model> listaModele) {
        this.listaModele = listaModele;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Marca other = (Marca) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void setModele(Set<Model> modele) {
        this.modele = modele;
    }

    public Set<Model> getModele() {
        return modele;
    }
    
    

    @Override
    public String toString() {
        return "Marca{" + "id=" + id + ", nume=" + nume + ", activa=" + activa + '}';
    }

}


