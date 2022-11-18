public class Queue implements IQueue {
    Object[] queue = new Object[10];
    int cont = 0;
    int begin = 1;
    boolean isEnqueued = false;

    private void copyQueue(Object[] sup) {
        if (isEnqueued) {
            for (int i = 0; i < cont; i++) {
                sup[i] = queue[i];
            }
        } else {
            for (int i = 0; i < cont; i++) {
                sup[i] = queue[begin];
                begin++;
            }
        }
    }

    public void sizeControl(){
        System.out.println("Size of queue is: " + queue.length);
    }

    @Override
    public void enqueue(Object o) {
        isEnqueued = true;
        if(cont >= queue.length -1) {
            Object[] sup = new Object[cont * 2];
            copyQueue(sup);
            sup[cont] = o;
            queue = sup;
        } else {
            queue[cont] = o;
        }
        cont++;
    }

    @Override
    public Object dequeue() {
        if(cont!=0){
            isEnqueued = false;
            Object o = queue[begin-1];
            if (cont <= (queue.length/3*2)) {
                Object[] sup = new Object[cont];
                copyQueue(sup);
                begin = 1;
                queue = sup;
            } else {
                queue[begin-1] = null;
                begin++;
            }
            cont--;
            return o;
        }else{
            return null;
        }
    }


    @Override
    public Object front() {
        return queue[0];
    }

    @Override
    public int size() {
        return cont;
    }

    @Override
    public boolean isEmpty() {
        if(cont==0){
            return true;
        }else{
            return false;
        }
    }
}
