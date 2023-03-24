package ui.components;

import javax.swing.*;
import java.awt.*;

// Represents a fancier JLabel, with a better color scheme
public class FancyLabel extends JLabel {

    public FancyLabel(String text) {
        super(text, JLabel.LEFT);
        setSize(WIDTH, HEIGHT / 3);
        setFont(new Font("Nanum Myeongjo", Font.CENTER_BASELINE, 30));
        setBackground(new Color(40, 40, 40));
        setForeground(new Color(200, 200, 200));
    }

}
