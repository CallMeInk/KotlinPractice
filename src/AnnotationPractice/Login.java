package AnnotationPractice;

public @interface Login {

    String username() default "username";
    String password() default "password";

}
