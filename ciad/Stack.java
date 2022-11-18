/**
     * @author MATTEO.PIAZZON && MATTEO.VALERII
     */
import java.util.Arrays;
    public class Stack implements IStack {
        private int DIM;
        private Object[] datas;


        public Stack(int DIM) {
            this.DIM = DIM;
            datas= new Object[DIM];
        }

        @Override
        public void push(Object o) {
            for (int i = 0; i < datas.length-1; i++) {
                if (datas.length-1 == i) {
                    System.out.println("The stack is full");
                } else if (datas[i] == null) {
                    datas[i] = o;
                    break;
                }
            }
        }

        @Override
        public Object pop() {
            if(isEmpty() == false) {
                for (int i = 0; i < datas.length - 1; i++) {
                    if (datas[i] == null) {
                        Object o = datas[i-1];
                        datas[i - 1] = null;
                        return o;
                    }
                }
                Object o = datas[datas.length - 1];
                datas[datas.length - 1] = null;
                return o;
            } else {
                return null;
            }
        }

        @Override
        public int size() {
            int count = 0;
            for (int i = 0; i < datas.length-1; i++) {
                if (datas[i] != null) {
                    count++;
                } else {
                    return count;
                }
            }
            return count;
        }
        @Override
        public Object top() {
            if (!isEmpty()) {
                for (int i = 0; i < datas.length - 1; i++) {
                    if (datas[i] == null) {
                        return datas[i - 1];
                    }
                } return datas[datas.length - 1];
            }
            return null;
        }


    @Override
    public boolean isEmpty() {
        if (datas[0] == null) {
            return true;
        } else {
            return false;
        }
    }

    public void print(){
        for (int i = 0; i < datas.length-1; i++) {
            System.out.println(datas[i]);
        }
    }
}
