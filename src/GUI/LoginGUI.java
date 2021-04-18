package GUI;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;

public class LoginGUI extends GUI{
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
        super("Login", 593, 383);
        this.controller = controller;

        addElements();

        //Window Settings
        setVisible(true);
    }

    private void addElements(){
        // Layout
        setLayout(new BorderLayout());
        formular.setLayout(new GridLayout(2,2, 20, 100));
        titlePanel.setLayout(new BorderLayout());
        buttonsPanel.setLayout(new GridLayout(1,1));
        add(formular, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
        add(titlePanel,BorderLayout.NORTH);

        titlePanel.add(title);
        formular.add(username);
        formular.add(drF);
        formular.add(password);
        formular.add(passwordF);
        buttonsPanel.add(login);

        // Design
        title.setFont(new Font("",Font.PLAIN,30));
        username.setFont(new Font("",Font.PLAIN,18));
        password.setFont(new Font("",Font.PLAIN,18));
        drF.setFont(new Font("",Font.PLAIN,18));
        passwordF.setFont(new Font("",Font.PLAIN,18));


        // Borders
        formular.setBorder(BorderFactory.createEmptyBorder(40, 130, 60, 80));



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
        this.dispose();
    }


}
