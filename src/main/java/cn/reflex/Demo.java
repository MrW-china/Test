package cn.reflex;

import cn.spring.moudle.Student;


import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Demo {
    public static void main (String[] args) throws Exception {
        Class<Student> studentClass=Student.class;
//        System.out.println(studentClass);
/*
        Student student=new Student();
        Class<? extends Student> aClass = student.getClass();
        System.out.println(aClass==studentClass);

        Class<?> aClass1 = Class.forName("cn.spring.moudle.Student");
        System.out.println(aClass1);*/
        Constructor<?>[] constructors = studentClass.getConstructors();
        for (Constructor c:constructors){
            System.out.println(c);
        }
        System.out.println();
        Constructor<?>[] declaredConstructors = studentClass.getDeclaredConstructors();
        for (Constructor c:declaredConstructors){
            System.out.println(c);
        }
        System.out.println();
        Constructor<Student> constructor = studentClass.getConstructor(String.class,int.class);
        System.out.println(constructor);
        constructor.setAccessible(true);
//        Object student = constructor.newInstance("申利宁",12);
        Student student1 = constructor.newInstance("123",1234);
        System.out.println(student1);

        System.out.println("----------------------");
        //获取成员变量
        Class<?> clas = Class.forName("cn.spring.moudle.Student");
//        Field[] fields = clas.getFields();
//        for (Field f:fields){
//            System.out.println(f);
//        }
        Field name = clas.getField("name");
        System.out.println(name);
        Constructor<?> constructor1 = clas.getConstructor();
        Object o = constructor1.newInstance();
        name.set(o,"123");
        System.out.println(o);
        Field age = clas.getField("age");
        age.set(o,123);
        System.out.println(o);

        System.out.println("-------------------------------");
        //成员方法

        Class<Student> cc = Student.class;
        Method fun = cc.getMethod("fun",int.class);
        System.out.println(fun);
        Constructor<Student> constructor2 = cc.getConstructor();
        Student student = constructor2.newInstance();
        fun.invoke(student,2);

        //集合反射
        System.out.println("----------------------------");
//        List<String> list=new ArrayList<>();
        Class<ArrayList> aClass = ArrayList.class;
//        Class<? extends List> aClass = list.getClass();
        Method add = aClass.getMethod("add", Object.class);
        Constructor<? extends List> listC = aClass.getConstructor();
        List list1 = listC.newInstance();
        add.invoke(list1,"nmsl");
        add.invoke(list1,"wsnd");
        System.out.println(list1);

        //配置文件
        System.out.println("-------------------");

        Properties properties=new Properties();
        FileReader fileReader=new FileReader("D:\\jdbc.properties");
        properties.load(fileReader);

        fileReader.close();
        String property = properties.getProperty("jdbc.driver");
        System.out.println(property);
    }
}
