package GUI;

import Controller.Controller;
import Data.PatientRowDt;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class MainGUI {

	private JFrame frame = new JFrame();
	private JPanel titlePanel = new JPanel();
	private JPanel searchPanel = new JPanel();
	private JPanel headerPanel = new JPanel();
	private JPanel patientList = new JPanel();
	private JPanel buttonsPanel = new JPanel();

	private Controller controller;

	private JTable table;
	private JScrollPane scrollP;

	ImageIcon personIcon = new ImageIcon("src/images/personIcon.png");
	private JLabel patientListing = new JLabel("Patient Listing", personIcon, JLabel.LEFT);
	ImageIcon heart = new ImageIcon("src/Images/heart.png");
	private JLabel patientLabel = new JLabel("E-Health", heart, JLabel.LEFT);
	ImageIcon hospital = new ImageIcon("src/Images/hospital.png");
	private JButton home = new JButton(hospital);

	BufferedImage image;

	{
		try {
			image = ImageIO.read(Objects.requireNonNull(MainGUI.class.getClassLoader().getResource("Images/loupe.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	JTextField searchField = new JTextField() {
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			int centerPoint = (getHeight() - image.getHeight())/2;
			g.drawImage(image, 0, centerPoint, this);
		}
	};

	private JButton newPatient = new JButton("   + New Patient   ");

	public MainGUI(Controller controller) {
		this.controller = controller;

		addElements();
		loadTableModel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Patient Listing");
		frame.setSize(1349, 867);
		frame.setVisible(true);
	}
	public MainGUI(Controller controller,  ArrayList<PatientRowDt> results) {
		this.controller = controller;

		addElements();
		loadTableModel(results);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Patient Listing");
		frame.setSize(1349, 867);
		frame.setVisible(true);
	}

	private void addElements() {
		searchField.setMargin(new Insets(0, image.getWidth(), 0, 0));

		//Layout
		frame.setLayout(new BorderLayout());
		titlePanel.setLayout(new BorderLayout());
		patientList.setLayout(new BorderLayout());
		headerPanel.setLayout(new BorderLayout());
		searchPanel.setLayout(new GridLayout(1,3,350,0));
		headerPanel.add(titlePanel, BorderLayout.SOUTH);
		headerPanel.add(searchPanel, BorderLayout.NORTH);
		frame.add(headerPanel, BorderLayout.NORTH);
		frame.add(patientList, BorderLayout.CENTER);

		titlePanel.add(patientListing, BorderLayout.WEST);
		titlePanel.add(newPatient, BorderLayout.EAST);
		searchPanel.add(patientLabel);
		searchPanel.add(home);
		searchPanel.add(searchField);
		searchField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.search(searchField.getText());
			}
		});

		TableCellRenderer tableRenderer;
		table = new JTable();
		tableRenderer = table.getDefaultRenderer(JButton.class);
		table.setDefaultRenderer(JCheckBox.class, new JTableButtonRenderer(tableRenderer));
		table.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
		table.getTableHeader().setReorderingAllowed(false);

		scrollP = new JScrollPane(table);
		patientList.add(scrollP, BorderLayout.CENTER);


		// Design
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		patientLabel.setFont(new Font("", Font.PLAIN, 30));
		patientLabel.setForeground(new Color(68, 68, 68));
		patientListing.setFont(new Font("", Font.PLAIN, 30));
		patientListing.setForeground(new Color(68, 68, 68));
		newPatient.setBackground(new Color(170, 170, 170));
		newPatient.setBorder(BorderFactory.createLineBorder(new Color(68, 68, 68)));
		newPatient.setForeground(Color.white);
		newPatient.setFont(new Font("", Font.BOLD, 15));
		newPatient.setOpaque(true);
		searchPanel.setBackground(new Color(170, 170, 170));

		// Borders
		titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 60, 0, 60));
		searchPanel.setBorder(BorderFactory.createEmptyBorder(5, 60, 5, 60));
		patientList.setBorder(BorderFactory.createEmptyBorder(20, 60, 30, 60));

		//Buttons
		newPatient.addActionListener(e -> controller.setNewPatientGUIVis());

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
								controller.setEditGUIVis(rowindex);
							}
						});
					}
					if (b.getText() == "Delete"){
						b.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								controller.deletePatient(rowindex);
								controller.setMainGUIVis();
							}
						});
					}
					b.doClick();
				}


				super.mouseClicked(e);
			}
		});

	}

	private void loadTableModel(ArrayList<PatientRowDt> showResult) {
		AbstractTableModel model = controller.getModel(showResult);
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
					String index1 = (String) table.getValueAt(rowindex, 0);
					int index = Integer.parseInt(index1) - 1;
					if (b.getText() == "Details"){
						b.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								controller.setDetailGUIVis(index);
							}
						});
					}
					if (b.getText() == "Edit"){
						b.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								controller.setEditGUIVis(index);
							}
						});
					}
					if (b.getText() == "Delete"){
						b.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								controller.deletePatient(index);
								controller.setMainGUIVis();
							}
						});
					}
					b.doClick();
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
