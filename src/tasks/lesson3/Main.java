package tasks.lesson3;

public class Main {

    /*
    1. Создайте исключения: MyArraySizeException (неправильный размер массива), и
MyArrayDataException (в ячейке массива лежит что-то не то);
2. Напишите метод, на вход которого подаётся двумерный строковый массив (String[][]) размером
4×4. При подаче массива другого размера необходимо бросить исключение
MyArraySizeException.
3. Далее метод должен пройтись по всем элементам массива, преобразовать в int и
просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
ячейке лежит символ или текст вместо числа), должно быть брошено исключение
MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные. Расчет
данных для этой матрицы прекращается.
4. В методе main() нужно вызвать полученный метод, обработать возможные исключения
MySizeArrayException и MyArrayDataException и вывести результат расчёта.
Заметка: для преобразования строки в число можно использовать метод класса Integer:
Integer.valueOf("1")
*/


    public static void main(String[] args) {


        String[][] array = {
                {"1", "2", "2", "2"},
                {"1", "1", "2", "2"},
                {"1", "1", "2", "2"},
                {"1", "1", "2", "2"},
        };

        try {
            toIntAndSumArray4x4(array);
        } catch (MyArraySizeException | MyArrayDataException exception) {
            exception.printStackTrace();
        }
    }

    private static void toIntAndSumArray4x4(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException();
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException exception) {
                    throw new MyArrayDataException(i, j, array);
                }
            }
        }
        System.out.println(sum);
    }


}

