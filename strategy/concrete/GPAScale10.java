package concrete;

import java.util.List;

import interfaces.GPAStrategy;
import model.Course;

public class GPAScale10 implements GPAStrategy {
    public float calculateGPA(List<Course> courses) {
        float totalScore = 0;
        int totalCredits = 0;

        for (Course course : courses) {
            if (course.getScore() != null && course.getCredits() != null) {
                totalScore += course.getScore() * course.getCredits();
                totalCredits += course.getCredits();
            }
        }

        // Trả về GPA thang điểm 10
        return totalCredits > 0 ? totalScore / totalCredits : 0;
    }
}
