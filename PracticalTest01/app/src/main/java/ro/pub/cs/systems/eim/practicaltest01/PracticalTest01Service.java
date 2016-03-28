package ro.pub.cs.systems.eim.practicaltest01;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class PracticalTest01Service extends Service {
    private ProcessingThread processingThread;

    public PracticalTest01Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
//            variabile de pe intentie
        }
        processingThread = new ProcessingThread(this);
        processingThread.start();
        return Service.START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
//        oprire thread
        processingThread.stopThread();
    }
}
