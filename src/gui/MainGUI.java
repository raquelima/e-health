package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
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

		frame.setLayout(new BorderLayout());
		haupt.setLayout(new GridLayout(1,2));
		data.setLayout(new BorderLayout());
		frame.add(haupt, BorderLayout.NORTH);
		haupt.setBorder(BorderFactory.createEmptyBorder(0,100,0,100)); 
		frame.add(data, BorderLayout.CENTER);
		data.setBorder(BorderFactory.createEmptyBorder(0,100,100,100)); 
		
		data.add(sp);
		
		jt.setEnabled(false);
 			
		haupt.add(patientL);
		haupt.add(newPatient);
		
		
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
