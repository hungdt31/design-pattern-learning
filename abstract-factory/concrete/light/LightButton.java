package concrete.light;

import interfaces.Button;
import javax.swing.*;
import java.awt.*;

/**
 * Nút kiểu Light theme
 */
public class LightButton implements Button {
    @Override
    public JComponent render() {
        JButton button = new JButton("Xin chào");
        button.setPreferredSize(new Dimension(100, 30));
        button.setBackground(new Color(245, 245, 245));
        button.setForeground(new Color(30, 30, 30));
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        button.setFocusPainted(false);
        button.addActionListener(e -> JOptionPane.showMessageDialog(null, "Welcome to Light Mode!"));
        return button;
    }
} 