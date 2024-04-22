package tasks.lesson9;

@Table(title = "Students")
public class Students {
    @Column
    String name;
    @Column
    int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Students(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
