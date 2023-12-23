package com.example.visualclock;

public class AnalogClock extends Clock {
    public AnalogClock(int ID,String brand, double price) {
        super(ID,brand, price);
    }
    public AnalogClock(String brand, double price) {
        super(brand, price);
    }

    @Override
    public void moveTimeForward(int hours, int minutes) {
        int totalMinutes = this.hours * 60 + this.minutes + hours * 60 + minutes;
        this.hours = totalMinutes / 60 % 24;
        this.minutes = totalMinutes % 60;
    }
}
