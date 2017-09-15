package com.example.huchuan.handlertest;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView=(TextView)this.findViewById(R.id.textView);
        final Handler handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                textView.setText(msg.arg1+"");
            }
        };
        final Runnable runnable=new Runnable() {

            @Override
            public void run() {
                int pro=0;
                while (pro<100){
                    Message msg=new Message();
                    msg.arg1=pro;
                    handler.sendMessage(msg);
                    pro++;
                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        final Thread thread=new Thread(null,runnable,"MyThread");
        Button button1=(Button)this.findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thread.start();
            }
        });
    }
}
