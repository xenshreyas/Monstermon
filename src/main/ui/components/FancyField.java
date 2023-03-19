package ui.components;

import javax.swing.*;
import java.awt.*;

public class FancyField extends JTextField {
    public FancyField() {
        super();
        setSize(WIDTH, HEIGHT / 3);
        setFont(new Font("Nanum Myeongjo", Font.CENTER_BASELINE, 30));
        setBackground(new Color(40, 40, 40));
        setForeground(new Color(200, 200, 200));

    }
}
