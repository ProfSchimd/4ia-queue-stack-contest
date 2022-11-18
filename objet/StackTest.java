public class StackTest {
    
    public static long manyPush(IStack s, long n, IGenerator generator) {
        long begin = System.currentTimeMillis();
        for (long i = 0; i < n; i++) {
            s.push(generator.next());
        }
        long end = System.currentTimeMillis();
        return (end - begin);
    }

    public static long manyPop(IStack s, long n) {
        long begin = System.currentTimeMillis();
        for (long i = 0; i < n; i++) {
            s.pop();
        }
        long end = System.currentTimeMillis();
        return (end - begin);
    }

    public static long emptyStack(IStack s) {
        long begin = System.currentTimeMillis();
        while (!s.isEmpty()) {
            s.pop();
        }
        long end = System.currentTimeMillis();
        return (end - begin);
    }
}
