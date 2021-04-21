
package Controller;

import Data.PatientRowDt;
import Data.PatientDt;
import GUI.*;

import Logic.Logic;
import Model.Model;

import java.util.ArrayList;

public class Controller {
    private Model model;
    private MainGUI mainGUI;
    private DetailGUI detailGUI;
    private NewPatientGUI newPatientGUI;
    private EditGUI editGUI;
    private LoginGUI loginGUI;
    private Logic logic;

    public Controller() {
        this.model = new Model(this);
        this.logic = new Logic();
        setLoginGUIVis();
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
        return logic.getID();
    }

    public String getID(int id){
        String idText = logic.getID(id);
        return idText;
    }

    public void setNewId() {
        logic.setNewId();
    }

    public void search(String search){
        model.getResults(search);
        setMainGUIVis(model.getResults(search));
    }

    public boolean checkPW(String text){
        return logic.checkPW(text);
    }

    public ArrayList<PatientRowDt> getRows() {
        return model.getRows();
    }


}
