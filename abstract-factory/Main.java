import concrete.dark.DarkFactory;
import concrete.light.LightFactory;
import javax.swing.*;
import java.awt.*;

/**
 * Lớp Main triển khai ứng dụng cho phép người dùng chuyển đổi
 * giữa giao diện Light và Dark mode
 */
public class Main {
    private static Application app;
    private static JFrame controlFrame;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            showSelectionDialog();
        });
    }

    /**
     * Hiển thị dialog lựa chọn kiểu giao diện ban đầu
     */
    private static void showSelectionDialog() {
        JFrame selectionFrame = new JFrame("Select a theme");
        selectionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        selectionFrame.setSize(300, 150);
        selectionFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel label = new JLabel("Select initial interface style:");

        JButton lightButton = new JButton("Light Mode");
        lightButton.addActionListener(e -> {
            app = new Application(new LightFactory());
            app.createUI();
            app.showUI();
            selectionFrame.dispose();
            createControlPanel();
        });

        JButton darkButton = new JButton("Dark Mode");
        darkButton.addActionListener(e -> {
            app = new Application(new DarkFactory());
            app.createUI();
            app.showUI();
            selectionFrame.dispose();
            createControlPanel();
        });

        panel.add(label);
        panel.add(lightButton);
        panel.add(darkButton);

        selectionFrame.add(panel);
        selectionFrame.setVisible(true);
    }

    /**
     * Tạo bảng điều khiển để chuyển đổi giữa các giao diện
     */
    private static void createControlPanel() {
        controlFrame = new JFrame("Interface Control - Simple Calculator");
        controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlFrame.setSize(350, 120);
        controlFrame.setLocation(50, 50);

        JPanel panel = new JPanel(new GridLayout(2, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton lightButton = new JButton("Switch to Light Mode");
        lightButton.addActionListener(e -> {
            app.changeTheme(new LightFactory());
        });

        JButton darkButton = new JButton("Switch to Dark Mode");
        darkButton.addActionListener(e -> {
            app.changeTheme(new DarkFactory());
        });

        panel.add(lightButton);
        panel.add(darkButton);

        controlFrame.add(panel);
        controlFrame.setVisible(true);
    }
}
