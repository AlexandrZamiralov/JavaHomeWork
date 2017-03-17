import java.io.PrintStream;

public interface Sequence<E> {


    void print(String delimiter, PrintStream ps);

    int size();
}
