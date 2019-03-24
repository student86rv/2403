package myLessson;

import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static Timer timer = new Timer();
    public static int count = 0;
    public static void main(String[] args) {

//        Robot robot = new Robot();
//
//        int a = 44;
//        robot.setOnMove(new Movable() {
//            @Override
//            public void move(char direction) {
//                System.out.println("Move"+direction);
//            }
//        });
//
//        robot.setOnMove(direction -> System.out.println("Move:" + direction)); //lambda
//
//        //robot.setOnMove(() -> System.out.println("Move:"));

        TimerTask task  = new TimerTask() {
            @Override
            public void run(){
                System.out.println("prowlo 5 sek");
                count ++;
                if (count == 5) {
                    stopTimer();
                }
            }
        };

        timer.schedule(task, 5000,2000);
        System.out.println("zaverwen");
    }

    public static void stopTimer(){
        timer.cancel(); //stop timer
        timer.purge(); //removes all tasks from timer
    }
}
