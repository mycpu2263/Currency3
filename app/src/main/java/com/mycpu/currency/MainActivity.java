package com.mycpu.currency;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edntd;
    private TextView tusd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        extracted();
    }

    private void extracted() {
        edntd = findViewById(R.id.ed_ntd);
        tusd = findViewById(R.id.t_usd);
        Button clear = findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String o =": None";
                tusd.setText(o);
            }
        });
    }

    public void currency(View view){
        if(edntd.getText().toString().equals("")){
            AlertDialog show = new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Problem")
                    .setMessage("Please enter your NTD amount.")
                    .setPositiveButton("OK", null)
                    .show();
                    return;
        }else{
        String n = edntd.getText().toString();
        String u = String.valueOf(30.9);
        float ntd = Float.parseFloat(n) ;
        float ntdtousd = Float.parseFloat(u);
        float usd = ntd /ntdtousd;
        Log.d("mainactivy","USD:"+usd);
        Toast.makeText(this,"NTD "+ntd+"=USD "+usd,Toast.LENGTH_LONG).show();
        tusd.setText(": "+usd);
        new AlertDialog.Builder(this)
                .setTitle("Result")
                .setMessage("NTD "+ntd+"=USD "+usd)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        edntd.setText("");
                    }
                })
                .show();}
    }
}