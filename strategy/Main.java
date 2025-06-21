import context.GPAContext;
import concrete.*;
import model.Course;
import ui.UI;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Đọc danh sách khóa học từ file
        List<Course> courses = readCoursesFromFile("points.txt");

        // Tạo context
        GPAContext context = new GPAContext();

        // Tính GPA theo thang điểm 10
        context.setStrategy(new GPAScale10());
        float gpa10 = context.calculateGPA(courses);

        // Tính GPA theo thang điểm 4
        context.setStrategy(new GPAScale4());
        float gpa4 = context.calculateGPA(courses);

        // Hiển thị UI
        new UI(courses, gpa10, gpa4);
    }

    private static List<Course> readCoursesFromFile(String filePath) {
        List<Course> courses = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Bỏ qua dòng không phải thông tin khóa học
                if (!line.matches("[A-Z]{2}\\d{4}.*")) {
                    continue;
                }

                // Xử lý dòng thông tin khóa học
                String[] parts = line.split("\\|");
                // Dùng trim() cho từng phần tử để loại bỏ khoảng trắng

                for (int i = 0; i < parts.length; i++) {
                    parts[i] = parts[i].trim();
                }
                if (parts[2].contains("-") || parts[4].contains("-")) {
                    continue;
                }
                String code = parts[0];
                String name = parts[1];
                Integer credits = Integer.parseInt(parts[2]);
                Float score = Float.parseFloat(parts[4]);
                courses.add(new Course(code, name, credits, score));
            }

            System.out.println("Read " + courses.size() + " courses from the file.");

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }

        return courses;
    }
}