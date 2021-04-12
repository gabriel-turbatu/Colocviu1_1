package ro.pub.cs.systems.eim.colocviu1_1service;

import java.util.Date;
import java.util.Random;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import ro.pub.cs.systems.eim.colocviu1_1service.Constants;

public class ProcessingThread extends Thread {

    private Context context = null;
    private boolean isRunning = true;


    private String data;

    public ProcessingThread(Context context, String data) {
        this.context = context;

        this.data = data;
    }

    @Override
    public void run() {
        Log.d(Constants.PROCESSING_THREAD_TAG, "Thread has started! PID: TID: ");
        while (isRunning) {
            sendMessage();
            sleep();
        }
        Log.d(Constants.PROCESSING_THREAD_TAG, "Thread has stopped!");
    }

    private void sendMessage() {
        Intent intent = new Intent();
        intent.putExtra("message",
                new Date(System.currentTimeMillis()) + " " + data);
        context.sendBroadcast(intent);
        Log.d("message", "I've sent intent");
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void stopThread() {
        isRunning = false;
    }
}