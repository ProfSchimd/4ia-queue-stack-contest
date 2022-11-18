public class Queue implements IQueue {
    private int DIM;
    Object[] queue;
    private int n = 0; //indice array
    public Queue(int DIM){
        this.DIM=DIM;
        this.queue=new Object[this.DIM];
    }


    @Override
    public void enqueue(Object o) {
        queue[n] = o;
        n++;

    }



    @Override
    public Object dequeue() {
        Object obj = queue[0];
        queue[0]=null;
        for (int i = 0; i < n-1; i++) {
            queue[i] = queue[i+1];
        }
        n--;
        return obj;

    }


    @Override
    public Object front() {
        return queue[0];
    }


    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        if(queue[0]==null){
            return true;
        }
        return false;
    }

    public void print(){
        for (int i = 0; i < queue.length; i++) {
            System.out.println(queue[i]);
        }
        System.out.println("--------------");
    }

}