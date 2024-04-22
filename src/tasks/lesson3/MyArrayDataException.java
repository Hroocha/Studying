package tasks.lesson3;

public class MyArrayDataException extends Exception{

    private final int row;
    private final int column;
    private final String value;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String getValue() {
        return value;
    }

    public MyArrayDataException(int i, int j, String [][] array) {
        super("в ячейке массива [" + i + "] [" + j + "] лежит не число: " + array[i][j]);// в ячейке массива лежит что-то не то
        this.row = i;
        this.column = j;
        this.value = array[i][j];

    }
}
