package Model;

import Controller.Controller;
import Data.PatientDt;
import Data.PatientRowDt;

import java.util.ArrayList;

public class Model {

    private ArrayList<PatientDt> patients = new ArrayList<>();

    private ArrayList<PatientRowDt> rows = new ArrayList<>();
    private ArrayList<PatientRowDt> results;


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

    public ArrayList<PatientRowDt> getRows() {
        return rows;
    }

    public ArrayList<PatientRowDt> getResults() {
        return results;
    }

    public ArrayList<PatientRowDt> getResults(String search){
        results = new ArrayList<>();
        for (PatientRowDt d: rows) {
            if (d.getPatientID().equals(search)|| d.getNachname().equals(search) || d.getVorname().equals(search) || d.getGeschlecht().equals(search) || d.getDob().equals(search)){
                results.add(d);
            }

        }
        return results;
    }


}