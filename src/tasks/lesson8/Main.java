package tasks.lesson8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    /*1. Создайте массив с набором слов, и с помощью Stream API найдите наиболее часто
встречающееся;
2. Создайте массив объектов типа Сотрудник (с полями Имя, Возраст, Зарплата) и вычислите
среднюю зарплату сотрудника;
3. Напишите метод, способный найти в массиве сотрудников из п. 2 найдите N самых старших
сотрудников и отпечатает в консоль сообщение вида “N самых старших сотрудников зовут:
имя1, имя2, имяN;”.
*/

    public static void main(String[] args) {
        // задание №1
        String [] arr = new String [] {"A", "A", "B", "C", "D", "A", "AAA", "SC", "C", "AA"};
        String word = Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().
                stream().max(Comparator.comparing(n -> n.getValue())).get().getKey();
                System.out.println("Наиболее часто встречающееся слово: " + word);
        // задание №2
        Person [] persons = new Person[]{
                new Person("Евгений", 46, 100000),
                new Person("Павел", 30, 65000),
                new Person("Игнат", 27, 40000),
                new Person("Михаил", 34, 79000)
        };
        OptionalDouble averageSalary = Arrays.stream(persons).mapToInt(Person::getSalary).average();
        System.out.println(averageSalary);

        // задание №3

        int n = persons.length / 2;
        Main main = new Main();
        main.oldestPerson(persons,2);
    }

    public void oldestPerson(Person[] persons, int n) {
        List<String> oldest = Arrays.stream(persons).sorted(Comparator.comparingInt(Person::getAge).reversed())
                .limit(n).map(Person::getName).collect(Collectors.toList());
        System.out.println(n + " самых старших сотрудников зовут: " + oldest);

    }

}
