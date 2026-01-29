package org.example;

public class Main {
    public static void main(String[] args) {

        Person p1 = new Person();

        p1.age = 20;
        p1.name = "홍길동";
        p1.home = "서울";
        p1.height = 180.5;
        p1.introduce();
        p1.addage();
        p1.introduce();

    }

}

class Person {
    int age;
    String name;
    String home;
    double height;

    public void introduce() {
        System.out.println("나이: " + age + " 이름: " + name + " 사는 곳: " + home + " 키: " + height);
    }

    public void addage(){
        age++;
    }
}