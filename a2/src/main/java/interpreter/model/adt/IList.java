package interpreter.model.adt;

public interface IList<T> {
    boolean add(T elem);
    T get(int index) throws IndexOutOfBoundsException;
    int size();
}
