package com.sale.kalkulatorplodnihdana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Spinner;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner sp = (Spinner)findViewById(R.id.spinner);
        sp.setSelection(3);
}

    public void calculate(View view) {

        DatePicker dp = (DatePicker)findViewById(R.id.datePicker2);
        Date datePicked = getDateFromDatePicker(dp);

        Spinner sp = (Spinner)findViewById(R.id.spinner);
        int brDana = Integer.parseInt(sp.getSelectedItem().toString());

        Intent intent = new Intent(this, Calculate.class);
        intent.putExtra("date", datePicked);
        intent.putExtra("br_dana", brDana);
        this.startActivity(intent);
    }

    public static Date getDateFromDatePicker(DatePicker datePicker){
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year =  datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return calendar.getTime();
    }
}
