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
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class NewPatientGUI extends GUI{

    private JPanel formular = new JPanel();
    private JPanel titlePanel = new JPanel();
    private JPanel buttonsPanel = new JPanel();

    ImageIcon personIcon = new ImageIcon("src/images/personIcon.png");
    private JLabel label;
    private JLabel newPatient = new JLabel("New Patient", personIcon, JLabel.LEFT);

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
    private JTextField vorerkrankungenF = new JTextField("");
    private String[] drOptions = {"Dr. Raquel Lima", "Dr. Elias Mattern", "Dr. Gabriel Nadolny", "Dr. Drake Ramoray", "Dr. Meredith Grey", "Dr. Painus Gregerus"};
    private JComboBox drF = new JComboBox(drOptions);

    private JButton cancel = new JButton("Cancel");
    private JButton add = new JButton("Add");

    public NewPatientGUI(Controller controller) {
        super("Add New Patient", 870, 856);
        // Layout
        setLayout(new BorderLayout());
        formular.setLayout(new GridLayout(12,2,5,10));
        titlePanel.setLayout(new BorderLayout());
        buttonsPanel.setLayout(new GridLayout(1,2));
        add(formular, BorderLayout.CENTER);
        add(titlePanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.SOUTH);

        // Elements
        titlePanel.add(newPatient);
        formular.add(getLabel("Nachname:"));
        formular.add(nachnameF);
        formular.add(getLabel("Vorname:"));
        formular.add(vornameF);
        formular.add(getLabel("Geschlecht:"));
        formular.add(geschlechtF);
        formular.add(getLabel("DOB:"));
        formular.add(dateField);
        dateField.setValue(LocalDate.now(ZoneId.systemDefault()));
        formular.add(getLabel("Status:"));
        formular.add(statusF);
        formular.add(getLabel("Grösse:"));
        formular.add(groesseF);
        formular.add(getLabel("Gewicht:"));
        formular.add(gewichtF);
        formular.add(getLabel("Wohnort:"));
        formular.add(wohnortF);
        formular.add(getLabel("Infos:"));
        formular.add(infosF);
        formular.add(getLabel("Medikamente:"));
        formular.add(medikamenteF);
        formular.add(getLabel("Arzt:"));
        formular.add(drF);
        formular.add(getLabel("Vorerkrankungen:"));
        formular.add(vorerkrankungenF);
        buttonsPanel.add(cancel);
        buttonsPanel.add(add);

        // Design
        titlePanel.setBackground(new Color(161, 194, 206));
        newPatient.setFont(new Font("",Font.PLAIN,30));
        newPatient.setForeground(new Color(68, 68, 68));



        // Borders
        formular.setBorder(BorderFactory.createEmptyBorder(10,40,15,40));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(0,40,20,40));

        //ActionListeners
        cancel.addActionListener(e -> {
            this.dispose();
            controller.setMainGUIVis();
        });
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nachnameF.getText().equals("") || vornameF.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the required fields", "Field required", JOptionPane.ERROR_MESSAGE);
                    if(nachnameF.getText().equals("")) {
                        nachnameF.setBackground(new Color(255,105,97)); }
                    if(vornameF.getText().equals("")) {
                        vornameF.setBackground(new Color(255,105,97));}
                } else {

                    JButton details = new JButton("Details");

                    JButton edit = new JButton("Edit");

                    JButton delete = new JButton("Delete");
                    String id = controller.getID();
                    PatientDt data = new PatientDt(id, nachnameF.getText(), vornameF.getText(), (String) geschlechtF.getSelectedItem(), dateField.getText(), (groesseF.getText().equals("")) ? 0 : Double.parseDouble(groesseF.getText()), (gewichtF.getText().equals("")) ? 0 : Double.parseDouble(gewichtF.getText()), wohnortF.getText(), infosF.getText(), medikamenteF.getText(),  statusF.getSelectedItem().toString(), (String) drF.getSelectedItem(), vorerkrankungenF.getText());
                    PatientRowDt row = new PatientRowDt(id, nachnameF.getText(), vornameF.getText(), (String) geschlechtF.getSelectedItem(), dateField.getText(), details, edit, delete );
                    controller.newPatient(data, row);
                    controller.setMainGUIVis();
                }

            }
        });

        //Window Settings
        setVisible(true);
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

class DateField extends JFormattedTextField {

    private static final long serialVersionUID = -4070878851012651987L;

    public DateField(DateTimeFormatter dateFormatter) {
        super(dateFormatter.toFormat(LocalDate::from));
    }

    @Override
    public LocalDate getValue() {
        return (LocalDate) super.getValue();
    }

}
