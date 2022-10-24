package chainstructure;

public class Fila implements FilaTAD {
    private ChainStructure lista;

    public Fila(){
        lista = new ChainStructure<>();
    }

    @Override
    public int size() {
        return lista.size();
    }

    @Override
    public boolean isEmpty() {
        return lista.isEmpty();
    }

    @Override
    public Object getHead() throws EmptyQueueException {
        return lista.getFirst();
    }

    @Override
    public void enqueue(Object element) {
        lista.addLast(element);
    }

    @Override
    public Object dequeue() throws EmptyQueueException {
        Object n = lista.getFirst();
        lista.removeFirst();
        return n;
    }

}
