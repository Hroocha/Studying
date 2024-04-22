package tasks.lesson1;

public abstract class Animal {

    String name;

    public Animal(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    abstract public void run(int distance);
    abstract public void swim(int distance);

}
