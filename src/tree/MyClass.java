package tree;

public class MyClass implements Comparable<MyClass>{

    private byte[] byteArray;

    @Override
    public int compareTo(MyClass that) {
        //        return Integer.compare(this.byteArray.length, that.byteArray.length); или вот так проще

        if (this.byteArray.length > that.byteArray.length) {
            return 1;
        } else if (this.byteArray.length == that.byteArray.length) {
            return 0;
        } else {
            return -1;
        }
    }
}
