package com.myapplicationdev.android.p02_holidays;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    TextView tvType;
    ArrayAdapter aa;
    ArrayList<Holiday> sHoliday;
    ArrayList<Holiday> erHoliday;
    ArrayList<Holiday> arraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = (ListView) this.findViewById(R.id.lvType);
        tvType = (TextView) findViewById(R.id.textView2);

        sHoliday = new ArrayList<Holiday>();
        sHoliday.add(new Holiday("Labour Day", "labour_day", "1 May 2017"));
        sHoliday.add(new Holiday("New Year's Day", "new_year", "1 Jan 2017"));

        erHoliday = new ArrayList<Holiday>();
        erHoliday.add(new Holiday("National Day", "national_day", "9 Aug 2017"));
        erHoliday.add(new Holiday("Christmas", "christmas", "25 Dec 2017"));
        erHoliday.add(new Holiday("Chinese New Year", "cny", "28-29 Jan 2017"));
        erHoliday.add(new Holiday("Deepavali", "deepavali", "18 Oct 2017"));
        erHoliday.add(new Holiday("Good Friday", "good_friday", "14 April 2017"));
        erHoliday.add(new Holiday("Hari Raya Haji", "hari_raya_haji", "31 Aug - 1 Sep 2017"));
        erHoliday.add(new Holiday("Hari Raya Puasa", "hari_raya_puasa", "26 June 2017"));
        erHoliday.add(new Holiday("Vesak Day", "vesak_day", "10 May 2017"));

        Intent intent = getIntent();
        String type = intent.getStringExtra(Intent.EXTRA_TEXT);

        if(type.equals("Secular")){
            tvType.setText("Secular");
            aa = new HolidayAdapter(this, R.layout.row, sHoliday);
            arraylist = sHoliday;
        }
        else {
            tvType.setText("Ethnic & Religion");
            aa = new HolidayAdapter(this, R.layout.row, erHoliday);
            arraylist = erHoliday;
        }

        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holiday selectedHoliday = arraylist.get(position);

                Toast.makeText(SecondActivity.this, selectedHoliday.getName()
                                + " Date: " + selectedHoliday.getDate(),
                        Toast.LENGTH_LONG).show();


            }
        });
    }



}
