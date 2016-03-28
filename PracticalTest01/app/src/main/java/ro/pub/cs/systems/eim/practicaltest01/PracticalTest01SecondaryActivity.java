package ro.pub.cs.systems.eim.practicaltest01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01SecondaryActivity extends AppCompatActivity {
    private TextView textView1, textView2, textView3, textView4;
    private Button buttonSum, getButtonProduct;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonSuma: {
                    Integer sum = Integer.parseInt(textView1.getText().toString())
                            + Integer.parseInt(textView1.getText().toString())
                            + Integer.parseInt(textView2.getText().toString())
                            + Integer.parseInt(textView3.getText().toString())
                            + Integer.parseInt(textView4.getText().toString());
                    Toast.makeText(getApplicationContext(), "Sum: " + sum, Toast.LENGTH_LONG).show();
                    break;
                }
                case R.id.buttonProduct: {
                    Integer prod = Integer.parseInt(textView1.getText().toString())
                            * Integer.parseInt(textView1.getText().toString())
                            * Integer.parseInt(textView2.getText().toString())
                            * Integer.parseInt(textView3.getText().toString())
                            * Integer.parseInt(textView4.getText().toString());
                    Toast.makeText(getApplicationContext(), "Prod: " + prod, Toast.LENGTH_LONG).show();
                    break;
                }
            }
//        terminare activitate
//            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_secondary);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);

        buttonSum = (Button) findViewById(R.id.buttonSuma);
        getButtonProduct = (Button) findViewById(R.id.buttonProduct);

        buttonSum.setOnClickListener(buttonClickListener);
        getButtonProduct.setOnClickListener(buttonClickListener);

//        variabile trimise pe intentie la creare
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey(Constants.NR1)) {
            textView1.setText(intent.getExtras().get(Constants.NR1).toString());
        }
        if (intent != null && intent.getExtras().containsKey(Constants.NR2)) {
            textView2.setText(intent.getExtras().get(Constants.NR2).toString());
        }
        if (intent != null && intent.getExtras().containsKey(Constants.NR3)) {
            textView3.setText(intent.getExtras().get(Constants.NR3).toString());
        }
        if (intent != null && intent.getExtras().containsKey(Constants.NR4)) {
            textView4.setText(intent.getExtras().get(Constants.NR4).toString());
        }
    }
}
