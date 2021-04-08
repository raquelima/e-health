package Data;

import javax.swing.*;

public class PatientRowDt {
    private String patientID;
    private String nachname;
    private String vorname;
    private String geschlecht;
    private String dob;
    private JButton edit;
    private JButton details;
    private JButton delete;

    public PatientRowDt(String patientID, String nachname, String vorname, String geschlecht, String dob, JButton edit, JButton details, JButton delete) {
        this.patientID = patientID;
        this.nachname = nachname;
        this.vorname = vorname;
        this.geschlecht = geschlecht;
        this.dob = dob;
        this.edit = edit;
        this.details = details;
        this.delete = delete;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String patientID) {
        this.vorname = vorname;
    }

    public String getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }


    public JButton getDelete() {
        return delete;
    }

    public void setDelete(JButton delete) {
        this.delete = delete;
    }

    public JButton getEdit() {
        return edit;
    }

    public void setEdit(JButton edit) {
        this.edit = edit;
    }

    public JButton getDetails() {
        return details;
    }

    public void setDetails(JButton details) {
        this.details = details;
    }

    public Object[] getAsArray(){
        return new Object[]{getPatientID(),getNachname(), getVorname(),getGeschlecht(),getDob(),getEdit(),getDetails(),getDelete()};
    }
}
