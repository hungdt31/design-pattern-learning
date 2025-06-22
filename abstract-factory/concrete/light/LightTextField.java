package concrete.light;

import interfaces.TextField;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Trường nhập liệu kiểu Light theme để nhập/hiển thị tên người dùng
 */
public class LightTextField implements TextField {
    private JPanel textFieldPanel;
    private JTextField textField;
    private JButton editButton;
    private JButton cancelButton;
    private String userName = "Nguyen Van A";
    private boolean isEditing = false;
    
    @Override
    public JComponent render() {
        textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new BorderLayout(5, 0));
        textFieldPanel.setOpaque(false);
        
        // Tạo text field
        textField = new JTextField(userName);
        textField.setPreferredSize(new Dimension(200, 30));
        textField.setBackground(new Color(255, 255, 255));
        textField.setForeground(new Color(30, 30, 30));
        textField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(180, 180, 180), 1),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        textField.setEditable(false); // Mặc định không cho phép chỉnh sửa
        
        // Tạo panel chứa các nút chỉnh sửa
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 0));
        buttonPanel.setOpaque(false);
        
        // Nút Edit
        editButton = new JButton("Edit");
        editButton.setFocusPainted(false);
        editButton.setBackground(new Color(240, 240, 240));
        editButton.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        
        // Nút Cancel
        cancelButton = new JButton("Cancel");
        cancelButton.setFocusPainted(false);
        cancelButton.setBackground(new Color(240, 240, 240));
        cancelButton.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
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
                    JOptionPane.showMessageDialog(textFieldPanel, "Saved name: " + userName);
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