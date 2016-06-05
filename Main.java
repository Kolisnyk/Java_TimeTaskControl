package com.company;


import java.io.BufferedReader;
import java.io.InputStreamReader;




public class Main {
    public static SoundUtil su = new SoundUtil();


    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the time before the alarm (in minutes)");
        int alarmTime = Integer.parseInt(reader.readLine());
        int alarmTimeInMinutes = alarmTime * 60;


        // Logic
        for (int i = 0; i <= alarmTimeInMinutes; i++) {
            if (i != alarmTimeInMinutes) {
                Thread.sleep(1000);
            }
            else {
                System.out.println("Alarm");
                su.getTone(1200, 1000, 1.0);
                su.getTone(800, 1000, 1.0);
            }
        }


    }


}
