package com.example.ani_irctc;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
 Button b=null;
 EditText e=null;
 TextView detail=null;
 TextView anim=null;
 String url=null;
 database d=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.button4);
        anim=findViewById(R.id.login);
        detail=findViewById(R.id.detail);
        d=new database(this);
            d.insert("po3l91jz5j");
        e=findViewById(R.id.editText);
        YoYo.with(Techniques.Flash).delay(0).repeat(10000).playOn(anim);
        YoYo.with(Techniques.Flash).delay(0).repeat(10000).playOn(findViewById(R.id.textView));
        YoYo.with(Techniques.Flash).delay(0).repeat(10000).playOn(b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Please Enter Train Number",Toast.LENGTH_LONG).show();
                }
                else
                {
                    if(e.getText().toString().length()!=5)
                    {
                        Toast.makeText(getApplicationContext(), "Incorrect Train Number", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        RequestQueue queue=null;
                            String API_KEY = "";
                            Cursor c = d.fetch();
                            c.moveToFirst();
                            API_KEY += c.getString(0);
                            url = "https://api.railwayapi.com/v2/route/train/" + e.getText().toString() + "/apikey/" + API_KEY + "/";
                             queue = Volley.newRequestQueue(MainActivity.this);
                        JsonObjectRequest request=new JsonObjectRequest(JsonObjectRequest.Method.GET,url, null, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                            String data="";
                            try {


                                int id = response.getInt("response_code");
                                if(id!=200)
                                {
                                    Toast.makeText(getApplicationContext(),"Check Internet or Train Number or May API KEY IS EXPIRED ",Toast.LENGTH_LONG).show();
                                }
                                else
                                {
                                    JSONArray array=response.getJSONArray("route");
                                    int length=array.length();
                                    for(int i=0;i<length;i++)
                                    {
                                        JSONObject object=array.getJSONObject(i);
                                        JSONObject sub=object.getJSONObject("station");
                                        data+="       Name      "+sub.getString("name")+"\n";
                                        data+="       Code      "+sub.getString("code")+"\n";
                                        data+="       Latitude  "+sub.getDouble("lat")+"\n";
                                        data+="       Longitude "+sub.getDouble("lng")+"\n";
                                        data+="       Arrival   "+object.getString("scharr")+"\n";
                                        data+="       Departure "+object.getString("schdep")+"\n";
                                        data+="       Day       "+object.getInt("day")+"\n";
                                        data+="       Distance  "+object.getInt("distance")+"\n";
                                        data+="       Halt Time "+object.getInt("halt")+"\n";
                                        data+="                                               \n";
                                        data+="                                                \n";
                                        data+="                                                \n";

                                    }
                                    data+="__________\n";
                                    data+="___________\n";
                                    data+="____________\n";
                                    detail.setText(data);
                                }
                            }
                            catch (Exception e)
                            {
                                Toast.makeText(getApplicationContext(),"There is some Exception",Toast.LENGTH_LONG).show();
                            }




                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        });
                    queue.add(request);
                    }
                }

            }
        });


    }


    public void action(View v)
    {
        Intent i=new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(i);
    }
}
