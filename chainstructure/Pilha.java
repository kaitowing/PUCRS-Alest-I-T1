package chainstructure;

public class Pilha implements PilhaTAD {
    private ChainStructure lista;

    public Pilha(){
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
    public Object top() throws EmptyQueueException {
        return lista.getLast();
    }

    @Override
    public void push(Object element) {
        lista.addLast(element);
    }

    @Override
    public Object pop() throws EmptyQueueException {
        Object n = lista.getLast();
        lista.removeLast();
        return n;
    }

}
