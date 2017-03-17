import java.util.Iterator;
import java.util.NoSuchElementException;

public class CycListClass <E>  implements CycList{

    private  static class Node<E> {
        E info;
        Node<E> next;
        public Node (E info, Node<E> next) {
            this.info = info;
            this.next = next;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;


    public void add(E element){
        if (head == null){
            head = new Node<E>(element,head);
            tail = head;
        }
        else{
            tail.next = new Node<E>(element,head);
            tail = tail.next;
        }

    }


    @Override
    public void shift(int delta) {
        for (int i = 0; i<delta; i++){
            head = head.next;
            tail = tail.next;
        }
    }

    @Override
    public Iterator iterator() {
        return new CycListIterator();
    }

    private class CycListIterator implements Iterator{

        private int index = 0;
        private Node<E> currentNode = head;

        @Override
        public boolean hasNext(){
            if (head==null) return false;
            else if (index==0) return true;
            if (currentNode.next.equals(head)) return false;

            return true;
        }

        @Override
        public E next(){
            if (!hasNext()) throw new NoSuchElementException();
            if (index ==0) {
                index++;
                return head.info;
            }
            else {
                currentNode = currentNode.next;
                return currentNode.info;
            }
        }
        @Override
        public void remove(){}
    }




}
