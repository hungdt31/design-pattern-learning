package concrete;

import java.util.List;

import interfaces.GPAStrategy;
import model.Course;

public class GPAScale4 implements GPAStrategy {
    @Override
    public float calculateGPA(List<Course> courses) {
        float totalScore = 0;
        int totalCredits = 0;

        for (Course course : courses) {
            if (course.getScore() != null && course.getCredits() != null) {
                // Chuyển đổi điểm từ thang 10 sang thang 4
                float score4 = convertTo4Scale(course.getScore());
                totalScore += score4 * course.getCredits();
                totalCredits += course.getCredits();
            }
        }

        // Trả về GPA thang điểm 4
        return totalCredits > 0 ? totalScore / totalCredits : 0;
    }

    private float convertTo4Scale(float score10) {
        if (score10 >= 8.5)
            return 4.0f;
        else if (score10 >= 8.0)
            return 3.5f;
        else if (score10 >= 7.0)
            return 3.0f;
        else if (score10 >= 6.5)
            return 2.5f;
        else if (score10 >= 5.5)
            return 2.0f;
        else if (score10 >= 5.0)
            return 1.5f;
        else if (score10 >= 4.0)
            return 1.0f;
        else
            return 0.0f;
    }
}
