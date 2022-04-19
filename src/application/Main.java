package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class Main extends Application {
	public void start(Stage primaryStage) {

		 primaryStage.setTitle("Convertisseur");
		 primaryStage.setHeight(300);
		 primaryStage.setWidth(500);

		 /*
		 * La mise en forme de la fenêtre sera gérée par un layout de type VBox
		 * (V = vertical).
		 * Donc les composants, Text, TextField, Text et la ligne contenant les 2 boutons,
		 * seront affichés verticalement, les uns en dessous des autres
		 */
		 VBox racine = new VBox(20); 


		 racine.setAlignment(Pos.CENTER);


		 Label titre = new Label("Convertisseur de durées heures et minutes ");
		 titre.setTextFill(Color.BLUE);
		 titre.setFont(new Font("verdana", 20));


		 TextField saisieHeure = new TextField();
		 TextField saisieMinute = new TextField();
		 TextField resultatEnMinute = new TextField();
		 resultatEnMinute.setEditable(false);
		 HBox heure = new HBox(30);
		 HBox minute = new HBox(30);
		 HBox enMinute = new HBox(30);



		 Label labelHeure = new Label("Heures :");
		 Label labelMinute = new Label("Minutes :");
		 Label labelEnMinute = new Label("En minutes :");
		 heure.getChildren().addAll(labelHeure,saisieHeure);
		 minute.getChildren().addAll(labelMinute,saisieMinute);
		 enMinute.getChildren().addAll(labelEnMinute,resultatEnMinute);

		 heure.setAlignment(Pos.CENTER);
		 minute.setAlignment(Pos.CENTER);
		 enMinute.setAlignment(Pos.CENTER);
		 
		 racine.getChildren().addAll(titre,heure,minute,enMinute);
		 

		 HBox ligneBouton = new HBox(30); 
		 ligneBouton.setAlignment(Pos.BOTTOM_RIGHT);


		 Button calculer = new Button("Convertir");
		 Button effacer = new Button("Annuler");
		 HBox.setMargin(effacer, new Insets(0, 10, 0, 0));
		 ligneBouton.getChildren().addAll(calculer, effacer);

		 racine.getChildren().add(ligneBouton);

		 /*
		 * On associe au bouton calculer un écouteur d'événement (clic sur bouton)
		 * Lors du clic sur le bouton "calculer", on affiche dans la zone de texte
		 * le nombre de minutes
		 */
		 calculer.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
		 @Override
		 public void handle(ActionEvent event) {
			 boolean entreeCorrect = true;
			 int heure = 0;
			 int minute = 0;
			 char[] entreeMinute = saisieMinute.getText().toCharArray();
			 char[] entreeHeure = saisieHeure.getText().toCharArray();
			 
			 for (int i = 0; i < entreeHeure.length && entreeCorrect; i++) {
				 if (entreeHeure[i] < 48 || entreeHeure[i] > 57) {
					 entreeCorrect = false;
				 }
				 else {
					 heure = (int) heure * 10  + (entreeHeure[i] - 48);
				 }
			 }
			 heure *= 60;

			 for (int i = 0; i < entreeMinute.length && entreeCorrect; i++) {
				 if (entreeMinute[i] < 48 || entreeMinute[i] > 57) {
					 entreeCorrect = false;
				 }
				 else {
					 minute = (int) minute * 10 + (entreeMinute[i] - 48);
				 }
			 }
			 minute += heure;
			 if (!entreeCorrect) {
				 minute = 0;
			 }
			 resultatEnMinute.setText(minute + " minutes ");
		 }
		 });
		 effacer.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				saisieMinute.clear();
				saisieHeure.clear();
				resultatEnMinute.clear();
				
			}
		});
		 Scene scene = new Scene(racine);
		 primaryStage.setScene(scene);
		 primaryStage.show();
	} 

	
	
	public static void main(String[] args) {
		launch(args);
	}
}
