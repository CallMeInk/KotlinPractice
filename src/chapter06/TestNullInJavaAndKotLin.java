package chapter06;

class TestNullJavaAndKotlin{
    public TestNullJavaAndKotlin(){

    }

    public static void main(String[] args){
        String message = null;
        new NullTest(1).printString(message);
    }

}
