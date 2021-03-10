package cn.spring.moudle;

public class Student {
    public String name;
    public int age;

    public Student(){}

    public Student(String name , int age){
        this.name=name;
        this.age=age;;
    }

    public void fun(int i){
        System.out.println(i);
    }
    public void tooo(){
        System.out.println(32);
    }

    @Override
    public String toString ( ) {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName ( ) {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getAge ( ) {
        return age;
    }

    public void setAge (int age) {
        this.age = age;
    }
}
