package tasks.lesson4;

public class Main {

    /*
    1. Написать метод, который меняет два (указанных по индексу) элемента массива местами (массив может быть любого
ссылочного типа).
    2. Написать метод, который преобразует массив в ArrayList.(того же типа что и входящий массив)

    3. Задача:
  a. Даны классы Fruit -> Apple, Orange.
  b.  Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу
фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины.
  c. Для хранения фруктов внутри коробки можно использовать ArrayList.
  d. Написать метод getWeight(), который высчитывает вес коробки. Задать вес одного
фрукта и их количество: вес яблока — 1.0f, апельсина — 1.5f (единицы измерения не
важны).
  e. Внутри класса Box написать метод compare(), который позволяет сравнить текущую
коробку с той, которую подадут в compare() в качестве аргумента. true, если их массы
равны, false — в противном случае. Можно сравнивать коробки с яблоками и
апельсинами.
  f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
Помним про сортировку фруктов: нельзя высыпать яблоки в коробку с апельсинами.
Соответственно, в текущей коробке фруктов не остаётся, а в другую перекидываются
объекты, которые были в первой.
  g. Не забываем про метод добавления фрукта в коробку.
*/

    public static void main(String[] args) {

//        Array <Integer> tasks.array = new Array<>();
//        Integer [] ar = {1,12,2,3,4};
//        tasks.array.changeElements(ar,1,4);
//        ArrayList <Integer> ttt = tasks.array.arrayToArrayList(ar);
//        System.out.println(ttt.size());
//        System.out.println(ttt);

        Box <Apple> box1 = new Box<>(1.1f);
        Box box2 = new Box<>(1.1f);
        Box box3 = new Box<>(1.1f);
        Box box4 = new Box<>(1.1f);

        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();

        box1.addFruit(apple1);
        box1.addFruit(apple2);
        box2.addFruit(orange1);
        box1.boxChange(box3);
        box3.print();
        System.out.println(box2.getWeight());
        System.out.println(box1.compare(box4));

    }




}
