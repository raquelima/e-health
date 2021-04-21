package GUI;

import Controller.Controller;
import Data.PatientDt;

import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;

public class DetailGUI extends GUI{
	private JPanel formular = new JPanel();
	private JPanel titlePanel = new JPanel();
	private JPanel buttonsPanel = new JPanel();

	private Controller controller;

	private JLabel label;
	private JLabel newPatient = new JLabel("New Patient");

	private JTextField patientIdF = new JTextField("");
	private JTextField nachnameF = new JTextField("");
	private JTextField vornameF = new JTextField("");
	private JTextField geschlechtF = new JTextField("");

	//Field with date format
	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/uu");
	DateField dateField = new DateField(dateFormatter);

	private JTextField groesseF = new JTextField("");
	private JTextField gewichtF = new JTextField("");
	private JTextField wohnortF = new JTextField("");
	private JTextField infosF = new JTextField("");
	private JTextField medikamenteF = new JTextField("");
	private JTextField statusF = new JTextField("");
	private JTextField arztF = new JTextField("");
	private JTextField vorerkrankungenF = new JTextField("");

	private JButton back = new JButton("Back to list");
	private JButton edit = new JButton("Edit");

	public DetailGUI(Controller controller, int index) {
		super("Patient Details", 870, 856);
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

		titlePanel.add(newPatient);
		newPatient.setText(patient.getNachname());
		formular.add(getLabel("Patient ID::"));
		formular.add(patientIdF);
		patientIdF.setText(patient.getPatientID());
		patientIdF.setEditable(false);
		formular.add(getLabel("Nachname:"));
		formular.add(nachnameF);
		nachnameF.setText(patient.getNachname());
		nachnameF.setEditable(false);
		formular.add(getLabel("Vorname:"));
		formular.add(vornameF);
		vornameF.setText(patient.getVorname());
		vornameF.setEditable(false);
		formular.add(getLabel("Geschlecht:"));
		formular.add(geschlechtF);
		geschlechtF.setText(patient.getGeschlecht());
		geschlechtF.setEditable(false);
		formular.add(getLabel("DOB:"));
		formular.add(dateField);
		dateField.setText(patient.getDob());
		dateField.setEditable(false);
		formular.add(getLabel("Status:"));
		formular.add(statusF);
		statusF.setText(patient.getStatus());
		statusF.setEditable(false);
		formular.add(getLabel("Grösse:"));
		formular.add(groesseF);
		groesseF.setText(String.valueOf(patient.getGroesse()));
		groesseF.setEditable(false);
		formular.add(getLabel("Gewicht:"));
		formular.add(gewichtF);
		gewichtF.setText(String.valueOf(patient.getGewicht()));
		gewichtF.setEditable(false);
		formular.add(getLabel("Wohnort:"));
		formular.add(wohnortF);
		wohnortF.setText(patient.getWohnort());
		wohnortF.setEditable(false);
		formular.add(getLabel("Infos:"));
		formular.add(infosF);
		infosF.setText(patient.getInfos());
		infosF.setEditable(false);
		formular.add(getLabel("Medikamente:"));
		formular.add(medikamenteF);
		medikamenteF.setText(patient.getMedikamente());
		medikamenteF.setEditable(false);
		formular.add(getLabel("Arzt:"));
		formular.add(arztF);
		arztF.setText(patient.getArzt());
		arztF.setEditable(false);
		formular.add(getLabel("Vorerkrankungen:"));
		formular.add(vorerkrankungenF);
		vorerkrankungenF.setText(patient.getVorerkrankungen());
		vorerkrankungenF.setEditable(false);

		buttonsPanel.add(back);
		buttonsPanel.add(edit);

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
		edit.addActionListener(e -> controller.setEditGUIVis(index));
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