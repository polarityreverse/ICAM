package com.example.ankit.icam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
    Intent i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.mpl1_mis);
        b2=findViewById(R.id.mpl2_mis);
        b3=findViewById(R.id.mpl3_mis);
        b4=findViewById(R.id.mpl5_mis);

        b5=findViewById(R.id.mpl1_hfdv);
        b6=findViewById(R.id.mpl2_hfdv);
        b7=findViewById(R.id.mpl3_hfdv);
        b8=findViewById(R.id.mpl5_hfdv);

        b9=findViewById(R.id.mpl1_cfdv);
        b10=findViewById(R.id.mpl2_cfdv);
        b11=findViewById(R.id.mpl3_cfdv);
        b12=findViewById(R.id.mpl5_cfdv);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i1 = new Intent(MainActivity.this, MPL1_MIS.class);
                startActivity(i1);

            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i2 = new Intent(MainActivity.this, MPL2_MIS.class);
                startActivity(i2);

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i3 = new Intent(MainActivity.this, MPL3_MIS.class);
                startActivity(i3);

            }
        });



        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i4 = new Intent(MainActivity.this, MPL5_MIS.class);
                startActivity(i4);

            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i5 = new Intent(MainActivity.this, MPL1_HFDV.class);
                startActivity(i5);

            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i6 = new Intent(MainActivity.this, MPL2_HFDV.class);
                startActivity(i6);

            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i7 = new Intent(MainActivity.this, MPL3_HFDV.class);
                startActivity(i7);

            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i8 = new Intent(MainActivity.this, MPL5_HFDV.class);
                startActivity(i8);

            }
        });



        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i9 = new Intent(MainActivity.this, MPL1_CFDV.class);
                startActivity(i9);

            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i10 = new Intent(MainActivity.this, MPL2_CFDV.class);
                startActivity(i10);

            }
        });

        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i11 = new Intent(MainActivity.this, MPL3_CFDV.class);
                startActivity(i11);

            }
        });

        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i12 = new Intent(MainActivity.this, MPL5_CFDV.class);
                startActivity(i12);

            }
        });
    }
}
