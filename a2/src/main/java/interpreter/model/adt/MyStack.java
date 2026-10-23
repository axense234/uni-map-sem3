package interpreter.model.adt;

import interpreter.exceptions.ADTException;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack<T> implements IStack<T> {
    private final Deque<T> stack = new ArrayDeque<>();

    @Override
    public void push(T v){
        this.stack.push(v);
    }

    @Override
    public T pop() throws ADTException {
        if(this.stack.isEmpty()){
            throw new ADTException("stack is empty");
        }
        return this.stack.pop();
    }

    @Override
    public boolean isEmpty(){
        return this.stack.isEmpty();
    }
}
