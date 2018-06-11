package chapter08;

import org.jetbrains.annotations.NotNull;

public class Chapter08 implements IInterfaceNotNullTest{
    @Override
    public void test(@NotNull String string) {
        System.out.println(string);
    }

    public static void main(String[] args){
        IInterfaceNotNullTest test = new Chapter08();
        test.test(null);
    }
}
