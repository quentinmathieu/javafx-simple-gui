package fr.afpa;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class LogBtnClickHandler implements EventHandler<ActionEvent> {

    public void handle(ActionEvent event) {
        System.out.println("a btn has been clicked !");
    }
    
}
