// package com.company;


public class Queue implements IQueue {

    private Object[] q;
    private int size = 100;

    public Queue() {
        this.q = new Object[size];
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int s) {
        this.size = s;
    }


    @Override
    public void enqueue(Object o) {
        for (int i = 0; i < q.length; i++) {
            if (q[i] == null) {
                q[i] = o;
            }
            break;
        }
    }

    @Override
    public Object dequeue() {
        Object obj = getSize();
        size--;
        for (int i = 0; i < size - 1; i++) {
            q[i] = q[i + 1];
            return obj;
        }
        return -1;
    }

    @Override
    public Object front() {
        return q[0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(q[0] == null) {
            return true;
        }
        else return false;
    }
}
