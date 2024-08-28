package ui;

import javax.swing.*;
import concrete.MilkTea;
import decorators.BlackSugar;
import decorators.Bubble;
import decorators.EggPudding;
import decorators.FruitPudding;
import decorators.WhiteBubble;
import interfaces.IMilkTea;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Option {
    private JPanel panel;
    private JLabel toppingNotice;
    private static IMilkTea milkTea = new MilkTea();
    private Topping[] toppings = {
        new Topping("WhiteBubble: 0.75$", "WhiteBubble","images/WhiteBubble.jpg"),
        new Topping("Bubble: 0.5$", "Bubble", "images/Bubble.jpg"),
        new Topping("EggPudding: 1.5$", "EggPudding", "images/EggPudding.jpg"),
        new Topping("BlackSugar: 1$", "BlackSugar", "images/BlackSugar.jpg"),
        new Topping("FruitPudding: 1.75$", "FruitPudding", "images/FruitPudding.jpg")
    };
    public Option() {
        panel = new JPanel();
        panel.setBackground(Color.decode("#B0B7C6")); // Màu nền trắng cho panel
        panel.setLayout(new BorderLayout()); // Sử dụng BorderLayout cho panel chính

        // Panel chứa các checkbox
        JPanel checkboxPanel = new JPanel();
        checkboxPanel.setLayout(new GridLayout(toppings.length, 1)); // 5 hàng, 1 cột cho checkbox
        JLabel label = new JLabel("Choose your toppings");
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding cho label
        label.setFont(new Font("Serif", Font.BOLD, 20)); // Font chữ Serif, in đậm, kích thước 20

        // Khởi tạo các JCheckBox và thêm vào checkboxPanel
        JCheckBox[] checkBoxes = new JCheckBox[toppings.length];
        ImageIcon[] images = new ImageIcon[toppings.length];
        for (int i = 0; i < toppings.length; i++) {
            // Create JCheckBox for each topping
            checkBoxes[i] = new JCheckBox(toppings[i].getLabel());// Màu nền trắng cho checkbox
            checkBoxes[i].setFont(new Font("Serif", Font.PLAIN, 16));
            checkBoxes[i].setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
            checkBoxes[i].setActionCommand(toppings[i].getName()); // Set action command for later use
            checkboxPanel.add(checkBoxes[i]); // Thêm checkbox vào panel chứa checkbox
            images[i] = new ImageIcon(toppings[i].getImage());
            Image image = images[i].getImage();
            Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            JLabel picLabel = new JLabel(scaledIcon);
            picLabel.setPreferredSize(new Dimension(100, 100));
            checkboxPanel.add(picLabel);
        }

        panel.add(label, BorderLayout.NORTH); // Thêm label vào phía trên
        panel.add(checkboxPanel, BorderLayout.CENTER); // Thêm panel chứa checkbox vào trung tâm
        panel.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 10)); // Padding cho panel

        // Nút bấm và label kết quả
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout()); // Layout cho các thành phần phía dưới

        JButton orderButton = new JButton("Accept");
        orderButton.setPreferredSize(new Dimension(100, 30));

        JButton resetButton = new JButton("Reset");
        resetButton.setPreferredSize(new Dimension(100, 30));

        JLabel resultLabel = new JLabel("Total cost: 0.00$", JLabel.CENTER);
        JPanel bottomInfoPanel = new JPanel();

        bottomInfoPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        bottomInfoPanel.add(resetButton);
        bottomInfoPanel.add(orderButton);
        bottomInfoPanel.add(resultLabel);
        bottomInfoPanel.setBackground(Color.decode("#B0B7C6")); // Màu nền trắng cho panel chứa nút và label kết quả
        bottomPanel.add(bottomInfoPanel, BorderLayout.NORTH); // Thêm panel chứa nút và label kết quả vào phía trên
        resultLabel.setFont(new Font("Serif", Font.BOLD, 16));

        panel.add(bottomPanel, BorderLayout.SOUTH); // Thêm panel chứa nút và label kết quả vào phía dưới

        // Action listener cho nút "Accept"
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                milkTea = new MilkTea(); // Reset milkTea

                // Duyệt qua từng JCheckBox để tính tổng chi phí
                for (JCheckBox checkBox : checkBoxes) {
                    if (checkBox.isSelected()) {
                        Topping topping = getToppingByName(checkBox.getActionCommand());
                        if (topping != null) {
                            // Cập nhật milkTea với các topping đã chọn
                            switch (topping.getName()) {
                                case "WhiteBubble":
                                    milkTea = new WhiteBubble(milkTea);
                                    break;
                                case "Bubble":
                                    milkTea = new Bubble(milkTea);
                                    break;
                                case "EggPudding":
                                    milkTea = new EggPudding(milkTea);
                                    break;
                                case "BlackSugar":
                                    milkTea = new BlackSugar(milkTea);
                                    break;
                                case "FruitPudding":
                                    milkTea = new FruitPudding(milkTea);
                                    break;
                            }
                        }
                    }
                }

                // Cập nhật toppingNotice và kết quả chi phí
                if (toppingNotice != null) {
                    bottomPanel.remove(toppingNotice);
                }
                toppingNotice = new JLabel(
                        "<html><b>Your current toppings:</b> " + milkTea.getDescription().toString() + "</html>");
                toppingNotice.setFont(new Font("Serif", Font.PLAIN, 16));
                toppingNotice.setForeground(Color.BLACK);
                toppingNotice.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                bottomPanel.add(toppingNotice, BorderLayout.SOUTH);

                resultLabel.setText(String.format("Total cost: %.2f$", milkTea.Cost()));
                panel.revalidate();
                panel.repaint();
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Bỏ chọn tất cả các checkbox
                for (JCheckBox checkBox : checkBoxes) {
                    checkBox.setSelected(false);
                }
                // Xóa toppingNotice và cập nhật lại kết quả chi phí
                if (toppingNotice != null) {
                    bottomPanel.remove(toppingNotice);
                    toppingNotice = null;
                }
                resultLabel.setText("Total cost: 0.00$");
                panel.revalidate();
                panel.repaint();
            }
        });
    }

    private Topping getToppingByName(String name) {
        for (Topping topping : toppings) {
            if (topping.getName().equals(name)) {
                return topping;
            }
        }
        return null;
    }

    public JPanel getPanel() {
        return panel;
    }
}
