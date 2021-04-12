package ro.pub.cs.systems.eim.Colocviu1_1;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Date;

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
        Log.d("pthread", "Thread has started! PID:  TID: ");
        while (isRunning) {
            sendMessage();
            sleep();
        }
        Log.d("pthread", "Thread has stopped!");
    }

    private void sendMessage() {
        Intent intent = new Intent();
        intent.setAction("ro.pub.cs.systems.eim.practicaltest01.data");
        intent.putExtra("message",
                new Date(System.currentTimeMillis()) + " " + data);
        context.sendBroadcast(intent);
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
