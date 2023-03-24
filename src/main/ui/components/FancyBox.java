package ui.components;

import javax.swing.*;
import java.awt.*;

// Represents a fancier JComboBox, with a better color scheme
public class FancyBox extends JComboBox<String> {

    public FancyBox() {
        super();
        setSize(WIDTH, HEIGHT / 3);
        setFont(new Font("Nanum Myeongjo", Font.CENTER_BASELINE, 15));
        setForeground(new Color(40, 40, 40));

        setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                return renderer;
            }
        });
    }
}
