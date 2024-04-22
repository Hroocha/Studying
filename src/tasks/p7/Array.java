package tasks.p7;

public class Array {


    private String[] array;
    private int size;

    public int getSize() {
        return size;
    }

    Array(int initialSize) {
        size = 0;
        array = new String[initialSize];
    }

    public void addArg(int cell, String arg) {
//      проверяю заполнен ли массив, и если да, то увеличиваю его вдвое
        if (size == array.length) {
            String[] arrayNew = array;
            array = new String[array.length * 2];
            for (int i = 0; i < arrayNew.length; i++) {
                array[i] = arrayNew[i];
            }
        }
        if (cell > (size-1)) {
            array[size] = arg;
        }
        if (cell < size-1 | cell == size-1) {
            for (int i = array.length - 1 ; i > cell; i--) {
                array[i] = array[i - 1];
            }
            array[cell] = arg;
        }
        this.size++;
    }


    public void addArg(String arg) {
        this.addArg(size+1,arg);
    }

    void delArg(String arg) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(arg)) {
                int cell = i;
                for (i = cell; i < array.length; i++) {
                    if (i != (array.length - 1)) {
                        array[i] = array[i + 1];
                    } else
                        array[i] = null;
                }
            }
            this.size--;
        }
    }


    void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print("\t" + array[i]);
        }
        System.out.println();
    }

    void printP() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                System.out.print("\t" + array[i]);
            }
        }
        System.out.println();
    }

}
