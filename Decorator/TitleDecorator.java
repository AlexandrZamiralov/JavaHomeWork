import java.io.PrintStream;

public class TitleDecorator extends Decorator {
    private String changes = "";
    
    public TitleDecorator (Sequence decoratedSequence, String changes){
        super(decoratedSequence);
        this.changes = changes;
    }

    @Override
    public void print(String delimiter, PrintStream ps){
        ps.print(changes);
        super.print(delimiter, ps);
    }

}
