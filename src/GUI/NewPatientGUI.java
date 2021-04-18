package GUI;

import Controller.Controller;
import Data.PatientDt;
import Data.PatientRowDt;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.ChoiceFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class NewPatientGUI extends GUI{

    private JPanel formular = new JPanel();
    private JPanel titlePanel = new JPanel();
    private JPanel buttonsPanel = new JPanel();

    private JLabel newPatient = new JLabel("New Patient");
    private JLabel nachname = new JLabel("Nachname:", JLabel.LEFT);
    private JLabel vorname = new JLabel("Vorname:");
    private JLabel geschlecht = new JLabel("Geschlecht:");
    private JLabel dob = new JLabel("DOB:");
    private JLabel groesse = new JLabel("Grösse:");
    private JLabel gewicht = new JLabel("Gewicht:");
    private JLabel wohnort = new JLabel("Wohnort:");
    private JLabel infos = new JLabel("Infos:");
    private JLabel medikamente = new JLabel("Medikamente:");
    private JLabel status = new JLabel("Status:");
    private JLabel arzt = new JLabel("Arzt:");
    private JLabel vorerkrankungen = new JLabel("Vorerkrankungen:");

    private JTextField nachnameF = new JTextField("");
    private JTextField vornameF = new JTextField("");
    private String[] geschlechtOptions = {"weiblich", "männlich", "anderes"};
    private JComboBox geschlechtF = new JComboBox(geschlechtOptions);

    //Field with date format
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/uu");
    DateField dateField = new DateField(dateFormatter);

    private NumberFormat amountFormat = new DecimalFormat();
    private JFormattedTextField groesseF = new JFormattedTextField(amountFormat);
    private JFormattedTextField gewichtF = new JFormattedTextField(amountFormat);
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
        formular.add(nachname);
        formular.add(nachnameF);
        formular.add(vorname);
        formular.add(vornameF);
        formular.add(geschlecht);
        formular.add(geschlechtF);
        formular.add(dob);
        formular.add(dateField);
        dateField.setValue(LocalDate.now(ZoneId.systemDefault()));
        formular.add(status);
        formular.add(statusF);
        formular.add(groesse);
        formular.add(groesseF);
        formular.add(gewicht);
        formular.add(gewichtF);
        formular.add(wohnort);
        formular.add(wohnortF);
        formular.add(infos);
        formular.add(infosF);
        formular.add(medikamente);
        formular.add(medikamenteF);
        formular.add(arzt);
        formular.add(drF);
        formular.add(vorerkrankungen);
        formular.add(vorerkrankungenF);
        buttonsPanel.add(cancel);
        buttonsPanel.add(add);

        // Design
        newPatient.setFont(new Font("",Font.PLAIN,30));
        newPatient.setForeground(new Color(68, 68, 68));
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

    public void DisposeView() {
        this.dispose();
    }

}

class DateField extends JFormattedTextField {

    private static final long serialVersionUID = -4070878851012651987L;

    public DateField(DateTimeFormatter dateFormatter) {
        super(dateFormatter.toFormat(LocalDate::from));
        setPreferredSize(new Dimension(100, 26));
    }

    @Override
    public LocalDate getValue() {
        return (LocalDate) super.getValue();
    }

}
