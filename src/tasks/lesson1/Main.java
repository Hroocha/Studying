package tasks.lesson1;

public class Main {

    public static void main(String[] args) {


        Animal[] animals = {
                new Tiger("Полосач"),
                new Cat("Барсик"),
                new Dog("Бобик"),
                new DomesticCat("Мурчик"),
        };
        int countAnimals = 0;
        int countDomesticCats = 0;
        int countDogs = 0;
        int countTigers = 0;

        for (Animal o : animals) {
            o.run(100);
            o.swim(5);
            countAnimals++;
            if (o instanceof DomesticCat) {
                countDomesticCats++;
            } else if (o instanceof Dog) {
                countDogs++;
            } else if (o instanceof Tiger) {
                countTigers++;
            }
        }
        System.out.println("Всего животных: " + countAnimals);
        System.out.println("Домашних кошек: " + countDomesticCats);
        System.out.println("Собак: " + countDogs);
        System.out.println("Тигров: " + countTigers);
    }
}
