package com.example.phuongtrinhbac2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText input_a, input_b, input_c;
    Button btn_tieptuc, btn_giaipt, btn_thoat;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_a = findViewById(R.id.input_a);
        input_b = findViewById(R.id.input_b);
        input_c = findViewById(R.id.input_c);

        output = findViewById(R.id.output);

        btn_tieptuc = findViewById(R.id.btn_tieptuc);
        btn_giaipt = findViewById(R.id.btn_giaipt);
        btn_thoat = findViewById(R.id.btn_thoat);

        btn_giaipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*lay du lieu vao*/
                int a = Integer.parseInt(input_a.getText().toString());
                int b = Integer.parseInt(input_b.getText().toString());
                int c = Integer.parseInt(input_c.getText().toString());


                String kq = "";
                DecimalFormat dcf = new DecimalFormat("#.00");
                if (a == 0) {
                    if (b == 0) {
                        if (c == 0)
                            kq = "PT vô số nghiệm";
                        else
                            kq = "PT vô nghiệm";
                    } else {
                        kq = "Pt có 1 No, x=" + dcf.format(-c / b);
                    }
                } else {
                    double delta = b * b - 4 * a * c;
                    if (delta < 0) {
                        kq = "PT vô nghiệm";
                    } else if (delta == 0) {
                        kq = "Pt có No kép x1=x2=" + dcf.format(-b / (2 * a));
                    } else {
                        kq = "Pt có 2 No: x1=" + dcf.format((-b + Math.sqrt(delta)) / (2 * a)) + "; x2=" + dcf.format((-
                                b - Math.sqrt(delta)) / (2 * a));
                    }
                }
                output.setText(kq);
            }


        });
        btn_tieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_a.setText("");
                input_b.setText("");
                input_c.setText("");
                input_a.requestFocus();
            }
        });
        btn_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}