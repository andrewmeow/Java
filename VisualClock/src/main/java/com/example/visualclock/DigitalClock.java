package com.example.visualclock;

public class DigitalClock extends Clock {
    private int seconds=0;

    public DigitalClock(int ID,String brand, double price) {
        super(ID,brand, price);
    }

    public DigitalClock(String brand, double price) {
        super(brand, price);
    }

    public void setInitialTime(int hours, int minutes, int seconds) {
        if (hours >= 0 && hours < 24 && minutes >= 0 && minutes < 60 && seconds >= 0 && seconds < 60) {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
        } else {
            throw new InvalidTimeException("Invalid initial time.");
        }
    }

    @Override
    public void moveTimeForward(int hours, int minutes) {
        int totalSeconds = this.hours * 3600 + this.minutes * 60 + this.seconds + hours * 3600 + minutes * 60;
        this.hours = totalSeconds / 3600 % 24;
        totalSeconds %= 3600;
        this.minutes = totalSeconds / 60;
        this.seconds = totalSeconds % 60;
    }

}
