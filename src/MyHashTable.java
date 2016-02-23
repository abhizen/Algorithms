import java.io.*;
import java.util.*;

public class MyHashTable<K, V> {
    private ArrayList<MyHashEntry> hashList = null;
    public static void main(String args[]) throws Exception {
        new TestHarness(new MyHashTable<String, String>()).run();
    }

    public MyHashTable(){
        this.hashList = new ArrayList();
    }

    public void put(K key, V value) {
        // TODO implement
        if(key==null)
            return;

        if(value==null)
            return;

        for(MyHashEntry entry : hashList) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        MyHashEntry tableEntry = new MyHashEntry<K,V>(key,value);

        this.hashList.add(tableEntry);
    }

    public V get(K key) {
        // TODO implement
        if(key==null)
            return null;

        for(MyHashEntry entry : hashList){
            if(entry.getKey().equals(key))
                return (V) entry.getValue();
        }
        return null;
    }

    private class MyHashEntry<K,V>{
        private K key;
        private V value;

        public MyHashEntry(K key,V value){
            this.key = key;
            this.value = value;
        }

        public V getValue(){
            return value;
        }

        public void setValue(V value){
            this.value = value;
        }

        public K getKey(){
            return key;
        }
    }
    /**
     * A helper class that tests MyHashtable by feeding it puts and gets from STDIN.
     */
    public static class TestHarness implements Runnable {
        final MyHashTable<String, String> hashtable;

        public TestHarness(MyHashTable<String, String> hashtable) {
            this.hashtable = hashtable;
        }

        public void run() {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String k = scanner.next();
                String v = null;
                if (k.contains("=")) {
                    String[] split = k.split("\\=");
                    k = split[0];
                    v = split[1];
                }
                if (v == null) {
                    System.out.println(hashtable.get(k));
                } else {
                    hashtable.put(k, v);
                }
            }
        }
    }
}