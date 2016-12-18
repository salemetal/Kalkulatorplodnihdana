package com.sale.kalkulatorplodnihdana;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Created by Sale on 27.6.2016..
 */
public class Calculate extends AppCompatActivity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.izracun_plodnih_dana);

        Date dateSelected = (Date)getIntent().getSerializableExtra("date");
        Bundle extras = getIntent().getExtras();
        int brDana = extras.getInt("br_dana");
        fillGrid(dateSelected, brDana);
    }

    private void fillGrid(Date dateSelected, int brDana)
    {
        Date dateStartMon;
        Dictionary dates = new Hashtable();

        Calendar c1 = Calendar.getInstance();
        c1.setTime(dateSelected);
        int dayOTV = c1.get(Calendar.DAY_OF_WEEK);

        if (dayOTV == Calendar.MONDAY)
        {
            dateStartMon = dateSelected;
        }
        else
        {
            dateStartMon = getMondayDate(dateSelected);
        }

        dates = getDates(dates, dateSelected, brDana);

        for (int i=1; i<43; i++)
        {
            DateFormat df = new SimpleDateFormat("dd.MM.");
            String dateF = df.format(dateStartMon);

            String day = "Day" + i;
            TextView textView = (TextView)findViewById(getResources().getIdentifier(day, "id", getPackageName()));

            textView.setText(dateF);
            textView.setTextSize(getResources().getDimension(R.dimen.date_size));

            if (dateStartMon.equals(dateSelected))
            {
                textView.setBackgroundResource(R.drawable.tv_zadnja_mj);
                textView.setTextColor(Color.WHITE);
            }
            else if (dateStartMon.equals(dates.get("datePlodno1"))
                    ||dateStartMon.equals(dates.get("datePlodno2"))
                    ||dateStartMon.equals(dates.get("datePlodno3"))
                    ||dateStartMon.equals(dates.get("datePlodno4"))
                    ||dateStartMon.equals(dates.get("datePlodno5")))
            {
                textView.setBackgroundResource(R.drawable.tv_plodno);
                textView.setTextColor(Color.WHITE);
            }
            else if  (dateStartMon.equals(dates.get("dateJakoPlodno1"))
                    ||dateStartMon.equals(dates.get("dateJakoPlodno2"))
                    ||dateStartMon.equals(dates.get("dateJakoPlodno3")))
            {
                textView.setBackgroundResource(R.drawable.tv_jako_plodno);
                textView.setTextColor(Color.WHITE);
            }
            else if  (dateStartMon.equals(dates.get("dateNajplodnije")))
            {
                textView.setBackgroundResource(R.drawable.tv_najplodnije);
                textView.setTextColor(Color.WHITE);
            }
            else if  (dateStartMon.equals(dates.get("dateTest1"))
                    ||dateStartMon.equals(dates.get("dateTest2")))
            {
                textView.setBackgroundResource(R.drawable.tv_test);
                textView.setTextColor(Color.WHITE);
            }
            else if  (dateStartMon.equals(dates.get("dateSljMj")))
            {
                textView.setBackgroundResource(R.drawable.tv_slj_mj);
                textView.setTextColor(Color.WHITE);
            }
            else if  (dateStartMon.equals(dates.get("dateKasni")))
            {
                textView.setBackgroundResource(R.drawable.tv_kasni);
                textView.setTextColor(Color.WHITE);
            }

            Calendar c = Calendar.getInstance();
            c.setTime(dateStartMon);
            c.add(Calendar.DATE, 1);
            dateStartMon = c.getTime();
        }
    }

    private Date getMondayDate(Date date)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.DAY_OF_WEEK);

        while (day != Calendar.MONDAY)
        {
            c.add(Calendar.DATE, -1);
            date = c.getTime();
            day = c.get(Calendar.DAY_OF_WEEK);
        }
        return date;
    }

    private Dictionary<String, Date> getDates (Dictionary<String, Date> dates, Date dateSelected, int brDana)
    {
        int dayStartPlodno = brDana - 19;

            Calendar plodno1 = Calendar.getInstance();
        plodno1.setTime(dateSelected);
        plodno1.add(Calendar.DATE, dayStartPlodno);
        Date datePlodno1 = plodno1.getTime();
        dates.put("datePlodno1", datePlodno1);

        plodno1.add(Calendar.DATE, 1);
        Date datePlodno2 = plodno1.getTime();
        dates.put("datePlodno2", datePlodno2);

        plodno1.add(Calendar.DATE, 1);
        Date datePlodno3 = plodno1.getTime();
        dates.put("datePlodno3", datePlodno3);

        plodno1.add(Calendar.DATE, 1);
        Date dateJakoPlodno1 = plodno1.getTime();
        dates.put("dateJakoPlodno1", dateJakoPlodno1);

        plodno1.add(Calendar.DATE, 1);
        Date dateJakoPlodno2 = plodno1.getTime();
        dates.put("dateJakoPlodno2", dateJakoPlodno2);

        plodno1.add(Calendar.DATE, 1);
        Date dateNajplodnije = plodno1.getTime();
        dates.put("dateNajplodnije", dateNajplodnije);

        plodno1.add(Calendar.DATE, 1);
        Date dateJakoPlodno3 = plodno1.getTime();
        dates.put("dateJakoPlodno3", dateJakoPlodno3);

        plodno1.add(Calendar.DATE, 1);
        Date datePlodno4 = plodno1.getTime();
        dates.put("datePlodno4", datePlodno4);

        plodno1.add(Calendar.DATE, 1);
        Date datePlodno5 = plodno1.getTime();
        dates.put("datePlodno5", datePlodno5);

        plodno1.add(Calendar.DATE, 7);
        Date dateTest1 = plodno1.getTime();
        dates.put("dateTest1", dateTest1);

        plodno1.add(Calendar.DATE, 2);
        Date dateTest2 = plodno1.getTime();
        dates.put("dateTest2", dateTest2);

        plodno1.add(Calendar.DATE, 2);
        Date dateSljMj = plodno1.getTime();
        dates.put("dateSljMj", dateSljMj);

        plodno1.add(Calendar.DATE, 2);
        Date dateKasni = plodno1.getTime();
        dates.put("dateKasni", dateKasni);

        return dates;
    }
}
