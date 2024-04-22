package tasks.p7;

public class Main {
//  создать класс массив (Array) инкапсулирующий в себе логику массива, должны быть реализованы следующие функции:
//  1 инициализация массива заданной длины (делать через конструктор) (массив для строк String)
//  2 добавление элемента в массив
//  3 добавление элемента в массив в указанную позицию в массиве
//  4 удаление элемента из массива (на вход дается какая то строка и ее удаляют первую попавшуюся)
//  5 реализовать метод который возвращает размер массива
//  6 добавить метод полной очистки массива
//  7 добавить метод который печатает весь массив


    public static void main(String[] args) {
        Array myArray = new Array(6);


//        myArray.length();
//        myArray.addArg(0,"h");
//        myArray.addArg(1,"f");
//        myArray.addArg(2,"c");
//        myArray.print();

        myArray.addArg("a");
        myArray.addArg("b");
        myArray.addArg("c");
        myArray.addArg("d");
        myArray.addArg("e");
        myArray.addArg("f");
        myArray.addArg(100,"z");
        myArray.print();

//        myArray.length();
//        System.out.println(myArray.length());

        myArray.delArg("z");
        myArray.print();
//        myArray.addArgToIndex(0, "z");
//
//        myArray.clear();
//        myArray.print();






    }
}





