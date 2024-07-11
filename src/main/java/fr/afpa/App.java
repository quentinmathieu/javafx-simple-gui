package fr.afpa;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
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
        form.setStyle("-fx-border-color: red");

        // add GUI components to each pane
        header.getChildren().add(new Label("Formulaire"));
        
        VBox btns = new VBox();
        Button delBtn = new Button("Effacer");
        Button exitBtn = new Button("Quitter");
        btns.getChildren().add(delBtn);
        btns.getChildren().add(exitBtn);

        Label firstLabel = new Label("Entrée utilisateur");
        TextField firstField = new TextField();
        TextField secondField = new TextField();
        secondField.setDisable(true);
        form.addRow(0, firstLabel, firstField, btns);
        GridPane.setValignment(firstField, VPos.CENTER);
        GridPane.setValignment(secondField, VPos.CENTER);
        firstLabel.setStyle("-fx-border-color: blue");

        form.addRow(1, new Label("Copie de l'entrée"), secondField);

        // copy 1st field content in 2nd field content on 1st field value change
        firstField.textProperty().addListener((event) -> secondField.setText(firstField.getText()));

        // add btn actions
        delBtn.setOnAction(event -> firstField.setText(""));
        exitBtn.setOnAction(event ->  Platform.exit());

        // add GUI elements to the global pane
        globalPane.getChildren().add(header);
        globalPane.getChildren().add(form);
        return new Scene(globalPane);
    }


    public Scene btnEventOnClick(){
        LogBtnClickHandler logBtnClickHandler = new LogBtnClickHandler();

        // GUI elements 
        VBox globalPane = new VBox();
        Button helloBtn = new Button("Hi !");
        Button booBtn = new Button("Boo !");

        // add event handler
        helloBtn.setOnAction(logBtnClickHandler);
        booBtn.setOnAction(logBtnClickHandler);
        

        // add each GUI element to the global pane
        globalPane.getChildren().add(helloBtn);
        globalPane.getChildren().add(booBtn);
        Scene scene = new Scene(globalPane);

        return scene;
    }

    public static void main(String[] args) {
        launch();
    }

}