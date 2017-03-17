import java.util.ArrayList;
import java.util.List;

class Tree<K extends Comparable<K>, V>{
    private class Node {
        K key;
        V value;
        Node left = null;
        Node right = null;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    Node root = null;

    public void add(K key, V value){
        if(root == null){
            root = new Node(key, value);
        }
        else {
            add(key, value, root);
        }
    }

    private void add(K key, V value, Node parent){
        if(key.compareTo(parent.key) > 0){
            if(parent.right == null){
                parent.right = new Node(key, value);
            }
            else {
                add(key, value, parent.right);
            }
        }
        else {
            if(parent.left == null){
                parent.left= new Node(key, value);
            }
            else {
                add(key, value, parent.left);
            }
        }
    }


    public List<V> get(K start, K finish){
        List<V> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        return get(start, finish, root, result);
    }


    private List<V> get(K start, K finish, Node next, List<V> result){
        if(next == null){
            return result;
        }

        if(next.key.compareTo(finish) > 0){
            return get(start, finish, next.left, result);
        }

        if(next.key.compareTo(start) < 0){
            return get(start, finish, next.right, result);
        }

        if(next.key.compareTo(finish) <= 0 && next.key.compareTo(start) >= 0) {
            result.add(next.value);
        }
        return get(start, finish, next.left, get(start, finish, next.right, result));
    }
}
