package GUI;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;

public class LoginGUI extends GUI{

    private Controller controller;

    ImageIcon personIcon = new ImageIcon("src/images/user.png");
    private JLabel title = new JLabel("Login", personIcon, JLabel.LEFT);
    private JLabel username = new JLabel("Username:");
    private JLabel password = new JLabel("Password:");

    private String[] drOptions = {"Dr. Raquel Lima", "Dr. Elias Mattern", "Dr. Gabriel Nadolny", "Dr. Drake Ramoray", "Dr. Meredith Grey", "Dr. Painus Gregerus"};
    private JComboBox drF = new JComboBox(drOptions);
    private JPasswordField passwordF = new JPasswordField();
    private JTextField invisible2 = new JTextField();

    ImageIcon loginIcon = new ImageIcon("src/images/login.png");
    private JButton login = new JButton(loginIcon);

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
        title.setBounds(200,25,200,30);
        login.setBounds(160,280,200,30);
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
        title.setFont(new Font("",Font.BOLD,25));
        title.setForeground(Color.white);
        username.setFont(new Font("",Font.BOLD,15));
        username.setForeground(Color.white);
        password.setFont(new Font("",Font.BOLD,15));
        password.setForeground(Color.white);
        login.setFont(new Font("",Font.PLAIN,15));
        getContentPane().setBackground( new Color(161, 194, 206) );
        login.setOpaque(false);
        login.setContentAreaFilled(false);
        login.setBorderPainted(false);

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
