/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodels;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import models.Sofer;

public class TableModelSoferi extends AbstractTableModel {

    private List<Sofer> listaSoferi;
    private String[] columnNames = new String[]{"Id", "Nume", "Prenume", "Cnp", "Poza"};

    public TableModelSoferi() {
        listaSoferi=new ArrayList<>();
    }

    public TableModelSoferi(List<Sofer> listaSoferi) {
        this.listaSoferi = listaSoferi;
    }

    @Override
    public int getRowCount() {
        return listaSoferi.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sofer sofer = listaSoferi.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sofer.getId();
            case 1:
                return sofer.getNume();
            case 2:
                return sofer.getPrenume();
            case 3:
                return sofer.getCnp();
            case 4:
              //  System.out.println(sofer.getPoza().toString());
                return sofer.getPoza();
            default:
                return "Nespecificat";

        }
    }
    
    public Sofer getSoferAtIdex(int rowIndex){
        return listaSoferi.get(rowIndex);
    }

    public List<Sofer> getListaSoferi() {
        return listaSoferi;
    }
    
    public void addSofer(Sofer sofer, int index){
        if(index==-1)
            listaSoferi.add(sofer);
        else{
            listaSoferi.set(index, sofer);
        }
        fireTableDataChanged();
    }
    
    public void setListaSoferi(List<Sofer> listaSoferi) {
        this.listaSoferi = listaSoferi;
        fireTableDataChanged();
    }
    
}
