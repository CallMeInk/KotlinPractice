package AnnotationPractice;

public class AnnotationMain {

    public static void main(String args[]){

    }

    class LoginTest{
        @Login(username = "anotherUsername", password = "anotherPassword")
        public void login(){

        }
    }

}
