package com.myapplicationdev.android.p02_holidays;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    TextView tvType;
    ArrayAdapter aa;
    ArrayList<Holiday> sHoliday;
    ArrayList<Holiday> erHoliday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = (ListView) this.findViewById(R.id.lvType);
        tvType = (TextView) findViewById(R.id.textView2);

        sHoliday = new ArrayList<Holiday>();
        sHoliday.add(new Holiday("Labour Day", "labour_day"));
        sHoliday.add(new Holiday("New Year", "new_year"));

        erHoliday = new ArrayList<Holiday>();
        erHoliday.add(new Holiday("National Day", "national_day"));
        erHoliday.add(new Holiday("Christmas", "christmas"));
        erHoliday.add(new Holiday("Chinese New Year", "cny"));
        erHoliday.add(new Holiday("Deepavali", "deepavali"));
        erHoliday.add(new Holiday("Good Friday", "good_friday"));
        erHoliday.add(new Holiday("Hari Raya Haji", "hari_raya_haji"));
        erHoliday.add(new Holiday("Hari Raya Puasa", "hari_raya_puasa"));
        erHoliday.add(new Holiday("Vesak Day", "vesak_day"));

        Intent intent = getIntent();
        String type = intent.getStringExtra(Intent.EXTRA_TEXT);

        if(type.equals("Secular")){
            tvType.setText("Secular");
            aa = new HolidayAdapter(this, R.layout.row, sHoliday);
        }
        else {
            tvType.setText("Ethnic & Religion");
            aa = new HolidayAdapter(this, R.layout.row, erHoliday);
        }

        lv.setAdapter(aa);
    }



}
