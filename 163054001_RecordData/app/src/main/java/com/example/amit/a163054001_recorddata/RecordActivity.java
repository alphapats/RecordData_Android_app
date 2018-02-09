package com.example.amit.a163054001_recorddata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.CircularArray;
import android.view.View;
import android.widget.Button;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.EditText;
import java.lang.Object;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Amit on 24-01-2018.
 */

public class RecordActivity extends MainActivity {
    private Switch RecordSwitch;
    Calendar start_time,stop_time;
    int hr1,min1,sec1;
    int hr2,min2,sec2;
    CircularArray display= new  CircularArray(5);
    long time=0;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setSelectedNavigationItem(2);
        setContentView(R.layout.record);

        RecordSwitch = (Switch) findViewById(R.id.RecordSwitch);
        Button btnclose = (Button) findViewById(R.id.closebtn);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //Intent intent=new Intent(currentclass.this,statingclass.class);
                finish();

            }
        });

        RecordSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {
                if (bChecked) {
                    //start_time=System.currentTimeMillis();
                    start_time=Calendar.getInstance();
                    hr1 = start_time.get(Calendar.HOUR_OF_DAY);
                    min1 = start_time.get(Calendar.MINUTE);
                    sec1 = start_time.get(Calendar.SECOND);

                } else {
                    //stop_time=System.currentTimeMillis();
                    stop_time = Calendar.getInstance();
                    hr2 = stop_time.get(Calendar.HOUR_OF_DAY);
                    min2 = stop_time.get(Calendar.MINUTE);
                    sec2 = stop_time.get(Calendar.SECOND);

                    //Toast.makeText(getApplicationContext(), "Timer stopped", Toast.LENGTH_SHORT).show();
                    print_reading();;
                }

                //Toast.makeText(getApplicationContext(), "Timer started", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        if(itemPosition ==1){
            Intent intent = new Intent(RecordActivity.this,SensorActivity.class);
            intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK|intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        }
        if(itemPosition ==0){
            Intent intent = new Intent(RecordActivity.this,LoginActivity.class);
            intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK|intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        }
        return true;
        //return super.onNavigationItemSelected(itemPosition, itemId);
    }

    private void print_reading()
    {
        final TextView txtreading1,txtreading2,txtreading3,txtreading4,txtreading5;
        txtreading1=(TextView) findViewById(R.id.reading1);
        txtreading2=(TextView) findViewById(R.id.reading2);
        txtreading3=(TextView) findViewById(R.id.reading3);
        txtreading4=(TextView) findViewById(R.id.reading4);
        txtreading5=(TextView) findViewById(R.id.reading5);



        //time=(stop_time-start_time)/1000;
        StringBuilder sb = new StringBuilder("Stop Time is ");
        sb.append(hr2);
        sb.append(" hr ");
        sb.append(min2);
        sb.append(" mins ");
        sb.append(sec2);
        sb.append(" seconds.");
        //String elapsed_time = String.valueOf(time);
        //sb.append(time);
        count++;

        if (count<=5)
        {
            display.addLast(sb);
            if(count ==1){

                txtreading1.setText(sb); //leave this line to assign a specific text
                //txtreading1.setText(R.string.reading1);


            }

            if(count ==2){

                txtreading2.setText(sb); //leave this line to assign a specific text
                //txtreading2.setText(R.string.reading2);
            }

            if(count ==3){

                txtreading3.setText(sb); //leave this line to assign a specific text
                //txtreading3.setText(R.string.reading3);
            }

            if(count ==4){

                txtreading4.setText(sb); //leave this line to assign a specific text
                //txtreading4.setText(R.string.reading4);
            }

            if(count ==5){

                txtreading5.setText(sb); //leave this line to assign a specific text
                // txtreading5.setText(R.string.reading5);
            }
        }
        else
        {
            display.popFirst();
            display.addLast(sb);

            //String temp_val = new String();
            String temp_val=display.get(0).toString();
            txtreading1.setText(temp_val);


            temp_val=display.get(1).toString();
            txtreading2.setText(temp_val);


            temp_val=display.get(2).toString();
            txtreading3.setText(temp_val);


            temp_val=display.get(3).toString();
            txtreading4.setText(temp_val);

            temp_val=display.get(4).toString();
            txtreading5.setText(temp_val);


        }

    }

}
