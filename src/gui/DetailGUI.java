package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author Elias
 *
 */
public class DetailGUI extends JFrame implements ActionListener {

	
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
	private JLabel test = new JLabel("name");
	private JPanel data = new JPanel();
	private JPanel haupt  = new JPanel();
	private JScrollPane sp = new JScrollPane(test);
	
	

	public static void main(String[] args) {
		DetailGUI a = new DetailGUI();
	}

	public DetailGUI() {

		frame.setLayout(new BorderLayout());
		
		frame.add(test);
		
		
		
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
