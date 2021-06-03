package springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exception){
        //create StudentErrorResponse
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        studentErrorResponse.setMessage(exception.getMessage());
        studentErrorResponse.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(studentErrorResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception){
        //create StudentErrorResponse
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        studentErrorResponse.setMessage(exception.getMessage());
        studentErrorResponse.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(studentErrorResponse,HttpStatus.NOT_FOUND);
    }
}
