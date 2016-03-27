package ro.pub.cs.systems.eim.practicaltest01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PracticalTest01SecondaryActivity extends AppCompatActivity {

//    private class ButtonClickListener implements View.OnClickListener {
//        @Override
//        public void onClick(View v) {
//            switch (v.getId()) {
//                case R.id.buttonOk: {
//                    setResult(RESULT_OK, null);
//                    break;
//                }
//                case R.id.buttonCancel: {
//                    setResult(RESULT_CANCELED, null);
//                    break;
//                }
//            }
//        terminare activitate
//            finish();
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_secondary);

//        variabile trimise pe intentie la creare
//        Intent intent = getIntent();
//        if (intent != null && intent.getExtras().containsKey(Constants.TOTAL_CLICKS)) {
//            editText.setText(intent.getExtras().getString(Constants.TOTAL_CLICKS));
//        }
    }
}
