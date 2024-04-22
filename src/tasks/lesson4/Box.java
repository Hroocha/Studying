package tasks.lesson4;

import java.util.ArrayList;

public class Box <T extends Fruit>  {
    private final float boxWeight;
    private final ArrayList <T> arrayInBox;


    public Box(float boxWeight) {
        this.boxWeight = boxWeight;
        arrayInBox = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        arrayInBox.add(fruit);
    }

    public float getWeight(){
        if (arrayInBox.isEmpty()){
            return this.boxWeight;
        }
        return boxWeight + arrayInBox.size() * arrayInBox.get(0).getWeight();
    }

    public boolean compare(Box<?> box){
        return this.getWeight() - box.getWeight() == 0;
    }

    public void boxChange(Box<T> box){
            box.arrayInBox.addAll(this.arrayInBox);
            this.arrayInBox.clear();
    }

    public void print(){
        for (Fruit f: this.arrayInBox) {
            System.out.println(f.getClass());
        }
    }

}
