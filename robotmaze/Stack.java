
/**
 * @author davide.yeh & andrea.sponchiado
 */
public class Stack implements IStack{
    private int lastElementIndex;
    public int calls=0;
    private Object[] elements;
    //private static final int array_extension = 50;
    public Stack(){
        lastElementIndex = 0;
        elements = new Object[1];
    }
    //inserimento di un elemento nello stack
    @Override
    public void push(Object o) {
        if(lastElementIndex+1 == elements.length){
            Object[] newElements = new Object[(int) Math.pow(elements.length,1.1)+1];
            System.arraycopy(elements,0,newElements,0,lastElementIndex);
            newElements[lastElementIndex]=o;
            elements=newElements;
            calls++;
        }
        else{
            elements[lastElementIndex] = o;
        }

        lastElementIndex++;
    }

    //rimuove e ritorna l'ultimo elemento inserito se elements.length != 0
    //altrimenti ritorna null

    @Override
    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        Object remObj = elements[lastElementIndex];
        elements[lastElementIndex] = null;
        lastElementIndex--;
        return remObj;
    }

    //ritorna l'ultimo elemento inserito
    @Override
    public Object top() {
        if (isEmpty()) {
            return null;
        }
        return elements[lastElementIndex];
    }

    @Override
    public int size() {
        return lastElementIndex;
    }

    @Override
    public boolean isEmpty() {
        return lastElementIndex == 0;
    }
}
