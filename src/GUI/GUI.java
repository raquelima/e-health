package GUI;

import javax.swing.*;

public class GUI extends JFrame {
    public GUI(String title, int width, int height) {
        super(title);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(width,height);
        setResizable(false);
        setVisible(false);
    }

}
