
public class main {
    public static void main(String[] args) {
        Tree<Integer,Integer> derevo = new Tree<>();
        for (int i=0; i<10;i++){
            derevo.add(i,i+10);
        }
        System.out.print(derevo.get(0, 5));
        System.out.println();
        System.out.print(derevo.get(3, 7));
        System.out.println();
        System.out.print(derevo.get(-100, 100));

    }
}
