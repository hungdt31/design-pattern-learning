package concrete.dark;

import interfaces.Window;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 * Cửa sổ kiểu Dark theme
 */
public class DarkWindow implements Window {
    private String title = "Dark Theme";

    @Override
    public JFrame render() {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Thiết lập Look and Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
            // Tùy chỉnh màu sắc cho JOptionPane
            UIManager.put("OptionPane.background", new Color(50, 50, 50));
            UIManager.put("Panel.background", new Color(50, 50, 50));
            UIManager.put("OptionPane.messageForeground", Color.WHITE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Tạo nội dung panel kiểu Dark
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        contentPanel.setBackground(new Color(33, 33, 33));
        
        // Thanh tiêu đề kiểu Dark
        JPanel titleBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titleBar.setBackground(new Color(45, 45, 45));
        titleBar.setPreferredSize(new Dimension(500, 35));
        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(new Color(230, 230, 230));
        titleLabel.setBorder(new EmptyBorder(5, 10, 5, 0));
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        titleBar.add(titleLabel);
        
        // Nội dung chính
        JPanel mainContent = new JPanel();
        mainContent.setBackground(new Color(40, 40, 40));
        mainContent.setBorder(new LineBorder(new Color(60, 60, 60), 1));
        mainContent.setLayout(new BorderLayout(10, 10));
        
        // Thêm vào frame
        contentPanel.add(titleBar, BorderLayout.NORTH);
        contentPanel.add(mainContent, BorderLayout.CENTER);
        frame.setContentPane(contentPanel);
        
        // Thiết lập kích thước và vị trí - lớn hơn cho máy tính
        frame.setSize(500, 600);
        frame.setLocationRelativeTo(null);
        
        return frame;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }
} 