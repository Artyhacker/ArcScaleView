package com.dh.arcscaleview;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private ArcScaleView arcScaleView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        arcScaleView = (ArcScaleView) findViewById(R.id.arc_scale_view);
        arcScaleView.setSweepValue(90);
        arcScaleView.setText("123456789");
    }




}
