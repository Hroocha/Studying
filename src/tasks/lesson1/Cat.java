package tasks.lesson1;

public class Cat extends Animal{

    public Cat(String name){
        super(name);
    }
    @Override
    public void run (int distance){
        if (distance > 200){
            System.out.println(getName() + " не пробежал");
        } else System.out.println(getName() + " пробежал " + distance + " м");
    }
    @Override
    public void swim (int distance){
        System.out.println(getName() + " не умеет плавать");
    }
}
