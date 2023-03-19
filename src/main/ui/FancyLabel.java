package ui;

import javax.swing.*;
import java.awt.*;

public class FancyLabel extends JLabel {

    public FancyLabel(String text) {
        super(text, JLabel.LEFT);
        setSize(WIDTH, HEIGHT / 3);
        setFont(new Font("Nanum Myeongjo", Font.CENTER_BASELINE, 30));
        setBackground(new Color(40, 40, 40));
        setForeground(new Color(200, 200, 200));
    }

    public FancyLabel(String text, int alignment) {
        super(text, JLabel.CENTER);
        setSize(WIDTH, HEIGHT / 3);
        setFont(new Font("Nanum Myeongjo", Font.CENTER_BASELINE, 30));
        setBackground(new Color(40, 40, 40));
        setForeground(new Color(200, 200, 200));
    }
}
