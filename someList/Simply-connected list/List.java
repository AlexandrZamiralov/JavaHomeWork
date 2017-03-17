public class List <E extends Comparable<E>> {
    private static class Node<E> {
        E info;
        Node<E> next;

        public Node(E info) {
            this.info = info;
            this.next = null;
        }
    }
    int size = 0;
   private Node<E> head = null;



    private Node<E> getLast(Node<E> node) {
        if (node.next == null) {
            return node;
        } else {
            return getLast(node.next);
        }

    }

    private Node<E> getByIndex(Node<E> node, int i) {
        if (i == 0) {
            return node;
        } else {
            return getByIndex(node.next, i - 1);
        }
    }

    public void add(E element) {
        size++;
        if (head == null) {
            head = new Node<E>(element);
        } else {
            Node<E> Last = getLast(head);
            Last.next = new Node<E>(element);
        }
    }

    public void swap(int i, int j) {
        if (j < i) {
            int c = i;
            i = j;
            j = c;
        }
        if ((i < 0) || (j >= size)) {
            throw new IndexOutOfBoundsException();
        }

        if (i != j) {
            Node<E> I = getByIndex(head, i);
            Node<E> postI = I.next;
            Node<E> predJ = getByIndex(I, j - i - 1);
            Node<E> J = predJ.next;
            Node<E> postJ = J.next;
            if (i + 1 == j) {
                if ((i - 1) >= 0) {
                    Node<E> predI = getByIndex(head, i - 1);
                    predI.next = J;
                    J.next = I;
                    I.next = postJ;
                } else {
                    head = J;
                    J.next = I;
                    I.next = postJ;
                }

            } else {
                if ((i - 1) >= 0) {
                    Node<E> predI = getByIndex(head, i - 1);
                    predI.next = J;
                } else {
                    head = J;
                }
                I.next = postJ;
                J.next = postI;
                predJ.next = I;

            }

        }
    }

    public void printAll() {
        print(head);
    }

    private Node<E> print(Node<E> node) {
        System.out.println(node.info);
        if (node.next == null) {
            return node;
        }
        return print(node.next);
    }

    public void sort() {
        for (int i = 1; i < size; i++) {
            Node<E> odin = getByIndex(head, i - 1);
            int j = i - 1;
            while (((j >= 0) && (odin.info.compareTo(odin.next.info) > 0))) {
                swap(j + 1, j);
                j--;
                if (j >= 0) {
                    odin = getByIndex(head, j);

                }
            }
        }
    }
}
