package application;


import java.awt.MouseInfo;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JLabel;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Client extends Application {
	int money=50000;
	int ore = 0;
	int res = 0;
	int[][]map =new int[12][6];
	int[][]status =new int[12][6];
	int tecnic[] = new int[6];
	int menuIsPressed = 0;
	ImageView oType;
	Label tcost;
	Label name;
	Label bcost,bchance,bprofit;
	Label level;
	Label description;
	Label owner;
	Label acost;
	Label aprofit;
	Label profit;
	Label nres;
	ImageView cityinfo;
	ImageView cran1;
	ImageView exc;
	ImageView qinfo;
	ImageView conc;
	ImageView finfo;
	ImageView lorry;
	ImageView helic;
	ImageView cran2;
	Button infomenu;
	@Override
	public void start(Stage s) {
		
		for(int i = 0;i<12;i++){
			for(int j = 0;j<6;j++){
				
				map[i][j]=0;
			}
			
		}
		for(int i = 0;i<12;i++){
			for(int j = 0;j<6;j++){
				
				status[i][j]=0;
			}
			
		}		
		
		
		map [0][0]=1 ;
				 String oak = "Oak City";
				 String oakd ="Small city near the outer edge. It's only one brick factory near the city.";
				 map[2][4]=2 ;
				 String pls = "Pine-Lake-City";
				 String plsd = "Industrial city surrounded with lots of factories and quarries.";
				 map[5][2] =3;
				 String newbirch = "New - Birch";
				 String newbirchd = "Big City in the center of the region. There aren't a lot of facilities near the city.";
				 map[7][5] =4;
				 String sana= "San-Acacia";
				 String sanad= "Middle-sized city at the south of the region surrounded by some quarries and factories.";
				 map[9][2] =5;
				 String lasf = "Las - Fir";
				 String lasfd = "Middle-sized touristic city located at the east of the region. Surrounded with some facilities.";
				 
				 map [3][0] =11;//sq
				 map [0][3]= 12;//sp
				  map[1][3] =13;//sq
				 map [3][3] =14;//sp
				 String sq = "Stone Quarry";
				 String sqd= "Here the stone is mined.";
				 String sp = "Sand Pit";
				 String spd= "Here the sand is mined.";
				 map [0][5] =15;//sq
				 map [5][0] =16;//sp
				 map [7][1] =17;//sq
				 map  [5][5] =18;//sp
				 map  [10][5] =19;//sq
				 map  [11][0] =20;//sp
				 
				  map[1][1]= 21;
				  map[0][4]= 22;
				  map[2][3] =23;
				  map[3][1]= 24;
				  String bf = "Brick Factory";
					 String cf = "Concrete Factory";
				 String bfd = "Here the bricks are produced";
				 String cfd = "Here the concrete is produced";
					 map[4][5]= 25;
				  map[6][3]= 26;
				  map[8][0] =27;
				  map[8][4]= 28;
				  map[10][3]=29;
				  map[11][5]=30;
				 
				
				 
		
		
		AnchorPane a1 = new AnchorPane();
		Scene sc1 = new Scene(a1);
		
		
		
		
		ImageView upbg = new ImageView("img/upbg.png");//бэкграунд верхней	панели
		upbg.setLayoutX(0);//
		upbg.setLayoutY(0);//
		upbg.setFitHeight(80);//
		upbg.setFitWidth(a1.getHeight());//
		a1.getChildren().add(upbg);
		
		
		ImageView menub = new ImageView("img/menub.png");//кнопка меню
		menub.setLayoutX(0);//
		menub.setLayoutY(0);//
		menub.setFitHeight(75);//
		menub.setFitWidth(75);//
		a1.getChildren().add(menub);//
	

		ImageView music = new ImageView("img/musicon.png");//кнопка вкл/выкл музыку
		music.setLayoutX(80);//
		music.setLayoutY(0);//
		music.setFitHeight(75);//
		music.setFitWidth(75);//
		a1.getChildren().add(music);
	
		ImageView qu = new ImageView("img/qest.png");//кнопка об игре
		qu.setLayoutX(160);//
		qu.setLayoutY(0);//
		qu.setFitHeight(75);//
		qu.setFitWidth(75);//
		a1.getChildren().add(qu);
	
		ImageView eb = new ImageView("img/endbutt.png");//кнопка передачи хода
		eb.setLayoutX(300);//
		eb.setLayoutY(0);//
		eb.setFitHeight(80);//
		eb.setFitWidth(350);//
		a1.getChildren().add(eb);
		
		ImageView goldcounter = new ImageView("img/money.png");//иконка денег
		goldcounter.setLayoutX(700);//
		goldcounter.setLayoutY(5);//
		goldcounter.setFitHeight(70);//
		goldcounter.setFitWidth(70);//
		a1.getChildren().add(goldcounter);
		
		ImageView orecounter = new ImageView("img/ore.png");//иконка сырья
		orecounter.setLayoutX(950);//
		orecounter.setLayoutY(5);//
		orecounter.setFitHeight(70);//
		orecounter.setFitWidth(70);//
		a1.getChildren().add(orecounter);
		
		

		
		
		
		
		
		ImageView rescounter = new ImageView("img/res.png");//иконка материалов
		rescounter.setLayoutX(1140);//
		rescounter.setLayoutY(5);//
		rescounter.setFitHeight(70);//
		rescounter.setFitWidth(70);//
		a1.getChildren().add(rescounter);
		
		
		ImageView mapi = new ImageView("img/map.png");//карта
		mapi.setLayoutX(150);//
		mapi.setLayoutY(80);//
		mapi.setFitHeight(570);//6x95height
		mapi.setFitWidth(1200);//12x100width
		a1.getChildren().add(mapi);
		
		
		for(int i=0;i<12;i++){
			for(int j = 0;j<6;j++){
				
				if(map[i][j]==1||map[i][j]==2||map[i][j]==3||map[i][j]==4||map[i][j]==5){
				
				ImageView house = new ImageView("img/cityi.png");//бэкграунд верхней	панели
				house.setLayoutX(150+100*i);//
				house.setLayoutY(80+95*j);//
				house.setFitHeight(95);//
				house.setFitWidth(100);//
				a1.getChildren().add(house);
			}
				if(map[i][j]==11||map[i][j]==12||map[i][j]==13||map[i][j]==14||map[i][j]==15||map[i][j]==16||map[i][j]==17||map[i][j]==18||map[i][j]==19||map[i][j]==20){
					
					ImageView ore = new ImageView("img/orei.png");//бэкграунд верхней	панели
					ore.setLayoutX(150+100*i);//
					ore.setLayoutY(80+95*j);//
					ore.setFitHeight(95);//
					ore.setFitWidth(100);//
					a1.getChildren().add(ore);
				}
				if(map[i][j]==21||map[i][j]==22||map[i][j]==23||map[i][j]==24||map[i][j]==25||map[i][j]==26||map[i][j]==27||map[i][j]==28||map[i][j]==29||map[i][j]==30){
					
					ImageView res = new ImageView("img/factl.png");//бэкграунд верхней	панели
					res.setLayoutX(150+100*i);//
					res.setLayoutY(80+95*j);//
					res.setFitHeight(95);//
					res.setFitWidth(100);//
					a1.getChildren().add(res);
				}
			
			
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		Label moneyl = new Label(""+money); //показатель денег
		moneyl.setFont(new Font("Showcard Gothic",40));
		moneyl.setLayoutX(780);
		moneyl.setLayoutY(13);
		a1.getChildren().add(moneyl);
		
		Label orel = new Label(""+ore); //показатель сырьяфаывп
		orel.setFont(new Font("Showcard Gothic",40));
		orel.setLayoutX(1030);
		orel.setLayoutY(13);
		a1.getChildren().add(orel);
		
		Label resl = new Label(""+res); //показатель материалов
		resl.setFont(new Font("Showcard Gothic",40));
		resl.setLayoutX(1220);
		resl.setLayoutY(13);
		a1.getChildren().add(resl);
		
		ImageView menui = new ImageView("img/pausem.png");//иконка материалов
		menui.setLayoutX(535);//
		menui.setLayoutY(130);//
		menui.setFitHeight(500);//6x95height
		menui.setFitWidth(300);//12x100width
		menui.setVisible(false);
		a1.getChildren().add(menui);
		
		
		ImageView lpanel = new ImageView("img/lowpanel.png");//иконка материалов
		lpanel.setLayoutX(0);//
		lpanel.setLayoutY(610);//
		lpanel.setFitHeight(220);//80
		lpanel.setFitWidth(a1.getWidth());//150
		lpanel.setVisible(true);
		a1.getChildren().add(lpanel);
		
		Image c=new Image("img/cityi.png");
		Image o=new Image ("img/orei.png");
		Image r=new Image ("img/factl.png");
		
		
		
		
		
		
		
		Button resume = new Button();
		resume.setLayoutX(565);//
		resume.setLayoutY(250);//
		resume.setPrefHeight(45);//
		resume.setPrefWidth(233);//
		resume.setOpacity(0);
		resume.setDisable(true);
		resume.setOnAction(resum->{
			menui.setVisible(false);
			a1.getChildren().remove(resume);
			
		});
		
		
		Button gexit = new Button();
		gexit.setLayoutX(568);//
		gexit.setLayoutY(465);//
		gexit.setPrefHeight(45);//
		gexit.setPrefWidth(233);//
		gexit.setOpacity(0);
		gexit.setDisable(true);
		gexit.setOnAction(gex->{
			System.exit(0);
			//a1.getChildren().remove(gexit);
			
		});
		a1.getChildren().add(resume);
		a1.getChildren().add(gexit);
		
		Button menu = new Button();
		menu.setLayoutX(0);//50
		menu.setLayoutY(0);//125
		menu.setPrefHeight(75);//
		menu.setPrefWidth(75);//
		menu.setOpacity(0);
		menu.setOnAction(bb->{
			
			
			if(menuIsPressed==1){
				menui.setVisible(false);
				System.out.println("f");
				resume.setDisable(true);
				a1.getChildren().remove(resume);
				s.show();//запуск стейджа
				
				
			}
			
			if(menuIsPressed==0){
				menui.setVisible(true);
				System.out.println("t");
				resume.setDisable(false);
				gexit.setDisable(false);
				
				s.setScene(sc1);//установка сцены
				s.show();//запуск стейджа
				
				
			}
			if(menuIsPressed==0){
				menuIsPressed = 1;
			}
			else{
				menuIsPressed=0;
			}
			
		});
		a1.getChildren().add(menu);
		 infomenu = new Button();
			infomenu.setLayoutX(10);//50
			infomenu.setLayoutY(615);//125
			infomenu.setPrefHeight(30);//
			infomenu.setPrefWidth(75);//
			infomenu.setDisable(true);
			infomenu.setOpacity(0);
			a1.getChildren().add(infomenu);
		
			
			
			cityinfo = new ImageView("img/infomenu.png");//50+10
			cityinfo.setLayoutX(0);//
			cityinfo.setLayoutY(80);//
			cityinfo.setFitHeight(700);//6x95height
			cityinfo.setFitWidth(a1.getWidth());//12x100width
			cityinfo.setVisible(false);
			a1.getChildren().add(cityinfo);
			
			finfo = new ImageView("img/fmenu.png");//50+10
			finfo.setLayoutX(0);//
			finfo.setLayoutY(80);//
			finfo.setFitHeight(700);//6x95height
			finfo.setFitWidth(a1.getWidth());//12x100width
			finfo.setVisible(false);
			a1.getChildren().add(finfo);
			
			
			qinfo = new ImageView("img/qmenu.png");//50+10
			qinfo.setLayoutX(0);//
			qinfo.setLayoutY(80);//
			qinfo.setFitHeight(700);//6x95height
			qinfo.setFitWidth(a1.getWidth());//12x100width
			qinfo.setVisible(false);
			a1.getChildren().add(qinfo);
			
			
			oType = new ImageView(c);//50+10
		oType.setLayoutX(35);//530
		oType.setLayoutY(665);//
		oType.setFitHeight(80);//6x95height
		oType.setFitWidth(80);//12x100width
		oType.setVisible(false);
		a1.getChildren().add(oType);
		
		owner = new Label("city"); //имя обьекта
		owner.setFont(new Font("Showcard Gothic",30));
		owner.setLayoutX(330);
		owner.setLayoutY(320);//170
		owner.setVisible(false);
		a1.getChildren().add(owner);
		
		profit = new Label("city"); //имя обьекта
		profit.setFont(new Font("Showcard Gothic",25));
		profit.setLayoutX(620);
		profit.setLayoutY(520);//170
		profit.setVisible(false);
		a1.getChildren().add(profit);
		
		
		acost = new Label("city"); //имя обьекта
		acost.setFont(new Font("Showcard Gothic",25));
		acost.setLayoutX(1100);
		acost.setLayoutY(505);//170
		acost.setVisible(false);
		a1.getChildren().add(acost);
		
		aprofit = new Label("city"); //имя обьекта
		aprofit.setFont(new Font("Showcard Gothic",25));
		aprofit.setLayoutX(1100);
		aprofit.setLayoutY(565);//170
		aprofit.setVisible(false);
		a1.getChildren().add(aprofit);
		
		
		

		bcost = new Label("city"); //имя обьекта
		bcost.setFont(new Font("Showcard Gothic",25));
		bcost.setLayoutX(1100);
		bcost.setLayoutY(625);//170
		bcost.setVisible(false);
		a1.getChildren().add(bcost);

		bchance = new Label("city"); //имя обьекта
		bchance.setFont(new Font("Showcard Gothic",25));
		bchance.setLayoutX(1100);
		bchance.setLayoutY(665);//170
		bchance.setVisible(false);
		a1.getChildren().add(bchance);

		bprofit = new Label("city"); //имя обьекта
		bprofit.setFont(new Font("Showcard Gothic",25));
		bprofit.setLayoutX(1100);
		bprofit.setLayoutY(700);//170
		bprofit.setVisible(false);
		a1.getChildren().add(bprofit);
		
		
		tcost = new Label("city"); //имя обьекта
		tcost.setFont(new Font("Showcard Gothic",30));
		tcost.setLayoutX(400);
		tcost.setLayoutY(450);//170
		tcost.setVisible(false);
		a1.getChildren().add(tcost);
		
		nres = new Label("city"); //имя обьекта
		nres.setFont(new Font("Showcard Gothic",30));
		nres.setLayoutX(460);
		nres.setLayoutY(550);//170
		nres.setVisible(false);
		a1.getChildren().add(nres);
		
		
		
		name = new Label("city"); //имя обьекта
		name.setFont(new Font("Showcard Gothic",40));
		name.setLayoutX(170);
		name.setLayoutY(680);//170
		name.setVisible(false);
		a1.getChildren().add(name);
		level = new Label("lvl"); //имя обьекта
		level.setFont(new Font("Showcard Gothic",27));
		level.setLayoutX(170);
		level.setLayoutY(735);//170
		level.setVisible(false);
		a1.getChildren().add(level);
		description = new Label("hi"); //имя обьекта
		description.setFont(new Font("Showcard Gothic",27));
		description.setPrefWidth(600);
		description.setPrefHeight(100);
		description.setLayoutX(700);
		description.setLayoutY(650);//170
		description.setVisible(false);
		a1.getChildren().add(description);
		
		
		exc = new ImageView("img/excav.png");//50+10
		exc.setLayoutX(50);//
		exc.setLayoutY(555);//
		exc.setFitHeight(70);//6x95height
		exc.setFitWidth(70);//12x100width
		exc.setVisible(false);
		a1.getChildren().add(exc);
		
		cran1 = new ImageView("img/cran2.png");//50+10
		cran1.setLayoutX(150);//
		cran1.setLayoutY(555);//
		cran1.setFitHeight(70);//6x95height
		cran1.setFitWidth(70);//12x100width
		cran1.setVisible(false);
		a1.getChildren().add(cran1);
		
		
		cran2 = new ImageView("img/cran.png");//50+10
		cran2.setLayoutX(250);//
		cran2.setLayoutY(555);//
		cran2.setFitHeight(70);//6x95height
		cran2.setFitWidth(70);//12x100width
		cran2.setVisible(false);
		a1.getChildren().add(cran2);
		
		
		conc = new ImageView("img/concrete.png");//50+10
		conc.setLayoutX(50);//
		conc.setLayoutY(635);//
		conc.setFitHeight(70);//6x95height
		conc.setFitWidth(70);//12x100width
		conc.setVisible(false);
		a1.getChildren().add(conc);
		
		lorry = new ImageView("img/lorry.png");//50+10
		lorry.setLayoutX(150);//
		lorry.setLayoutY(635);//
		lorry.setFitHeight(70);//6x95height
		lorry.setFitWidth(70);//12x100width
		lorry.setVisible(false);
		a1.getChildren().add(lorry);
		
		
		helic = new ImageView("img/helicopter.png");//50+10
		helic.setLayoutX(250);//
		helic.setLayoutY(635);//
		helic.setFitHeight(70);//6x95height
		helic.setFitWidth(70);//12x100width
		helic.setVisible(false);
		a1.getChildren().add(helic);
		
		
		Button closeim = new Button();
		closeim.setLayoutX(10);//
		closeim.setLayoutY(85);//
		closeim.setPrefHeight(30);//
		closeim.setPrefWidth(70);//
		closeim.setOpacity(0);
		closeim.setDisable(true);
		a1.getChildren().add(closeim);
		
		
		EventHandler handler = new EventHandler<InputEvent>() {
		    public void handle(InputEvent event) {
		    	Point location = MouseInfo.getPointerInfo().getLocation();
		        double x = (int)(location.getX()-150)/100;
		        double y =(int) (location.getY()-80)/95;
		    	
		    	System.out.println("Handling event " + event.getEventType()+"/"+x+"/"+y); 
		        if(location.getX()>150&&location.getY()>80){
		    	if(map[(int) x][(int) y]==1||map[(int) x][(int) y]==2||map[(int) x][(int) y]==3||map[(int) x][(int) y]==4||map[(int) x][(int) y]==5){
		    		level.setText("");
		    		level.setVisible(true);
		    		oType.setImage(c);
		    		oType.setVisible(true);
		    		if(map[(int) x][(int) y]==1){
		    		name.setText(oak);
		    		name.setVisible(true);	
		    		description.setText(oakd);
		    		description.setVisible(true);
		    		
		    		}
		    		if(map[(int) x][(int) y]==2){
			    		name.setText(pls);
			    		name.setVisible(true);	
			    		description.setText(plsd);
			    		description.setVisible(true);	
		    		}
		    		if(map[(int) x][(int) y]==3){
			    		name.setText(newbirch);
			    		name.setVisible(true);	
			    		description.setText(newbirchd);
			    		description.setVisible(true);	
		    		}
		    		if(map[(int) x][(int) y]==4){
			    		name.setText(sana);
			    		name.setVisible(true);	
			    		description.setText(sanad);
			    		description.setVisible(true);	
	
		    		}
		    		if(map[(int) x][(int) y]==5){
			    		name.setText(lasf);
			    		name.setVisible(true);	
			    		description.setText(lasfd);
			    		description.setVisible(true);	
		    		}
		    		
		    		s.setScene(sc1);//установка сцены
		    		s.show();//запуск стейджа
		    		
		    		
		    	}
		    	if(map[(int) x][(int) y]==11||map[(int) x][(int) y]==12||map[(int) x][(int) y]==13||map[(int) x][(int) y]==14||map[(int) x][(int) y]==15||map[(int) x][(int) y]==16||map[(int) x][(int) y]==17||map[(int) x][(int) y]==18||map[(int) x][(int) y]==19||map[(int) x][(int) y]==20){
		    		oType.setImage(o);
		    		oType.setVisible(true);
		    		if(map[(int) x][(int) y]==11||map[(int) x][(int) y]==13||map[(int) x][(int) y]==15||map[(int) x][(int) y]==17||map[(int) x][(int) y]==19){
		    			name.setText(sq);
			    		name.setVisible(true);	
		    		description.setText(sqd);
		    		description.setVisible(true);
		    		}
		    		else{
		    			name.setText(sp);
			    		name.setVisible(true);	
			    		description.setText(spd);
			    		description.setVisible(true);
		    		}
		    		
		    		if(map[(int) x][(int) y]==11||map[(int) x][(int) y]==12||map[(int) x][(int) y]==13||map[(int) x][(int) y]==14){
		    			level.setText("1 lvl");
			    		level.setVisible(true);	
		    			
		    		}
		    		if(map[(int) x][(int) y]==15||map[(int) x][(int) y]==16||map[(int) x][(int) y]==17){
		    			level.setText("2 lvl");
			    		level.setVisible(true);	
		    			
		    		}
		    		if(map[(int) x][(int) y]==18||map[(int) x][(int) y]==19){
		    			level.setText("3 lvl");
			    		level.setVisible(true);	
		    			
		    		}
		    		if(map[(int) x][(int) y]==20){
		    			level.setText("4 lvl");
			    		level.setVisible(true);	
		    			
		    		}
		    		
		    		
		    		
		    		
		    		s.setScene(sc1);//установка сцены
		    		s.show();//запуск стейджа
		    		
		    		
		    	}
		    	if(map[(int) x][(int) y]==21||map[(int) x][(int) y]==22||map[(int) x][(int) y]==23||map[(int) x][(int) y]==24||map[(int) x][(int) y]==25||map[(int) x][(int) y]==26||map[(int) x][(int) y]==27||map[(int) x][(int) y]==28||map[(int) x][(int) y]==29||map[(int) x][(int) y]==30){
		    		oType.setImage(r);
		    		oType.setVisible(true);
		    		
		    		if(map[(int) x][(int) y]==21||map[(int) x][(int) y]==23||map[(int) x][(int) y]==25||map[(int) x][(int) y]==27||map[(int) x][(int) y]==29){
		    			name.setText(bf);
			    		name.setVisible(true);	
			    		description.setText(bfd);
			    		description.setVisible(true);
		    		}
		    		else{
		    			name.setText(cf);
			    		name.setVisible(true);	
			    		description.setText(cfd);
			    		description.setVisible(true);
		    		}
		    		
		    		if(map[(int) x][(int) y]==21||map[(int) x][(int) y]==22||map[(int) x][(int) y]==23||map[(int) x][(int) y]==24){
		    			level.setText("1 lvl");
			    		level.setVisible(true);	
		    			
		    		}
		    		if(map[(int) x][(int) y]==25||map[(int) x][(int) y]==26||map[(int) x][(int) y]==27){
		    			level.setText("2 lvl");
			    		level.setVisible(true);	
		    			
		    		}
		    		if(map[(int) x][(int) y]==28||map[(int) x][(int) y]==29){
		    			level.setText("3 lvl");
			    		level.setVisible(true);	
		    			
		    		}
		    		if(map[(int) x][(int) y]==30){
		    			level.setText("4 lvl");
			    		level.setVisible(true);	
		    			
		    		}
		    		
		    		
		    		
		    		
		    		
		    		s.setScene(sc1);//установка сцены
		    		s.show();//запуск стейджа
		    		
		    		
		    	}
		    	
		    	
	    		infomenu.setOnAction(bb2->{
	    		if(oType.getImage()==c){
	    			System.out.println("lol");
	    			cityinfo.setVisible(true);
	    			lpanel.setVisible(false);
	    			oType.setLayoutY(155);
	    			name.setLayoutY(170);
	    			description.setLayoutY(170);
	    			tcost.setVisible(true);
	    			profit.setVisible(true);
	    			nres.setVisible(true);
	    			acost.setVisible(true);
	    			aprofit.setVisible(true);
	    			bcost.setVisible(true);
	    			bchance.setVisible(true);
	    			bprofit.setVisible(true);
	    			if(map[(int) x][(int) y]==1){
	    				tcost.setText("500");
	    				profit.setText("4500$/turn");
	    			nres.setText("500");
	    			cran1.setVisible(true);
	    			exc.setVisible(true);
	    			acost.setText("1000$/turn");
	    			aprofit.setText("+3%/turn");
	    			bcost.setText("5000$");
	    			bchance.setText("70%");
	    			bprofit.setText("+15%");
	    			
	    			}
	    			if(map[(int) x][(int) y]==2){
	    				tcost.setText("500");
	    				profit.setText("4500$/turn");
	    				nres.setText("520");
	    				cran1.setVisible(true);
	    				conc.setVisible(true);
	    				acost.setText("1000$/turn");
		    			aprofit.setText("+3%/turn");
		    			bcost.setText("5000$");
		    			bchance.setText("70%");
		    			bprofit.setText("+15%");
	    			}
	    			if(map[(int) x][(int) y]==3){
	    				tcost.setText("800");
	    				profit.setText("7650$/turn");
	    				nres.setText("850");
	    				cran1.setVisible(true);
	    				conc.setVisible(true);
	    				exc.setVisible(true);
	    				acost.setText("1500$/turn");
		    			aprofit.setText("+5%/turn");
		    			bcost.setText("15000$");
		    			bchance.setText("60%");
		    			bprofit.setText("+19%");
	    			}
	    			if(map[(int) x][(int) y]==4){
	    				tcost.setText("800");
	    				profit.setText("7600$/turn");
	    				nres.setText("1000");
	    				cran2.setVisible(true);
		    			exc.setVisible(true);
		    			helic.setVisible(true);
		    			acost.setText("1500$/turn");
		    			aprofit.setText("+5%/turn");
		    			bcost.setText("15000$");
		    			bchance.setText("60%");
		    			bprofit.setText("+19%");
	    			}
	    			if(map[(int) x][(int) y]==5){
	    				tcost.setText("1400");
	    				profit.setText("14000$/turn");
	    				nres.setText("2000");
	    				cran2.setVisible(true);
		    			exc.setVisible(true);
		    			helic.setVisible(true);
		    			lorry.setVisible(true);
		    			conc.setVisible(true);
		    			acost.setText("2900$/turn");
		    			aprofit.setText("+8%/turn");
		    			bcost.setText("25000$");
		    			bchance.setText("45%");
		    			bprofit.setText("+20%");
	    			}
	    			if(status[(int) x][(int) y]==0){
	    				owner.setVisible(true);
	    				owner.setText("Not Defined");
	    			}
	    			closeim.setDisable(false);
	    			closeim.setOnAction(cl->{
	    				cityinfo.setVisible(false);
		    			lpanel.setVisible(true);
		    			oType.setLayoutY(665);
		    			name.setLayoutY(680);
		    			description.setLayoutY(680);
		    			tcost.setVisible(false);
		    			profit.setVisible(false);
		    			nres.setVisible(false);
		    			cran2.setVisible(false);
		    			exc.setVisible(false);
		    			helic.setVisible(false);
		    			lorry.setVisible(false);
		    			conc.setVisible(false);
		    			cran1.setVisible(false);
		    			acost.setVisible(false);
		    			aprofit.setVisible(false);
		    			bcost.setVisible(false);
		    			bchance.setVisible(false);
		    			bprofit.setVisible(false);
		    			if(status[(int) x][(int) y]==0){
		    				owner.setText("Not Defined");
		    				owner.setVisible(false);
		    				
		    			}
	    			});
	    			
	    			s.setScene(sc1);//установка сцены
	    			s.show();//запуск стейджа
	    			
	    		}	
	    		if(oType.getImage()==o){
	    			System.out.println("lol");
	    			qinfo.setVisible(true);
	    			lpanel.setVisible(false);
	    			oType.setLayoutY(155);
	    			name.setLayoutY(170);
	    			level.setLayoutY(250);
	    			description.setLayoutY(170);
	    			if(status[(int) x][(int) y]==0){
	    				owner.setVisible(true);
	    				owner.setText("Not Defined");
	    			}
	    			closeim.setDisable(false);
	    			closeim.setOnAction(cl->{
	    				qinfo.setVisible(false);
		    			lpanel.setVisible(true);
		    			oType.setLayoutY(665);
		    			name.setLayoutY(680);
		    			level.setLayoutY(735);
		    			if(status[(int) x][(int) y]==0){
		    				owner.setVisible(false);
		    				owner.setText("Not Defined");
		    			}
		    			description.setLayoutY(680);
	    			});
	    			
	    			s.setScene(sc1);//установка сцены
	    			s.show();//запуск стейджа
	    			
	    		}	
	    		if(oType.getImage()==r){
	    			System.out.println("lol");
	    			finfo.setVisible(true);
	    			lpanel.setVisible(false);
	    			oType.setLayoutY(155);
	    			name.setLayoutY(170);
	    			level.setLayoutY(250);
	    			description.setLayoutY(170);
	    			if(status[(int) x][(int) y]==0){
	    				owner.setVisible(true);
	    				owner.setText("Not Defined");
	    			}
	    			closeim.setDisable(false);
	    			closeim.setOnAction(cl->{
	    				finfo.setVisible(false);
		    			lpanel.setVisible(true);
		    			oType.setLayoutY(665);
		    			name.setLayoutY(680);
		    			level.setLayoutY(735);
		    			description.setLayoutY(680);
		    			if(status[(int) x][(int) y]==0){
		    				owner.setVisible(false);
		    				owner.setText("Not Defined");
		    			}
	    			});
	    			
	    			s.setScene(sc1);//установка сцены
	    			s.show();//запуск стейджа
	    			
	    		}	
	    		});
	    		infomenu.setDisable(false);
	    		
	    		
		    	event.consume();
		    }
		    }
		};
		
		a1.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		
		
		
	s.setFullScreen(true);//фуллскрин
	s.setScene(sc1);//установка сцены
	s.show();//запуск стейджа
	

	}

	
	
	public static void main(String[] args) {
		launch(args);
	}
}
