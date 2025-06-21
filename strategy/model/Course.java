package model;

public class Course {
    private String code;
    private String name;
    private Integer credits;
    private Float score;
    
    public Course(String code, String name, Integer credits, Float score) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.score = score;
    }
    
    // Getters và setters
    public String getCode() {
        return code;
    }
    
    public String getName() {
        return name;
    }
    
    public Integer getCredits() {
        return credits;
    }
    
    public Float getScore() {
        return score;
    }
    
    @Override
    public String toString() {
        return code + name + credits + " - " + 
               (score != null ? String.format("%.2f", score) : "N/A");
    }
}
