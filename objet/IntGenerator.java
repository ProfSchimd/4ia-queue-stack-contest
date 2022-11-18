import java.util.Random;

public class IntGenerator implements IGenerator {

    Random rand = new Random();

    @Override
    public Object next() {
        return Integer.valueOf(rand.nextInt());
    }
}
