package com.gadhvi.tcs;

import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ebanx.swipebtn.OnStateChangeListener;
import com.ebanx.swipebtn.SwipeButton;

public class EMG extends AppCompatActivity {
    public int counter;
    TextView textView;
    SwipeButton swipe;
    Integer a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emg);
        textView= (TextView) findViewById(R.id.textView);
        swipe=(SwipeButton)findViewById(R.id.sw);

        new CountDownTimer(10000, 1000){
            public void onTick(long millisUntilFinished){
                textView.setText(String.valueOf(counter));
                counter++;
                swipe.setOnStateChangeListener(new OnStateChangeListener() {
                    @Override
                    public void onStateChange(boolean active) {
                        cancel();
                        a=1;
                    }
                });
            }
            public  void onFinish(){
                textView.setText("Emergency Message Sent!!");
            }
        }.start();
        if(a==1)
        {
            Intent smsIntent = new Intent(Intent.ACTION_VIEW);
            smsIntent.setData(Uri.parse("smsto:"));
            smsIntent.setType("vnd.android-dir/mms-sms");
            smsIntent.putExtra("address"  , new String("8237366307;9975745215"));
            smsIntent.putExtra("sms_body"  , "Test SMS to Angilla");
            //  SmsManager smsManager = SmsManager.getDefault();
            // smsManager.sendTextMessage("7710877175", null, "sms message", null, null);

        }
    }
}
