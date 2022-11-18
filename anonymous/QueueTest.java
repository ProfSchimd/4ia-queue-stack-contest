public class QueueTest {
    public static long manyEnqueue(IQueue q, Long n, IGenerator generator) {
        long begin = System.currentTimeMillis();
        for (long i = 0; i < n; i++) {
            q.enqueue(generator.next());
        }
        long end = System.currentTimeMillis();
        return (end - begin);
    }

    public static long manyDequeue(IQueue q, long n) {
        long begin = System.currentTimeMillis();
        for (long i = 0; i < n; i++) {
            q.dequeue();
        }
        long end = System.currentTimeMillis();
        return (end - begin);
    }

    public static long emptyQueue(IQueue q) {
        long begin = System.currentTimeMillis();
        while (!q.isEmpty()) {
            q.dequeue();
        }
        long end = System.currentTimeMillis();
        return (end - begin);
    }
}
