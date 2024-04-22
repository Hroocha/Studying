package tasks.lesson7;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private final Race race;
    private final int speed;
    private final String name;
    private final CyclicBarrier wait;
    private final static Object monitor = new Object();
    private volatile static Boolean winner = false;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CyclicBarrier wait) {
        this.wait = wait;
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }


    @Override
    public void run() {

        try {

            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            wait.await();

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        synchronized (monitor){
            if (!winner){
                winner = true;
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Победил: " + getName());
            }
        }

        try {
            wait.await();
        }catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }


}
