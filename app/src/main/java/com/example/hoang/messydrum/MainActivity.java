package com.example.hoang.messydrum;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DrumPad button1;
    private DrumPad button2;
    private DrumPad button3;
    private DrumPad button4;
    private DrumPad button5;
    private DrumPad button6;
    private DrumPad button7;
    private DrumPad button8;
    private DrumPad button9;
    private DrumPad button10;
    private DrumPad button11;
    private DrumPad button12;
    private DrumPad button13;
    private DrumPad button14;
    private DrumPad button15;
    private DrumPad button16;
    private DrumPad button17;
    private DrumPad button18;
    private DrumPad button19;
    private DrumPad button20;
    private DrumPad button21;
    private DrumPad button22;
    private DrumPad button23;
    private DrumPad button24;

    private ArrayList<DrumPad> drumPads;

    private static Context appContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appContext = getApplicationContext();

        drumPads = new ArrayList<>();

        View.OnTouchListener triggered = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN: {
                        System.out.println("DOWN");
                        for (DrumPad el : drumPads) {
                            if (v.getId() == el.getButton().getId()) {
                                el.getPlayer().start();
                                el.changeColor();
                                break;
                            }
                        }
                    }
                    break;
                    case MotionEvent.ACTION_UP: {
                        System.out.println("UP");
                        for (DrumPad el : drumPads) {
                            if (v.getId() == el.getButton().getId()) {
                                if (el.getPlayer().isPlaying()) {
                                    el.getPlayer().pause();
                                    el.getPlayer().seekTo(0);
                                }
                                el.undoColorChange();
                                break;
                            }
                        }
                    }
                    break;
                }
                return false;
            }
        };


        button1 = new DrumPad((ImageView) findViewById(R.id.button1));
        button1.getButton().setOnTouchListener(triggered);

        button2 = new DrumPad((ImageView) findViewById(R.id.button2));
        button2.getButton().setOnTouchListener(triggered);

        button3 = new DrumPad((ImageView) findViewById(R.id.button3));
        button3.getButton().setOnTouchListener(triggered);

        button4 = new DrumPad((ImageView) findViewById(R.id.button4));
        button4.getButton().setOnTouchListener(triggered);

        button5 = new DrumPad((ImageView) findViewById(R.id.button5));
        button5.getButton().setOnTouchListener(triggered);

        button6 = new DrumPad((ImageView) findViewById(R.id.button6));
        button6.getButton().setOnTouchListener(triggered);

        button7 = new DrumPad((ImageView) findViewById(R.id.button7));
        button7.getButton().setOnTouchListener(triggered);

        button8 = new DrumPad((ImageView) findViewById(R.id.button8));
        button8.getButton().setOnTouchListener(triggered);

        button9 = new DrumPad((ImageView) findViewById(R.id.button9));
        button9.getButton().setOnTouchListener(triggered);

        button10 = new DrumPad((ImageView) findViewById(R.id.button10));
        button10.getButton().setOnTouchListener(triggered);

        button11 = new DrumPad((ImageView) findViewById(R.id.button11));
        button11.getButton().setOnTouchListener(triggered);

        button12 = new DrumPad((ImageView) findViewById(R.id.button12));
        button12.getButton().setOnTouchListener(triggered);

        button13 = new DrumPad((ImageView) findViewById(R.id.button13));
        button13.getButton().setOnTouchListener(triggered);

        button14 = new DrumPad((ImageView) findViewById(R.id.button14));
        button14.getButton().setOnTouchListener(triggered);

        button15 = new DrumPad((ImageView) findViewById(R.id.button15));
        button15.getButton().setOnTouchListener(triggered);

        button16 = new DrumPad((ImageView) findViewById(R.id.button16));
        button16.getButton().setOnTouchListener(triggered);

        button17 = new DrumPad((ImageView) findViewById(R.id.button17));
        button17.getButton().setOnTouchListener(triggered);

        button18 = new DrumPad((ImageView) findViewById(R.id.button18));
        button18.getButton().setOnTouchListener(triggered);

        button19 = new DrumPad((ImageView) findViewById(R.id.button19));
        button19.getButton().setOnTouchListener(triggered);

        button20 = new DrumPad((ImageView) findViewById(R.id.button20));
        button20.getButton().setOnTouchListener(triggered);

        button21 = new DrumPad((ImageView) findViewById(R.id.button21));
        button21.getButton().setOnTouchListener(triggered);

        button22 = new DrumPad((ImageView) findViewById(R.id.button22));
        button22.getButton().setOnTouchListener(triggered);

        button23 = new DrumPad((ImageView) findViewById(R.id.button23));
        button23.getButton().setOnTouchListener(triggered);

        button24 = new DrumPad((ImageView) findViewById(R.id.button24));
        button24.getButton().setOnTouchListener(triggered);

        drumPads.add(button1);
        drumPads.add(button2);
        drumPads.add(button3);
        drumPads.add(button4);
        drumPads.add(button5);
        drumPads.add(button6);
        drumPads.add(button7);
        drumPads.add(button8);
        drumPads.add(button9);
        drumPads.add(button10);
        drumPads.add(button11);
        drumPads.add(button12);
        drumPads.add(button13);
        drumPads.add(button14);
        drumPads.add(button15);
        drumPads.add(button16);
        drumPads.add(button17);
        drumPads.add(button18);
        drumPads.add(button19);
        drumPads.add(button20);
        drumPads.add(button21);
        drumPads.add(button22);
        drumPads.add(button23);
        drumPads.add(button24);

    }

    public static Context getAppContext() {
        return appContext;
    }
}
