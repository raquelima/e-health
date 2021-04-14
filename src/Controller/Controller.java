
package Controller;

import Data.IdGenerator;
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
    private EditGUI editGUI;
    private IdGenerator idGenerator;
    private LoginGUI loginGUI;

    public Controller() {
        this.model = new Model(this);
        this.idGenerator = new IdGenerator();
        setLoginGUIVis();
    }

    public AbstractTableModel getModel() {
        return model.getModel();
    }

    public AbstractTableModel getModel(ArrayList<PatientRowDt> results) {
        return model.getModel(results);
    }

    public void setMainGUIVis() {
        cleanView();
        mainGUI = new MainGUI(this);
    }
    public void setMainGUIVis(ArrayList<PatientRowDt> results) {
        cleanView();
        mainGUI = new MainGUI(this, results);
    }

    public void setDetailGUIVis(int index) {
        cleanView();
        detailGUI = new DetailGUI(this, index);
    }

    public void setNewPatientGUIVis() {
        cleanView();
        newPatientGUI = new NewPatientGUI(this);
    }

    public void setEditGUIVis(int index) {
        cleanView();
        editGUI = new EditGUI(this, index);
    }

    public void setLoginGUIVis() {
        cleanView();
        loginGUI = new LoginGUI(this);
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


    private void cleanView() {

        if (detailGUI != null) {
            detailGUI.DisposeView();
        }
        if (newPatientGUI != null) {
            newPatientGUI.DisposeView();
        }
        if (editGUI != null) {
            editGUI.DisposeView();
        }
        if (mainGUI != null) {
            mainGUI.DisposeView();
        }
        if (loginGUI != null) {
            loginGUI.DisposeView();
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

    public String getID() {
        return idGenerator.getID();
    }

    public String getID(int id){
        String idText = idGenerator.getID(id);
        return idText;
    }

    public void setNewId() {
        idGenerator.setNewId();
    }

    public void search(String search){
        model.getResults(search);
        setMainGUIVis(model.getResults(search));
    }

}
