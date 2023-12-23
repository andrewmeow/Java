package com.example.visualclock;

import java.util.Random;

public class ClockFactory {
    private double minPrice = 100.0;
    private double maxPrice = 10000.0;
    private static Random rand = new Random();
    private static String[] names = new String[]
            {
                    "Rolex",
                    "Omega",
                    "Casio",
                    "Huawei"

            };
    public ClockFactory(){}
    public Clock Create(int type)
    {
        double rand_ = minPrice+maxPrice* rand.nextDouble();
        double randPrice = (double)Math.round(rand_*100.0)/100.0;
        int randInd = rand.nextInt(names.length);
        switch (type)
        {
            case 1 ->{
                return new AnalogClock(names[randInd],randPrice);
            }
            case 2 ->{
                return new DigitalClock(names[randInd],randPrice);
            }
            default ->  { return  null;}

        }

    }
}
