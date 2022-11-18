public class Stopwatch implements IStopwatch{

    private int play = -1;//-1 = before starting, 0 = stop, 1 = play, 2 = pause
    private String name;
    private long millis;
    private long started;
    private long paused;

    public Stopwatch(String name) {
        this.name = name;
    }

    public void start(){
        if (play == -1){
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

    public void pause(){
        if(play != 2){
            play = 2;
            paused = System.currentTimeMillis() - started;
        }
    }

    public void resume(){
        if(play == 2){
            play = 1;
        }else if(play == 0){
            play = 1;
            reset();
            started = System.currentTimeMillis();
        }
    }


    public void reset() {
        if (play == 0) {
            started = System.currentTimeMillis();
            millis = 0;
            play = -1;
        }
    }

    public long getTime(){
        switch(play){
            case 0:
                System.out.println(millis);
                break;
            case 1:
                System.out.println(millis = System.currentTimeMillis() - started);
                break;
            case 2:
                System.out.println(paused);
                break;
        }
        return 0;
    }
}
