public interface IStack {
    void push(Object o);
    Object pop();
    Object top();
    int size();
    boolean isEmpty();
}