package GUI;

import Controller.Controller;
import Data.PatientDt;
import Data.PatientRowDt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;

public class EditGUI extends GUI{
    private JPanel formular = new JPanel();
    private JPanel titlePanel = new JPanel();
    private JPanel buttonsPanel = new JPanel();

    private Controller controller;

    private JLabel label;
    private JLabel newPatient = new JLabel("New Patient");

    private JTextField patientIdF = new JTextField("");
    private JTextField nachnameF = new JTextField("");
    private JTextField vornameF = new JTextField("");
    private String[] geschlechtOptions = {"weiblich", "männlich", "anderes"};
    private JComboBox geschlechtF = new JComboBox(geschlechtOptions);

    //Field with date format
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/uu");
    DateField dateField = new DateField(dateFormatter);

    private NumberFormat format = new DecimalFormat();
    private JFormattedTextField groesseF = new JFormattedTextField(format);
    private JFormattedTextField gewichtF = new JFormattedTextField(format);
    private JTextField wohnortF = new JTextField("");
    private JTextField infosF = new JTextField("");
    private JTextField medikamenteF = new JTextField("");
    private String[] statusOptions = {"waiting", "in treatment", "treated"};
    private JComboBox statusF = new JComboBox(statusOptions);
    private String[] drOptions = {"Dr. Raquel Lima", "Dr. Elias Mattern", "Dr. Gabriel Nadolny", "Dr. drake ramoray", "Dr. Meredith Grey", "Dr Painus Gregerus"};
    private JComboBox drF = new JComboBox(drOptions);
    private JTextField vorerkrankungenF = new JTextField("");

    private JButton back = new JButton("Back to list");
    private JButton save = new JButton("Save");

    public EditGUI(Controller controller, int index) {
        super("Edit Patient", 870, 856);
        this.controller = controller;

        addElements(index);

        //Window Settings
        setVisible(true);
    }

    private void addElements(int index){
        // Layout
        setLayout(new BorderLayout());
        formular.setLayout(new GridLayout(13,2,5,10));
        titlePanel.setLayout(new BorderLayout());
        buttonsPanel.setLayout(new GridLayout(1,2));
        add(formular, BorderLayout.CENTER);
        add(titlePanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.SOUTH);

        // Elements
        PatientDt patient = controller.getPatientDetails(index);
        PatientRowDt row = controller.getRowDetails(index);

        titlePanel.add(newPatient);
        newPatient.setText(patient.getVorname() + " " + patient.getNachname());
        formular.add(getLabel("Patient ID::"));
        formular.add(patientIdF);
        patientIdF.setText(patient.getPatientID());
        patientIdF.setEditable(false);
        formular.add(getLabel("Nachname:"));
        formular.add(nachnameF);
        nachnameF.setText(patient.getNachname());
        formular.add(getLabel("Vorname:"));
        formular.add(vornameF);
        vornameF.setText(patient.getVorname());
        formular.add(getLabel("Geschlecht:"));
        formular.add(geschlechtF);
        geschlechtF.setSelectedItem(patient.getGeschlecht());
        formular.add(getLabel("DOB:"));
        formular.add(dateField);
        dateField.setText(patient.getDob());
        formular.add(getLabel("Status:"));
        formular.add(statusF);
        statusF.setSelectedItem(patient.getStatus());
        formular.add(getLabel("Grösse:"));
        formular.add(groesseF);
        groesseF.setText(String.valueOf(patient.getGroesse()));
        formular.add(getLabel("Gewicht:"));
        formular.add(gewichtF);
        gewichtF.setText(String.valueOf(patient.getGewicht()));
        formular.add(getLabel("Wohnort:"));
        formular.add(wohnortF);
        wohnortF.setText(patient.getWohnort());
        formular.add(getLabel("Infos:"));
        formular.add(infosF);
        infosF.setText(patient.getInfos());
        formular.add(getLabel("Medikamente:"));
        formular.add(medikamenteF);
        medikamenteF.setText(patient.getMedikamente());
        formular.add(getLabel("Arzt:"));
        formular.add(drF);
        drF.setSelectedItem(patient.getArzt());
        formular.add(getLabel("Vorerkrankungen:"));
        formular.add(vorerkrankungenF);
        vorerkrankungenF.setText(patient.getVorerkrankungen());

        buttonsPanel.add(back);
        buttonsPanel.add(save);

        // Design
        newPatient.setFont(new Font("",Font.PLAIN,30));



        // Borders
        formular.setBorder(BorderFactory.createEmptyBorder(10,40,15,40));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20,40,10,40));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(0,40,20,40));

        //Button
        back.addActionListener(e -> {
            this.dispose();
            controller.setMainGUIVis();
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                patient.setNachname(nachnameF.getText());
                row.setNachname(nachnameF.getText());
                patient.setVorname(vornameF.getText());
                row.setVorname(vornameF.getText());
                patient.setGeschlecht((String) geschlechtF.getSelectedItem());
                row.setGeschlecht((String) geschlechtF.getSelectedItem());
                patient.setDob(dateField.getText());
                row.setDob(dateField.getText());
                patient.setStatus((String) statusF.getSelectedItem());
                patient.setGroesse(Double.parseDouble(groesseF.getText()));
                patient.setGewicht(Double.parseDouble(gewichtF.getText()));
                patient.setWohnort(wohnortF.getText());
                patient.setInfos(infosF.getText());
                patient.setMedikamente(medikamenteF.getText());
                patient.setArzt((String)drF.getSelectedItem());
                patient.setVorerkrankungen(vorerkrankungenF.getText());

                controller.setMainGUIVis();
            }
        });
    }
    private JLabel getLabel(String name){
        label = new JLabel(name);
        label.setBackground(new Color(161, 194, 206));
        label.setBorder(BorderFactory.createLineBorder(new Color(135, 176, 192)));
        label.setForeground(Color.white);
        label.setFont(new Font("", Font.BOLD,14));
        label.setOpaque(true);
        return label;
    }
    public void DisposeView() {
        this.dispose();
    }


}
