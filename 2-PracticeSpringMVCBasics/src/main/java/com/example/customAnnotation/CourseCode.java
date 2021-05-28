package com.example.customAnnotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    //defining default course code
    public String value() default "SUP";

    //defining default error message
    public String message() default "must start with SUP";

    //defining default groups
    public Class<?>[] groups() default {};

    //defining default payloads
    public Class<? extends Payload>[] payload() default{};
}
