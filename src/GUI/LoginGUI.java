package GUI;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;

public class LoginGUI extends GUI{

    private Controller controller;

    private JLabel title = new JLabel("Login", JLabel.CENTER);
    private JLabel username = new JLabel("Username:");
    private JLabel password = new JLabel("Password:");

    private String[] drOptions = {"Dr. Raquel Lima", "Dr. Elias Mattern", "Dr. Gabriel Nadolny", "Dr. Drake Ramoray", "Dr. Meredith Grey", "Dr. Painus Gregerus"};
    private JComboBox drF = new JComboBox(drOptions);
    private JPasswordField passwordF = new JPasswordField();
    private JTextField invisible2 = new JTextField();

    private JButton login = new JButton("Login");

    public LoginGUI(Controller controller) {
        super("Login", 536, 383);
        this.controller = controller;
        
        setPositions();
        addElements();

        //Window Settings
        setVisible(true);
    }

    private void setPositions(){
        username.setBounds(123,115,100,30);
        drF.setBounds(276,115,170,30);
        password.setBounds(123,195,100,30);
        passwordF.setBounds(276,195,170,30);
        title.setBounds(160,25,200,30);
        login.setBounds(160,285,200,30);
    }

    private void addElements(){
        // Layout
        setLayout(null);

        add(username);
        add(drF);
        add(password);
        add(passwordF);
        add(title);
        add(login);

        // Design
        title.setFont(new Font("",Font.PLAIN,25));
        username.setFont(new Font("",Font.PLAIN,15));
        password.setFont(new Font("",Font.PLAIN,15));
        login.setFont(new Font("",Font.PLAIN,15));

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
