package concrete.dark;

import interfaces.Button;
import javax.swing.*;
import java.awt.*;

/**
 * Nút kiểu Dark theme
 */
public class DarkButton implements Button {
    @Override
    public JComponent render() {
        JButton button = new JButton("Hello, ");
        button.setPreferredSize(new Dimension(100, 30));
        button.setBackground(new Color(40, 40, 45));
        button.setForeground(new Color(250, 250, 250));
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(60, 60, 70), 1),
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        button.setFocusPainted(false);
        button.addActionListener(e -> JOptionPane.showMessageDialog(null, "Welcome to Dark Mode!"));
        return button;
    }
} 