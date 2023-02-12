package comp3350.srsys.presentation;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import comp3350.srsys.R;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class GraphActivity extends Activity {

    private float TEXT_SIZE = 32;

    private BarChart barChart;
    private BarData barData;
    private BarDataSet barDataSet;
    private ArrayList<BarEntry> barEntriesArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        // create chart
        barChart = findViewById(R.id.idBarChart);
        getBarEntries();
        barDataSet = new BarDataSet(barEntriesArrayList, "Activity (hours)");
        barData = new BarData(barDataSet);
        barChart.setData(barData);

        // set visuals
        barDataSet.setColors(Color.CYAN /*ColorTemplate.MATERIAL_COLORS*/ );
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(TEXT_SIZE);
        barChart.getDescription().setEnabled(false);
        Legend l = barChart.getLegend();
        l.setTextSize(TEXT_SIZE);

        // set x-axis
        ArrayList<String> xVals = getXVals();
        XAxis xAxis = barChart.getXAxis();
        xAxis.setCenterAxisLabels(true);
        xAxis.setDrawGridLines(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(TEXT_SIZE);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xVals));

        // set y-axis (as left axis)
        YAxis yAxis = barChart.getAxisLeft();
        yAxis.setDrawGridLines(false);
        yAxis.setTextSize(TEXT_SIZE);

        // hide right axis
        YAxis right = barChart.getAxisRight();
        right.setDrawLabels(false);
        right.setDrawGridLines(false);
    }

    private void getBarEntries() {
        barEntriesArrayList = new ArrayList<>();
        barEntriesArrayList.add(new BarEntry(1f, 4));
        barEntriesArrayList.add(new BarEntry(2f, 6));
        barEntriesArrayList.add(new BarEntry(3f, 8));
        barEntriesArrayList.add(new BarEntry(4f, 2));
        barEntriesArrayList.add(new BarEntry(5f, 4));
        barEntriesArrayList.add(new BarEntry(6f, 1));
    }

    private ArrayList<String> getXVals() {
        ArrayList<String> xVals = new ArrayList<>();
        xVals.add("Jan");
        xVals.add("Feb");
        xVals.add("Mar");
        xVals.add("Apr");
        xVals.add("May");
        xVals.add("Jun");
        xVals.add("Jul");
        xVals.add("Aug");
        xVals.add("Sep");
        xVals.add("Oct");
        xVals.add("Nov");
        xVals.add("Dec");
        return xVals;
    }

}