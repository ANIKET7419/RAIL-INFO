package com.example.ani_irctc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    String username="ANIKET";
    String password="India@123456";
    EditText us=null;
    EditText pa=null;
    Button lo=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        us=findViewById(R.id.name);
        pa=findViewById(R.id.editText3);
        lo=findViewById(R.id.button2);
        lo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(us.getText().toString().equals(username)&&pa.getText().toString().equals(password))
                {
                    Intent j=new Intent(getApplicationContext(),Main3Activity.class);
                    startActivity(j);
                }
                else
                {
                    us.setText("");
                    pa.setText("");
                    Toast.makeText(getApplicationContext(),"Something Wrong!!! ",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
