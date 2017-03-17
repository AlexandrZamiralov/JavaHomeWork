import java.io.PrintStream;

public class CountingDecorator extends Decorator {
    private String changes = "";
    private String changes1="";


    
    public CountingDecorator(Sequence decoratedSequence, String changes,String changes1){
        super(decoratedSequence);
        this.changes = changes;
        this.changes1=changes1;
    }
    
    public CountingDecorator(Sequence decoratedSequence,String changes){
        super(decoratedSequence);
        this.changes=changes;
    }

    @Override
    public void print(String delimiter, PrintStream ps){
        super.print(delimiter, ps);
        ps.print(changes);
        ps.print(" " + super.size() + " " );
        ps.print(changes1);
    }

}
