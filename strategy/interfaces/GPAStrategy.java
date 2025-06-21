package interfaces;

import java.util.List;

import model.Course;

public interface GPAStrategy {
    float calculateGPA(List<Course> courses);
}
