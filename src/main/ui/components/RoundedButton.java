package ui.components;

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

        FontMetrics fm = g.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(getText())) / 2;
        int y = (getHeight() + fm.getAscent()) / 2;
        g.drawString(getText(), x, y - 1);
    }
}