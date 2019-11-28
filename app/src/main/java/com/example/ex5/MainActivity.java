package com.example.ex5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int UPDATA_TEXT=1;
    private TextView textView;
    private Handler handler = new Handler(){
        public  void handleMessage(Message msg){
            switch (msg.what){
                case UPDATA_TEXT:
                    textView.setText("Nice to meet you");
                    break;
                    default:
                        break;
            }
        }
    } ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_text_change = findViewById(R.id.button_text_change);
        textView = findViewById(R.id.text_original);
        button_text_change.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_text_change:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what=UPDATA_TEXT;
                        handler.sendMessage(message);
                    }
                }).start();
                break;
                default:
                    break;
        }
    }
}
