package tasks.lesson5;

public class Main {

    /*
    1 Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и
вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
Посчитать, сколько раз встречается каждое слово.
    2 Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
телефонных номеров. В этот телефонный справочник с помощью метода add() можно
добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует
учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
тогда при запросе такой фамилии должны выводиться все телефоны. Желательно не добавлять
лишний функционал (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем
через консоль и т.д). Консоль использовать только для вывода результатов проверки телефонного
справочника.
*/

    public static void main(String[] args) {

//        Task1 test = new Task1();
//        test.magicWithHashMap();

        Phonebook phonebook = new Phonebook();
        phonebook.add(94357348, "Смирнов");
        phonebook.add(94435448, "Уткин");
        phonebook.add(94222248, "Степанов");
        phonebook.add(97688848, "Смирнов");
        phonebook.add(97888858, "Иванов");
        phonebook.get("Смирнов");

    }
}