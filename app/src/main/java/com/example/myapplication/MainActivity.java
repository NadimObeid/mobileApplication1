package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText bill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void getTip10(View view){
        bill = findViewById(R.id.bill);
        if(TextUtils.isEmpty(bill.getText().toString())){
            bill.setError("EmptyField");
        }else{
            double tip = Double.parseDouble(bill.getText().toString())*0.1;
            Toast.makeText(this, String.format("Your tip is %.2f L.L",tip), Toast.LENGTH_SHORT).show();
        }
    }

    public void getTip15(View view){
        bill = findViewById(R.id.bill);
        if(TextUtils.isEmpty(bill.getText().toString())){
            bill.setError("EmptyField");
        }else{
            double tip = Double.parseDouble(bill.getText().toString())*0.15;
            Toast.makeText(this, String.format("Your tip is %.2f L.L",tip), Toast.LENGTH_SHORT).show();
        }
    }

    public void getTip20(View view){
        bill = findViewById(R.id.bill);
        if(TextUtils.isEmpty(bill.getText().toString())){
            bill.setError("EmptyField");
        }else{
            double tip = Double.parseDouble(bill.getText().toString())*0.2;
            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("tip",tip);
            startActivity(intent);
        }
    }

}