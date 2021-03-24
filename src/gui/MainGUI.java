package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 * 
 * @author Elias
 *
 */
public class MainGUI extends JFrame implements ActionListener {

	
	private JFrame frame = new JFrame();
	
	private String[] columns = {"ID", "Nachname", "Vorname", "Geschlecht", "dob"};
	private String[][] rows = {{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},{"ID", "Nachname", "Vorname", "Geschlecht", "dob"},};

	JTable jt = new JTable(rows,columns);
	 DefaultTableModel dm = new DefaultTableModel();

	private JLabel patientL = new JLabel("Patient Listing");
	private JButton newPatient = new JButton("+ new Patient");
	
	private JButton delete = new JButton("löschen");
	private JButton details = new JButton("details");
	private JButton edit = new JButton("ändern");
	
	private JPanel data = new JPanel();
	private JPanel haupt  = new JPanel();
	private JScrollPane sp = new JScrollPane(jt);
	
	

	public static void main(String[] args) {
		MainGUI a = new MainGUI();
	}

	public MainGUI() {

		//Layouts
		frame.setLayout(new BorderLayout());
		haupt.setLayout(new BorderLayout());
		data.setLayout(new BorderLayout());
		frame.add(haupt, BorderLayout.NORTH);
		frame.add(data, BorderLayout.CENTER);
		jt.setEnabled(false);

		//Elements
		data.add(sp);
		haupt.add(patientL, BorderLayout.WEST);
		haupt.add(newPatient, BorderLayout.EAST);

		//Design
		patientL.setFont(new Font("Arial",Font.PLAIN,35));

		//Borders
		haupt.setBorder(BorderFactory.createEmptyBorder(20,100,20,100));
		data.setBorder(BorderFactory.createEmptyBorder(0,100,50,100));

		//Buttons
		newPatient.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				NewPatientGUI d = new NewPatientGUI();//opens window to create new patients
				
			}
		});
		
		// Window Settings
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setTitle("e-Health");
		frame.setSize(1500, 1000);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
