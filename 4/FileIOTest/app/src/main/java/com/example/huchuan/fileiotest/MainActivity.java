package com.example.huchuan.fileiotest;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnWrite=(Button) this.findViewById(R.id.write);
        Button btnRead=(Button) this.findViewById(R.id.read);
        final EditText sid=(EditText) this.findViewById(R.id.Sid);
        final EditText name=(EditText) this.findViewById(R.id.name);
        final String MyFileName="myfile.txt";
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OutputStream out=null;
                try{
                    if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                        File file=Environment.getExternalStorageDirectory();
                        File myfile=new File(file.getCanonicalPath() + "/"+ MyFileName);
                        FileOutputStream fileOutputStream=new FileOutputStream(myfile);
                        out=new BufferedOutputStream(fileOutputStream);
                        String strId=sid.getText().toString();
                        String strName=name.getText().toString();
                        String content="学号:"+strId+",姓名:"+strName;
//                        String content="hello";
                        try{
                            out.write(content.getBytes(StandardCharsets.UTF_8));
                            Toast.makeText(MainActivity.this,"已写入"+strId+strName, Toast.LENGTH_SHORT).show();
                        }finally {
                            out.close();
                        }
                    }
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputStream in=null;
                try {
                    if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                        File file=Environment.getExternalStorageDirectory();
                        File myfile=new File(file.getCanonicalPath()+"/"+MyFileName);
                        FileInputStream fileInputStream=new FileInputStream(myfile);
                        in=new BufferedInputStream(fileInputStream);
                        BufferedReader reader=new BufferedReader(new InputStreamReader(in,"UTF-8"));
                        String line="";
                        String result = null;
                        try {
                            while((line=reader.readLine())!=null){
                                result=line;
                            }
                            Toast.makeText(MainActivity.this,result, Toast.LENGTH_SHORT).show();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
