package ui;

import model.Course;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class UI extends JFrame {
    private JTable courseTable;
    private JLabel gpa10Label;
    private JLabel gpa4Label;

    public UI(List<Course> courses, float gpa10, float gpa4) {
        // Thiết lập cửa sổ chính
        setTitle("Student score management");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Sử dụng BorderLayout cho frame chính
        setLayout(new BorderLayout(10, 10));

        // Panel hiển thị GPA
        JPanel gpaPanel = createGPAPanel(gpa10, gpa4);
        add(gpaPanel, BorderLayout.NORTH);

        // Panel hiển thị danh sách môn học
        JPanel coursePanel = createCoursePanel(courses);
        add(coursePanel, BorderLayout.CENTER);

        // Hiển thị cửa sổ
        setVisible(true);
    }

    private JPanel createGPAPanel(float gpa10, float gpa4) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
        panel.setBorder(BorderFactory.createTitledBorder("GPA information"));

        // Hiển thị GPA thang 10
        gpa10Label = new JLabel(String.format("GPA on 10th scale: %.2f", gpa10));
        gpa10Label.setFont(new Font("Arial", Font.BOLD, 16));
        gpa10Label.setForeground(new Color(0, 102, 204));
        panel.add(gpa10Label);

        // Hiển thị GPA thang 4
        gpa4Label = new JLabel(String.format("GPA on 4th scale: %.2f", gpa4));
        gpa4Label.setFont(new Font("Arial", Font.BOLD, 16));
        gpa4Label.setForeground(new Color(0, 153, 0));
        panel.add(gpa4Label);

        return panel;
    }

    private JPanel createCoursePanel(List<Course> courses) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("List of subjects"));

        // Tạo model cho bảng
        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép chỉnh sửa dữ liệu
            }
        };

        // Thêm các cột
        tableModel.addColumn("Subject code");
        tableModel.addColumn("Subject name");
        tableModel.addColumn("Number of credits");
        tableModel.addColumn("Score");

        // Thêm dữ liệu từ danh sách courses
        for (Course course : courses) {
            tableModel.addRow(new Object[] {
                    course.getCode(),
                    course.getName(),
                    course.getCredits(),
                    course.getScore()
            });
        }

        // Tạo JTable với model
        courseTable = new JTable(tableModel);
        courseTable.setRowHeight(25);
        courseTable.setFont(new Font("Arial", Font.PLAIN, 14));

        // Thiết lập header của bảng
        courseTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        courseTable.getTableHeader().setReorderingAllowed(false);

        // Thêm table vào scrollpane
        JScrollPane scrollPane = new JScrollPane(courseTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }
}