package ui;

import javax.swing.*;
import java.awt.*;

public class Header {
  private JPanel panel;

  public Header() {
    panel = new JPanel();
    panel.setLayout(new BorderLayout()); // Sử dụng BorderLayout

    JLabel header = new JLabel("Welcome to Milk Tea Shop", JLabel.CENTER);
    header.setFont(new Font("Serif", Font.BOLD, 20)); // Font chữ Serif, in đậm, kích thước 20
    header.setForeground(Color.WHITE); // Màu chữ trắng
    header.setOpaque(true); // Cho phép thay đổi màu nền
    header.setBackground(new Color(0x4567)); // Màu nền xanh lá cây (#4CAF50)
    header.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding cho header

    panel.add(header, BorderLayout.CENTER); // Thêm header vào giữa panel
  }

  public JPanel getPanel() {
    return panel;
  }
}
