package tasks.lesson8;

public class Person {
//    enum Position {
//        ENGINEER, DIRECTOR, MANAGER;
//    }
    private final String name;
    private final int age;
    private final int salary;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }



    public Person(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}
