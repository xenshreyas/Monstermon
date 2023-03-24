package ui.components;

import javax.swing.*;
import java.awt.*;

// Represents a fancier JTextField, with a better color scheme
public class FancyField extends JTextField {
    public FancyField(int columns) {
        super(null, null, columns);
        setSize(WIDTH * 20, HEIGHT / 3);
        setFont(new Font("Nanum Myeongjo", Font.CENTER_BASELINE, 15));
        setBackground(new Color(40, 40, 40));
        setForeground(new Color(200, 200, 200));
    }
}
