package cn.reflex;

import cn.spring.moudle.Student;

import java.lang.reflect.Constructor;

public class Demo2 {
    public static void main (String[] args) throws Exception{
        Class<? extends Student> nmsl = new Student("nmsl", 123).getClass();
        System.out.println(nmsl);
        Constructor<? extends Student> constructor = nmsl.getConstructor(String.class, int.class);
        System.out.println(constructor);
        Student student = constructor.newInstance("nmsl",123);
        System.out.println(student);
    }
}
