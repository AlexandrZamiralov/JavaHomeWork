import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        demo();

    }

    public static void print(CycList list) {
        Iterator iterator = list.iterator();
    
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

    }

    public static <E> boolean listsEqual(CycList<E> list1, CycList<E> list2) {

        
        int c = 0;
        Iterator list1Iter = list1.iterator();
        Iterator list2Iter = list2.iterator();
        while (list1Iter.hasNext() && list2Iter.hasNext()) {
            list1Iter.next();
            list2Iter.next();
            c++;
        }
        if ((list1Iter.hasNext() && !list2Iter.hasNext()) || (!list1Iter.hasNext() && list2Iter.hasNext()))
            return false;


      work:  for (int shift = 0; shift < c; shift++) {
            Iterator Iter1 = list1.iterator();
            Iterator Iter2 = list2.iterator();
            for (int i = 0; i < c; i++) {
                if (!Iter1.next().equals(Iter2.next())) {
                    list2.shift(1);
                    continue work;
                }
            }
            return true;
        }
        return false;
    }


   public static void demo(){
       
        CycListClass<Integer> list1 = new CycListClass<>();
       CycListClass<Integer> list2 = new CycListClass<>();


        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);


        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);

        System.out.print("test1 ");
        print(list1);
        System.out.print("and ");
        print(list2);
        System.out.println();
        System.out.println(listsEqual(list1, list2));


        list1.shift(2);

        System.out.print("test2 with shift ");
        print(list1);
        System.out.print("and ");
        print(list2);
        System.out.println();
        System.out.println(listsEqual(list1, list2));

        list2.add(6);

        System.out.print("test3 ");
        print(list1);
        System.out.print("and ");
        print(list2);
        System.out.println();
        System.out.println(listsEqual(list1, list2));

        list2.add(7);
        list1.add(7);
        list1.add(6);

        System.out.print("test4 ");
        print(list1);
        System.out.print("and ");
        print(list2);
        System.out.println();
        System.out.println(listsEqual(list1, list2));



    }

}
