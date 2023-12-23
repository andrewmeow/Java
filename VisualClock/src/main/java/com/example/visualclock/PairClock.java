package com.example.visualclock;

public class PairClock {
    String brand;
    double price;

    public PairClock(String brand_, double price_){
        brand = brand_;
        price = price_;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    @Override
    public String toString()
    {
        return "PairClock(Brand = "+brand+", price = "+price+')';
    }
}
