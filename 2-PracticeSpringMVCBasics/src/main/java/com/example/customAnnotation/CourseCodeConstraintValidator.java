package com.example.customAnnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode,String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode courseCode) {
        coursePrefix = courseCode.value();
    }

    @Override
    public boolean isValid(String userEnteredCode, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;
        if(userEnteredCode!=null) {
            result = userEnteredCode.startsWith(coursePrefix);
        }
        else{
            result = true;
        }
        return result;
    }
}
