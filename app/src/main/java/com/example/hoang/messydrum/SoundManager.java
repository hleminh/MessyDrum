package com.example.hoang.messydrum;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.SoundPool;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Hoang on 4/15/2017.
 */

public class SoundManager {
    private static int NUMBER_OF_NOTE = 12;

    public static SoundPool soundPool = new SoundPool(NUMBER_OF_NOTE, AudioManager.STREAM_MUSIC, 0);

    public static ArrayList<Integer> soundList = new ArrayList<>();

    public static void loadSoundIntoList(Context context) {
        for (int i = 1; i <= NUMBER_OF_NOTE; i++) {
            int resIDSound = context.getResources().getIdentifier("sound_" + i, "raw", context.getPackageName());
            int soundPoolID = soundPool.load(context, resIDSound, 1);
            soundList.add(soundPoolID);
        }
    }

    static HashMap<String, Integer> listSoundId = new HashMap<>();

    static {
        listSoundId.put("1", 0);
        listSoundId.put("2", 1);
        listSoundId.put("3", 2);
        listSoundId.put("4", 3);
        listSoundId.put("5", 4);
        listSoundId.put("6", 5);
        listSoundId.put("7", 6);
        listSoundId.put("8", 7);
        listSoundId.put("9", 8);
        listSoundId.put("10", 9);
        listSoundId.put("11", 10);
        listSoundId.put("12", 11);
    }

    public static void playSound(DrumPad ivKey) {
        ivKey.setStreamID(soundPool.play(soundList.get(listSoundId.get(ivKey.getButton().getTag().toString())), 1.0f, 1.0f, 1, 0, 1.0f));
    }

    public static void stopSound(DrumPad ivKey) {
        soundPool.stop(ivKey.getStreamID());
    }

}
