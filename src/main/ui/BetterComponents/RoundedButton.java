package ui.BetterComponents;

import java.awt.*;
import javax.swing.*;

public class RoundedButton extends JButton {

    public RoundedButton(String text) {
        super(text);
        setOpaque(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setBackground(new Color(40,40,40));
        setForeground(new Color(179,179,179));
        setFont(new Font("Enchanted", Font.CENTER_BASELINE, 12));
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth(), getHeight(), getHeight(), getHeight());
        g.setColor(getForeground());
        g.drawString(getText(), 23, 18);
    }
}