package com.richpathanimator.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.richpath.RichPath;
import com.richpath.RichPathView;

public class SeatMapActivity extends AppCompatActivity {
    RichPath currentPath;
    private int mOriginalColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_map);

        RichPathView colorPickerRichPathView = findViewById(R.id.seatMap);
        final TextView tvSelectedSeat = findViewById(R.id.tvSelectedSeat);

        colorPickerRichPathView.setOnPathClickListener(new RichPath.OnPathClickListener() {
            @Override
            public void onClick(RichPath richPath) {
                if(currentPath != null) {
                    currentPath.setFillColor(mOriginalColor);
                }

                mOriginalColor = richPath.getFillColor();
                currentPath = richPath;

                richPath.setFillColor(Color.GREEN);
                tvSelectedSeat.setText("Selected " + richPath.getName());
            }
        });
    }
}