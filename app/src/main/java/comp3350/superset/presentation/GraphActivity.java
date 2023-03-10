package comp3350.superset.presentation;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import comp3350.superset.R;
import comp3350.superset.business.Statistics;

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

    // Graph variables
    private float TEXT_SIZE = 16;
    private BarChart barChart;
    private BarData barData;
    private BarDataSet barDataSet;
    private ArrayList<BarEntry> barEntriesArrayList;
    private Statistics statistics;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        // data
        statistics = new Statistics();

        // create chart
        barChart = findViewById(R.id.idBarChart);
        getBarEntries();
        barDataSet = new BarDataSet(barEntriesArrayList, "Activity (minutes)");
        barData = new BarData(barDataSet);
        barChart.setData(barData);

        // set visuals
        barDataSet.setColors(Color.CYAN );
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(TEXT_SIZE);
        barChart.getDescription().setEnabled(false);
        Legend l = barChart.getLegend();
        l.setTextSize(40);

        // set x-axis
        ArrayList<String> xVals = getXVals();
        XAxis xAxis = barChart.getXAxis();
        xAxis.setCenterAxisLabels(true);
        xAxis.setDrawGridLines(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(TEXT_SIZE);
        xAxis.setLabelCount(xVals.size());
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
        int[] workoutMinutesByMonth = statistics.workoutMinutesByMonth();
        barEntriesArrayList = new ArrayList<>();
        for(int i = 0; i < workoutMinutesByMonth.length; i++) {
            barEntriesArrayList.add(new BarEntry(i+1, workoutMinutesByMonth[i]));
        }
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