package concrete.dark;

import interfaces.TextField;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Trường nhập liệu kiểu Dark theme để nhập/hiển thị tên người dùng
 */
public class DarkTextField implements TextField {
    private JPanel textFieldPanel;
    private JTextField textField;
    private JButton editButton;
    private JButton cancelButton;
    private String userName = "Nguyen Van B";
    private boolean isEditing = false;
    
    @Override
    public JComponent render() {
        textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new BorderLayout(8, 0));
        textFieldPanel.setOpaque(false);
        
        // Tạo text field
        textField = new JTextField(userName);
        textField.setPreferredSize(new Dimension(200, 32));
        textField.setBackground(new Color(50, 53, 55));
        textField.setForeground(new Color(230, 230, 230));
        textField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(80, 80, 80), 1),
            BorderFactory.createEmptyBorder(6, 8, 6, 8)
        ));
        textField.setCaretColor(Color.WHITE);
        textField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        textField.setEditable(false); // Mặc định không cho phép chỉnh sửa
        
        // Tạo panel chứa các nút chỉnh sửa
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 0));
        buttonPanel.setOpaque(false);
        
        // Nút Edit
        editButton = new JButton("Edit");
        editButton.setFocusPainted(false);
        editButton.setBackground(new Color(40, 40, 45));
        // editButton.setForeground(new Color(250, 250, 250));
        editButton.setForeground(Color.BLUE);
        editButton.setBorder(BorderFactory.createLineBorder(new Color(60, 60, 70), 1));
        editButton.setPreferredSize(new Dimension(60, 32));
        
        // Nút Cancel
        cancelButton = new JButton("Cancel");
        cancelButton.setFocusPainted(false);
        cancelButton.setBackground(new Color(45, 45, 50));
        // cancelButton.setForeground(new Color(250, 250, 250));
        cancelButton.setForeground(Color.BLUE);
        cancelButton.setBorder(BorderFactory.createLineBorder(new Color(60, 60, 70), 1));
        cancelButton.setPreferredSize(new Dimension(70, 32));
        cancelButton.setVisible(false); // Ẩn nút Cancel khi không trong chế độ chỉnh sửa
        
        // Thêm các nút vào panel
        buttonPanel.add(editButton);
        buttonPanel.add(cancelButton);
        
        // Thêm các thành phần vào panel chính
        textFieldPanel.add(textField, BorderLayout.CENTER);
        textFieldPanel.add(buttonPanel, BorderLayout.EAST);
        
        // Thiết lập sự kiện cho nút Edit
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isEditing) {
                    // Bắt đầu chỉnh sửa
                    isEditing = true;
                    textField.setEditable(true);
                    textField.requestFocus();
                    editButton.setText("Save");
                    cancelButton.setVisible(true);
                } else {
                    // Lưu chỉnh sửa
                    isEditing = false;
                    textField.setEditable(false);
                    userName = textField.getText();
                    editButton.setText("Edit");
                    cancelButton.setVisible(false);
                    
                    // Tạo JOptionPane với giao diện tối
                    UIManager.put("OptionPane.background", new Color(50, 50, 50));
                    UIManager.put("Panel.background", new Color(50, 50, 50));
                    UIManager.put("OptionPane.messageForeground", Color.WHITE);
                    
                    JOptionPane optionPane = new JOptionPane(
                        "Saved name: " + userName,
                        JOptionPane.INFORMATION_MESSAGE
                    );
                    
                    JDialog dialog = optionPane.createDialog("Notification");
                    dialog.setVisible(true);
                }
            }
        });
        
        // Thiết lập sự kiện cho nút Cancel
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hủy chỉnh sửa, khôi phục giá trị cũ
                isEditing = false;
                textField.setEditable(false);
                textField.setText(userName);
                editButton.setText("Edit");
                cancelButton.setVisible(false);
            }
        });
        
        return textFieldPanel;
    }

    @Override
    public void setUserName(String name) {
        this.userName = name;
        if (textField != null) {
            textField.setText(name);
        }
    }

    @Override
    public String getUserName() {
        return userName;
    }
} 