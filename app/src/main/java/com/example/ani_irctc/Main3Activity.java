package com.example.ani_irctc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    EditText api=null;
    Button submit=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        api=findViewById(R.id.editText2);
        submit=findViewById(R.id.button3);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database d=new database(Main3Activity.this);
                d.delete();
                d.insert(api.getText().toString());
                api.setText("");
                Toast.makeText(getApplicationContext(),"API KEY HAS BEEN CHANGED",Toast.LENGTH_LONG).show();
            }
        });
    }
}
