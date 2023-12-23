package com.example.visualclock;

public abstract class Clock {
    int ID;
    private String brand = "";
    private double price = 0.0;
    protected int hours = 0;
    protected int minutes = 0;

    public Clock(int ID,String brand, double price) {
        this.brand = brand;
        this.price = price;
        this.ID = ID;
    }
    public Clock(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }
    public int getHour(){return hours;}
    public int getMinutes(){return minutes;}
    public void setInitialTime(int hours, int minutes) {
        if (hours >= 0 && hours < 24 && minutes >= 0 && minutes < 60) {
            this.hours = hours;
            this.minutes = minutes;
        } else {
            throw new InvalidTimeException("Invalid initial time.");
        }
    }

    public abstract void moveTimeForward(int hours, int minutes);
    public String Info() {
        String info_ = brand + hours + ":"+ minutes;
        return  info_;
    }
}

