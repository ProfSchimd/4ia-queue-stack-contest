import java.util.ArrayList;

public class StopwatchPro extends Stopwatch implements IStopwatchPro{
    private int play = -1;//-1 = before starting, 0 = stop, 1 = play, 2 = pause
    private String name;
    private long millis;
    private long started;
    private long paused;
    private ArrayList<Long> partials = new ArrayList<Long>();

    public StopwatchPro(String name) {
        super(name);
    }

    public void start() {
        if (play == -1) {
            play = 1;
            started = System.currentTimeMillis();
        }
    }

    public void stop() {
        if (play != 0) {
            play = 0;
            millis = System.currentTimeMillis() - started;
        }
    }


    public void pause() {
        paused = System.currentTimeMillis() - started;
        partials.add(paused);
        play = 2;
    }


    public void resume() {

    }


    public void reset() {
        if (play == 0) {
            started = System.currentTimeMillis();
            millis = 0;
            play = -1;
            partials.clear();
        }
    }


    public long getTime() {
        switch (play) {
            case 0:
                formatting(millis);
                break;
            case 1:
                formatting((System.currentTimeMillis() - started));
                break;
            case 2:
                if (partials.size() != 0) {
                    System.out.println();
                    for (int i = 0; i < partials.size(); i++) {
                        System.out.print("Partial N." + (i + 1) + ": ");
                        formatting(partials.get(i));
                    }
                }
                System.out.println();
                formatting((System.currentTimeMillis() - started));
                break;
        }
        return 0;
    }

    private void formatting(long ms) {
        millis = ms;
        long seconds = (millis / 1000) % 60;
        long minutes = (millis / 60000) % 60;
        long hours = (millis / 3600000) % 24;

        if(((millis) - ((millis / 1000) * 1000)) < 10){
            System.out.println(hours + ":" + minutes + ":" + seconds + ".00" + ((millis) - ((millis / 1000) * 1000)));
        }else if(((millis) - ((millis / 1000) * 1000)) < 100){
            System.out.println(hours + ":" + minutes + ":" + seconds + ".0" + ((millis) - ((millis / 1000) * 1000)));
        }else{
            System.out.println(hours + ":" + minutes + ":" + seconds + "." + ((millis) - ((millis / 1000) * 1000)));
        }
    }

    public void delete(int pos) {
        partials.remove(pos - 1);
        getTime();
    }
}
