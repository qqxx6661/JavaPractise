package LRU;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author yzd
 * @version Id: LRU.java, v 0.1 2018年08月09日 17:15 yzd Exp $
 */
public class LRU<K, V> implements Iterable<K> {

    private Node head;
    private Node tail;
    private HashMap<K, Node> map;
    private int maxSize;

    /**
     * Node类
     */
    private class Node {

        Node pre;
        Node next;
        K k;
        V v;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    /**
     * LRU类构造函数
     * @param maxSize
     */
    public LRU(int maxSize) {

        this.maxSize = maxSize;
        this.map = new HashMap<>(maxSize * 4 / 3);

        head = new Node(null, null);
        tail = new Node(null, null);

        head.next = tail;
        tail.pre = head;
    }

    /**
     * 取操作
     * @param key
     * @return
     */
    public V get(K key) {

        if (!map.containsKey(key)) {
            return null;
        }

        Node node = map.get(key);
        unlink(node);
        appendHead(node);

        return node.v;
    }

    /**
     * 存操作
     * @param key
     * @param value
     */
    public void put(K key, V value) {

        if (map.containsKey(key)) {
            Node node = map.get(key);
            unlink(node);
        }

        Node node = new Node(key, value);
        map.put(key, node);
        appendHead(node);

        if (map.size() > maxSize) {
            Node toRemove = removeTail();
            map.remove(toRemove);
        }
    }

    /**
     * 从链表中间移除，把左右两边接上
     */
    private void unlink(Node node) {
        Node pre = node.pre;
        node.pre = node.next;
        node.next = pre;
    }

    /**
     * 把该node放在队列头部
     * @param node
     */
    private void appendHead(Node node) {
        node.next = head.next;
        head.next = node;
    }

    /**
     * 移除队尾
     * @return
     */
    private Node removeTail() {
        Node node = tail.pre;
        node.pre = tail;
        return node;
    }

    /**
     * 重写该类迭代方式，hasNext和next函数
     * @return
     */
    @Override
    public Iterator<K> iterator() {

        return new Iterator<K>() {

            private Node cur = head.next;

            @Override
            public boolean hasNext() {
                return cur != tail;
            }

            @Override
            public K next() {
                Node node = cur;
                cur = cur.next;
                return node.k;
            }
        };
    }

    public static void main(String[] args) {
        LRU<String, Integer> lru = new LRU<String, Integer>(3);
        lru.put("a", 1);
        lru.put("b", 2);
        System.out.println(lru.get("b"));
    }
}