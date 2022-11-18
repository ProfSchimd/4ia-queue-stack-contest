import java.util.Arrays;

public class ArrayStack implements IStack {

    private Object[] stack;

    public ArrayStack(){
        stack = new Object[0];
    }

    public void push(Object o){
        stack = Arrays.copyOf(stack, size() + 1);
        stack[size() - 1] = o;
    }

    public Object top(){
        if(!isEmpty())
            return stack[size() - 1];
        return null;
    }

    public Object pop(){
        if(!isEmpty()){
            Object element = top();
            stack = Arrays.copyOfRange(stack, 0, size() - 1); //l'ultimo non viene copiato, è tolto
            return element;
        }
        return null;
    }

    @Override
    public int size() {
        return stack.length;
    }

    @Override
    public boolean isEmpty() {
        if (size() == 0)
            return true;
        return false;
    }
}