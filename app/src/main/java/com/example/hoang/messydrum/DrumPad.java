package com.example.hoang.messydrum;

import android.media.MediaPlayer;
import android.widget.ImageView;

import java.util.Random;

/**
 * Created by Hoang on 4/8/2017.
 */

public class DrumPad {
    private ImageView button;
    private int streamID;
    private static int[] images = {R.drawable.button_0, R.drawable.button_1, R.drawable.button_2, R.drawable.button_3, R.drawable.button_4};

    public DrumPad(ImageView button) {
        this.button = button;
    }

    public ImageView getButton() {
        return button;
    }

    public void changeColor() {
        Random random = new Random();
        int color = random.nextInt(5);
        button.setImageResource(images[color]);
    }

    public int getStreamID() {
        return streamID;
    }

    public void setStreamID(int streamID) {
        this.streamID = streamID;
    }

    public void undoColorChange() {
        button.setImageResource(R.drawable.button);
    }
}
