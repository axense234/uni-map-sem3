package interpreter.model.adt;

import interpreter.exceptions.ExpressionException;

import java.util.HashMap;

public class MyDictionary<K, V> implements IDictionary<K, V> {
    private final HashMap<K, V> hashMap = new HashMap<>();

    @Override
    public boolean isDefined(K key){
        return this.hashMap.containsKey(key);
    }

    @Override
    public V lookup(K key) throws ExpressionException {

        if(!this.hashMap.containsKey(key)){
            throw new ExpressionException("Key not found in hashmap: " + key);
        }

        return this.hashMap.get(key);
    }

    @Override
    public void put(K key, V value){
        this.hashMap.put(key, value);
    }

    @Override
    public void update(K key, V value) throws ExpressionException{
        if(!this.hashMap.containsKey(key)){
            throw new ExpressionException("Key is not in the hash map which is required for the update operation: " + key);
        }

        this.hashMap.put(key, value);
    }

    @Override
    public String toString(){
        return this.hashMap.toString();
    }
}
