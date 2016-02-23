import java.math.BigInteger;

/**
 * Created by abhinit on 9/6/15.
 */
public class MyHashMap<K,V> {
    private static final int limit = 256;
    private HashObject[] map = new HashObject[limit];



    private class HashObject<K,V>{
        private K key;
        private V value;

        public HashObject(K key,V value){
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}