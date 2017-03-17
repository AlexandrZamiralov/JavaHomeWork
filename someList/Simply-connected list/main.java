public class main {
    public static void main(String[] args) {
        List<Integer> list = new List<>(); /
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.swap(2, 3);
        list.swap(1,2);
        list.swap(4,3);
        list.swap(0,1);
        list.swap(0,9);
       list.printAll();
      list.sort();
      list.printAll();
    }
}
