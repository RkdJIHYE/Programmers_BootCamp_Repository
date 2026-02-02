package org.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person(1, "Alice", 20, 'F'));
        people.add(new Person(4, "Bob", 25, 'M'));
        people.add(new Person(3, "David", 35, 'M'));


        // 조건에 맞는 Person 객체가 없을 수도 있기 때문에 바로 Person 반환이 안된다. Optional을 통해 null처리 강제
        Optional<Person> target = people.stream()
                .filter(p -> p.getId() == 3)
                .findFirst();

        if(target.isPresent()) {
            Person realTarget = target.get();
            System.out.println(realTarget.getName());
        }

        Person target2 = people.stream()
                .filter(p -> p.getId() == 3)
                .findFirst()
                .orElseThrow(); // 없으면 예외를 발생시킬 수도 있다.

    }
}

class Person {
    private int id;
    private String name;
    private int age;
    private char gender;

    public Person(int id, String name, int age, char gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }
}