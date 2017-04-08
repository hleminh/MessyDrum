package com.example.hoang.messydrum;

import android.media.MediaPlayer;
import android.widget.ImageView;

import java.util.Random;

/**
 * Created by Hoang on 4/8/2017.
 */

public class DrumPad {
    private ImageView button;
    private MediaPlayer player;
    private int[] images;

    public DrumPad(ImageView button) {
        images = new int[7];
        images[0] = R.drawable.button_0;
        images[1] = R.drawable.button_1;
        images[2] = R.drawable.button_2;
        images[3] = R.drawable.button_3;
        images[4] = R.drawable.button_4;
        images[5] = R.drawable.button_5;
        images[6] = R.drawable.button_6;

        this.button = button;

        switch (button.getId()) {
//            case R.id.button1:{
//                player = MediaPlayer.create(MainActivity.getAppContext(),R.raw.sound_01);
//            }break;
//            case R.id.button2:{
//                player = MediaPlayer.create(MainActivity.getAppContext(),R.raw.sound_02);
//            }break;
//            case R.id.button3:{
//                player = MediaPlayer.create(MainActivity.getAppContext(),R.raw.sound_03);
//            }break;
//            case R.id.button4:{
//                player = MediaPlayer.create(MainActivity.getAppContext(),R.raw.sound_04);
//            }break;
//            case R.id.button5:{
//                player = MediaPlayer.create(MainActivity.getAppContext(),R.raw.sound_05);
//            }break;
//            case R.id.button6:{
//                player = MediaPlayer.create(MainActivity.getAppContext(),R.raw.sound_06);
//            }break;
//            case R.id.button7:{
//                player = MediaPlayer.create(MainActivity.getAppContext(),R.raw.sound_07);
//            }break;
//            case R.id.button8:{
//                player = MediaPlayer.create(MainActivity.getAppContext(),R.raw.sound_08);
//            }break;
//            case R.id.button9:{
//                player = MediaPlayer.create(MainActivity.getAppContext(),R.raw.sound_09);
//            }break;
//            case R.id.button10:{
//                player = MediaPlayer.create(MainActivity.getAppContext(),R.raw.sound_10);
//            }break;
//            case R.id.button11:{
//                player = MediaPlayer.create(MainActivity.getAppContext(),R.raw.sound_11);
//            }break;
//            case R.id.button12:{
//                player = MediaPlayer.create(MainActivity.getAppContext(),R.raw.sound_12);
//            }break;
//            case R.id.button13:{
//                player = MediaPlayer.create(MainActivity.getAppContext(),R.raw.sound_13);
//            }break;
//            case R.id.button14:{
//                player = MediaPlayer.create(MainActivity.getAppContext(),R.raw.sound_14);
//            }break;
//            case R.id.button15:{
//                player = MediaPlayer.create(MainActivity.getAppContext(),R.raw.sound_15);
//            }break;
//            case R.id.button16:{
//                player = MediaPlayer.create(MainActivity.getAppContext(),R.raw.sound_16);
//            }break;
//            case R.id.button17:{
//                player = MediaPlayer.create(MainActivity.getAppContext(),R.raw.sound_17);
//            }break;
//            case R.id.button18:{
//                player = MediaPlayer.create(MainActivity.getAppContext(),R.raw.sound_18);
//            }break;
//            case R.id.button19:{
//                player = MediaPlayer.create(MainActivity.getAppContext(),R.raw.sound_19);
//            }break;
//            case R.id.button20:{
//                player = MediaPlayer.create(MainActivity.getAppContext(),R.raw.sound_20);
//            }break;
//            case R.id.button21:{
//                player = MediaPlayer.create(MainActivity.getAppContext(),R.raw.sound_21);
//            }break;
//            case R.id.button22:{
//                player = MediaPlayer.create(MainActivity.getAppContext(),R.raw.sound_22);
//            }break;
//            case R.id.button23:{
//                player = MediaPlayer.create(MainActivity.getAppContext(),R.raw.sound_23);
//            }break;
//            case R.id.button24:{
//                player = MediaPlayer.create(MainActivity.getAppContext(),R.raw.sound_24);
//            }break;
            case R.id.button1: {
                player = MediaPlayer.create(MainActivity.getAppContext(), R.raw.sound_1);
            }
            break;
            case R.id.button4: {
                player = MediaPlayer.create(MainActivity.getAppContext(), R.raw.sound_2);
            }
            break;
            case R.id.button24: {
                player = MediaPlayer.create(MainActivity.getAppContext(), R.raw.sound_3);
            }
            break;
            case R.id.button21: {
                player = MediaPlayer.create(MainActivity.getAppContext(), R.raw.sound_4);
            }
            break;
            case R.id.button3: {
                player = MediaPlayer.create(MainActivity.getAppContext(), R.raw.sound_5);
            }
            break;
            default: {
                player = MediaPlayer.create(MainActivity.getAppContext(), R.raw.weed);
            }
            break;
        }
    }

    public ImageView getButton() {
        return button;
    }

    public void setButton(ImageView button) {
        this.button = button;
    }

    public MediaPlayer getPlayer() {
        return player;
    }

    public void setPlayer(MediaPlayer player) {
        this.player = player;
    }

    public void changeColor() {
        Random random = new Random();
        int color = random.nextInt(7);
        button.setImageResource(images[color]);
    }

    public void undoColorChange() {
        button.setImageResource(R.drawable.button);
    }
}
