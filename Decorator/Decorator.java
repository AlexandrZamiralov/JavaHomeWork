import java.io.PrintStream;

public abstract class Decorator implements Sequence {

    private Sequence decoratedSequence;

    public Decorator(Sequence decoratedSequence)
    {
        this.decoratedSequence = decoratedSequence;
    }


    public void print(String delimiter, PrintStream ps){
        decoratedSequence.print(delimiter, ps);
    }


    public int size(){
        return decoratedSequence.size();
    }



}
