package my_collections;

public class CycleUtils {
    /**
     * Метод позволяет шагрунть вправо на 1 для циклических массивов
     * @param i текущий индекс
     * @param size размер массива
     * @return следующее значение индекса
     */
    public static int stepRight(int i, int size) {
        return ++i % size;
    }

    /**
     * Метод позволяет шагрунть влево на 1 для циклических массивов
     * @param i текущий индекс
     * @param size размер массива
     * @return следующее значение индекса
     */
    public static int stepLeft(int i, int size) {
        return (--i + size) % size;
    }
}
