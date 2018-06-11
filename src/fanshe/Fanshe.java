package fanshe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Fanshe {

    public static void main(String[] args){
        Student student1 = new Student();
        Class studentClass = student1.getClass();
        System.out.println(studentClass.getSimpleName());

        Class studentClass2 = Student.class;
        System.out.println(studentClass == studentClass2);

        try {
            Class stuClass3 = Class.forName("fanshe.Student");//注意此字符串必须是真实路径，就是带包名的类路径，包名.类名
            System.out.println(stuClass3 == studentClass2);//判断三种方式是否获取的是同一个Class对象
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //1.加载Class对象
        try{
            Class clazz = Class.forName("fanshe.Student");

            //2.获取所有公有构造方法
            System.out.println("**********************所有公有构造方法*********************************");
            Constructor[] conArray = clazz.getConstructors();
            for(Constructor c : conArray){
                System.out.println(c);
            }


            System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
            conArray = clazz.getDeclaredConstructors();
            for(Constructor c : conArray){
                System.out.println(c);
            }

            System.out.println("*****************获取公有、无参的构造方法*******************************");
            Constructor con = clazz.getConstructor(null);
            //1>、因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型
            //2>、返回的是描述这个无参构造函数的类对象。

            System.out.println("con = " + con);
            //调用构造方法
            Object obj = con.newInstance();
            //  System.out.println("obj = " + obj);
            //  Student stu = (Student)obj;

            System.out.println("******************获取私有构造方法，并调用*******************************");
            con = clazz.getDeclaredConstructor(char.class);
            System.out.println(con);
            //调用构造方法
            con.setAccessible(true);//暴力访问(忽略掉访问修饰符)
            obj = con.newInstance('男');



            //2.获取字段
            System.out.println("************获取所有公有的字段********************");
            Field[] fieldArray = clazz.getFields();
            for(Field f : fieldArray){
                System.out.println(f);
            }
            System.out.println("************获取所有的字段(包括私有、受保护、默认的)********************");
            fieldArray = clazz.getDeclaredFields();
            for(Field f : fieldArray){
                System.out.println(f);
            }
            System.out.println("*************获取公有字段**并调用***********************************");
            Field f = clazz.getField("name");
            System.out.println("Field::" + f);
            //获取一个对象
            Object obj1 = clazz.getConstructor().newInstance();//产生Student对象--》Student stu = new Student();
            //为字段设置值
            f.set(obj1, "刘德华");//为Student对象中的name属性赋值--》stu.name = "刘德华"
            //验证
            Student stu = (Student)obj1;
            System.out.println("验证姓名：" + stu.name);


            System.out.println("**************获取私有字段****并调用********************************");
            f = clazz.getDeclaredField("phoneNum");
            System.out.println(f);
            f.setAccessible(true);//暴力反射，解除私有限定
            f.set(obj1, "18888889999");
            System.out.println("验证电话：" + stu);





            //2.获取所有公有方法
            System.out.println("***************获取所有的”公有“方法*******************");
            clazz.getMethods();
            Method[] methodArray = clazz.getMethods();
            for(Method m : methodArray){
                System.out.println(m);
            }
            System.out.println("***************获取所有的方法，包括私有的*******************");
            methodArray = clazz.getDeclaredMethods();
            for(Method m : methodArray){
                System.out.println(m);
            }
            System.out.println("***************获取公有的show1()方法*******************");
            Method m = clazz.getMethod("show1", String.class);
            System.out.println(m);
            //实例化一个Student对象
            Object obj2 = clazz.getConstructor().newInstance();
            m.invoke(obj2, "刘德华");

            System.out.println("***************获取私有的show4()方法******************");
            m = clazz.getDeclaredMethod("show4", int.class);
            System.out.println(m);
            m.setAccessible(true);//解除私有限定
            Object result = m.invoke(obj2, 20);//需要两个参数，一个是要调用的对象（获取有反射），一个是实参
            System.out.println("返回值：" + result);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
