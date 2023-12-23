package com.example.visualclock;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Collection;

public class MainController {

    public TextField type;
    public TextField hour;
    public TextField min;
    ClockShop shop =  new ClockShop();
    ClockFactory factory = new ClockFactory();
    @FXML
    public TextField brand;
    @FXML
    public TextField price;

    @FXML
    GridPane allPair;

    @FXML
    public void addClock(ActionEvent actionEvent) {
        Clock clock = null;
        shop.addClock(clock= new DigitalClock(brand.getText(), Double.parseDouble(price.getText())));
        //if (type.getText() == "1")
            //shop.addClock(clock= new DigitalClock(brand.getText(), Double.parseDouble(price.getText())));
        //if (type.getText() == "2")
            //shop.addClock(clock = new AnalogClock(brand.getText(), Double.parseDouble(price.getText())));

        //allPair.getChildren().clear();

        try {

            pairController pc = new pairController();

            FXMLLoader fxmlLoader = new FXMLLoader(pairController.class.getResource("pairView.fxml"));

            fxmlLoader.setController(pc);

            Parent root = null;
            root = fxmlLoader.load();

            pc.setPair(brand.getText(), price.getText());
            pc.setTime("00","00");
            pc.setClock(clock);
            allPair.addColumn(0, root);

        } catch (IOException e) {

            throw new RuntimeException(e);

        }


    }

    public void generateClock(ActionEvent actionEvent) {
        Clock c = factory.Create(Integer.parseInt(type.getText()));
        brand.setText(c.getBrand());
        price.setText(""+c.getPrice());
    }

    public void setTime(ActionEvent actionEvent) {
        shop.setAllTime(Integer.parseInt(hour.getText()), Integer.parseInt(min.getText()));
        allPair.getChildren().clear();
        for(Clock clock: shop.getCatalog()){
            try{
                pairController pc = new pairController();

                FXMLLoader fxmlLoader = new FXMLLoader(pairController.class.getResource("pairView.fxml"));

                fxmlLoader.setController(pc);

                Parent root = null;
                root = fxmlLoader.load();

                pc.setPair(clock.getBrand(), ""+clock.getPrice());
                pc.setTime(""+clock.getHour(),""+clock.getMinutes());
                pc.setClock(clock);
                allPair.addColumn(0, root);

            } catch (IOException e) {

                throw new RuntimeException(e);

            }
        }

    }

    public void addBD(ActionEvent actionEvent) {
        allPair.getChildren().clear();
        for(Clock clock: shop.getCatalog()){
            try {

                pairController pc = new pairController();

                FXMLLoader fxmlLoader = new FXMLLoader(pairController.class.getResource("pairView.fxml"));

                fxmlLoader.setController(pc);

                Parent root = null;
                root = fxmlLoader.load();

                pc.setPair(clock.getBrand(), ""+clock.getPrice());
                pc.setTime(""+clock.getHour(),""+clock.getMinutes());
                pc.setClock(clock);
                allPair.addColumn(0, root);

            } catch (IOException e) {

                throw new RuntimeException(e);

            }
        }
    }
}
