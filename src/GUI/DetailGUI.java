package GUI;

import Controller.Controller;
import Data.PatientDt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetailGUI extends JFrame implements ActionListener {
	private JFrame frame = new JFrame();
	private JPanel formular = new JPanel();
	private JPanel titlePanel = new JPanel();
	private JPanel buttonsPanel = new JPanel();

	private Controller controller;

	private JLabel newPatient = new JLabel("");
	private JLabel title = new JLabel("Title*:", JLabel.LEFT);
	private JLabel dueDate = new JLabel("Due Date:");
	private JLabel priority = new JLabel("Priority:");
	private JLabel description = new JLabel("Description*:");

	private JTextField titleF = new JTextField("");
	private JTextField dueDateF = new JTextField("");
	private JTextField priorityF = new JTextField("");
	private JTextField descriptionF = new JTextField("");

	private JButton back = new JButton("Back to list");
	private JButton edit = new JButton("Edit");

	public DetailGUI(Controller controller, int index) {
		this.controller = controller;

		addElements(index);

		//Window Settings
		frame.setTitle("Patient Details");
		frame.setSize(500, 400);
		frame.setVisible(true);
	}

	private void addElements(int index){
		// Layout
		frame.setLayout(new BorderLayout());
		formular.setLayout(new GridLayout(4,2,5,10));
		titlePanel.setLayout(new BorderLayout());
		buttonsPanel.setLayout(new GridLayout(1,2));
		frame.add(formular, BorderLayout.CENTER);
		frame.add(titlePanel, BorderLayout.NORTH);
		frame.add(buttonsPanel, BorderLayout.SOUTH);

		// Elements
		PatientDt patient = controller.getPatientDetails(index);

		titlePanel.add(newPatient);
		newPatient.setText(patient.getTitle());
		formular.add(title);
		formular.add(titleF);
		titleF.setText(patient.getTitle());
		titleF.setEditable(false);
		formular.add(dueDate);
		formular.add(dueDateF);
		dueDateF.setText(patient.getDueDate());
		dueDateF.setEditable(false);
		formular.add(priority);
		formular.add(priorityF);
		priorityF.setText(String.valueOf(patient.getPriority()));
		priorityF.setEditable(false);
		formular.add(description);
		formular.add(descriptionF);
		descriptionF.setText(patient.getDescription());
		descriptionF.setEditable(false);
		buttonsPanel.add(back);
		buttonsPanel.add(edit);

		// Design
		newPatient.setFont(new Font("",Font.PLAIN,30));
		title.setBackground(new Color(189,191,242));
		title.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		title.setOpaque(true);
		dueDate.setBackground(new Color(189,191,242));
		dueDate.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		dueDate.setOpaque(true);
		priority.setBackground(new Color(189,191,242));
		priority.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		priority.setOpaque(true);
		description.setBackground(new Color(189,191,242));
		description.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		description.setOpaque(true);


		// Borders
		formular.setBorder(BorderFactory.createEmptyBorder(10,40,15,40));
		titlePanel.setBorder(BorderFactory.createEmptyBorder(20,40,10,40));
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(0,40,20,40));

		//Button
		back.addActionListener(e -> this.frame.dispose());
		edit.addActionListener(e -> controller.setDetailGUIVis(index));
	}

	public void DisposeView() {
		this.frame.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}