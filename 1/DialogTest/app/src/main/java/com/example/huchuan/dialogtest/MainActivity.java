package com.example.huchuan.dialogtest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn1=(Button)this.findViewById(R.id.button1);
        Button btn2=(Button)this.findViewById(R.id.button2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder1=new AlertDialog.Builder(MainActivity.this);
                builder1.setTitle("对话框").setMessage("这是一个对话框");
                builder1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"确定",Toast.LENGTH_LONG).show();
                    }
                });
                builder1.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"取消",Toast.LENGTH_LONG).show();
                    }
                });
                builder1.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"忽略",Toast.LENGTH_LONG).show();
                    }
                });
                builder1.show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder2=new AlertDialog.Builder(MainActivity.this);
                LayoutInflater layoutInflater=getLayoutInflater();
                final View view1=layoutInflater.inflate(R.layout.login_dialog,null);
                builder2.setView(view1);
                builder2.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        final EditText Username=(EditText)view1.findViewById(R.id.username);
                        final EditText Password=(EditText)view1.findViewById(R.id.password);
                        String username= Username.getText().toString();
                        String password= Password.getText().toString();
                        Log.i("Text",username+password);
                        if(username.equals("abc")&&password.equals("123")){
                            Toast.makeText(MainActivity.this,"成功",Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(MainActivity.this,"失败",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                builder2.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder2.show();
            }
        });
    }
}
