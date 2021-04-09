package Model;

import Controller.Controller;
import Data.PatientDt;
import Data.PatientRowDt;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class Model {

    private ArrayList<PatientDt> patients = new ArrayList<>();

    private ArrayList<PatientRowDt> rows = new ArrayList<>();

    private Controller controller;


    public void newPatient(PatientDt patient, PatientRowDt row) {
        patients.add(patient);
        rows.add(row);
    }

    public Model(Controller controller) {
        this.controller = controller;
    }

    public void deletePatient(int length){
        controller.setNewId();
        rows.remove(length);
        patients.remove(length);
        for (PatientDt d: patients) {
            int id = Integer.parseInt(d.getPatientID());
            if (id > length){
                id--;
                d.setPatientID(controller.getID(id));
            }

        }
        for (PatientRowDt d: rows) {
            int id = Integer.parseInt(d.getPatientID());
            if (id > length){
                id--;
                d.setPatientID(controller.getID(id));
            }

        }
    }

    public void deleteAllPatients(){
        rows.clear();
        patients.clear();
    }

    public ArrayList<PatientRowDt> getAllRows(){
        return rows;
    }

    public PatientDt getPatientDetails(int index){
        return patients.get(index);
    }

    public PatientRowDt getRowDetails(int index){
        return rows.get(index);
    }

    public AbstractTableModel getModel() {

        String[] reihen = new String[]{"Patient ID", "Nachname", "Vorname", "Geschlecht", "DOB", "Details", "Edit", "Delete"};

        return new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return rows.size();
            }

            @Override
            public int getColumnCount() {
                return reihen.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return rows.get(rowIndex).getAsArray()[columnIndex];
            }

            public String getColumnName(int column) {
                return reihen[column];
            }
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }


        };
    }



}