package com.supermath.jacobgb24.supermath;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * Created by jacob_000 on 12/5/2014.
 */
public class AreaFinder extends ActionBarActivity {
    private RadioGroup shape;
    private static double A1, A2, area;
    private static EditText Anum1, Anum2;
    private static Button calculate;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aflayout);
        shape = (RadioGroup) findViewById(R.id.AFchoice);
        calculate = (Button) findViewById(R.id.Calculateaf);
        Anum1 = (EditText) findViewById(R.id.Anum1);
        Anum2 = (EditText) findViewById(R.id.Anum2);
        Math();
    }
    public void Math(){
        //checks which shape is selected
        shape.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                    if (checkedId == R.id.rectB)
                        RectMath();
                    else if (checkedId == R.id.triB)
                        TriMath();
                    else
                        CircMath();
            }
        });
    }
    //math for each shape
    public void RectMath() {
        Anum1.setHint("Length");
        Anum2.setVisibility(View.VISIBLE);
        Anum2.setHint("Width");
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    A1 = Double.parseDouble(Anum1.getText().toString());
                    A2 = Double.parseDouble(Anum2.getText().toString());
                    area = A1 * A2;
                    print();
                }catch(Exception e) { }
            }
        });
    }
    public void TriMath() {
        Anum1.setHint("Base");
        Anum2.setVisibility(View.VISIBLE);
        Anum2.setHint("Height");
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    A1 = Double.parseDouble(Anum1.getText().toString());
                    A2 = Double.parseDouble(Anum2.getText().toString());
                    area = A1 * A2/2;
                    print();
                }catch(Exception e) { }
            }
        });
    }
    public void CircMath() {
        Anum1.setHint("Radius");
        Anum2.setVisibility(View.GONE);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    A1 = Double.parseDouble(Anum1.getText().toString());
                    area = Math.pow(A1, 2) * Math.PI;
                    print();
                } catch (Exception e) {
                }
            }
        });
    }
    //sets textview based off of answer
    public void print(){
        DecimalFormat fmt = new DecimalFormat("########.###");
        String fanswer = fmt.format(area);
        TextView textView = (TextView) findViewById(R.id.Answeraf);
        textView.setText(String.valueOf(fanswer));
        area = 0;
    }
}