package ro.pub.cs.systems.eim.practicaltest01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01MainActivity extends AppCompatActivity {
//    private members: ui elements, handlers, broadcast receiver, filters
    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private MessageBroadcastReceiver messageBroadcastReceiver = new MessageBroadcastReceiver();
    private IntentFilter intentFilter = new IntentFilter();
    private EditText editText1, editText2, editText3, editText4;
    private Button buttonSet;
    private Boolean serviceStarted = false;

    private class MessageBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            editText1.setText(intent.getExtras().get("nr1").toString());
            editText2.setText(intent.getExtras().get("nr2").toString());
            editText3.setText(intent.getExtras().get("nr3").toString());
            editText4.setText(intent.getExtras().get("nr4").toString());
        }
    }
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Integer nr1 = null, nr2 = null, nr3 = null, nr4 = null;
            if (!editText1.getText().equals(""))
            nr1 = Integer.parseInt(editText1.getText().toString());
            if (!editText2.getText().equals(""))
            nr2 = Integer.parseInt(editText2.getText().toString());
            if (!editText3.getText().equals(""))
            nr3 = Integer.parseInt(editText3.getText().toString());
            if (!editText4.getText().equals(""))
            nr4 = Integer.parseInt(editText4.getText().toString());

            if (nr1 != null && nr2 != null & nr3 != null & nr4 != null) {
                switch (v.getId()) {
                    case R.id.buttonSet: {
                        //                pornire activitate
                        Intent intent = new Intent("ro.pub.cs.systems.eim.practicaltest01.PracticalTest01SecondaryActivity");
                        intent.putExtra(Constants.NR1, nr1);
                        intent.putExtra(Constants.NR2, nr2);
                        intent.putExtra(Constants.NR3, nr3);
                        intent.putExtra(Constants.NR4, nr4);
                        startActivityForResult(intent, 1);
                        break;
                    }
                }
            }

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
        outState.putString(Constants.NR1, editText1.getText().toString());
        outState.putString(Constants.NR2, editText2.getText().toString());
        outState.putString(Constants.NR3, editText3.getText().toString());
        outState.putString(Constants.NR4, editText4.getText().toString());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);

//        initializari variabile globale ui
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        buttonSet = (Button) findViewById(R.id.buttonSet);
//        listeneri butoane
        buttonSet.setOnClickListener(buttonClickListener);
//        initializare filtru cu actiuni
        intentFilter.addAction(Constants.ACTION);
        Intent intent = new Intent(getApplicationContext(), PracticalTest01Service.class);
        getApplicationContext().startService(intent);
        serviceStarted = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
//        inregistrarea receiverului cu filter
        registerReceiver(messageBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
//        oprirea listenerului cand apicatia nu e pornita
        unregisterReceiver(messageBroadcastReceiver);
        super.onPause();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
//        restaurare stare
        editText1.setText(savedInstanceState.getString(Constants.NR1));
        editText2.setText(savedInstanceState.getString(Constants.NR2));
        editText3.setText(savedInstanceState.getString(Constants.NR3));
        editText4.setText(savedInstanceState.getString(Constants.NR4));
    }

    @Override
    protected void onDestroy() {
//        oprirea serviciului odata cu oprirea aplicatiei
        Intent intent = new Intent(this, PracticalTest01Service.class);
        stopService(intent);
        super.onDestroy();
    }
}
