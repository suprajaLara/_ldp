package Assignment12;

import java.util.ArrayList;
import java.util.List;

public class Assignment12 {
    public static void main(String[] args) {
        StudentDataUsingStreamApi studentData = new StudentDataUsingStreamApi();
        studentData.setStudentsList();
        //1
        studentData.printAllDepartments();
        //2
        studentData.getStudentsEnrolledAfterYear(2018);
        //3
        studentData.getStudentsOfGivenGenderAndOfGivenDepartment("Male", "Computer Science");
        //4
        studentData.getNumberOfMaleAndFemale();
        //5
        studentData.getAverageAgeOfMaleAndFemale();
        //6
        studentData.getStudentWithHighestPercentage();
        //7
        studentData.getStudentsPerDepartment();
        //8
        studentData.getAveragePercentInEachDepartment();
        //9
        studentData.getYoungestMaleInGivenDept("Electronic");
        //10
        studentData.getNumberOfFemaleMaleInGivenDept("Computer Science");
    }
}
