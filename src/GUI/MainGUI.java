package GUI;

import Controller.Controller;
import Data.PatientDt;
import Data.PatientRowDt;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainGUI {

	private JFrame frame = new JFrame();
	private JPanel titlePanel = new JPanel();
	private JPanel patientList = new JPanel();
	private JPanel buttonsPanel = new JPanel();

	private Controller controller;

	private JTable table;
	private JScrollPane scrollP;

	private JLabel patientListing = new JLabel("Patient Listing");
	private JButton newPatient = new JButton("   + New Patient   ");

	private JButton reset = new JButton("Reset");
	private JButton update = new JButton("Update");
	private JButton toDoneList = new JButton("to Done List ->");

	public MainGUI(Controller controller) {
		this.controller = controller;

		addElements();
		loadTableModel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Patient Listing");
		frame.setSize(750, 500);
		frame.setVisible(true);
	}

	private void addElements() {

		//Layout
		frame.setLayout(new BorderLayout());
		titlePanel.setLayout(new BorderLayout());
		patientList.setLayout(new BorderLayout());
		buttonsPanel.setLayout(new GridLayout(1, 3, 30, 0));
		frame.add(titlePanel, BorderLayout.NORTH);
		frame.add(patientList, BorderLayout.CENTER);
		frame.add(buttonsPanel, BorderLayout.SOUTH);

		//Elements
		TableCellRenderer tableRenderer;
		table = new JTable();
		tableRenderer = table.getDefaultRenderer(JButton.class);
		table.setDefaultRenderer(JCheckBox.class, new JTableButtonRenderer(tableRenderer));
		table.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));

		scrollP = new JScrollPane(table);
		patientList.add(scrollP, BorderLayout.CENTER);
		titlePanel.add(patientListing, BorderLayout.WEST);
		titlePanel.add(newPatient, BorderLayout.EAST);
		buttonsPanel.add(reset);
		buttonsPanel.add(update);
		buttonsPanel.add(toDoneList);

		// Design
		patientListing.setFont(new Font("Arial", Font.PLAIN, 35));
		newPatient.setBackground(new Color(189, 191, 242));
		newPatient.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		newPatient.setOpaque(true);

		// Borders
		titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 60, 0, 60));
		patientList.setBorder(BorderFactory.createEmptyBorder(20, 60, 20, 60));
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(0, 60, 20, 60));

		//Buttons
		newPatient.addActionListener(e -> controller.setNewPatientGUIVis());
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//default icon, custom title
				Object[] options = {"Yes, please",
						"No way!"};
				int n = JOptionPane.showOptionDialog(frame,
						"Are you sure you would like to reset your To-Do List?",
						"A Silly Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if (n == JOptionPane.YES_OPTION){
					controller.deleteAllPatients();
					controller.setMainGUIVis();
				}

			}
		});

	}

	private void loadTableModel() {
		AbstractTableModel model = controller.getModel();
		table.setModel(model);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JTable t = (JTable) e.getComponent();
				int columindex = t.columnAtPoint(e.getPoint());
				int rowindex = t.rowAtPoint(e.getPoint());
				Object cell = table.getModel().getValueAt(rowindex, columindex);
				if (cell instanceof JButton) {
					JButton b = (JButton) table.getModel().getValueAt(rowindex, columindex);

					if (b.getText() == "Delete"){
						b.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								controller.deletePatient(rowindex);
								controller.setMainGUIVis();
							}
						});
					}
					if (b.getText() == "Details"){
						b.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								controller.setDetailGUIVis(rowindex);
							}
						});
					}
					if (b.getText() == "Edit"){
						b.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								controller.setDetailGUIVis(rowindex);
							}
						});
					}
					b.doClick();
				}
				if (cell instanceof JCheckBox){
					JCheckBox c = (JCheckBox) table.getModel().getValueAt(rowindex, columindex);
					c.setSelected(true);
					controller.setMainGUIVis();
				}

				super.mouseClicked(e);
			}
		});

	}

	public void DisposeView() {
		this.frame.dispose();
	}
}

class JTableButtonRenderer implements TableCellRenderer {
	private TableCellRenderer defaultRenderer;

	public JTableButtonRenderer(TableCellRenderer renderer) {
		this.defaultRenderer = renderer;
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		if (value instanceof Component)
			return (Component) value;
		return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}
}
