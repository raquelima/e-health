package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 * 
 * @author Elias
 *
 */
public class MainGUI extends JFrame implements ActionListener {

	private JFrame frame = new JFrame();

	JTable table;
	 DefaultTableModel dm = new DefaultTableModel();

	ImageIcon image = new ImageIcon("../images/personIcon.png");
	private JLabel patientL = new JLabel("Patient Listing", image, JLabel.LEFT);
	private JButton newPatient = new JButton("+ new Patient");

	private JPanel data = new JPanel();
	private JPanel haupt  = new JPanel();
	private JScrollPane scrollP;

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

		//Elements
		TableCellRenderer tableRenderer;
		table = new JTable(new JTableButtonModel());
		tableRenderer = table.getDefaultRenderer(JButton.class);
		table.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
		scrollP = new JScrollPane(table);
		data.add(scrollP, BorderLayout.CENTER);
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
class JTableButtonRenderer implements TableCellRenderer {
	private TableCellRenderer defaultRenderer;
	public JTableButtonRenderer(TableCellRenderer renderer) {
		defaultRenderer = renderer;
	}
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		if(value instanceof Component)
			return (Component)value;
		return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}
}
class JTableButtonModel extends AbstractTableModel {
	JButton delete;
	JButton details;
	JButton edit;
	private Object[][] rows = {{"001", "Mattern", "Raquel", "M", "05.06.2002", delete = new JButton("Löschen"), details = new JButton("Detail"), edit = new JButton("ändern")}};
	private String[] columns = {"ID", "Nachname", "Vorname", "Geschlecht", "dob", " ", " ", " "};
	public String getColumnName(int column) {
		return columns[column];
	}
	public int getRowCount() {
		return rows.length;
	}
	public int getColumnCount() {
		return columns.length;
	}
	public Object getValueAt(int row, int column) {
		return rows[row][column];
	}
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	public Class getColumnClass(int column) {
		return getValueAt(0, column).getClass();
	}
}
