
package Controller;

import Data.PatientRowDt;
import Data.PatientDt;
import GUI.*;

import Model.Model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class Controller {
    private Model model;
    private MainGUI mainGUI;
    private DetailGUI detailGUI;
    private NewPatientGUI newPatientGUI;



    public Controller() {
        this.model = new Model();
        setMainGUIVis();
    }

    public AbstractTableModel getModel() {
        return model.getModel();
    }

    public void setMainGUIVis() {
        cleanMainView();
        mainGUI = new MainGUI(this);
    }

    public void setDetailGUIVis(int index) {
        cleanMainView();
        detailGUI = new DetailGUI(this, index);
    }

    public void setNewPatientGUIVis() {
        cleanMainView();
        newPatientGUI = new NewPatientGUI(this);
    }

    public void deletePatient(int length){
        model.deletePatient(length);
    }

    public void deleteAllPatients(){
        model.deleteAllPatients();
    }

    public ArrayList<PatientRowDt> getAllRows(){
        return model.getAllRows();
    }


    private void cleanMainView() {

        if (detailGUI != null) {
            detailGUI.DisposeView();
        }
        if (newPatientGUI != null) {
            newPatientGUI.DisposeView();
        }

    }

    public void newPatient(PatientDt patient,PatientRowDt row){
        model.newPatient(patient, row);
    }

    public PatientDt getPatientDetails(int index){
        return model.getPatientDetails(index);
    }

    public PatientRowDt getRowDetails(int index){
        return model.getRowDetails(index);
    }


}
