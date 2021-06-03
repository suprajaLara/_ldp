package springdemo.rest;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springdemo.entity.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> studentList;

    //define @PostConstruct to load the student data only ONCE
    @PostConstruct  //DON'T USE - "import jakarta.annotation.PostConstruct;
    public void loadData(){
        studentList = new ArrayList<>();
        studentList.add(new Student("Poornima","Patel"));
        studentList.add(new Student("Mario","Rossi"));
        studentList.add(new Student("Mary","Smith"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentList;
    }

    //define endpoint for "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){ //@pathVariable is to bind {studentId} with parameter studentId
        //check student id against list size
        if((studentId >= studentList.size()) || (studentId<0)){
            throw new StudentNotFoundException("Student id not found: "+studentId);
        }
        return studentList.get(studentId);
    }

//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(Exception exception){
//        //create StudentErrorResponse
//        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
//        studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
//        studentErrorResponse.setMessage(exception.getMessage());
//        studentErrorResponse.setTimeStamp(System.currentTimeMillis());
//
//        //return ResponseEntity
//        return new ResponseEntity<>(studentErrorResponse,HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception){
//        //create StudentErrorResponse
//        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
//        studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
//        studentErrorResponse.setMessage(exception.getMessage());
//        studentErrorResponse.setTimeStamp(System.currentTimeMillis());
//
//        //return ResponseEntity
//        return new ResponseEntity<>(studentErrorResponse,HttpStatus.NOT_FOUND);
//    }
}
