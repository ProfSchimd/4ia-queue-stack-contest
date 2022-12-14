/**
 * @author francesco.fassino
 * @author giulio.semenzato
 * @author giacomo.esposito
 * @author filippo.schierato
 * @version 0.1
 */

public class Queue implements IQueue{

    Object[] queue;

    public Queue(){
        queue = new Object[0];
    }

    /**
     * meotodo che rialloca l'array
     * se il parametro boolean è true l'array verrà aumentato di 1
     * se il parametro boolean è false l'array verrà diminuito di 1
     */
    private void reAlloc(boolean bool){
        Object[] newArray;
        if (isEmpty()){
            newArray = new Object[1];
        }
        else if(bool){
            newArray = new Object[this.queue.length + 1];
            //funzione per la copa dell'array queue in newArray
            //(array da copiare, indice da cui partire, array in cui copiare, indice di partenza, lunghezza dell'array)
            System.arraycopy(this.queue, 0, newArray, 0, this.queue.length);
        }else{
            newArray = new Object[this.queue.length - 1];
            System.arraycopy(this.queue, 1, newArray, 0, this.queue.length - 1);
        }
        this.queue = newArray;
    }

    /**
     * metodo che aggiunge alla coda un oggetto o
     */
    public void enqueue(Object o){
        reAlloc(true);
        this.queue[queue.length-1] = o;
    }

    /**
     * metodo che toglie dalla coda l'oggetto o
     */
    public Object dequeue(){
        if (!isEmpty()){
            Object r = this.queue[0];
            reAlloc(false);
            return r;
        }else{
            return null;
        }
    }

    /**
     * meotodo che prende il primo elemento della coda
     */
    public Object front(){
        if (!isEmpty()){
            return this.queue[0];
        }else{
            return null;
        }
    }

    /**
     * metodo che restituisce la lunghezza della coda
     */
    public int size(){
        return queue.length;
    }

    /**
     * metodo che verifica se la coda è vuota e ritorna true, altrimenti false
     */
    public boolean isEmpty(){
        if (this.queue.length==0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString(){
        String plinio = "";
        for(int i = 0; i<this.queue.length; i++){
            plinio += queue[i];
            plinio += " ";
        }
        return plinio;
    }
}
