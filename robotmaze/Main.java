public class Main {

    public static final long KILO = 1024;
    public static final long MEGA = (1 << 20);
    public static final long GIGA = (1 << 30);

    public static void stackPerf(IStack s) {
        IGenerator generator = new IntGenerator();
        
        // long[] sizes = {KILO,128*KILO, MEGA, 128*MEGA, GIGA, 8*GIGA};
        long[] sizes = {KILO, 128*KILO, 256*KILO};
        for(long size : sizes) {
            long time = 0;
            time += StackTest.manyPush(s, size, generator);
            System.out.println(size + "," + time);
        }
    }

    public static void queuePerf(IQueue q) {
        IGenerator generator = new IntGenerator();
        
        // long[] sizes = {KILO,128*KILO, MEGA, 128*MEGA, GIGA, 8*GIGA};
        long[] sizes = {KILO, 128*KILO, 256*KILO};
        for(long size : sizes) {
            long time = 0;
            time += QueueTest.manyEnqueue(q, size, generator);
            System.out.println(size + "," + time);
        }
        
    }

    public static void main(String[] args) {
        IQueue q = new Queue();
        IStack s = new Stack();
        stackPerf(s);
        queuePerf(q);
    }
}
