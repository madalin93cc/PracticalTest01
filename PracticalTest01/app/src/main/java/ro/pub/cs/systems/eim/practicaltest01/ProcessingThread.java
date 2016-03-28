package ro.pub.cs.systems.eim.practicaltest01;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Random;

/**
 * Created by colez on 27/03/2016.
 */
public class ProcessingThread extends Thread{
    private Context context;
    private boolean isRunning = true;
    private Random random = new Random();

    public ProcessingThread(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        Log.d("[ProcessingThread]", "Thread has started!");
        while (isRunning) {
//            actiune
            sendMessage();
            sleep();
        }
        Log.d("[ProcessingThread]", "Thread has stopped!");
    }

    private void sendMessage() {
//        send broadcast message
        Intent intent = new Intent();
        intent.setAction(Constants.ACTION);
        intent.putExtra("nr1", random.nextInt());
        intent.putExtra("nr2", random.nextInt());
        intent.putExtra("nr3", random.nextInt());
        intent.putExtra("nr4", random.nextInt());
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopThread() {
//        apelata la inchiderea serviciului
        isRunning = false;
    }
}
