package com.example.advancedwidgets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvTime = findViewById(R.id.tvTime);
        Button btnTime = findViewById(R.id.btnTime);
        Button btnGetTime2 = findViewById((R.id.btnGetTime2));

        btnGetTime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timeDialog = new TimePickerDialog(
                        MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        String time_string1=Integer.toString(hourOfDay)+":"+Integer.toString(minute);
                        tvTime.setText(time_string1);
                    }
                },5,5, true);
                timeDialog.show();
            }
        });

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = new TimePickerFragment();
                newFragment.show(getSupportFragmentManager(),"TimePickerFragment");
            }
        });

        Button btnDate = findViewById(R.id.btnGetDate);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePicker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener(){
                            @Override
                            public void onDateSet(
                                    DatePicker datePicker, int year, int month, int dayOfMonth
                            ) {

                                String godina = Integer.toString(year);
                                String mesec = Integer.toString(month+1);
                                String den = Integer.toString(dayOfMonth);
                                String datum = den+"."+mesec+"."+godina;

                                ((TextView)findViewById(R.id.tvDate)).setText(datum);
                            }
                        },1,1,1);
                datePicker.show();
            }
        });


    }
}