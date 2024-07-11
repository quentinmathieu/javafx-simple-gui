package fr.afpa;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
        stage.setResizable(false);
        stage.show();
    }

    public Scene firstForm(){
        // graphic vars
        double spacing = 10.0;
        String headerLiearGradient = "-fx-background-color: linear-gradient(to right,#165d82 20%, #0a79b3 50%, #165d82 80%)";
        Integer padding = 40;

        // create panes
        VBox globalPane = new VBox();
        VBox header = new VBox();
        GridPane form = new GridPane();
        form.setVgap(spacing);
        form.setHgap(spacing);
        form.setPadding(new Insets(padding, padding, padding, padding));

        // add GUI components to each pane
        Label title = new Label("Formulaire");
        header.getChildren().add(title);
        header.setAlignment(Pos.CENTER);
        header.setStyle(headerLiearGradient);
        title.setStyle("-fx-font-weight: bold; -fx-text-fill: white;");
        title.setPadding(new Insets(padding/3, padding/3, padding/3, padding/3));

        VBox btns = new VBox();
        btns.setSpacing(spacing);
        Button delBtn = new Button("Effacer");
        Button exitBtn = new Button("Quitter");
        btns.getChildren().add(delBtn);
        btns.getChildren().add(exitBtn);
        TextField firstField = new TextField();
        TextField secondField = new TextField();
        secondField.setDisable(true);

        // add components to the gridPane
        form.addRow(0, new Label("Entrée de l'utilisateur"), firstField);
        form.addRow(1, new Label("Copie de l'entrée"), secondField);
        form.add(btns, 2 , 0 ,1, 2);
        btns.setAlignment(Pos.CENTER);
        
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