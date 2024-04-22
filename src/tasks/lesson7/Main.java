package tasks.lesson7;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {
    /*Все участники должны стартовать одновременно, несмотря на разное время подготовки. В тоннель не
может одновременно заехать больше половины участников (условность).
Попробуйте все это синхронизировать.
Когда все завершат гонку, нужно выдать объявление об окончании.
Можно корректировать классы (в том числе конструктор машин) и добавлять объекты классов из
пакета util.concurrent.
Обязательно необходимо объявить победителя гонки, он должен быть только один, и это участник
первым закончивший последний этап.
    */

    // превая цель: чтобы все стартовали одновременно
    // может вынести подготовку в отдельный метод, или в рэйсе сделать сначала подготовку
    /* пул потоков будет в тоннеле? неа, нужен Semaphore
    для завершения гонки будем ловить первый законченный тред
    * */

    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        CyclicBarrier cyc = new CyclicBarrier(CARS_COUNT + 1);
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));     // создали трассу
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {                                         // создали машины
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cyc);
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        for (int i = 0; i < cars.length; i++) {
            new Thread (cars[i]).start();
        }
        try {
            cyc.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            cyc.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }


    }

}
