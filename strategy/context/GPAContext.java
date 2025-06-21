package context;

import interfaces.GPAStrategy;
import java.util.List;
import model.Course;

public class GPAContext {
    private GPAStrategy strategy;
    
    public void setStrategy(GPAStrategy strategy) {
        this.strategy = strategy;
    }
    
    public float calculateGPA(List<Course> courses) {
        return strategy.calculateGPA(courses);
    }
}