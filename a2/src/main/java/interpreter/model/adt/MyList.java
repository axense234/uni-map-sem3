package interpreter.model.adt;

import java.util.ArrayList;

public class MyList<T> implements IList<T> {
    private final ArrayList<T> list = new ArrayList<>();

    @Override
    public boolean add(T elem){
        return this.list.add(elem);
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException{
        return this.list.get(index);
    }

    @Override
    public int size(){
        return this.list.size();
    }
}
