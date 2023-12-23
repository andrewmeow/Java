package com.example.visualclock;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.*;
import java.util.function.Consumer;

public class ClockShop {
    protected Collection<Clock> catalog = new ArrayList<>();
    private Map<String, Double> table = new HashMap<>();
    Connection c;
    ClockShop(){
        connect();
        selectAll();
    }
    Collection<Clock> getCatalog(){
        return catalog;
    }
    void connect()
    {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(
                    "jdbc:sqlite:clock.db");
            System.out.println("Opened database successfully");
        } catch (ClassNotFoundException ex) {
        //не найден драйвер
        } catch (SQLException ex) {
            System.out.println("Can't open DB");
        }
    }

    void selectAll(){
        catalog.clear();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from clocks_table");
            while (rs.next()){
                catalog.add(new DigitalClock(rs.getInt("Id"),rs.getString("brand"),rs.getDouble("price")));
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Clock getInfoMaxPrice(){
        return Collections.max(catalog, (c1, c2) -> Double.compare(c1.getPrice(), c2.getPrice()));
    }

    public void addClock(Clock clock)
    {
        catalog.add(clock);
        table.put(clock.getBrand(),clock.getPrice());
    }
    public void removeClock(Clock clock)
    {
        catalog.remove(clock);
    }

    public void setAllTime(int hour,int min) {
        catalog.forEach(clock -> clock.setInitialTime(hour,min));
    }
}
