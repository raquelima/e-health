package GUI;

import Controller.Controller;
import Data.PatientDt;
import Data.PatientRowDt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

public class LoginGUI {
    private JFrame frame = new JFrame();
    private JPanel formular = new JPanel();
    private JPanel titlePanel = new JPanel();
    private JPanel buttonsPanel = new JPanel();

    private Controller controller;

    private JLabel title = new JLabel("Login");
    private JLabel username = new JLabel("Username");
    private JLabel password = new JLabel("Password:");

    private String[] drOptions = {"Dr. Raquel Lima", "Dr. Elias Mattern", "Dr. Gabriel Nadolny", "Dr. Drake Ramoray", "Dr. Meredith Grey", "Dr. Painus Gregerus"};
    private JComboBox drF = new JComboBox(drOptions);
    private JPasswordField passwordF = new JPasswordField();

    private JButton login = new JButton("Login");

    public LoginGUI(Controller controller) {
        this.controller = controller;

        addElements();

        //Window Settings
        frame.setTitle("Login");
        frame.setSize(593, 383);
        frame.setVisible(true);
    }

    private void addElements(){
        // Layout
        frame.setLayout(new BorderLayout());
        formular.setLayout(new GridLayout(2,2,10,100));
        titlePanel.setLayout(new BorderLayout());
        buttonsPanel.setLayout(new GridLayout(1,1));
        frame.add(formular, BorderLayout.CENTER);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonsPanel, BorderLayout.SOUTH);


        titlePanel.add(title);
        formular.add(username);
        formular.add(drF);
        formular.add(password);
        formular.add(passwordF);

        buttonsPanel.add(login);


        // Design
        title.setFont(new Font("",Font.PLAIN,30));
        username.setBackground(new Color(189,191,242));
        username.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        username.setOpaque(true);
        password.setBackground(new Color(189,191,242));
        password.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        password.setOpaque(true);

        // Borders
        formular.setBorder(BorderFactory.createEmptyBorder(10,40,15,40));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20,40,10,40));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(0,40,20,40));

        //Button
        login.addActionListener(e -> {
            if (controller.checkPW(passwordF.getText())){
                controller.setMainGUIVis();
            }else {
                passwordF.setBackground(new Color(255,105,97));
            }
        });

    }

    public void DisposeView() {
        this.frame.dispose();
    }


}
