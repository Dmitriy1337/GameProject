	package application;
	
	import java.awt.event.ActionEvent; 
	import java.awt.event.ActionListener; 
	import java.io.DataInputStream; 
	import java.io.DataOutputStream; 
	import java.io.IOException; 
	import java.net.InetAddress; 
	import java.net.Socket;
import java.util.ArrayList;

import javafx.application.Application; 
	import javafx.scene.Scene; 
	import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField; 
	import javafx.scene.image.ImageView; 
	import javafx.scene.layout.AnchorPane; 
	import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage; 
	
	
	public class Menu extends Application { 
	ImageView warning; 
	Stage ss; 
	TextField ip;
	TextField ipe;
	static Stage classStage = new Stage(); 
	ArrayList<String>iplist = new ArrayList<String>();
	ArrayList<String>namelist = new ArrayList<String>();
	ArrayList<String>rlist = new ArrayList<String>();
	TextField region;
	TextField name;
	public void start(Stage ss) throws IOException { 
	Menu.classStage = ss; 
	int serverPort = 3220; // здесь об€зательно нужно указать порт к которому прив€зываетс€ сервер. 
	String address = "127.0.0.1"; // это IP-адрес компьютера, где исполн€етс€ наша серверна€ программа. 
	//десь указан адрес того самого компьютера где будет исполн€тьс€ и клиент. 
	
	try { 
	InetAddress ipAddress = InetAddress.getByName(address); // создаем объект который отображает вышеописанный IP-адрес. 
	System.out.println("Any of you heard of a socket with IP address " + address + " and port " + serverPort + "?"); 
	Socket socket = new Socket(ipAddress, serverPort); // создаем сокет использу€ IP-адрес и порт сервера. 
	
	
	
	} catch (Exception x) { 
	
	} 
	
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
	
	
	 ip = new TextField(); 
	ip.setLayoutX(125); 
	ip.setLayoutY(227); 
	ip.setPrefWidth(186); 
	ip.setPrefHeight(27); 
	a1.getChildren().add(ip); 
	
	 ipe = new TextField(); 
	 ipe.setLayoutX(525); 
	 ipe.setLayoutY(525); 
	 ipe.setPrefWidth(186); 
	 ipe.setPrefHeight(27); 
	 a1.getChildren().add(ipe); 
	
	
	 name = new TextField(); 
	name.setLayoutX(136); 
	name.setLayoutY(293); 
	name.setPrefWidth(175); 
	name.setPrefHeight(27); 
	a1.getChildren().add(name); 
	
	
	 region = new TextField(); 
	
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
	create.setDisable(false); 
	create.setOpacity(0); 
	create.setOnAction(server->{ 
		iplist.add(ip.getText());
		namelist.add(name.getText());
		rlist.add(region.getText());
		for(int i = 0;i<iplist.size();i++){
		Label l = new Label(iplist.get(i));
		l.setLayoutX(400);
		l.setLayoutY(125+20*i);
		l.setFont(new Font("Showcard Gothic",20));
		a1.getChildren().add(l);
		}
		for(int i = 0;i<namelist.size();i++){
			Label l = new Label(namelist.get(i));
			l.setLayoutX(540);
			l.setLayoutY(125+20*i);
			l.setFont(new Font("Showcard Gothic",20));
			a1.getChildren().add(l);
			}
		for(int i = 0;i<rlist.size();i++){
			Label l = new Label(rlist.get(i));
			l.setLayoutX(650);
			l.setLayoutY(125+20*i);
			l.setFont(new Font("Showcard Gothic",20));
			a1.getChildren().add(l);
			}
		
		
		
		
		Thread tc = new launchServer(); 
	tc.start(); 
	
	
	
	}); 
	a1.getChildren().add(create); 
	
	Button join = new Button(); 
	join.setLayoutX(410); 
	join.setLayoutY(440); 
	join.setPrefHeight(65); 
	join.setPrefWidth(337); 
	join.setDisable(false); 
	join.setOpacity(0); 
	join.setOnAction(client->{ 
	
	Client cl = new Client(); 
	
	cl.start(Client.classStage); 
	cl.setIP(ipe.getText());
	
	
	
	}); 
	a1.getChildren().add(join); 
	
	} 
	
	
	
	public class launchServer extends Thread{ 
	
	
	public void run() { 
	try { 
	new Server(23454,ip.getText()).run(); 
	} catch (IOException e) { 
	// TODO Auto-generated catch block 
	e.printStackTrace(); 
	} 
	} 
	
	} 
	
	public static void main(String[] args) { 
	
	launch(args); 
	} 
	
	
	
	
	
	
	
	
	
	}