package application;

import java.io.IOException; 

import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.image.ImageView; 
import javafx.scene.layout.AnchorPane; 
import javafx.stage.Stage; 

public class Launcher extends Application { 


public void start(Stage s) { 
AnchorPane a1 = new AnchorPane(); 
Scene sc = new Scene(a1); 
ImageView screen = new ImageView("img/screen3.png"); 
screen.setLayoutX(0); 
screen.setLayoutY(0); 
screen.setFitHeight(650); 
screen.setFitWidth(850); 
a1.getChildren().add(screen); 
s.setScene(sc); 
s.show(); 

Button newg = new Button(); 

newg.setLayoutX(340); 
newg.setLayoutY(190); 
newg.setPrefHeight(25); 
newg.setPrefWidth(150); 
newg.setDisable(false); 
newg.setOpacity(0); 
newg.setOnAction(newgame->{ 

Menu mn = new Menu(); 
try { 
mn.start(Menu.classStage); 
} catch (IOException e) { 

e.printStackTrace(); 
} 

}); 
a1.getChildren().add(newg); 

Button nexit = new Button(); 
nexit.setLayoutX(340); 
nexit.setLayoutY(360); 
nexit.setPrefHeight(23); 
nexit.setPrefWidth(150); 
nexit.setDisable(false); 
nexit.setOpacity(0); 
nexit.setOnAction(newexit->{ 

s.close(); 

}); 
a1.getChildren().add(nexit); 

} 

public static void main(String[] args) { 
launch(args); 
} 
}