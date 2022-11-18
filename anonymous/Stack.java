public class Stack implements IStack{
    Object[] stack = new Object[10]; // initialization of the stack
    int cont = 0; // counter for the elements of the stack
    boolean isPush; // true if the user calls push() method false if calls pop() method

    //copyArray is a method that copy the stack into a new temporary array
    private void copyArray(Object[] sup){
        if (isPush) {
            for (int i = 0; i < cont; i++) {
                sup[i] = stack[i];
            }
        }else{
            for (int i = 0; i < cont-1; i++) {
                sup[i] = stack[i];
            }
        }
    }

    //push is the method that allows to add elements into the stack
    @Override
    public void push(Object o) {
        isPush = true;
        if(cont >= stack.length-1) {
            Object[] sup = new Object[cont*2];
            copyArray(sup);
            sup[cont] = o;
            stack = sup;
        }else{
            stack[cont] = o;
        }
        cont++;
    }

    //sizeControl is a method that return the length of the array
    public void sizeControl(){
        System.out.println("Size of stack is: " + stack.length);
    }

    //pop is the method that allows to remove elements from the stack
    @Override
    public Object pop() {
        if(cont != 0){
            isPush = false;
            Object o = stack[cont-1];
            if(cont <= (stack.length/3*2)) {
                Object[] sup = new Object[cont];
                copyArray(sup);
                stack = sup;
            }else{
                stack[cont-1] = null;
            }
            cont--;
            return o;
        }else{
            return null;
        }
    }

    //top is the method that return the last insert element
    @Override
    public Object top() {
        if(cont != 0){
            return stack[cont-1];
        }else{
            return null;
        }
    }

    //size is the method that return the size of the stack
    @Override
    public int size() {
        return cont;
    }

    //isEmpty is the method that return true if the stack is empty and false if is not
    @Override
    public boolean isEmpty() {
        if(cont == 0){
            return true;
        }else {
            return false;
        }
    }
}
