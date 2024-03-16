package com.example.secondprojected;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.secondprojected.Veritaban.Okuyucu;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class GrafikActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafik);

        setTitle(getString(R.string.grafbaslik));

        BarChart barChart = (BarChart) findViewById(R.id.barchart);
        Okuyucu okc = new Okuyucu(GrafikActivity.this);
        ArrayList<BarEntry> barEntries = new ArrayList<BarEntry>();

        barEntries.add(new BarEntry(0,okc.pcleriGetir().size() ));
        barEntries.add(new BarEntry(1,okc.yazicileriGetir().size() ));
        barEntries.add(new BarEntry(2,okc.tarayicilariGetir().size()));
        barEntries.add(new BarEntry(3,okc.tabletleriGetir().size()));
        barEntries.add(new BarEntry(4,okc.kullanicilariGetir().size()));


        BarDataSet barDataSet = new BarDataSet(barEntries, "");
        barDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        barDataSet.setHighlightEnabled(true);
        barDataSet.setHighLightColor(Color.RED);
        barDataSet.setValueTextSize(16f);
        barDataSet.setValueTextColor(Color.WHITE);

        BarData barData = new BarData(barDataSet);

        barChart.getDescription().setText("");
        barChart.getDescription().setTextSize(12);


        barChart.getAxisLeft().setAxisMinimum(0);

        barChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        barChart.getXAxis().setTextSize(16f);
        barChart.getXAxis().setTextColor(Color.WHITE);

        ArrayList<String> labels = new ArrayList<String> ();

        labels.add( "Bilgisayar");
        labels.add( "Yazıcı");
        labels.add( "Tarayıcı");
        labels.add( "Tablet");
        labels.add("Kullanıcı");



        barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(labels));
        barChart.animateY(2000);

        barChart.getXAxis().setGranularityEnabled(true);
        barChart.getXAxis().setGranularity(1.0f);
        barChart.getXAxis().setLabelCount(barDataSet.getEntryCount());

        barChart.setData(barData);

    }

}