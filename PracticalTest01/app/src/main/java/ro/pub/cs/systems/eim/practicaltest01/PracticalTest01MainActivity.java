package ro.pub.cs.systems.eim.practicaltest01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01MainActivity extends AppCompatActivity {
//    private members: ui elements, handlers, broadcast receiver, filters
//    private ButtonClickListener buttonClickListener = new ButtonClickListener();
//    private MessageBroadcastReceiver messageBroadcastReceiver = new MessageBroadcastReceiver();
//    private IntentFilter intentFilter = new IntentFilter();

    //    folosita pentru interceptarea mesajelor conform cu filtrul definit
//    private class MessageBroadcastReceiver extends BroadcastReceiver {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            Log.d("[Message]", intent.getStringExtra("message"));
//        }
//    }
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.button: {
//                break;
//            }
//            case R.id.button2: {
//                break;
//            }
//            case R.id.buttonSwitch: {
//                pornire activitate
//                Intent intent = new Intent("ro.pub.cs.systems.eim.practicaltest01.PracticalTest01SecondaryActivity");
//                Integer nr = Integer.parseInt(leftEditText.getText().toString())+ Integer.parseInt(rightEditText.getText().toString());
//                intent.putExtra(Constants.TOTAL_CLICKS, nr.toString());
//                startActivityForResult(intent,1);
//                break;
//            }
//        }

//        Integer sum = Integer.parseInt(leftEditText.getText().toString()) + Integer.parseInt(rightEditText.getText().toString());
//        if (sum > Constants.limit && !serviceStarted) {
//            pornire serviciu
//            Intent intent = new Intent(getApplicationContext(), PracticalTest01Service.class);
//            intent.putExtra(Constants.NR_1, leftEditText.getText().toString());
//            intent.putExtra(Constants.NR_2, rightEditText.getText().toString());
//            getApplicationContext().startService(intent);
//            serviceStarted = true;
//        }
        }
    }

    @Override
//    apelata la distrugerea activitatii
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1: { // cod dar la pornirea activitatii
//                Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
// salvarea starii
//        outState.putString(Constants.TEXT_FIELD_LEFT, leftEditText.getText().toString());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);

//        initializari variabile globale ui
//        leftEditText = (EditText) findViewById(R.id.editText);

//        listeneri butoane
//        leftButton.setOnClickListener(buttonClickListener);

//        initializare filtru cu actiuni
//        for(int i = 0; i < Constants.actionTypes.length; i++) {
//            intentFilter.addAction(Constants.actionTypes[i]);
//        }
    }

    @Override
    protected void onResume() {
        super.onResume();
//        inregistrarea receiverului cu filter
//        registerReceiver(messageBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
//        oprirea listenerului cand apicatia nu e pornita
//        unregisterReceiver(messageBroadcastReceiver);
        super.onPause();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
//        restaurare stare
//        leftEditText.setText(savedInstanceState.getString(Constants.TEXT_FIELD_LEFT));
    }

    @Override
    protected void onDestroy() {
//        oprirea serviciului odata cu oprirea aplicatiei
//        Intent intent = new Intent(this, PracticalTest01Service.class);
//        stopService(intent);
        super.onDestroy();
    }
}
