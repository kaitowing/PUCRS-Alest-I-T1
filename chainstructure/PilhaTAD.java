package chainstructure;

public interface PilhaTAD<E> {
    public int size();

    public boolean isEmpty();

    public E top() throws EmptyQueueException;

    public void push(E element);

    public E pop() throws EmptyQueueException;
    
}
