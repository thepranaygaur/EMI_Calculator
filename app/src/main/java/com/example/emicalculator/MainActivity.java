package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText pr;
    EditText ra;
    EditText te;
    public static String s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.b1);
        Button button2=(Button) findViewById(R.id.b2);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openActivity2_a();
            }

        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                openActivity2_b();
            }
        });
    }
    public void openActivity2_a() {
        Intent i=new Intent(this,Main2Activity.class);
        pr=findViewById(R.id.textbox1);
        ra=findViewById(R.id.textbox2);
        te=findViewById(R.id.textbox3);
        int p=Integer.parseInt(pr.getText().toString());
        int r=Integer.parseInt(ra.getText().toString());
        int t=Integer.parseInt(te.getText().toString());
        double e1=fle(p,r,t);
        String s2= String.valueOf(e1);
        i.putExtra(s1,s2);
        startActivity(i);
    }
    public void openActivity2_b() {
        Intent i2=new Intent(this,Main2Activity.class);
        pr=findViewById(R.id.textbox1);
        ra=findViewById(R.id.textbox2);
        te=findViewById(R.id.textbox3);
        int p=Integer.parseInt(pr.getText().toString());
        int r=Integer.parseInt(ra.getText().toString());
        int t=Integer.parseInt(te.getText().toString());
        double e1=rbe(p,r,t);
        String s2= String.valueOf(e1);
        i2.putExtra(s1,s2);
        System.out.println(s1);
        startActivity(i2);
    }
    double fle(int p,int r,int n){
        double em=(p*r*power((1+r),n))/power((1+r),(n-1));
        return em;
    }
    double rbe(int p,int r,int n){
        double em=(p*r*power((1+r),n))/(((1+r)*n)-1);
        return em;
    }
    int power(int r,int n){
        int pow=1;
        if(n!=0) {
            for (int i = 0; i < n; i++) {
                pow *= r;
            }

        return(pow);
        }
        else
            return 1;
    }
}
