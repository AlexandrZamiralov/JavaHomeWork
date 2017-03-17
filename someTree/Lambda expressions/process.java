import java.util.function.Function;

public class process {
    //ordinary sum. but we cant divide.
    public static Integer valueCalculation (Node<Integer, Character> node) {
        return node.process(Function.identity(),(Character character, Integer x, Integer y) -> {
            if (character == '+') return (x + y);
            if (character == '-') return (x - y);
            if (character == '*') return (x * y);
            return 0;
        });

    }


    //Object to string and a bit of glue => string
    public static String convertTreeToString(Node<Integer, Character> node) {
        return node.process(Object::toString, (Character character, String x, String y) -> x + character.toString() + y );
    }

    //if in ordinary algebra to each number attributed to negative, it turns out that we are inverted with respect to zero
    public static Node<Integer, Character> invertTree(Node<Integer, Character> node) {
        return node.process(x -> new Leaf<>(-x),
                BiNode<Integer, Character>::new); // its not explicit type arguments!
    }


    public static void main(String[] args) {
        //7*3+12-3
        Node<Integer, Character> first = new BiNode<>('*', new Leaf<>(7), new Leaf<>(3)); //first act
        Node<Integer, Character> second = new BiNode<>('+', first, new Leaf<>(12)); //second act
        Node<Integer, Character> third = new BiNode<>('-', second, new Leaf<>(3)); //third act


        System.out.println("Tree: " + convertTreeToString(third));  //check second function
        System.out.println("Value of Tree: " + valueCalculation(third)); //check first function
        System.out.println("Inverted Tree: " + convertTreeToString(invertTree(third))); //check first part of third function
        System.out.println("Value of Inverted Tree: " + valueCalculation(invertTree(third))); //check second part of third function

    }

}
