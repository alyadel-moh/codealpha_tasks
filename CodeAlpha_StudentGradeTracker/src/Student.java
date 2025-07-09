public class Student {
    private String name;
    private float grade;

    public Student(float grade, String name) {
        this.grade = grade;
        this.name = name;
    }

    public float getGrade() {
        return grade;
    }
    public void setGrade(float grade) {
        this.grade = grade;
    }
    @Override
    public String toString() {
        return "name : " + name + "  " + "grade : " + grade;
    }
}
