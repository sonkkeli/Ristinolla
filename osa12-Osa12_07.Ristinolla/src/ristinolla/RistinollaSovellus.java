package ristinolla;

import javafx.application.Application;
import java.util.Arrays;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class RistinollaSovellus extends Application {
    
    private Button[] napit = new Button[9];

    public void start(Stage ikkuna){
        BorderPane asettelu = new BorderPane();
        Pelilogiikka peli = new Pelilogiikka();
        
        GridPane ristikko = new GridPane();
        ristikko.setVgap(10);
        ristikko.setHgap(10);
        ristikko.setPadding(new Insets(10, 10, 10, 10));
         // Font font = new Font(40);
        int i = 0;
        while (i < 9){
            for (int x = 1; x <= 3; x++) {
                for (int y = 1; y <= 3; y++) {
                    napit[i] = new Button(" ");
                    napit[i].setFont(Font.font("Monospaced", 40));
                    ristikko.add(napit[i], x, y);                   
                    i++;
                }
            }
        }        
        Label vuoro = new Label("Vuoro: X");
        vuoro.setFont(Font.font("Monospaced", 40));
        asettelu.setTop(vuoro);
        asettelu.setCenter(ristikko);
        
        
        for (Button nappi : napit){
            nappi.setOnAction((event) -> {
            nappi.setText(peli.getVuoro());
            nappi.setDisable(true);
            vuoro.setText("Vuoro: " + peli.getSeuraavaVuoro());
            peli.setVuoro();
            if (peli.onkoVoitettu(napit) == true){
                vuoro.setText("Loppu!");
                for(Button loput : napit){
                    loput.setDisable(true); 
                }
                               
            }

            });
        }
        
        
        Scene nakyma = new Scene(asettelu);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(RistinollaSovellus.class);
    }

}
