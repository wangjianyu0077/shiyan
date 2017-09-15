package com.example.huchuan.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        final Intent intent=getIntent();
        String s=intent.getStringExtra("text");
        Toast.makeText(this,"来自MainActivity的信息："+s,Toast.LENGTH_LONG).show();
        Button button=(Button)this.findViewById(R.id.button1);
        final EditText editText=(EditText)this.findViewById(R.id.text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=editText.getText().toString();
                intent.putExtra("result",s);
                setResult(1,intent);
                finish();
            }
        });
    }
}
