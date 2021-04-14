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
    private JPanel buttonsPanel = new JPanel();
    private JPanel titlePanel = new JPanel();

    private Controller controller;

    private JLabel title = new JLabel("Login", JLabel.CENTER);
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
        formular.setLayout(new GridLayout(4,1));
        titlePanel.setLayout(new BorderLayout());
        buttonsPanel.setLayout(new GridLayout(1,1));
        frame.add(formular, BorderLayout.CENTER);
        frame.add(buttonsPanel, BorderLayout.SOUTH);
        frame.add(titlePanel,BorderLayout.NORTH);

        titlePanel.add(title);
        formular.add(username);
        formular.add(drF);
        formular.add(password);
        formular.add(passwordF);
        buttonsPanel.add(login);

        // Design
        title.setFont(new Font("",Font.PLAIN,30));


        // Borders
        username.setBorder(BorderFactory.createEmptyBorder(60, 20, 0, 0));
        password.setBorder(BorderFactory.createEmptyBorder(30, 20, 0, 0));
        drF.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        passwordF.setBorder(BorderFactory.createEmptyBorder(0, 20, 40, 0));



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
