import java.util.Arrays;

public class ArrayQueue implements IQueue {

    private Object[] queue;

    public ArrayQueue() {
        queue = new Object[0];
    }

    public void enqueue(Object o) {
        queue = Arrays.copyOf(queue, size() + 1);
        queue[size() - 1] = o;
    }

    public Object dequeue() {
        if (!isEmpty()) {
            Object o = front();
            queue = Arrays.copyOfRange(queue, 1, size());
            return o;
        }
        return null;
    }

    public Object front() {
        if (!isEmpty())
            return queue[0];
        return null;
    }

    public int size() {
        return queue.length;
    }

    public boolean isEmpty() {
        if (size() == 0)
            return true;
        return false;
    }
}
