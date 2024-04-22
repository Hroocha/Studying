package tasks.lesson7;

import java.util.concurrent.Semaphore;

import static tasks.lesson7.Main.CARS_COUNT;

public class Tunnel extends Stage {
    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
final Semaphore smp = new Semaphore(CARS_COUNT/2);



    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " готовится к этапу(ждет): " +
                    description);
            smp.acquire();
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000L);
            System.out.println(c.getName() + " закончил этап: " +
                    description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } smp.release();


    }

}
