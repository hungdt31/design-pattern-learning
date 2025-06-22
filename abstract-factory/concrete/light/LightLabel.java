package concrete.light;

import javax.swing.JComponent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

import interfaces.Label;

public class LightLabel implements Label {
    @Override
    public JComponent render() {
        JLabel greetingLabel = new JLabel("WELCOME:");
        greetingLabel.setForeground(new Color(50, 50, 50)); // Dark text for light theme
        greetingLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        return greetingLabel;
    }
}
