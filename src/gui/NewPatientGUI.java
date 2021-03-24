package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class NewPatientGUI extends JFrame implements ActionListener {
    private JFrame frame = new JFrame();
    private JPanel titlePanel = new JPanel();
    private JPanel formular = new JPanel();
    private JPanel buttonsPanel = new JPanel();

    ImageIcon image = new ImageIcon("/Users/lima/Desktop/e-Health/src/images/personIcon.png");

    private JLabel newPatient = new JLabel("New Patient", image, JLabel.LEFT);
    private JLabel vorname = new JLabel("Vorname:");
    private JLabel nachname = new JLabel("Nachname:");
    private JLabel geschlecht = new JLabel("Geschlecht:");
    private JLabel dob = new JLabel("DOB:");

    private JTextField vornameF = new JTextField("");
    private JTextField nachnameF = new JTextField("");
    private JTextField geschlechtF = new JTextField("");
    private JTextField dobF = new JTextField("");

    private JButton cancel = new JButton("Cancel");
    private JButton add = new JButton("Add");

    public static void main(String[] args) {
        NewPatientGUI a = new NewPatientGUI();
    }

    public NewPatientGUI() {
        // Layout
        frame.setLayout(new BorderLayout());
        formular.setLayout(new GridLayout(4,2,5,10));
        titlePanel.setLayout(new BorderLayout());
        buttonsPanel.setLayout(new GridLayout(1,2));
        frame.add(formular, BorderLayout.CENTER);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonsPanel, BorderLayout.SOUTH);

        // Elements
        titlePanel.add(newPatient);
        formular.add(vorname);
        formular.add(vornameF);
        formular.add(nachname);
        formular.add(nachnameF);
        formular.add(geschlecht);
        formular.add(geschlechtF);
        formular.add(dob);
        formular.add(dobF);
        buttonsPanel.add(cancel);
        buttonsPanel.add(add);

        // Design
        newPatient.setFont(new Font("Arial",Font.PLAIN,30));
        vorname.setBackground(new Color(189,191,242));
        vorname.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        vorname.setOpaque(true);
        nachname.setBackground(new Color(189,191,242));
        nachname.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        nachname.setOpaque(true);
        geschlecht.setBackground(new Color(189,191,242));
        geschlecht.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        geschlecht.setOpaque(true);
        dob.setBackground(new Color(189,191,242));
        dob.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        dob.setOpaque(true);

        // Borders
        formular.setBorder(BorderFactory.createEmptyBorder(0,40,10,40));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20,40,10,40));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(0,40,15,40));

        //ActionListeners
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        frame.setTitle("Add New Patient");
        frame.setSize(500, 400);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
