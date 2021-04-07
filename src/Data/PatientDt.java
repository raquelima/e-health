package Data;

import javax.swing.*;

public class PatientDt {
    private String patientID;
    private String nachname;
    private String vorname;
    private String geschlecht;
    private String dob;
    private double groesse;
    private String wohnort;
    private String infos;
    private String medikamente;
    private boolean status;
    private String arzt;
    private String vorerkrankungen;

    public PatientDt(String patientID, String nachname, String vorname, String geschlecht, String dob, double groesse, String wohnort, String infos, String medikamente, boolean status, String arzt, String vorerkrankungen) {
        this.patientID = patientID;
        this.nachname = nachname;
        this.vorname = vorname;
        this.geschlecht = geschlecht;
        this.groesse = groesse;
        this.wohnort = wohnort;
        this.infos = infos;
        this.medikamente = medikamente;
        this.status = status;
        this.arzt = arzt;
        this.vorerkrankungen = vorerkrankungen;
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

    public void setVorname(String vorname) {
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

    public double getGroesse() {
        return groesse;
    }

    public void setGroesse(double groesse) {
        this.groesse = groesse;
    }

    public String getWohnort() {
        return wohnort;
    }

    public void setWohnort(String wohnort) {
        this.wohnort = wohnort;
    }

    public String getInfos() {
        return infos;
    }

    public void setInfos(String infos) {
        this.infos = infos;
    }

    public String getMedikamente() {
        return medikamente;
    }

    public void setMedikamente(String medikamente) {
        this.medikamente = medikamente;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getArzt() {
        return arzt;
    }

    public void setArzt(String arzt) {
        this.arzt = arzt;
    }

    public String getVorerkrankungen() {
        return vorerkrankungen;
    }

    public void setVorerkrankungen(String vorerkrankungen) {
        this.vorerkrankungen = vorerkrankungen;
    }
}