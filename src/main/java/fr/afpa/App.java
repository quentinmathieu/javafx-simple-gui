package fr.afpa;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        stage.setScene(this.firstForm());
        stage.show();
    }

    public Scene firstForm(){
        // create panes
        VBox globalPane = new VBox();
        VBox header = new VBox();
        GridPane form = new GridPane();

        // add GUI components to each pane
        header.getChildren().add(new Label("Formulaire"));
        
        VBox btns = new VBox();
        Button copyBnt = new Button("Recopier");
        Button delBtn = new Button("Effacer");
        Button exitBtn = new Button("Quitter");
        btns.getChildren().add(copyBnt);
        btns.getChildren().add(delBtn);
        btns.getChildren().add(exitBtn);

        TextField firField = new TextField();
        TextField secondField = new TextField();
        secondField.setDisable(true);

        form.addRow(0, new Label("Enteée utilisateur"), firField, btns);
        form.addRow(1, new Label("Copier utilisateur"), secondField);


        // add btn actions
        // copyBnt.setOnAction(event -> );

        // add GUI elements to the global pane
        globalPane.getChildren().add(header);
        globalPane.getChildren().add(form);
        return new Scene(globalPane);
    }


    public Scene btnEventOnClick(){

        // GUI elements 
        VBox globalPane = new VBox();
        Button helloBtn = new Button("Hi !");
        Button booBtn = new Button("Boo !");

        // add event handler
        helloBtn.setOnAction(new LogBtnClickHandler());
        booBtn.setOnAction(new LogBtnClickHandler());

        // add each GUI element to the global pane
        globalPane.getChildren().add(helloBtn);
        globalPane.getChildren().add(booBtn);
        return new Scene(globalPane);
    }

    public static void main(String[] args) {
        launch();
    }

}