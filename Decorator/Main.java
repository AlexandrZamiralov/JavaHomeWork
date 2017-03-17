

public class Main {
    public static void main(String[] args) {



        Integer[] array = new Integer[5];
        for (int i = 0; i<array.length; i++) array[i] = i;

        System.out.println("Your old print");
        Sequence sequence = new MyArray(array);
        sequence.print(", ", System.out);
        System.out.println();
        System.out.println();


        System.out.println("Lazy brackets ");
        Sequence sequenceWithBrackets = new BracketsDecorator(sequence, "(");
        sequenceWithBrackets.print(",", System.out);
        System.out.println();
        System.out.println();

        System.out.println("Brackets for smart ");
        Sequence sequenceWithBrackets1 = new BracketsDecorator(sequence, "(","]]");
        sequenceWithBrackets1.print(",", System.out);
        System.out.println();
        System.out.println();



        System.out.println("For Last Word");
        Sequence countedSequence = new CountingDecorator(sequence, " elements count ","your last word");
        countedSequence.print(",", System.out);
        System.out.println();
        System.out.println();


        System.out.println("Classic Counting Decorator");
        Sequence countedSequence1 = new CountingDecorator(sequence, " total elements");
        countedSequence1.print(",", System.out);
        System.out.println();
        System.out.println();

        System.out.println("We can mix them");
        countedSequence = new CountingDecorator (new BracketsDecorator(sequence, "{"), "=>","!!");
        countedSequence.print(", ", System.out);
        System.out.println();
        System.out.println();

        System.out.println("Really can");
        Sequence titledSequence = new TitleDecorator( countedSequence, "For the natural born leader ");
        titledSequence.print(",", System.out);
        System.out.println();
        System.out.println();
    }

}
