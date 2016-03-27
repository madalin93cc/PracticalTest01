package ro.pub.cs.systems.eim.practicaltest01;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by colez on 27/03/2016.
 */
public class ProcessingThread extends Thread{
    private Context context;
    private boolean isRunning = true;

    public ProcessingThread(Context context/* alte variabile*/) {
        this.context = context;
    }

    @Override
    public void run() {
        Log.d("[ProcessingThread]", "Thread has started!");
        while (isRunning) {
//            actiune
//            sendMessage();
            sleep();
        }
        Log.d("[ProcessingThread]", "Thread has stopped!");
    }

    private void sendMessage() {
//        send broadcast message
        Intent intent = new Intent();
//        actiunea, trebuie sa fie aceleasi la care asculta actiunea principala
//        intent.setAction(Constants.actionTypes[random.nextInt(Constants.actionTypes.length)]);
//        intent.putExtra("message", new Date(System.currentTimeMillis()) + " " + aritm + geom);
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
