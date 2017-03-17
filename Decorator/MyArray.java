import java.io.PrintStream;

public class MyArray implements Sequence<Integer>{

    private Integer[] array;

    public MyArray(Integer[] elements) {
        array = elements;
    }
    public int size() { return array.length; }

    public void print(String delimiter, PrintStream ps){
        if (array.length == 0) return;
        for (int i=0; i<array.length-1; i++) {
            ps.print(array[i] + delimiter);
        }
        ps.print(array[array.length-1]);
    }

}
