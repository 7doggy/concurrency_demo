package com.lichun;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                //e.printStackTrace();
                System.out.println("thread is interrupted!");
            }
        });
        thread.setDaemon(true);
        thread.start();
        System.out.println(thread.isInterrupted());
        TimeUnit.MILLISECONDS.sleep(2);
        thread.interrupt();
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.println(thread.isInterrupted());
    }
}
