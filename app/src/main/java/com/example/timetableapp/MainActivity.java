package com.example.timetableapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import com.example.timestable.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTableListView;

    public void generateTimesTable(int timesTablesNumber) {
        ArrayList<String> timesTableContent = new ArrayList<String>();

        for (int j = 1; j <= 10; j++) {
            int timesTableNumber = 0;
            timesTableContent.add(Integer.toString(j * timesTableNumber));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);

        timesTableListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTablesSeekbar = findViewById(R.id.timesTablesSeekBar);
        final ListView timesTablesListView = findViewById(R.id.timesTableListView);

        int max= 20;
        int startingposition = 10;
                
        timesTablesSeekbar.setMax(20);
        timesTablesSeekbar.setProgress(startingposition);

        timesTablesSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timesTableNumber;

                if (i < min) {
                    timesTableNumber = min;
                    timesTablesSeekbar.setProgress(min);
                } else {
                    timesTableNumber = i;
                }

                Log.i("Seekbar Value", Integer.toString(timesTableNumber));

                generateTimesTable(timesTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

        });
    }
}
