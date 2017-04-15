package com.example.hoang.messydrum;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ArrayList<DrumPad> drumPads;

    private ArrayList<PressedKeyInfo> pressedKeyInfos;

    private static Context appContext;

    class PressedKeyInfo {
        private DrumPad ivKey;
        private int pointerId;

        public PressedKeyInfo(DrumPad ivKey, int pointerId) {
            this.ivKey = ivKey;
            this.pointerId = pointerId;
            pressedKeyInfos.add(this);
        }

        public DrumPad getIvKey() {
            return ivKey;
        }

        public void setIvKey(DrumPad ivKey) {
            this.ivKey = ivKey;
        }

        public int getPointerId() {
            return pointerId;
        }

        public void setPointerId(int pointerId) {
            this.pointerId = pointerId;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pressedKeyInfos = new ArrayList<>();

        appContext = getApplicationContext();

        SoundManager.loadSoundIntoList(appContext);

        drumPads = new ArrayList<>();

        drumPads.add(new DrumPad((ImageView) findViewById(R.id.button1)));
        drumPads.add(new DrumPad((ImageView) findViewById(R.id.button2)));
        drumPads.add(new DrumPad((ImageView) findViewById(R.id.button3)));
        drumPads.add(new DrumPad((ImageView) findViewById(R.id.button4)));
        drumPads.add(new DrumPad((ImageView) findViewById(R.id.button5)));
        drumPads.add(new DrumPad((ImageView) findViewById(R.id.button6)));
        drumPads.add(new DrumPad((ImageView) findViewById(R.id.button7)));
        drumPads.add(new DrumPad((ImageView) findViewById(R.id.button8)));
        drumPads.add(new DrumPad((ImageView) findViewById(R.id.button9)));
        drumPads.add(new DrumPad((ImageView) findViewById(R.id.button10)));
        drumPads.add(new DrumPad((ImageView) findViewById(R.id.button11)));
        drumPads.add(new DrumPad((ImageView) findViewById(R.id.button12)));

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int pointerAction = event.getActionMasked();

        if (pointerAction == MotionEvent.ACTION_MOVE) {
            for (int pointerIndex = 0; pointerIndex < event.getPointerCount(); pointerIndex++) {
                int pointerId = event.getPointerId(pointerIndex);
                float pointerX = event.getX(pointerIndex);
                float pointerY = event.getY(pointerIndex);
                for (int i = 0; i < pressedKeyInfos.size(); i++) {
                    PressedKeyInfo el = pressedKeyInfos.get(i);
                    if (el.getPointerId() == pointerId && !isInside(pointerX, pointerY, el.getIvKey().getButton())) {
                        pressedKeyInfos.remove(i);
                        i--;
                        setPressed(el.getIvKey(), false);
                    }
                }
                for (DrumPad el : drumPads) {
                    if (isInside(pointerX, pointerY, el.getButton())) {
                        if (!containKeyInfoWith(el)) {
                            new PressedKeyInfo(el, pointerId);
                            setPressed(el, true);
                        }
                    }
                }
            }
        }

        int pointerIndex = MotionEventCompat.getActionIndex(event);
        int pointerId = event.getPointerId(pointerIndex);

        float pointerX = event.getX(pointerIndex);
        float pointerY = event.getY(pointerIndex);

        DrumPad pressedKey = findPressedKey(pointerX, pointerY);

        if (pressedKey != null) {
            if (pointerAction == MotionEvent.ACTION_DOWN || pointerAction == MotionEvent.ACTION_POINTER_DOWN || pointerAction == MotionEvent.ACTION_MOVE) {
                if (!containKeyInfoWith(pressedKey)) {
                    new PressedKeyInfo(pressedKey, pointerId);
                    setPressed(pressedKey, true);
                }
            }
            if (pointerAction == MotionEvent.ACTION_UP || pointerAction == MotionEvent.ACTION_POINTER_UP) {
                for (int i = 0; i < pressedKeyInfos.size(); i++) {
                    if (pointerId == pressedKeyInfos.get(i).pointerId) {
                        pressedKeyInfos.remove(i);
                        setPressed(pressedKey, false);
                        i--;
                    }
                }
            }
        }

        Log.d(TAG, String.format("onTouchEvent : %s", pointerIndex));
        Log.d(TAG, String.format("onTouchEvent : %s", pointerId));

        return super.onTouchEvent(event);

    }

    private void setPressed(DrumPad ivKey, boolean isPressed) {
        if (isPressed) {
            ivKey.changeColor();
            SoundManager.playSound(ivKey);
        } else {
            ivKey.undoColorChange();
            SoundManager.stopSound(ivKey);
        }
    }

    private boolean isInside(float x, float y, View v) {
        int[] location = new int[2];
        v.getLocationOnScreen(location);
        int left = location[0];
        int top = location[1];
        int right = left + v.getWidth();
        int bottom = top + v.getHeight();
        if (x > left && x < right && y > top && y < bottom) {
            return true;
        } else return false;
    }

    private boolean containKeyInfoWith(DrumPad ivKey) {
        for (PressedKeyInfo pressedKeyInfo : pressedKeyInfos) {
            if (pressedKeyInfo.getIvKey() == ivKey) return true;
        }
        return false;
    }

    private DrumPad findPressedKey(float x, float y) {
        for (DrumPad el : drumPads) {
            if (isInside(x, y, el.getButton())) return el;
        }
        return null;
    }


    public static Context getAppContext() {
        return appContext;
    }
}
