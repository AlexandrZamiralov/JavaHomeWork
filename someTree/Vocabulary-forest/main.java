public class main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.addWord("bit");
        dictionary.addWord("byte");
        dictionary.addWord("bite");
        System.out.print(dictionary.size() + " ");
        dictionary.addWord("sit");
        dictionary.addWord("sit");
        System.out.print(dictionary.size() + " ");
        dictionary.addWord("site");
        System.out.print(dictionary.size() + " ");
        dictionary.removeWord("sit");
        if (!dictionary.hasWord("sit")){System.out.println("remove  ok");}
        if (dictionary.hasWord("bit")){System.out.print("hasword -- ok");}


    }
}
