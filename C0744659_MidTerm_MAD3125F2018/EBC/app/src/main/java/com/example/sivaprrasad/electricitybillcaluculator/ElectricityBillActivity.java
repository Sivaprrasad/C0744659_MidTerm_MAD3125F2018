package com.example.sivaprrasad.electricitybillcaluculator;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.Calendar;
import java.util.Date;

public class ElectricityBillActivity extends AppCompatActivity {

    private static final String TAG = "ElectricityBillActivity";

    private EditText cID, cName, cEmail, billdat, ucons, totalBA;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private RadioGroup radioGroupGender;
    private Button sub;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity_bill);
        cID = (EditText)findViewById(R.id.custId);
        cName = (EditText)findViewById(R.id.custName);
        cEmail = (EditText)findViewById(R.id.custEmail);
        billdat = (EditText)findViewById(R.id.billDate);
        ucons = (EditText)findViewById(R.id.unitsConsumed);
        totalBA = (EditText)findViewById(R.id.totalBillAmount);
        sub = (Button)findViewById(R.id.submit);
        radioGroupGender = (RadioGroup)findViewById(R.id.rgGender);

        billdat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(ElectricityBillActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyyy: " + month + "/" + dayOfMonth + "/" + year );

                String date = month + "/" + dayOfMonth + "/" + year;
                billdat.setText(date);
            }
        };

        radioGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id)
            {
                switch (id)
                {
                    case R.id.rbMale:
                        //txtMessage.setText("MALE");
                        break;
                    case R.id.rbFemale:
                        //txtMessage.setText("FEMALE");
                        break;
                    case R.id.rbOther:
                        //txtMessage.setText("OTHER");
                }
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* if (ucons < 100)
                {
                    totalBA  = (ucons) * 0.75;

                } else if (ucons >100 && ucons < 150)
                {
                    totalBA = ((ucons-100) * 1.25);
                }else if (ucons >150 && ucons < 200)
                {
                    totalBA = ((ucons-150) * 1.75);
                }
                else if (ucons > 450)
                {
                    totalBA = ((ucons-200)* 2.25);
                }
                */
                Intent i = new Intent(ElectricityBillActivity.this, BillDetailsActivity.class);
                startActivity(i);

            }
        });

    }
}
