package com.company;


/**
 * Created by Olexiy on 03.06.2016.
 */

import javax.sound.sampled.*;

public class SoundUtil {

    public static float SAMPLE_RATE = 8000f;

    public static void tone(int hz, int msecs, double vol)
            throws LineUnavailableException {
        byte[] buf = new byte[1];
        AudioFormat af =
                new AudioFormat(
                        SAMPLE_RATE, // sampleRate
                        8,           // sampleSizeInBits
                        1,           // channels
                        true,        // signed
                        false);      // bigEndian
        SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
        sdl.open(af);
        sdl.start();
        for (int i = 0; i < msecs * 8; i++) {
            double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;
            buf[0] = (byte) (Math.sin(angle) * 127.0 * vol);
            sdl.write(buf, 0, 1);
        }
        sdl.drain();
        sdl.stop();
        sdl.close();
    }

    public static void main(String[] args)  {

    }
    public static void getTone(int hz, int msecs, double vol)throws Exception  {
        SoundUtil.tone(hz, msecs, vol);
    }
    public static void getTone(int hz, int msecs)throws Exception  {
        SoundUtil.tone(hz, msecs, 1);
    }
}