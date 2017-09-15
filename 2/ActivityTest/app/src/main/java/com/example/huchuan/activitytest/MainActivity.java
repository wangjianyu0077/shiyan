package com.example.huchuan.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1=(Button)this.findViewById(R.id.button1);
        Button button2=(Button)this.findViewById(R.id.button2);
        final EditText editText=(EditText)this.findViewById(R.id.text);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=editText.getText().toString();
                Intent intent=new Intent(MainActivity.this,FirstActivity.class);
                intent.putExtra("text",s);
                startActivityForResult(intent,1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=editText.getText().toString();
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("text",s);
                startActivityForResult(intent,2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==1){
            String str=data.getStringExtra("result");
            Toast.makeText(MainActivity.this,"从Activity1返回："+str,Toast.LENGTH_LONG).show();
        }else if(requestCode==2 && resultCode==2){
                String str=data.getStringExtra("result");
                Toast.makeText(MainActivity.this,"从Activity2返回："+str,Toast.LENGTH_LONG).show();
        }
    }
}
