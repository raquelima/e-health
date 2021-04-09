package GUI;

import Controller.Controller;
import Data.PatientDt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

public class DetailGUI extends JFrame implements ActionListener {
	private JFrame frame = new JFrame();
	private JPanel formular = new JPanel();
	private JPanel titlePanel = new JPanel();
	private JPanel buttonsPanel = new JPanel();

	private Controller controller;

	private JLabel newPatient = new JLabel("New Patient");
	private JLabel patientID = new JLabel("Patient ID:");
	private JLabel nachname = new JLabel("Nachname:", JLabel.LEFT);
	private JLabel vorname = new JLabel("Vorname:");
	private JLabel geschlecht = new JLabel("Geschlecht:");
	private JLabel dob = new JLabel("DOB:");
	private JLabel alter = new JLabel("Alter:");
	private JLabel groesse = new JLabel("Grösse:");
	private JLabel gewicht = new JLabel("Gewicht:");
	private JLabel wohnort = new JLabel("Wohnort:");
	private JLabel infos = new JLabel("Infos:");
	private JLabel medikamente = new JLabel("Medikamente:");
	private JLabel status = new JLabel("Status:");
	private JLabel arzt = new JLabel("Arzt:");
	private JLabel vorerkrankungen = new JLabel("Vorerkrankungen:");

	private JTextField patientIdF = new JTextField("");
	private JTextField nachnameF = new JTextField("");
	private JTextField vornameF = new JTextField("");
	private String[] geschlechtOptions = {"weiblich", "männlich", "anderes"};
	private JComboBox geschlechtF = new JComboBox(geschlechtOptions);

	//Field with date format
	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/uu");
	DateField dateField = new DateField(dateFormatter);

	private JTextField alterF = new JTextField("");
	private JTextField groesseF = new JTextField("");
	private JTextField gewichtF = new JTextField("");
	private JTextField wohnortF = new JTextField("");
	private JTextField infosF = new JTextField("");
	private JTextField medikamenteF = new JTextField("");
	private String[] statusOptions = {"waiting", "in treatment", "treated"};
	private JComboBox statusF = new JComboBox(statusOptions);
	private JTextField arztF = new JTextField("");
	private JTextField vorerkrankungenF = new JTextField("");

	private JButton back = new JButton("Back to list");
	private JButton edit = new JButton("Edit");

	public DetailGUI(Controller controller, int index) {
		this.controller = controller;

		addElements(index);

		//Window Settings
		frame.setTitle("Patient Details");
		frame.setSize(870, 856);
		frame.setVisible(true);
	}

	private void addElements(int index){
		// Layout
		frame.setLayout(new BorderLayout());
		formular.setLayout(new GridLayout(14,2,5,10));
		titlePanel.setLayout(new BorderLayout());
		buttonsPanel.setLayout(new GridLayout(1,2));
		frame.add(formular, BorderLayout.CENTER);
		frame.add(titlePanel, BorderLayout.NORTH);
		frame.add(buttonsPanel, BorderLayout.SOUTH);

		// Elements
		PatientDt patient = controller.getPatientDetails(index);

		titlePanel.add(newPatient);
		newPatient.setText(patient.getNachname());
		formular.add(patientID);
		formular.add(patientIdF);
		patientIdF.setText(patient.getPatientID());
		patientIdF.setEditable(false);
		formular.add(nachname);
		formular.add(nachnameF);
		nachnameF.setText(patient.getNachname());
		nachnameF.setEditable(false);
		formular.add(vorname);
		formular.add(vornameF);
		vornameF.setText(patient.getVorname());
		vornameF.setEditable(false);
		formular.add(geschlecht);
		formular.add(geschlechtF);
		geschlechtF.setSelectedItem(patient.getGeschlecht());
		geschlechtF.setEditable(false);
		formular.add(dob);
		formular.add(dateField);
		dateField.setText(patient.getDob());
		dateField.setEditable(false);
		formular.add(alter);
		formular.add(alterF);
		alterF.setEditable(false);
		formular.add(status);
		formular.add(statusF);
		statusF.setSelectedItem(patient.getStatus());
		statusF.setEditable(false);
		formular.add(groesse);
		formular.add(groesseF);
		groesseF.setText(String.valueOf(patient.getGroesse()));
		groesseF.setEditable(false);
		formular.add(gewicht);
		formular.add(gewichtF);
		gewichtF.setText(String.valueOf(patient.getGewicht()));
		gewichtF.setEditable(false);
		formular.add(wohnort);
		formular.add(wohnortF);
		wohnortF.setText(patient.getWohnort());
		wohnortF.setEditable(false);
		formular.add(infos);
		formular.add(infosF);
		infosF.setText(patient.getInfos());
		infosF.setEditable(false);
		formular.add(medikamente);
		formular.add(medikamenteF);
		medikamenteF.setText(patient.getMedikamente());
		medikamenteF.setEditable(false);
		formular.add(arzt);
		formular.add(arztF);
		arztF.setText(patient.getArzt());
		arztF.setEditable(false);
		formular.add(vorerkrankungen);
		formular.add(vorerkrankungenF);
		vorerkrankungenF.setText(patient.getVorerkrankungen());
		vorerkrankungenF.setEditable(false);

		buttonsPanel.add(back);
		buttonsPanel.add(edit);

		// Design
		newPatient.setFont(new Font("",Font.PLAIN,30));
		patientID.setBackground(new Color(189,191,242));
		patientID.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		patientID.setOpaque(true);
		nachname.setBackground(new Color(189,191,242));
		nachname.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		nachname.setOpaque(true);
		vorname.setBackground(new Color(189,191,242));
		vorname.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		vorname.setOpaque(true);
		geschlecht.setBackground(new Color(189,191,242));
		geschlecht.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		geschlecht.setOpaque(true);
		dob.setBackground(new Color(189,191,242));
		dob.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		dob.setOpaque(true);
		alter.setBackground(new Color(189,191,242));
		alter.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		alter.setOpaque(true);
		status.setBackground(new Color(189,191,242));
		status.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		status.setOpaque(true);
		groesse.setBackground(new Color(189,191,242));
		groesse.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		groesse.setOpaque(true);
		gewicht.setBackground(new Color(189,191,242));
		gewicht.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		gewicht.setOpaque(true);
		wohnort.setBackground(new Color(189,191,242));
		wohnort.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		wohnort.setOpaque(true);
		infos.setBackground(new Color(189,191,242));
		infos.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		infos.setOpaque(true);
		medikamente.setBackground(new Color(189,191,242));
		medikamente.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		medikamente.setOpaque(true);
		arzt.setBackground(new Color(189,191,242));
		arzt.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		arzt.setOpaque(true);
		vorerkrankungen.setBackground(new Color(189,191,242));
		vorerkrankungen.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		vorerkrankungen.setOpaque(true);


		// Borders
		formular.setBorder(BorderFactory.createEmptyBorder(10,40,15,40));
		titlePanel.setBorder(BorderFactory.createEmptyBorder(20,40,10,40));
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(0,40,20,40));

		//Button
		back.addActionListener(e -> this.frame.dispose());
		edit.addActionListener(e -> controller.setEditGUIVis(index));
	}

	public void DisposeView() {
		this.frame.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}