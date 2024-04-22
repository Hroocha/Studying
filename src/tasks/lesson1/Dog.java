package tasks.lesson1;

public class Dog extends Animal{
    public Dog(String name) {
        super(name);
    }

    public void run (int distance){
        if (distance > 500){
            System.out.println(getName() + " не пробежал");
        } else System.out.println(getName() + " пробежал " + distance + " м");
    }

    @Override
    public void swim (int distance){
        if (distance > 10){
            System.out.println(getName() + " не проплыл");
        } else System.out.println(getName() + " проплыл " + distance + " м");
    }

}
