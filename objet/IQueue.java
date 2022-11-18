public interface IQueue {
    void enqueue(Object o);
    Object dequeue();
    Object front();
    int size();

    boolean isEmpty();
}