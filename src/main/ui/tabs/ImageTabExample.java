package ui.tabs;

import ui.tabs.Tab;

import java.awt.*;
import javax.swing.*;

public class ImageTabExample {
    public static void main(String[] args) {
        // Create a new JFrame
        JFrame frame = new JFrame("Image Tab Example");

        // Set the size of the frame
        frame.setSize(400, 400);

        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a new JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Create a new JPanel for the image tab
        JPanel imagePanel = new JPanel();

        // Load the image from a file
        ImageIcon imageIcon = new ImageIcon("data/mew.gif");

        // Create a new JLabel with the image
        JLabel imageLabel = new JLabel(imageIcon);

        // Add the label to the panel
        imagePanel.add(imageLabel);

        // Add the panel to the tabbed pane with a tab title
        tabbedPane.addTab("Image", imagePanel);

        // Add the tabbed pane to the frame
        frame.getContentPane().add(tabbedPane);

        // Show the frame
        frame.setVisible(true);
    }
}
