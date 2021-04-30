package Assignment12;

import java.util.*;
import java.util.stream.Collectors;

public class StudentDataUsingStreamApi {

    List<Student> studentsList;
    public StudentDataUsingStreamApi(){
        studentsList = new ArrayList<>();
    }

    //initialize students list
    public void setStudentsList(){
        studentsList.add(new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8));
        studentsList.add(new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2));
        studentsList.add(new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3));
        studentsList.add(new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80));
        studentsList.add(new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70));
        studentsList.add(new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70));
        studentsList.add(new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70));
        studentsList.add(new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80));
        studentsList.add(new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85));
        studentsList.add(new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82));
        studentsList.add(new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83));
        studentsList.add(new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4));
        studentsList.add(new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6));
        studentsList.add(new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8));
        studentsList.add(new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4));
        studentsList.add(new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4));
        studentsList.add(new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5));
    }

    // 1: Name of all departments
    public void printAllDepartments(){
        List<String> departmentList = studentsList.stream()
                .map(student -> student.getDept())
                .distinct().collect(Collectors.toList());
        System.out.println("Departments list: ");
        System.out.println(departmentList);
    }

    // 2: Names of all students enrolled after given year
    public void getStudentsEnrolledAfterYear(int year){
        List<String> studentsEnrolled = studentsList.stream()
                .filter(student -> student.getYearOfEnrollment() >year)
                .map(student -> student.getName())
                .collect(Collectors.toList());
        System.out.println("\nStudent names, who enrolled after "+year+" are:");
        System.out.println(studentsEnrolled);
    }

    // 3: Details of male students in Computer Science Department
    public void getStudentsOfGivenGenderAndOfGivenDepartment(String gender, String department){
        System.out.println("\nStudents of, gender-"+gender+" and department-"+department+", are:");
        studentsList.stream()
                .filter(student -> student.getGender().equals(gender) && student.getDept().equals(department))
                .forEach(System.out::println);
        // or   .forEach(student -> System.out.println(student));
    }

    // 4: Number of Male and female students using groupingBy
    public void getNumberOfMaleAndFemale(){
        Map<String, Long> eachGenderCount = studentsList.stream()
                .collect(Collectors.groupingBy(student -> student.getGender(), Collectors.counting()));
        System.out.println("\nNumber of students of each gender are:");
        System.out.println(eachGenderCount);
    }

    // 5: Average age of male and female students
    public void getAverageAgeOfMaleAndFemale(){
        Map<String,Double> avgAgeMap = studentsList.stream()
                .collect(Collectors.groupingBy(Student::getGender,Collectors.averagingInt(Student::getAge)));
        System.out.println("\nAverage age is:\n"+avgAgeMap);
    }

    // 6: Details of student having Highest Percentage
    public void getStudentWithHighestPercentage(){
        Student student = studentsList.stream()
                .max(Comparator.comparingDouble(Student::getPerTillDate))
                .get();
        System.out.println("\nStudent with highest percentage: ");
        System.out.println(student);
    }

    // 7: Count of students in each department
    public void getStudentsPerDepartment(){
        Map<String,Long> studentPerDeptCountMap = studentsList.stream()
                .collect(Collectors.groupingBy(Student::getDept,Collectors.counting()));
        System.out.println("\nNumber of students in each department are : ");
        System.out.println(studentPerDeptCountMap);
    }

    // 8: Average percentage achieved in each department
    public void getAveragePercentInEachDepartment(){
        Map<String,Double> deptPercentMap = studentsList.stream()
                .collect(Collectors.groupingBy(Student::getDept
                        ,Collectors.averagingDouble(Student::getPerTillDate)));
        System.out.println("\nAverage of percentages in each department are  :");
        System.out.println(deptPercentMap);
    }

    // 9: Youngest male student in Electronic department
    public void getYoungestMaleInGivenDept(String department){
        Student student = studentsList.stream()
                .filter(student1 -> student1.getDept().equals(department) && student1.getGender().equals("Male"))
                .min(Comparator.comparingInt(Student::getAge))
                .get();
        System.out.println("\nYoungest Male student in " + department +" department is: ");
        System.out.println(student);
    }

    // 10: Number of male and female students in given dept
    public void getNumberOfFemaleMaleInGivenDept(String department){
        Map<String,Long> genderCountMap = studentsList.stream()
        .filter(student -> student.getDept().equals(department))
        .collect(Collectors.groupingBy(Student::getGender,Collectors.counting()));
        System.out.println("\nNumber of male and female in " + department + " department are: ");
        System.out.println(genderCountMap);
    }

}
