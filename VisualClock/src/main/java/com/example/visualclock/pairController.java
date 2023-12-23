package com.example.visualclock;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class pairController {
    public pairController() {
    }

    public void setPair(String brand, String price){
        this.brand.setText(brand);
        this.price.setText(price);
    }
    public void setTime(String hour_,String min_)
    {
        hour.setText(hour_);
        min.setText(min_);
    }
    public void setClock(Clock clock_){
        clock = clock_;
    }
    Clock clock;
    @FXML
    Pane root;
    @FXML
    Label brand;
    @FXML
    Label price;
    @FXML
    Label hour;
    @FXML
    Label min;
    @FXML
    void removeClock()
    {
        ((Pane) root.getParent()).getChildren().remove(root);
    }
}
