package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Menu extends Application {

	@Override
	public void start(Stage ss) {
		AnchorPane a1 =new AnchorPane();
		Scene sc1 = new Scene(a1,800,600);
		ss.setTitle("DuoPolia");
		
		ImageView bg = new ImageView("img/launcher.png");
		bg.setLayoutX(0);
		bg.setLayoutX(0);
		bg.setFitHeight(600);
		bg.setFitWidth(800);
		a1.getChildren().add(bg);
		ss.setScene(sc1);
		ss.show();
	
		
		TextField ip = new TextField();
		ip.setLayoutX(125);
		ip.setLayoutY(227);
		ip.setPrefWidth(186);
		ip.setPrefHeight(27);
		a1.getChildren().add(ip);
	

		TextField name = new TextField();
		name.setLayoutX(136);
		name.setLayoutY(293);
		name.setPrefWidth(175);
		name.setPrefHeight(27);
		a1.getChildren().add(name);
	

		TextField region = new TextField();
		region.setLayoutX(175);
		region.setLayoutY(370);
		region.setPrefWidth(125);
		region.setPrefHeight(27);
		a1.getChildren().add(region);
	
	
		ImageView warning =new ImageView("img/warning.png");
		warning.setLayoutX(300);
		warning.setLayoutY(250);
		warning.setFitHeight(40);
		warning.setFitWidth(300);
		warning.setOpacity(0);
		a1.getChildren().add(warning);
		
		Button create = new Button();
		create.setLayoutX(25);
		create.setLayoutY(485);
		create.setPrefHeight(65);
		create.setPrefWidth(337);
		create.setOpacity(0);
		create.setOnAction(server->{
			try {
				new Server(23454);
			} catch (IOException e) {
				warning.setOpacity(1);
				ss.show();
			}
			
		});
		a1.getChildren().add(create);

		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
