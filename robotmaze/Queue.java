// package it.edu.zuccante;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Queue implements IQueue {
    private Object[] data;
    private int n = 0; // Indice in cui andremo ad aggiungere i nuovi elementi
    private int s = 0; // Indice che indica l'inizio della codacrf

    public Queue() {
        data = new Object[10];
    }

    /**
     * metodo che aggiunge un elemento alla coda
     * @param o elemnto da aggiungere alla coda
     */
    @Override
    public void enqueue(Object o) {
        if (n == data.length) {
            // Espando array del 10%
            int extra = (int) Math.ceil(data.length * 0.1);
            Object[] newData = new Object[data.length + extra];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        data[n - s] = o;
        n++;
    }

    /**
     * metodo che rimuove l'ultimo elemento dell'array
     * @return l'elemento rimosso quindi il primo elemento della coda
     */
    @Override
    public Object dequeue() {
        Object remove = front();
        int maxFreeSpace = (int) Math.ceil(data.length * 0.1);
        //System.out.println("FS: " + maxFreeSpace + " DL: " + data.length + " S: " + s);
        if (s > maxFreeSpace) {
            Object[] newData = new Object[data.length - s/* - 1*/];
            System.arraycopy(data, s + 1, newData, 0, data.length - s - 1);
            n -= s;
            s = 0;
            data = newData;
        } else {
            s++;
        }
        // n--;
        return remove;
    }

    /**
     * @return ritorna il primo elemento della coda
     */
    @Override
    public Object front() {
        return data[s];
    }

    /**
     * @return La lunghezza corrente della coda
     */
    @Override
    public int size() {
        return n - s;
    }

    /**
     * @return Se è vuoto ritorna true, se non è vuoto ritorna false
     */
    @Override
    public boolean isEmpty() {
        return n == 0;
    }
}