import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students= new ArrayList<>();
        String name;
        float grade;
        float sum = 0;
        System.out.print("enter number of students : ");
        int num =  scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < num ; i++)
        {
          System.out.print("enter student name : ");
          name = scanner.nextLine();
          System.out.print("enter student grade : ");
          grade = scanner.nextFloat();
          scanner.nextLine();
          students.add(new Student(grade,name));
        }
        System.out.println();
        for (Student student:students)
            System.out.println(student);
        System.out.println();
        for(Student student : students)
            sum += student.getGrade();
        System.out.println("average of scores : "+String.format("%.2f", (sum / num)) );
        Collections.sort(students, Comparator.comparing(Student::getGrade));
        System.out.println("lowest score : " + "\n" + students.getFirst());
        System.out.println("highest score : " + "\n" + students.getLast());
        }

}