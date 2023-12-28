import java.util.HashMap;

public class LRUCache {

    static class Node {
        private Node prev;
        private Node next;
        private int value;
        private int key;
        Node(){}

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node head, tail;
    int size, capacity;
    HashMap<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            deleteNode(node);
            insertNode(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            insertNode(node);
        } else {
            if(size == capacity) {
                Node toDelete = tail.prev;
                deleteNode(toDelete);
                map.remove(toDelete.key);
                size--;
            }
            Node toInsert = new Node(key, value);
            map.put(key, toInsert);
            insertNode(toInsert);
            size++;
        }
    }

    public void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertNode(Node node) {
        Node temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }

    public void print() {
        Node iterate = head;
        String ans = "";
        while (iterate!=null) {
            ans+= iterate.value + " ";
            iterate = iterate.next;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.print();
        lruCache.put(2, 2);
        lruCache.print();
        lruCache.get(1);
        lruCache.print();
        lruCache.put(3, 3);
        lruCache.print();
        lruCache.get(2);
        lruCache.print();
    }

}
