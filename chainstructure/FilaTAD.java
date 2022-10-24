package chainstructure;

public interface FilaTAD<E> {
    public int size();

    public boolean isEmpty();

    public E getHead() throws EmptyQueueException;

    public void enqueue(E element);

    public E dequeue() throws EmptyQueueException;
    
}
