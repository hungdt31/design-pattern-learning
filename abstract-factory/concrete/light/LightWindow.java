package concrete.light;

import interfaces.Window;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 * Cửa sổ kiểu Light theme
 */
public class LightWindow implements Window {
    private String title = "Light Theme";

    @Override
    public JFrame render() {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Tạo nội dung panel kiểu Light
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPanel.setBackground(new Color(240, 240, 240));
        
        // Thanh tiêu đề kiểu Light
        JPanel titleBar = new JPanel();
        titleBar.setBackground(new Color(220, 220, 220));
        titleBar.setPreferredSize(new Dimension(500, 30));
        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(new Color(30, 30, 30));
        titleLabel.setBorder(new EmptyBorder(0, 10, 0, 0));
        titleBar.add(titleLabel);
        
        // Nội dung chính
        JPanel mainContent = new JPanel();
        mainContent.setBackground(new Color(250, 250, 250));
        mainContent.setBorder(new LineBorder(new Color(200, 200, 200), 1));
        mainContent.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        
        // Thêm vào frame
        contentPanel.add(titleBar, BorderLayout.NORTH);
        contentPanel.add(mainContent, BorderLayout.CENTER);
        frame.setContentPane(contentPanel);
        
        // Kích thước lớn hơn cho máy tính
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