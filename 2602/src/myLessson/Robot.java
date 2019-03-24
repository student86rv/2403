package myLessson;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Robot {
    interface Listener {
        void onMove();
    }
    private int x = 0;
    private int y = 0;

    private Listener listener;

    private Random random = new Random();

    public void startMoving() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                randomMove();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 1000, 1000);
    }

    private void randomMove() {

    }
    public void setOnMoveListener(Listener listener) {
        this.listener = listener;
    }
}
