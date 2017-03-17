import java.io.PrintStream;

public class BracketsDecorator extends Decorator {
    private String changes = "";
    private String changes1="";
    private String changes2="1";
    
    public BracketsDecorator(Sequence decoratedSequence, String changes) {
        super(decoratedSequence);
        this.changes = changes;
    }
    
    public BracketsDecorator (Sequence decoratedSequence, String changes, String changes1){
        super(decoratedSequence);
        this.changes=changes;
        this.changes1=changes1;
        changes2="0";
    }



    @Override
    public void print(String delimiter, PrintStream ps) {
        if(changes2=="1") {
            ps.print(changes);
            super.print(delimiter, ps);
            String changes2 = changes.replaceAll("\\(", ")");
            changes2 = changes2.replaceAll("\\[", "]");
            changes2 = changes2.replaceAll("\\{", "}");
            ps.print(changes2);
        }
        else {
            ps.print(changes);
            super.print(delimiter, ps);
            ps.print(changes1);
        }



    }

}
