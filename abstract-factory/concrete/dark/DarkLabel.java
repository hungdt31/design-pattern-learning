package concrete.dark;

import javax.swing.JComponent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

import interfaces.Label;

public class DarkLabel implements Label {
    @Override
    public JComponent render() {
        JLabel greetingLabel = new JLabel("WELCOME:");
        greetingLabel.setForeground(new Color(230, 230, 230)); // Light text for dark theme
        greetingLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        return greetingLabel;
    }
}
