package application;

import java.awt.MouseInfo;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JLabel;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Client extends Application {
	static BufferedReader br;   
	static BufferedWriter bw; 
	ArrayList<Circle> circles = new ArrayList<Circle>();
	ArrayList<Integer> listp  = new ArrayList<Integer>();
	int index;
	
	int m1 = 0;
	int y1 =0;
	int j1=0;
	int k1= 0;
	int m2 = 0;
	int y2 =0;
	int j2=0;
	int k2= 0;
	int h = 0;
	EventHandler handler ;
	String pmass="";
	int QPROFIT=0;
	String fmass="";
	int RPROFIT=0;
	int LOSS=0;
	int RES=0;
	int eres=0;
	ImageView winl;
	Image biuld;
	ImageView eb;
	Label moneyl;
	AnchorPane a1 ;
	Scene sc1;
	Button participate1;
	Button participate;
	Button adv;
	Button bribery;
	Button list;
	ImageView py;
	Image wini;
	Image losei;
	Image bb2;
	Image bb;
	ImageView lpanel;
	Image win;
	Image lose;
	Image standart;
	Label orel;

	String m = "";
	int tid = 0;
	Label cpt;
	int T_COUNT=0;
	int TURN_P = 0;
	Label mpt;
	Label mapt;
	String tt="";
	int tapcounter;
	int MOVE_C=0;;
	static Socket s;  
	private BufferedReader input;
    private PrintWriter output;
    static AffableThread mSecondThread;
    String line = null;
   Image build;
    String lin2e = "";
    int money=50000;
	String TURN_ID="";
	ProgressBar winp;
	ProgressBar tprogress;
	Button buyq;
	Button use;
	Button buyf;
	int B_COUNT=0;
	int ore = 0;
	int res = 0;
	int[][]map =new int[12][6];
	int[][]status =new int[12][6];
	int tecnic[] = new int[6];
	int [][]usr = new int[12][6];
	int [][]bstatus = new int[12][6];
	int [][]built = new int[12][6];
	double [][]prog = new double[12][6];
	int menuIsPressed = 0;
	ImageView oType;
	Button nextTurn;
	Button bank;
	//
	Label tcost;
	Label name;
	Label bcost,bchance,bprofit;
	Label level;
	Label description;
	Label resl;
	Label owner;
	Label acost;
	Label aprofit;
	Label profit;
	Label nres;
	Label salary;
	Label qcost;
	Label listo;
	Label listo1;
	Label listl;
	Label listl1;
	Label listh;
	Label listh1;
	Label listk;
	Label listk1;
	Label mm1;
	Label yy1;
	Label jj1;
	Label kk1;
	Label mm2;
	Label yy2;
	Label jj2;
	Label kk2;
	Label city1;
	Label city2;
	Label city3;
	Label city4;
	Label city5;
	TextArea er;
	ImageView wl;
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
	int A_COUNT=0;
	String ip;
	Socket so;  // yoi aoaao nieao aey na?aa?a
    BufferedReader socketReader; // aooa?ece?iaaiiue ?eoaoaeu n na?aa?a
    BufferedWriter socketWriter; // aooa?ece?iaaiiue ienaoaeu ia na?aa?
     BufferedReader userInput; // aooa?ece?iaaiiue ?eoaoaeu iieuciaaoaeuneiai aaiaa n eiiniee
	
    
    
    
    public synchronized void close() {//iaoia neio?iiece?iaai, ?oiau enee??eou aaieiia cae?uoea.
        if (!so.isClosed()) { // i?iaa?yai, ?oi nieao ia cae?uo...
            try {
                so.close(); // cae?uaaai...
                System.exit(0); // auoiaei!
            } catch (IOException ignored) {
                ignored.printStackTrace();
            }
        }
    }
   
    
    public void setIP(String ip){
    	this.ip = ip;
    	
    }
    
    static Stage classStage = new Stage();
    
    public void start(Stage s) {
    	
    	Client.classStage = s;

    	System.out.println(index);
    	try {
			so = new Socket(ip,23454);
			 socketReader = new BufferedReader(new InputStreamReader(so.getInputStream(), "UTF-8"));
		        socketWriter = new BufferedWriter(new OutputStreamWriter(so.getOutputStream(), "UTF-8"));
		        // nicaaai ?eoaoaey n eiiniee (io iieuciaaoaey)
		      
		        new Thread(new Receiver()).start();// nicaaai e caioneaai ieou aneio?iiiiai ?oaiey ec nieaoa

		  } catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // nicaaai nieao
	        // nicaaai ?eoaoaey e ienaoaey a nieao n aaoieiie eiae?iaeie UTF-8
		
		
		
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
		
		for(int i = 0;i<12;i++){
			for(int j = 0;j<6;j++){
				
				usr[i][j]=0;
			}
			
		}	
		for(int i = 0;i<12;i++){
			for(int j = 0;j<6;j++){
				
				built[i][j]=0;
			}
			
		}	
		for(int i = 0;i<12;i++){
			for(int j = 0;j<6;j++){
				
				prog[i][j]=0;
			}
			
		}	
		for(int i = 0;i<12;i++){
			for(int j = 0;j<6;j++){
				
				bstatus[i][j]=0;
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
				 
				
				 
		
		
		 a1 = new AnchorPane();
		 sc1 = new Scene(a1);
		
		
		
		
		ImageView upbg = new ImageView("img/upbg.png");//ayea?aoia aa?oiae	iaiaee
		
		upbg.setLayoutX(0);//
		upbg.setLayoutY(0);//
		upbg.setFitHeight(80);//
		upbg.setFitWidth(a1.getHeight());//
		a1.getChildren().add(upbg);
		
		
		ImageView progbar = new ImageView("img/progressbar.png");//ayea?aoia aa?oiae	iaiaee
		
		progbar.setLayoutX(970);//
		progbar.setLayoutY(90);//
		progbar.setFitHeight(150);//
		progbar.setFitWidth(300);//
		a1.getChildren().add(progbar);
		
		ImageView leftbar = new ImageView("img/leftp.png");//ayea?aoia aa?oiae	iaiaee
		
		leftbar.setLayoutX(0);//
		leftbar.setLayoutY(90);//
		leftbar.setFitHeight(600);//
		leftbar.setFitWidth(150);//
		a1.getChildren().add(leftbar);
		
		ImageView menub = new ImageView("img/menub.png");//eiiiea iai?
		menub.setLayoutX(0);//
		menub.setLayoutY(0);//
		menub.setFitHeight(75);//
		menub.setFitWidth(75);//
		a1.getChildren().add(menub);//
	

		ImageView music = new ImageView("img/musicon.png");//eiiiea aee/auee iocueo
		music.setLayoutX(80);//
		music.setLayoutY(0);//
		music.setFitHeight(75);//
		music.setFitWidth(75);//
		a1.getChildren().add(music);//
	
		ImageView qu = new ImageView("img/qest.png");//eiiiea ia ea?a
		qu.setLayoutX(160);//
		qu.setLayoutY(0);//
		qu.setFitHeight(75);//
		qu.setFitWidth(75);//
		a1.getChildren().add(qu);
	
		 eb = new ImageView("img/endbutt.png");//eiiiea ia?aaa?e oiaa
		eb.setLayoutX(300);//
		eb.setLayoutY(0);//
		eb.setFitHeight(80);//
		eb.setFitWidth(350);//
		a1.getChildren().add(eb);
		 
		
		
		ImageView goldcounter = new ImageView("img/money.png");//eeiiea aaiaa
		goldcounter.setLayoutX(700);//
		goldcounter.setLayoutY(5);//
		goldcounter.setFitHeight(70);//
		goldcounter.setFitWidth(70);//
		a1.getChildren().add(goldcounter);
		
		ImageView orecounter = new ImageView("img/ore.png");//eeiiea nu?uy
		orecounter.setLayoutX(950);//
		orecounter.setLayoutY(5);//
		orecounter.setFitHeight(70);//
		orecounter.setFitWidth(70);//
		a1.getChildren().add(orecounter);
		
		
		 winp = new ProgressBar();
		winp.setLayoutX(990);
		winp.setLayoutY(155);
		
		
		
		
		double dwinp = money/1000000.0;
		System.out.println(money+"/"+dwinp);
		winp.setProgress(dwinp);
		winp.setPrefWidth(250);
		a1.getChildren().add(winp);
		
		
		
		
		
		
		
		
		ImageView rescounter = new ImageView("img/res.png");//eeiiea iaoa?eaeia
		rescounter.setLayoutX(1140);//
		rescounter.setLayoutY(5);//
		rescounter.setFitHeight(70);//
		rescounter.setFitWidth(70);//
		a1.getChildren().add(rescounter);
		
		
		ImageView mapi = new ImageView("img/map.png");//ea?oa
		mapi.setLayoutX(150);//
		mapi.setLayoutY(80);//
		mapi.setFitHeight(570);//6x95height
		mapi.setFitWidth(800);//12x100width
		a1.getChildren().add(mapi);
		
		
		for(int i=0;i<12;i++){
			for(int j = 0;j<6;j++){
				
				if(map[i][j]==1||map[i][j]==2||map[i][j]==3||map[i][j]==4||map[i][j]==5){
				
				ImageView house = new ImageView("img/cityi.png");//ayea?aoia aa?oiae	iaiaee
				house.setLayoutX(150+67*i);//
				house.setLayoutY(85+95*j);//
				house.setFitHeight(70);//
				house.setFitWidth(63);//
				a1.getChildren().add(house);
			}
				if(map[i][j]==11||map[i][j]==12||map[i][j]==13||map[i][j]==14||map[i][j]==15||map[i][j]==16||map[i][j]==17||map[i][j]==18||map[i][j]==19||map[i][j]==20){
					
					ImageView ore = new ImageView("img/orei.png");//ayea?aoia aa?oiae	iaiaee
					ore.setLayoutX(150+67*i);//
					ore.setLayoutY(85+95*j);//
					ore.setFitHeight(70);//
					ore.setFitWidth(63);//
					a1.getChildren().add(ore);
				}
				if(map[i][j]==21||map[i][j]==22||map[i][j]==23||map[i][j]==24||map[i][j]==25||map[i][j]==26||map[i][j]==27||map[i][j]==28||map[i][j]==29||map[i][j]==30){
					
					ImageView res = new ImageView("img/factl.png");//ayea?aoia aa?oiae	iaiaee
					res.setLayoutX(150+67*i);//
					res.setLayoutY(85+95*j);//
					res.setFitHeight(70);//
					res.setFitWidth(63);//
					a1.getChildren().add(res);
				}
			
			
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		 moneyl = new Label(""+money); //iieacaoaeu aaiaa
		moneyl.setFont(new Font("Showcard Gothic",40));
		moneyl.setLayoutX(780);
		moneyl.setLayoutY(13);
		a1.getChildren().add(moneyl);
		
		 orel = new Label(""+ore); //iieacaoaeu nu?uyoauai
		orel.setFont(new Font("Showcard Gothic",40));
		orel.setLayoutX(1030);
		orel.setLayoutY(13);
		a1.getChildren().add(orel);
		
		 resl = new Label(""+res); //iieacaoaeu iaoa?eaeia
		resl.setFont(new Font("Showcard Gothic",40));
		resl.setLayoutX(1220);
		resl.setLayoutY(13);
		a1.getChildren().add(resl);
		
		ImageView menui = new ImageView("img/pausem.png");//eeiiea iaoa?eaeia
		menui.setLayoutX(535);//
		menui.setLayoutY(130);//
		menui.setFitHeight(500);//6x95height
		menui.setFitWidth(300);//12x100width
		menui.setVisible(false);
		a1.getChildren().add(menui);
		
		
		 lpanel = new ImageView("img/lowpanel.png");//eeiiea iaoa?eaeia
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
			a1.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
			menui.setVisible(false);
			resume.setDisable(true);
			for(int i = 0;i<circles.size();i++){
	    			Circle ss = circles.get(i);
	    			ss.setOpacity(1);
	    			
	    		}
		});
		
		
		ImageView sellw = new ImageView("img/sellw.png");//eeiiea iaoa?eaeia
		sellw.setLayoutX(100);//
		sellw.setLayoutY(150);//
		sellw.setFitHeight(250);//6x95height
		sellw.setFitWidth(400);//12x100width
		sellw.setVisible(false);
		a1.getChildren().add(sellw);
		 
		ImageView list1 = new ImageView("img/list.png");
		 list1.setLayoutX(145);//
		 list1.setLayoutY(80);//
		 list1.setFitHeight(570);//6x95height
		 list1.setFitWidth(810);//12x100width
		 list1.setVisible(false);
		 a1.getChildren().add(list1);
		
		TextArea sellc = new TextArea("0");
		sellc.setLayoutX(130);
		sellc.setLayoutY(243);
		sellc.setPrefHeight(20);
		sellc.setMaxHeight(20);
		sellc.setPrefWidth(110);
		sellc.setVisible(false);
		sellc.setDisable(true);
		sellc.setFont(new Font("Showcard Gothic",20));
		a1.getChildren().add(sellc);
		
		TextArea sellr = new TextArea("0");
		sellr.setLayoutX(130);
		sellr.setLayoutY(328);
		sellr.setPrefHeight(20);
		sellr.setMaxHeight(20);
	
		sellr.setPrefWidth(110);
		sellr.setVisible(false);
		sellr.setDisable(true);
		sellr.setFont(new Font("Showcard Gothic",20));
		a1.getChildren().add(sellr);
		
		
		Button sexit = new Button();
		sexit.setLayoutX(442);//
		sexit.setLayoutY(162);//
		sexit.setPrefHeight(40);//
		sexit.setPrefWidth(40);//
		sexit.setOpacity(0);
		sexit.setDisable(true);
		a1.getChildren().add(sexit);
		
		
		
		Button buys = new Button();
		buys.setLayoutX(320);//
		buys.setLayoutY(260);//
		buys.setPrefHeight(50);//
		buys.setPrefWidth(130);//
		buys.setOpacity(0);
		buys.setDisable(true);
		buys.setOnAction(ggex->{
		
			if(nextTurn.isDisable()==false){
				
				String ssellc = sellc.getText();
			int isellc = Integer.parseInt(ssellc);
			if(ore>=isellc){
				ore = ore - isellc;
				money = money+(isellc*30);
				orel.setText(""+ore);
				moneyl.setText(""+money);
				
			}
			String ssellr = sellr.getText();
			int isellr = Integer.parseInt(ssellr);
			if(res>=isellr){
				res = res - isellr;
				money = money+(isellr*75);
				resl.setText(""+res);
				moneyl.setText(""+money);
				
			}
			
		
		}	
		s.setScene(sc1);//onoaiiaea noaiu
		s.show();//caione noaea?a	
			
			
		});
		a1.getChildren().add(buys);
		
		
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
		
		
		 bank = new Button();
		 bank.setLayoutX(30);//
		 bank.setLayoutY(110);//
		 bank.setPrefHeight(90);//
		 bank.setPrefWidth(90);//
		 bank.setOpacity(0);
		 bank.setDisable(false);
		 bank.setOnAction(buy->{
			 for(int i = 0;i<circles.size();i++){
	    			Circle ss = circles.get(i);
	    			ss.setOpacity(1);
	    			
	    		} 
				a1.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
				list1.setVisible(false); 
				listo.setVisible(false);
				listo1.setVisible(false);
				listl.setVisible(false);
				listl1.setVisible(false);
				listh.setVisible(false);
				listh1.setVisible(false);
		        listk.setVisible(false);
			    listk1.setVisible(false);
			    mm1.setVisible(false);
             mm2.setVisible(false);
				yy1.setVisible(false);
				yy2.setVisible(false);
				jj1.setVisible(false);
				jj2.setVisible(false);
				kk1.setVisible(false);
				kk2.setVisible(false);
				city1.setVisible(false);	
				city2.setVisible(false);
				city3.setVisible(false);
				city4.setVisible(false);
				city5.setVisible(false);
			 for(int i = 0;i<circles.size();i++){
	    			Circle ss = circles.get(i);
	    			ss.setOpacity(0);
	    			
	    		}
			 //sellw set visibe;
			 sellw.setVisible(true); 
			 sellc.setVisible(true);
				sellc.setDisable(false);
				sellr.setVisible(true);
				sellr.setDisable(false);
				buys.setDisable(false);
				
				sexit.setDisable(false);
				sexit.setOnAction(ll->{
					for(int i = 0;i<circles.size();i++){
		    			Circle ss = circles.get(i);
		    			ss.setOpacity(1);
		    			
		    		} 
					sellw.setVisible(false); 
					 sellc.setVisible(false);
						sellc.setDisable(true);
						sellr.setVisible(false);
						sellr.setDisable(true);
						buys.setDisable(true);	
					
					
				});
				
		 });
		 a1.getChildren().add(bank);
		

			Button lexit = new Button();
			lexit.setLayoutX(890);//
			lexit.setLayoutY(80);//
			lexit.setPrefHeight(50);//
			lexit.setPrefWidth(50);//
			lexit.setOpacity(0);
			lexit.setDisable(true);
			a1.getChildren().add(lexit);
			   
		 
		 
		 
		   list  = new Button();
		   list.setLayoutX(30);//
		   list.setLayoutY(350);//
		   list.setPrefHeight(90);//
		   list.setPrefWidth(90);//
		   list.setOpacity(0);
		   list.setDisable(false);
		   list.setVisible(true);
		   list.setOnAction(lis->{	 
			   for(int i = 0;i<circles.size();i++){
	    			Circle ss = circles.get(i);
	    			ss.setOpacity(1);
	    			
	    		} 
				sellw.setVisible(false); 
				 sellc.setVisible(false);
					sellc.setDisable(true);
					sellr.setVisible(false);
					sellr.setDisable(true);
					buys.setDisable(true);	
			   for(int i = 0;i<circles.size();i++){
	    			Circle ss = circles.get(i);
	    			ss.setOpacity(0);
	    			
	    		}
			   list1.setVisible(true);
				a1.removeEventHandler(MouseEvent.MOUSE_CLICKED, handler);
			   
			   
			   
			   
			   String mm = Integer.toString(m1);
			   String yy = Integer.toString(y1);
			   String jj = Integer.toString(j1);
			   String kk = Integer.toString(k1);
			   String mml = Integer.toString(m2);
			   String yyl = Integer.toString(y2);
			   String jjl = Integer.toString(j2);
			   String kkl = Integer.toString(k2);
			   for(int z =0;z<listp.size();z++){
			   if(listp.contains(1)){
			   
		     
		      if (m1 ==1){
		      listo.setText("Stone/Sand Quarry 1 lvl");
		      } 
		      else{
		    	listo.setText("Stone/Sand Quarries 1 lvl");  
		      }
		      listo.setVisible(true);
		      mm1.setText(mm);
			  mm1.setVisible(true);
			   //listl.setVisible(true);
		   
			   }
		   if(listp.contains(2)){
			   if (y1 ==1){
				      listl.setText("Stone/Sand Quarry 2 lvl");
				      } 
				      else{
				    	listl.setText("Stone/Sand Quarries 2 lvl");  
				      }
				      listl.setVisible(true);
				      yy1.setText(yy);
					  yy1.setVisible(true); 
		   }
		   if(listp.contains(3)){
			   if (j1 ==1){
				      listh.setText("Stone/Sand Quarry 3 lvl");
				      } 
				      else{
				    	listh.setText("Stone/Sand Quarries 3 lvl");  
				      }
				      listh.setVisible(true);
				      jj1.setText(jj);
					 jj1.setVisible(true); 
		   }
		   if(listp.contains(4)){
			   if (k1 ==1){
				      listk.setText("Stone/Sand Quarry 4 lvl");
				      } 
				      else{
				    	listk.setText("Stone/Sand Quarries 4  lvl");  
				      }
				      listk.setVisible(true);
				      kk1.setText(kk);
					  kk1.setVisible(true); 
		   }
		   if(listp.contains(5)){
			   if (m2 ==1){
				      listo1.setText("Brick/Concrete Factory 1 lvl");
				       
				     
			          
			   } 
				      else{
				    	listo1.setText("Brick/Concrete Factory 1 lvl");  
				    	 
				      }
			      
			   listo1.setVisible(true);
				      mm2.setText(mml);
					  mm2.setVisible(true); 
		   }  
		   if(listp.contains(6)){
			   if (y2 ==1){
				      listl1.setText("Brick/Concrete Factory 2 lvl");
				      
				     
			          
			   } 
				      else{
				    	listl1.setText("Brick/Concrete Factory 2 lvl");  
				    	
				      }
			      
			   listl1.setVisible(true);
				      yy2.setText(yyl);
					  yy2.setVisible(true); 
		   }  
		   if(listp.contains(7)){
			   if (j2 ==1){
				      listh1.setText("Brick/Concrete Factory 3 lvl");
				     
				     
			          
			   } 
				      else{
				    	listh1.setText("Brick/Concrete Factory 3 lvl");  
				    	 
				      }
			      
			   listh1.setVisible(true);
				      jj2.setText(jjl);
					  jj2.setVisible(true); 
		   } 
		   if(listp.contains(8)){
			   if (k2 ==1){
				      listk1.setText("Brick/Concrete Factory 4 lvl");
				      
				     
			          
			   } 
				      else{
				    	listk1.setText("Brick/Concrete Factory 4 lvl");  
				    	 
				      }
			      
			   listk1.setVisible(true);
				      kk2.setText(kkl);
					  kk2.setVisible(true); 
		   } 
			  
		   if(listp.contains(9)){
			   city1.setText("Oak City");
			   city1.setVisible(true);
		     
			   } 
			   
			  
		   if(listp.contains(10)){
			   city2.setText("Pine-Lake-City");
			   city2.setVisible(true);

		     
			   } 
			  
		   if(listp.contains(11)){
			   city3.setText("New - Birch");
			   city3.setVisible(true);

		     
			   } 
			  
		   if(listp.contains(12)){
			   city4.setText("San-Acacia");
			   city4.setVisible(true);

		     
			   } 
			  
		   if(listp.contains(13)){
			   city5.setText("Las - Fir");
			   city5.setVisible(true);

		     
			   } 
			   
			   
			   }   
			   
			   
			   lexit.setDisable(false);
			   lexit.setOnAction(l1->{
					for(int i = 0;i<circles.size();i++){
		    			Circle ss = circles.get(i);
		    			ss.setOpacity(1);
		    			
		    		} 
					a1.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
					list1.setVisible(false); 
					listo.setVisible(false);
					listo1.setVisible(false);
					listl.setVisible(false);
					listl1.setVisible(false);
					listh.setVisible(false);
					listh1.setVisible(false);
			        listk.setVisible(false);
				    listk1.setVisible(false);
				    mm1.setVisible(false);
	                mm2.setVisible(false);
					yy1.setVisible(false);
					yy2.setVisible(false);
					jj1.setVisible(false);
					jj2.setVisible(false);
					kk1.setVisible(false);
					kk2.setVisible(false);
					city1.setVisible(false);	
					city2.setVisible(false);
					city3.setVisible(false);
					city4.setVisible(false);
					city5.setVisible(false);
					
				});
		   
		   });
		   a1.getChildren().add(list);
		
		
		Button menu = new Button();
		menu.setLayoutX(0);//50
		menu.setLayoutY(0);//125
		menu.setPrefHeight(75);//
		menu.setPrefWidth(75);//
		menu.setOpacity(0);
		menu.setOnAction(bb->{
			a1.removeEventHandler(MouseEvent.MOUSE_CLICKED, handler);	
			
			if(menuIsPressed==1){
				menui.setVisible(false);
				System.out.println("f");
				resume.setDisable(true);
				gexit.setDisable(true);
				for(int i = 0;i<circles.size();i++){
 	    			Circle ss = circles.get(i);
 	    			ss.setOpacity(1);
 	    			
 	    		}
				s.show();//caione noaea?a
				
				
			}
			
			if(menuIsPressed==0){
				menui.setVisible(true);
				System.out.println("t");
				resume.setDisable(false);
				gexit.setDisable(false);
				for(int i = 0;i<circles.size();i++){
 	    			Circle ss = circles.get(i);
 	    			ss.setOpacity(0);
 	    			
 	    		}
				s.setScene(sc1);//onoaiiaea noaiu
				s.show();//caione noaea?a
				
				
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
		
			
			
			
			
			
			
			 bb2 = new Image("img/endbutt2.png");
			 bb = new Image("img/endbutt.png");
			nextTurn = new Button();
			nextTurn.setLayoutX(310);//50
			nextTurn.setLayoutY(2);//125
			nextTurn.setPrefHeight(75);//
			nextTurn.setPrefWidth(320);//
			nextTurn.setDisable(false);
			nextTurn.setOpacity(0);
		System.out.println("Turnid"+TURN_ID);
			
			nextTurn.setOnAction(nturn->{
				MOVE_C=0;
				money = money-LOSS;
			moneyl.setText(""+money);
			a1.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
			
				py.setVisible(false);
				adv.setDisable(true);
				bribery.setDisable(true);	
			
    			tprogress.setVisible(false);
    			participate.setDisable(true);
    			cityinfo.setVisible(false);
			lpanel.setVisible(true);
			oType.setLayoutY(665);
			name.setLayoutY(680);
			description.setLayoutY(680);
			tcost.setVisible(false);
			profit.setVisible(false);
			nres.setVisible(false);
			py.setVisible(false);
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
			for(int i = 0;i<circles.size();i++){
    			Circle sj = circles.get(i);
    			sj.setOpacity(1);
    			
    		}
			
				owner.setVisible(false);
				er.setDisable(true);
				use.setDisable(true);
				er.setVisible(false);
				finfo.setVisible(false);
    			lpanel.setVisible(true);
    			oType.setLayoutY(665);
    			name.setLayoutY(680);
    			buyq.setDisable(true);
    			level.setLayoutY(735);
    			description.setLayoutY(680);
    			owner.setVisible(false);
    			er.setDisable(true);
				use.setDisable(true);
				er.setVisible(false);
				finfo.setVisible(false);
    			lpanel.setVisible(true);
    			oType.setLayoutY(665);
    			name.setLayoutY(680);
    			buyq.setDisable(true);
    			level.setLayoutY(735);
    			description.setLayoutY(680);
    			owner.setVisible(false);
			
			for(int i = 0;i<12;i++){
				for(int j = 0;j<6;j++){
					pmass = pmass+status[i][j];
					
					
				}
			}
			
			
			
			if(TURN_ID.equals("1")){
				System.out.println("TURNID3"+TURN_ID);		
				try {
						tapcounter++;
						
						socketWriter.write(pmass+"/1");
						socketWriter.write("\n"); //aiaaaeyai "iiai? no?ieo", aaau readLine() na?aa?a n?aaioae
				        socketWriter.flush(); // ioi?aaeyai
				        pmass="";		
				} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
				
				if(TURN_ID.equals("2")){
					tapcounter++;
					System.out.println("TURNID3"+TURN_ID);	
					try{
					System.out.print("test");
						socketWriter.write(pmass+"/2");
					socketWriter.write("\n"); //aiaaaeyai "iiai? no?ieo", aaau readLine() na?aa?a n?aaioae
			        socketWriter.flush(); // ioi?aaeyai
					pmass="";
					}
			        catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				}
				
			nextTurn.setDisable(true);
			eb.setImage(bb2);
			s.setScene(sc1);//onoaiiaea noaiu
    		s.show();//caione noaea?a
			});
			a1.getChildren().add(nextTurn);
			
			
			
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
		
		
		
		
		owner = new Label("city"); //eiy iauaeoa
		owner.setFont(new Font("Showcard Gothic",30));
		owner.setTextFill(Color.WHITE);
		
		owner.setLayoutX(330);
		
		owner.setLayoutY(320);//170
		owner.setVisible(false);
		a1.getChildren().add(owner);
		
		qcost = new Label("city"); //eiy iauaeoa
		qcost.setFont(new Font("Showcard Gothic",30));
		qcost.setTextFill(Color.WHITE);
		qcost.setLayoutX(320);
		qcost.setLayoutY(443);//170
		qcost.setVisible(false);
		a1.getChildren().add(qcost);
		
		
		salary = new Label("city"); //eiy iauaeoa
		salary.setFont(new Font("Showcard Gothic",30));
		salary.setTextFill(Color.WHITE);
		salary.setLayoutX(360);
		salary.setLayoutY(400);//170
		salary.setVisible(false);
		a1.getChildren().add(salary);
		
		
		
		profit = new Label("city"); //eiy iauaeoa
		profit.setTextFill(Color.WHITE);
		profit.setFont(new Font("Showcard Gothic",25));
		profit.setLayoutX(620);
		profit.setLayoutY(520);//170
		profit.setVisible(false);
		a1.getChildren().add(profit);
		
		
		acost = new Label("city"); //eiy iauaeoa
		acost.setFont(new Font("Showcard Gothic",25));
		acost.setTextFill(Color.WHITE);
		acost.setLayoutX(1100);
		acost.setLayoutY(505);//170
		acost.setVisible(false);
		a1.getChildren().add(acost);
		
		aprofit = new Label("city"); //eiy iauaeoa
		aprofit.setFont(new Font("Showcard Gothic",25));
		aprofit.setTextFill(Color.WHITE);
		aprofit.setLayoutX(1100);
		aprofit.setLayoutY(565);//170
		aprofit.setVisible(false);
		a1.getChildren().add(aprofit);
		
		
		

		bcost = new Label("city"); //eiy iauaeoa
		bcost.setFont(new Font("Showcard Gothic",25));
		bcost.setTextFill(Color.WHITE);
		bcost.setLayoutX(1100);
		bcost.setLayoutY(625);//170
		bcost.setVisible(false);
		a1.getChildren().add(bcost);

		bchance = new Label("city"); //eiy iauaeoa
		bchance.setFont(new Font("Showcard Gothic",25));
		bchance.setTextFill(Color.WHITE);
		bchance.setLayoutX(1100);
		bchance.setLayoutY(665);//170
		bchance.setVisible(false);
		a1.getChildren().add(bchance);

		bprofit = new Label("city"); //eiy iauaeoa
		bprofit.setFont(new Font("Showcard Gothic",25));
		bprofit.setTextFill(Color.WHITE);
		bprofit.setLayoutX(1100);
		bprofit.setLayoutY(700);//170
		bprofit.setVisible(false);
		a1.getChildren().add(bprofit);
		
		
		tcost = new Label("city"); //eiy iauaeoa
		tcost.setFont(new Font("Showcard Gothic",30));
		tcost.setTextFill(Color.WHITE);
		tcost.setLayoutX(400);
		tcost.setLayoutY(450);//170
		tcost.setVisible(false);
		a1.getChildren().add(tcost);
		
		nres = new Label("city"); //eiy iauaeoa
		nres.setFont(new Font("Showcard Gothic",30));
		nres.setTextFill(Color.WHITE);
		nres.setLayoutX(460);
		nres.setLayoutY(550);//170
		nres.setVisible(false);
		a1.getChildren().add(nres);
		
		listo = new Label("");
		listo.setFont(new Font("Showcard Gothic", 25));	
		listo.setLayoutX(200);
		listo.setLayoutY(110);
		listo.setVisible(false);
		a1.getChildren().add(listo);
		
		listo1 = new Label("");
		listo1.setFont(new Font("Showcard Gothic", 25));	
		listo1.setLayoutX(200);
		listo1.setLayoutY(360);
		listo1.setVisible(false);
		a1.getChildren().add(listo1);
		
		
		listl = new Label( "");
		listl.setFont(new Font("Showcard Gothic", 25));	
		listl.setLayoutX(200);
		listl.setLayoutY(160);
		listl.setVisible(false);
		a1.getChildren().add(listl);
		
		listl1 = new Label( "");
		listl1.setFont(new Font("Showcard Gothic", 25));	
		listl1.setLayoutX(200);
		listl1.setLayoutY(420);
		listl1.setVisible(false);
		a1.getChildren().add(listl1);
		
		listh = new Label( "");
		listh.setFont(new Font("Showcard Gothic", 25));	
		listh.setLayoutX(200);
		listh.setLayoutY(210);
		listh.setVisible(false);
		a1.getChildren().add(listh); 
		
		listh1 = new Label( "");
		listh1.setFont(new Font("Showcard Gothic", 25));	
		listh1.setLayoutX(200);
		listh1.setLayoutY(480);
		listh1.setVisible(false);
		a1.getChildren().add(listh1);
		
		listk = new Label( "");
		listk.setFont(new Font("Showcard Gothic", 25));	
		listk.setLayoutX(200);
		listk.setLayoutY(260);
		listk.setVisible(false);
		a1.getChildren().add(listk);
		
		listk1 = new Label( "");
		listk1.setFont(new Font("Showcard Gothic", 25));	
		listk1.setLayoutX(200);
		listk1.setLayoutY(540);
		listk1.setVisible(false);
		a1.getChildren().add(listk1);
		
		mm1 = new Label("");
		mm1.setFont(new Font("Showcard Gothic", 25));	
		mm1.setLayoutX(180);
		mm1.setLayoutY(110);
		mm1.setVisible(false);
		a1.getChildren().add(mm1);
		
		mm2 = new Label("");
		mm2.setFont(new Font("Showcard Gothic", 25));	
		mm2.setLayoutX(180);
		mm2.setLayoutY(360);
		mm2.setVisible(false);
		a1.getChildren().add(mm2);
		
		yy1 = new Label("");
		yy1.setFont(new Font("Showcard Gothic", 25));	
		yy1.setLayoutX(180);
		yy1.setLayoutY(160);
		yy1.setVisible(false);
		a1.getChildren().add(yy1);
		
		yy2 = new Label("");
		yy2.setFont(new Font("Showcard Gothic", 25));	
		yy2.setLayoutX(180);
		yy2.setLayoutY(420);
		yy2.setVisible(false);
		a1.getChildren().add(yy2);
		
		jj1 = new Label("");
		jj1.setFont(new Font("Showcard Gothic", 25));	
		jj1.setLayoutX(180);
		jj1.setLayoutY(210);
		jj1.setVisible(false);
		a1.getChildren().add(jj1);
		
		jj2 = new Label("");
		jj2.setFont(new Font("Showcard Gothic", 25));	
		jj2.setLayoutX(180);
		jj2.setLayoutY(480);
		jj2.setVisible(false);
		a1.getChildren().add(jj2);
		
		kk1 = new Label("");
		kk1.setFont(new Font("Showcard Gothic", 25));	
		kk1.setLayoutX(180);
		kk1.setLayoutY(260);
		kk1.setVisible(false);
		a1.getChildren().add(kk1);
		
		kk2 = new Label("");
		kk2.setFont(new Font("Showcard Gothic", 25));	
		kk2.setLayoutX(180);
		kk2.setLayoutY(540);
		kk2.setVisible(false);
		a1.getChildren().add(kk2);
		
		city1 = new Label("");
		city1.setFont(new Font("Showcard Gothic", 25));	
		city1.setLayoutX(640);
		city1.setLayoutY(170);
		city1.setVisible(false);
		a1.getChildren().add(city1);
		
		
		city2 = new Label("");
		city2.setFont(new Font("Showcard Gothic", 25));	
		city2.setLayoutX(640);
		city2.setLayoutY(240);
		city2.setVisible(false);
		a1.getChildren().add(city2);
		
		city3= new Label("");
		city3.setFont(new Font("Showcard Gothic", 25));	
		city3.setLayoutX(640);
		city3.setLayoutY(310);
		city3.setVisible(false);
		a1.getChildren().add(city3);
		
		city4 = new Label("");
		city4.setFont(new Font("Showcard Gothic", 25));	
		city4.setLayoutX(640);
		city4.setLayoutY(380);
		city4.setVisible(false);
		a1.getChildren().add(city4);
		
		city5 = new Label("");
		city5.setFont(new Font("Showcard Gothic", 25));	
		city5.setLayoutX(640);
		city5.setLayoutY(450);
		city5.setVisible(false);
		a1.getChildren().add(city5);
		
		cpt = new Label("city"); //eiy iauaeoa
		cpt.setFont(new Font("Showcard Gothic",30));
		cpt.setTextFill(Color.WHITE);
		cpt.setLayoutX(440);
		cpt.setLayoutY(363);//170
		cpt.setVisible(false);
		a1.getChildren().add(cpt);
		
		mpt = new Label("city"); //eiy iauaeoa
		mpt.setFont(new Font("Showcard Gothic",30));
		mpt.setTextFill(Color.WHITE);
		mpt.setLayoutX(440);
		mpt.setLayoutY(363);//170
		mpt.setVisible(false);
		a1.getChildren().add(mpt);
		
		
		mapt = new Label("city"); //eiy iauaeoa
		mapt.setFont(new Font("Showcard Gothic",30));
		mapt.setTextFill(Color.WHITE);
		mapt.setLayoutX(440);
		mapt.setLayoutY(363);//170
		mapt.setVisible(false);
		a1.getChildren().add(mapt);
		
		
		
		
		
		name = new Label("city"); //eiy iauaeoa
		name.setFont(new Font("Showcard Gothic",40));
		name.setTextFill(Color.WHITE);
		name.setLayoutX(170);
		name.setLayoutY(680);//170
		name.setVisible(false);
		a1.getChildren().add(name);
		level = new Label("lvl"); //eiy iauaeoa
		level.setFont(new Font("Showcard Gothic",27));
		level.setTextFill(Color.WHITE);
		level.setLayoutX(170);
		level.setLayoutY(735);//170
		level.setVisible(false);
		a1.getChildren().add(level);
		description = new Label("hi"); //eiy iauaeoa
		description.setFont(new Font("Showcard Gothic",20));
		description.setTextFill(Color.WHITE);
		description.setWrapText(true);
		description.setPrefWidth(600);
		description.setPrefHeight(100);
		description.setLayoutX(700);
		description.setLayoutY(650);//170
		description.setVisible(false);
		a1.getChildren().add(description);
		
		

		 participate = new Button();
		 participate.setLayoutX(790);//50
		 participate.setLayoutY(315);//125
		 participate.setPrefHeight(101);//
		 participate.setPrefWidth(513);//
		 participate.setDisable(true);
		 participate.setOpacity(0);
		 a1.getChildren().add(participate);
		
		 participate1 = new Button();
		 participate1.setLayoutX(790);//50
		 participate1.setLayoutY(315);//125
		 participate1.setPrefHeight(101);//
		 participate1.setPrefWidth(513);//
		 participate1.setDisable(true);
		 participate1.setOpacity(0);
		 a1.getChildren().add(participate1);
		 
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
		
		
		py = new ImageView("img/py.png");//50+10
		py.setLayoutX(790);//
		py.setLayoutY(315);//
		py.setFitHeight(101);//6x95height
		py.setFitWidth(513);//12x100width
		py.setVisible(false);
		a1.getChildren().add(py);
		
		
		
		Button closeim = new Button();
		closeim.setLayoutX(10);//
		closeim.setLayoutY(85);//
		closeim.setPrefHeight(30);//
		closeim.setPrefWidth(70);//
		closeim.setOpacity(0);
		closeim.setDisable(true);
		a1.getChildren().add(closeim);
		
		buyq = new Button();
		buyq.setLayoutX(800);//50
		buyq.setLayoutY(320);//125
		buyq.setPrefHeight(100);//
		buyq.setPrefWidth(500);//
		buyq.setDisable(true);
		buyq.setOpacity(0);
		a1.getChildren().add(buyq);
		
		use = new Button();
		use.setLayoutX(450);//50
		use.setLayoutY(610);//125
		use.setPrefHeight(80);//
		use.setPrefWidth(250);//
		use.setDisable(true);
		use.setOpacity(0);
		a1.getChildren().add(use);
		
		
		
		 er = new TextArea("0");
		er.setLayoutX(310);
		er.setLayoutY(620);
		er.setPrefHeight(19);
		er.setDisable(true);
		er.setVisible(false);
		er.setPrefWidth(110);
		er.setFont(new Font("Showcard Gothic",27));
		a1.getChildren().add(er);
		
		

		tprogress = new ProgressBar();
		tprogress.setLayoutX(339);
		tprogress.setLayoutY(370);
		tprogress.setProgress(0);
		tprogress.setPrefWidth(250);
		tprogress.setVisible(false);
		a1.getChildren().add(tprogress);
		
		adv =new Button();
		adv.setLayoutX(790);//50
		adv.setLayoutY(315);//125
		adv.setPrefHeight(101);//
		adv.setPrefWidth(513/2);//
		adv.setDisable(true);
		adv.setOpacity(0);
		a1.getChildren().add(adv);
		
		bribery =new Button();
		bribery.setLayoutX(1046);//50
		bribery.setLayoutY(315);//125
		bribery.setPrefHeight(101);//
		bribery.setPrefWidth(513/2);//
		bribery.setDisable(true);
		bribery.setOpacity(0);
		a1.getChildren().add(bribery);
		 win = new Image("img/win.png");
		 lose = new Image("img/lose.png");
		 standart = new Image("img/py.png");
		 build = new Image("img/build.png");
		
		 wini = new Image("img/victory.png");
		 losei = new Image("img/defeat.png");
			this.winl = new ImageView(wini);	 
		 winl.setLayoutX(200);
		 winl.setLayoutY(200);
		winl.setFitHeight(400);
		winl.setFitWidth(700);
		winl.setOpacity(0);
		a1.getChildren().add(winl);
		 
		 handler = new EventHandler<InputEvent>() {

	
			 
			 
			 
			 public void handle(InputEvent event) {
		    	Point location = MouseInfo.getPointerInfo().getLocation();
		        double x = (int)(location.getX()-150)/67;
		        double y =(int) (location.getY()-80)/95;
		    	
		    	System.out.println("Handling event " + event.getEventType()+"/"+x+"/"+y); 
		        if(location.getX()>150&&location.getY()>80&&location.getX()<950&&location.getY()<650){//950/650
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
		    		
		    		s.setScene(sc1);//onoaiiaea noaiu
		    		s.show();//caione noaea?a
		    		
		    		
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
			    		cpt.setText("6/turn");
			    		salary.setText("300$/turn");
			    		qcost.setText("8000$");
		    		}
		    		if(map[(int) x][(int) y]==15||map[(int) x][(int) y]==16||map[(int) x][(int) y]==17){
		    			level.setText("2 lvl");
			    		level.setVisible(true);	
			    		cpt.setText("12/turn");
			    		salary.setText("600$/turn");
			    		qcost.setText("16000$");
		    		}
		    		if(map[(int) x][(int) y]==18||map[(int) x][(int) y]==19){
		    			level.setText("3 lvl");
			    		level.setVisible(true);	
			    		cpt.setText("24/turn");
			    		salary.setText("1200$/turn");
			    		qcost.setText("32000$");
		    		}
		    		if(map[(int) x][(int) y]==20){
		    			level.setText("4 lvl");
			    		level.setVisible(true);	
			    		cpt.setText("48/turn");
			    		salary.setText("2400$/turn");
			    		qcost.setText("64000$");
		    		}
		    	}
		    		///
		    		if(map[(int) x][(int) y]==21||map[(int) x][(int) y]==22||map[(int) x][(int) y]==23||map[(int) x][(int) y]==24||map[(int) x][(int) y]==25||map[(int) x][(int) y]==26||map[(int) x][(int) y]==27||map[(int) x][(int) y]==28||map[(int) x][(int) y]==29||map[(int) x][(int) y]==30){
		    		if(map[(int) x][(int) y]==21||map[(int) x][(int) y]==22||map[(int) x][(int) y]==23||map[(int) x][(int) y]==24){
		    			level.setText("1 lvl");
			    		level.setVisible(true);	
			    		cpt.setText("9/turn");
			    		salary.setText("450$/turn");
			    		qcost.setText("12000$");
		    		}
		    		if(map[(int) x][(int) y]==25||map[(int) x][(int) y]==26||map[(int) x][(int) y]==27){
		    			level.setText("2 lvl");
			    		level.setVisible(true);	
			    		cpt.setText("18/turn");
			    		salary.setText("900$/turn");
			    		qcost.setText("24000$");
		    		}
		    		if(map[(int) x][(int) y]==28||map[(int) x][(int) y]==29){
		    			level.setText("3 lvl");
			    		level.setVisible(true);	
			    		cpt.setText("32/turn");
			    		salary.setText("1800$/turn");
			    		qcost.setText("48000$");
		    		}
		    		if(map[(int) x][(int) y]==30){
		    			level.setText("4 lvl");
			    		level.setVisible(true);	
			    		cpt.setText("64/turn");
			    		salary.setText("3600$/turn");
			    		qcost.setText("96000$");
		    		}
		    		
		    		
		    		s.setScene(sc1);//onoaiiaea noaiu
		    		s.show();//caione noaea?a
		    		
		    		
		    	}//
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
		    		
		    		
		    		
		    		
		    		
		    		s.setScene(sc1);//onoaiiaea noaiu
		    		s.show();//caione noaea?a
		    		
		    		
		    	}
		    	
		    	
	    		infomenu.setOnAction(bb2->{
	    			a1.removeEventHandler(MouseEvent.MOUSE_CLICKED, handler);
	    			for(int i = 0;i<circles.size();i++){
	    			Circle s = circles.get(i);
	    			s.setOpacity(0);
	    			
	    		}
	    			
	    			
	    			
	    			
	    			if(oType.getImage()==c){
	    			System.out.println("lol");
	    			if(status[(int) x][(int) y]==0||status[(int) x][(int) y]==4){
	    			participate.setDisable(false);
	    			
	    			}
	    			if(status[(int) x][(int) y]==1){
		    			participate.setDisable(false);
		    			py.setImage(build);
		    		py.setVisible(true);	
	    			}
	    			if(status[(int) x][(int) y]==3){
	    			if(bstatus[(int) x][(int) y]==0){
	    				py.setImage(standart);
	    			}
	    			if(bstatus[(int) x][(int) y]==1){
	    				py.setImage(win);
	    			System.out.println("ttt1");
	    			}
	    			if(bstatus[(int) x][(int) y]==2){
	    				py.setImage(lose);
	    				System.out.println("ttt2");
	    			}
	    			}
	    			
	    			
	    			participate.setOnAction(l->{
	    				if(prog[(int) x][(int) y]<1){
	    				System.out.println("presserbutton");
	    					if((status[(int) x][(int) y]==0||status[(int) x][(int) y]==4)&&T_COUNT==0&&Integer.parseInt(tcost.getText())<=money){
	    				
	    					if(bstatus[(int) x][(int) y]==0){
	    	    				py.setImage(standart);
	    	    				py.setVisible(true);
	    					}
	    	    			if(bstatus[(int) x][(int) y]==1){
	    	    				py.setImage(win);
	    	    			System.out.println("ttt1");
	    	    			py.setVisible(true);
	    	    			}
	    	    			if(bstatus[(int) x][(int) y]==2){
	    	    				py.setImage(lose);
	    	    				System.out.println("ttt2");
	    	    				py.setVisible(true);
	    	    			}
	    				money = money -Integer.parseInt(tcost.getText()); 	
	    				moneyl.setText(""+money);	
	    				prog[(int) x][(int) y]+=0.1;
	    				tprogress.setProgress(prog[(int) x][(int) y]);
	    				status[(int) x][(int) y]=3;
	    				py.setVisible(true);
	    				
	    				
	    				T_COUNT=1;	
	    				adv.setDisable(false);
	    				bribery.setDisable(false);
	    				adv.setOnAction(k->{
	    				if(A_COUNT==0){
	    					String ss[] = acost.getText().split("/");
	    				String ss1  = ss[0].replace("$", "");
	    				
	    				if(money>Integer.parseInt(ss1)){
	    					money = money -Integer.parseInt(ss1);
	    					moneyl.setText(""+money);
	    					String a1 = aprofit.getText().replace("+","" );
	    					String a2[] = a1.split("%");
	    					System.out.println(""+Double.parseDouble(a2[0])/100);
	    					prog[(int) x][(int) y]+=Double.parseDouble(a2[0])/100;
	    					tprogress.setProgress(prog[(int) x][(int) y]);
	    				}
	    					
	    				A_COUNT = 1;
	    				}
	    				}
	    				);
	    				bribery.setOnAction(m->{
	    					if(B_COUNT==0&&money>Integer.parseInt(bcost.getText().replace("$",""))&&bstatus[(int) x][(int) y] ==0){
		    				String ss1  = acost.getText().replace("$", "");
	    					int a= (int)(Math.random()*100+1);
	    					money = money - Integer.parseInt(bcost.getText().replace("$",""));
	    					moneyl.setText(""+money);
	    					if(a<Integer.parseInt(bchance.getText().replace("%", ""))){
	    						py.setImage(win);
	    					String f = bprofit.getText().replace("%", "");
	    					f = f.replace("+", "");
	    						prog[(int) x][(int) y] += Double.parseDouble(f)/100;
	    						tprogress.setProgress(prog[(int) x][(int) y]);
	    						bstatus[(int) x][(int) y] = 1;
	    					   
	    					}
	    					else{
	    						py.setImage(lose);	
	    						bstatus[(int) x][(int) y] = 2;
	    					
	    					}
	    					
		    				B_COUNT=1;
	    					}	
	    				});//
	    				
	    				for(int i=0;i<12;i++){
	 	           			for(int j = 0;j<6;j++){
	 	           			if(status[i][j]==1){
	 	           				
	 	           				Circle c = new Circle();
	 	           				c.setRadius(5);
	 	           				c.setCenterX(155+67*i);
	 	           				c.setCenterY(86+95*j);
	 	           			c.setFill(Color.GREEN);
	 	           		System.out.println("circle");
	 	           			a1.getChildren().add(c);
	 	           		circles.add(c);
	 	           			}//revolution	
	 	           		if(status[i][j]==2){
	 	           		Circle c2 = new Circle();
	           				c2.setRadius(5);
	           				c2.setCenterX(155+67*i);
	           				c2.setCenterY(86+95*j);
	           			c2.setFill(Color.RED);
	           		System.out.println("circle2");
	           			a1.getChildren().add(c2);	
	           			circles.add(c2);
 	           				
 	           			}	
	 	           	if(status[i][j]==3){
	 	           		Circle c2 = new Circle();
	           				c2.setRadius(5);
	           				c2.setCenterX(155+67*i);
	           				c2.setCenterY(86+95*j);
	           			c2.setFill(Color.ORANGE);
	           		System.out.println("circle2");
	           			a1.getChildren().add(c2);	
	           			circles.add(c2);
 	           				
 	           			}			
	 	           				
	 	           				
	 	           			}
	 	           			
	 	            		}//
	    				for(int i = 0;i<circles.size();i++){
	    	    			Circle s = circles.get(i);
	    	    			s.setOpacity(0);
	    	    			
	    	    		}
	    				s.setScene(sc1);//onoaiiaea noaiu
		    			s.show();//caione noaea?a
		    			
	    				}
	    				
	    				
	    				
	    			}
	    				else{
	    				status[(int) x][(int) y]=1;	
	    				System.out.println("success");
	    				for(int i=0;i<12;i++){
	 	           			for(int j = 0;j<6;j++){
	 	           			if(status[i][j]==1){
	 	           				Circle c = new Circle();
	 	           				c.setRadius(5);
	 	           				c.setCenterX(155+67*i);
	 	           				c.setCenterY(86+95*j);
	 	           			c.setFill(Color.GREEN);
	 	           		System.out.println("circle");
	 	           			a1.getChildren().add(c);
	 	           		circles.add(c);
	 	           			}//revolution	
	 	           		if(status[i][j]==2){
	 	           		Circle c2 = new Circle();
	           				c2.setRadius(5);
	           				c2.setCenterX(155+67*i);
	           				c2.setCenterY(86+95*j);
	           			c2.setFill(Color.RED);
	           		System.out.println("circle2");
	           			a1.getChildren().add(c2);	
	           			circles.add(c2);
 	           				
 	           			}	
	 	           	if(status[i][j]==3){
	 	           		Circle c2 = new Circle();
	           				c2.setRadius(5);
	           				c2.setCenterX(155+67*i);
	           				c2.setCenterY(86+95*j);
	           			c2.setFill(Color.ORANGE);
	           		System.out.println("circle2");
	           			a1.getChildren().add(c2);	
	           			circles.add(c2);
 	           				
 	           			}			
	 	           				
	 	           				
	 	           			}
	 	           			
	 	            		}//
	    				for(int i = 0;i<circles.size();i++){
	    	    			Circle s = circles.get(i);
	    	    			s.setOpacity(0);
	    	    			
	    	    		}
	    				
	    			
	    				}});
	    		if(status[(int) x][(int) y]==1){
	    			participate.setDisable(true);	
	    			participate.setOpacity(0);
		    		participate1.setDisable(false);
	    			
	    		}
	    		if(participate1.isDisable()==false){
	    			
	    			participate1.setOnAction(zz->{	
	    			py.setImage(build);
	    		    py.setVisible(true);
	    		  if(Integer.parseInt(nres.getText())<=res&&T_COUNT==0&&built[(int) x][(int) y]==0){
	    						System.out.println("buildprofit");
	    						String d = profit.getText().replace("$", "");
    				String dd[] = d.split("/");
    				TURN_P+=Integer.parseInt(dd[0]);
	    			res = res - Integer.parseInt(nres.getText());
	    			resl.setText(""+res);
	    			
	    			built[(int) x][(int) y]=1;
	    			String name1 = name.getText();
	    			if(name1== oak){
	    				listp.add(9);
	    			}
	    			else if(name1==pls){
	    				listp.add(10);
	    			}///
	    			else if(name1==newbirch){
	    				listp.add(11);
	    			}
	    			else if(name1==sana){
	    				listp.add(12);
	    			}
	    			else if(name1==lasf){
	    				listp.add(13);
	    			}
	    			s.setScene(sc1);//onoaiiaea noaiu
	    			s.show();//caione noaea?a
	    			T_COUNT=1;
	    		   
	    			
	    			
	    			
	    					
	    			  
	    		
	    		
	    		
	    			}
	    			
	    		});	
	    			  
	    		}		
	    		s.setScene(sc1);//onoaiiaea noaiu
    			s.show();//caione noaea?a	
    			
	    		if(status[(int) x][(int) y]==3){
    				py.setVisible(true);
    				adv.setDisable(false);
    				adv.setOnAction(k->{
	    				if(A_COUNT==0){
    					String ss[] = acost.getText().split("/");
	    				String ss1  = ss[0].replace("$", "");
	    				System.out.println("f"+ss1);
	    				if(money>Integer.parseInt(ss1)){
	    					money = money -Integer.parseInt(ss1);
	    					moneyl.setText(""+money);
	    					String a1 = aprofit.getText().replace("+","" );
	    					String a2[] = a1.split("%");
	    					
	    					prog[(int) x][(int) y]+=Double.parseDouble(a2[0])/100;
	    					tprogress.setProgress(prog[(int) x][(int) y]);
	    				}
	    					
	    				s.setScene(sc1);//onoaiiaea noaiu
		    			s.show();//caione noaea?a
	    				}});
    				bribery.setOnAction(m->{
    					if(B_COUNT==0&&money>Integer.parseInt(bcost.getText().replace("$",""))&&bstatus[(int) x][(int) y] ==0){
	    				String ss1  = acost.getText().replace("$", "");
    					int a= (int)(Math.random()*100+1);
    					money = money - Integer.parseInt(bcost.getText().replace("$",""));
    					moneyl.setText(""+money);
    					if(a<Integer.parseInt(bchance.getText().replace("%", ""))){
    						py.setImage(win);
    					String f = bprofit.getText().replace("%", "");
    					f = f.replace("+", "");
    						prog[(int) x][(int) y] += Double.parseDouble(f)/100;
    						tprogress.setProgress(prog[(int) x][(int) y]);
    						bstatus[(int) x][(int) y] = 1;
    					}
    					else{
    						py.setImage(lose);	
    						bstatus[(int) x][(int) y] = 2;
    					}
    					
	    				B_COUNT=1;
	    				s.setScene(sc1);//onoaiiaea noaiu
		    			s.show();//caione noaea?a
    					}	
    				});//
    				
    				
    				bribery.setDisable(false);
	    			}
	    			tprogress.setProgress(prog[(int) x][(int) y]);
	    			tprogress.setVisible(true);
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
	    			nres.setText("66");//66
	    			cran1.setVisible(true);
	    			exc.setVisible(true);
	    			acost.setText("1000$/turn");
	    			aprofit.setText("+10%/turn");
	    			bcost.setText("2000$");
	    			bchance.setText("70%");
	    			bprofit.setText("+25%");
	    			
	    			}
	    			if(map[(int) x][(int) y]==2){
	    				tcost.setText("500");
	    				profit.setText("4550$/turn");
	    				nres.setText("66");//60
	    				cran1.setVisible(true);
	    				conc.setVisible(true);
	    				acost.setText("1000$/turn");
		    			aprofit.setText("+10%/turn");
		    			bcost.setText("2000$");
		    			bchance.setText("70%");
		    			bprofit.setText("+25%");
	    			}
	    			if(map[(int) x][(int) y]==3){
	    				tcost.setText("132");
	    				profit.setText("7650$/turn");
	    				nres.setText("120");//120
	    				cran1.setVisible(true);
	    				conc.setVisible(true);
	    				exc.setVisible(true);
	    				acost.setText("1500$/turn");
		    			aprofit.setText("+15%/turn");
		    			bcost.setText("4000$");
		    			bchance.setText("60%");
		    			bprofit.setText("+28%");
	    			}
	    			if(map[(int) x][(int) y]==4){
	    				tcost.setText("138");
	    				profit.setText("7600$/turn");
	    				nres.setText("120");//1000
	    				cran2.setVisible(true);
		    			exc.setVisible(true);
		    			helic.setVisible(true);
		    			acost.setText("1500$/turn");
		    			aprofit.setText("+15%/turn");
		    			bcost.setText("4000$");
		    			bchance.setText("60%");
		    			bprofit.setText("+29%");
	    			}
	    			if(map[(int) x][(int) y]==5){
	    				tcost.setText("250");
	    				profit.setText("14000$/turn");
	    				nres.setText("276");//276
	    				cran2.setVisible(true);
		    			exc.setVisible(true);
		    			helic.setVisible(true);
		    			lorry.setVisible(true);
		    			conc.setVisible(true);
		    			acost.setText("2900$/turn");
		    			aprofit.setText("+15%/turn");
		    			bcost.setText("8000$");
		    			bchance.setText("45%");
		    			bprofit.setText("+20%");
	    			}
	    			if(status[(int) x][(int) y]==0){
	    				owner.setVisible(true);
	    				owner.setText("Not Defined");
	    			}
	    			closeim.setDisable(false);
	    			closeim.setOnAction(cl->{
	    				a1.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
	    				if(status[(int) x][(int) y]==3){
	        				py.setVisible(false);
	        				adv.setDisable(true);
	        				bribery.setDisable(true);	
	    				}
	    	    			tprogress.setVisible(false);
	    	    			participate.setDisable(true);
	    	    			cityinfo.setVisible(false);
		    			lpanel.setVisible(true);
		    			oType.setLayoutY(665);
		    			name.setLayoutY(680);
		    			description.setLayoutY(680);
		    			tcost.setVisible(false);
		    			profit.setVisible(false);
		    			nres.setVisible(false);
		    			py.setVisible(false);
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
		    			for(int i = 0;i<circles.size();i++){
			    			Circle s = circles.get(i);
			    			s.setOpacity(1);
			    			
			    		}
		    			if(status[(int) x][(int) y]==0||status[(int) x][(int) y]==3){
		    				owner.setText("Not Defined");
		    				owner.setVisible(false);
		    				
		    			}
	    			});//
	    			
	    			s.setScene(sc1);//onoaiiaea noaiu
	    			s.show();//caione noaea?a
	    			
	    		}	
	    		if(oType.getImage()==o){
	    			buyq.setOnAction(ha->{
	    				if(nextTurn.isDisable()==false){
	    				if(MOVE_C==0&&status[(int) x][(int) y]==0){
	    				char l = level.getText().charAt(0);	
	    			String l2 = ""+l;
	    			int ll = Integer.parseInt(l2);
	    			System.out.println(ll);
	    			if(ll==1&&money>8000&&status[(int) x][(int) y]==0){
	    				if(nextTurn.isDisable()==false){
	    					listp.add(1);
	    					m1++;
	    					LOSS = LOSS+300;
	    				QPROFIT = QPROFIT+6;
	    				System.out.println("bp");
	    				money = money-8000;
	    				moneyl.setText(""+money);
	    				double dwinp = money/1000000.0;
	    				winp.setProgress(dwinp);
	    				status[(int) x][(int) y]=1;
	    				if(status[(int) x][(int) y]==0){
		    				owner.setVisible(true);
		    			
		    				owner.setText("Not Defined");
		    				s.setScene(sc1);//onoaiiaea noaiu
			    			s.show();//caione noaea?a
		    			}
		    			if(status[(int) x][(int) y]==1){
		    				owner.setVisible(true);
		    				owner.setText("Yours");
		    				s.setScene(sc1);//onoaiiaea noaiu
			    			s.show();//caione noaea?a
		    			}
		    			if(status[(int) x][(int) y]==2){
		    				owner.setText("Your Enemy");
		    				owner.setVisible(true);
		    				
		    			}
		    			for(int i=0;i<12;i++){
	 	           			for(int j = 0;j<6;j++){
	 	           			if(status[i][j]==1){
	 	           				Circle c = new Circle();
	 	           				c.setRadius(5);
	 	           				c.setCenterX(155+67*i);
	 	           				c.setCenterY(86+95*j);
	 	           			c.setFill(Color.GREEN);
	 	           		System.out.println("circle");
	 	           			a1.getChildren().add(c);
	 	           		circles.add(c);
	 	           			}//revolution	
	 	           		if(status[i][j]==2){
	 	           		Circle c2 = new Circle();
	           				c2.setRadius(5);
	           				c2.setCenterX(155+67*i);
	           				c2.setCenterY(86+95*j);
	           			c2.setFill(Color.RED);
	           		System.out.println("circle2");
	           			a1.getChildren().add(c2);	
	           			circles.add(c2);
 	           				
 	           			}	
	 	           				
	 	           				
	 	           				
	 	           			}
	 	           			
	 	            		}//
		    			 for(int i = 0;i<circles.size();i++){
		 	    			Circle ss = circles.get(i);
		 	    			ss.setOpacity(0);
		 	    			
		 	    		}
		    			s.setScene(sc1);//onoaiiaea noaiu
		    			s.show();//caione noaea?a
	    			}}
	    				
	    				
	    			if(ll==2&&money>16000&&status[(int) x][(int) y]==0){
	    				if(nextTurn.isDisable()==false){
	    					listp.add(2);
	    					y1++;
	    					System.out.println("bp");
	    				LOSS = LOSS+300;
	    				QPROFIT = QPROFIT+12;
	    				money = money-16000;
	    				double dwinp = money/1000000.0;
	    				winp.setProgress(dwinp);
	    				moneyl.setText(""+money);
	    				status[(int) x][(int) y]=1;
	    				if(status[(int) x][(int) y]==0){
		    				owner.setVisible(true);
		    			
		    				owner.setText("Not Defined");
		    				s.setScene(sc1);//onoaiiaea noaiu
			    			s.show();//caione noaea?a
		    			}
		    			if(status[(int) x][(int) y]==1){
		    				owner.setVisible(true);
		    				owner.setText("Yours");
		    				s.setScene(sc1);//onoaiiaea noaiu
			    			s.show();//caione noaea?a
		    			}
		    			if(status[(int) x][(int) y]==2){
		    				owner.setText("Your Enemy");
		    				owner.setVisible(true);
		    				
		    			}
		    			for(int i=0;i<12;i++){
	 	           			for(int j = 0;j<6;j++){
	 	           			if(status[i][j]==1){
	 	           				Circle c = new Circle();
	 	           				c.setRadius(5);
	 	           				c.setCenterX(155+67*i);
	 	           				c.setCenterY(86+95*j);
	 	           			c.setFill(Color.GREEN);
	 	           		System.out.println("circle");
	 	           			a1.getChildren().add(c);
	 	           		circles.add(c);
	 	           			}//revolution	
	 	           		if(status[i][j]==2){
	 	           		Circle c2 = new Circle();
	           				c2.setRadius(5);
	           				c2.setCenterX(155+67*i);
	           				c2.setCenterY(86+95*j);
	           			c2.setFill(Color.RED);
	           		System.out.println("circle2");
	           			a1.getChildren().add(c2);	
	           			circles.add(c2);
 	           				
 	           			}	
	 	           				
	 	           				
	 	           				
	 	           			}
	 	           			
	 	            		}//
		    			 for(int i = 0;i<circles.size();i++){
		 	    			Circle ss = circles.get(i);
		 	    			ss.setOpacity(0);
		 	    			
		 	    		}
		    			s.setScene(sc1);//onoaiiaea noaiu
		    			s.show();//caione noaea?a
	    				}
	    				
	    			}	
	    			if(ll==3&&money>32000&&status[(int) x][(int) y]==0){
	    				if(nextTurn.isDisable()==false){
	    					listp.add(3);
	    					j1++;
	    					System.out.println("bp");
	    				LOSS = LOSS+300;
	    				QPROFIT = QPROFIT+24;
	    				money = money-32000;
	    				double dwinp = money/1000000.0;
	    				winp.setProgress(dwinp);
	    				moneyl.setText(""+money);
	    				status[(int) x][(int) y]=1;
	    				if(status[(int) x][(int) y]==0){
		    				owner.setVisible(true);
		    			
		    				owner.setText("Not Defined");
		    				s.setScene(sc1);//onoaiiaea noaiu
			    			s.show();//caione noaea?a
		    			}
		    			if(status[(int) x][(int) y]==1){
		    				owner.setVisible(true);
		    				owner.setText("Yours");
		    				s.setScene(sc1);//onoaiiaea noaiu
			    			s.show();//caione noaea?a
		    			}
		    			if(status[(int) x][(int) y]==2){
		    				owner.setText("Your Enemy");
		    				owner.setVisible(true);
		    				
		    			}
		    			for(int i=0;i<12;i++){
	 	           			for(int j = 0;j<6;j++){
	 	           			if(status[i][j]==1){
	 	           				Circle c = new Circle();
	 	           				c.setRadius(5);
	 	           				c.setCenterX(155+67*i);
	 	           				c.setCenterY(86+95*j);
	 	           			c.setFill(Color.GREEN);
	 	           		System.out.println("circle");
	 	           			a1.getChildren().add(c);
	 	           		circles.add(c);
	 	           			}//revolution	
	 	           		if(status[i][j]==2){
	 	           		Circle c2 = new Circle();
	           				c2.setRadius(5);
	           				c2.setCenterX(155+67*i);
	           				c2.setCenterY(86+95*j);
	           			c2.setFill(Color.RED);
	           		System.out.println("circle2");
	           			a1.getChildren().add(c2);	
	           			circles.add(c2);
 	           				
 	           			}	
	 	           				
	 	           				
	 	           				
	 	           			}
	 	           			
	 	            		}//
		    			 for(int i = 0;i<circles.size();i++){
		 	    			Circle ss = circles.get(i);
		 	    			ss.setOpacity(0);
		 	    			
		 	    		}
		    			s.setScene(sc1);//onoaiiaea noaiu
		    			s.show();//caione noaea?a
	    				}
	    				
	    			}	
	    			if(ll==4&&money>64000&&status[(int) x][(int) y]==0){
	    				  listp.add(4);
	    				  k1++;
	    					System.out.println("bp");
	    				LOSS = LOSS+300;
	    				QPROFIT = QPROFIT+48;
	    				money = money-64000;
	    				double dwinp = money/1000000.0;
	    				winp.setProgress(dwinp);
	    				moneyl.setText(""+money);
	    				status[(int) x][(int) y]=1;
	    				if(status[(int) x][(int) y]==0){
		    				owner.setVisible(true);
		    			
		    				owner.setText("Not Defined");
		    				s.setScene(sc1);//onoaiiaea noaiu
			    			s.show();//caione noaea?a
		    			}
		    			if(status[(int) x][(int) y]==1){
		    				owner.setVisible(true);
		    				owner.setText("Yours");
		    				s.setScene(sc1);//onoaiiaea noaiu
			    			s.show();//caione noaea?a
		    			}
		    			if(status[(int) x][(int) y]==2){
		    				owner.setText("Your Enemy");
		    				owner.setVisible(true);
		    				
		    			}
		    			if(nextTurn.isDisable()==false){
	    					for(int i=0;i<12;i++){
		 	           			for(int j = 0;j<6;j++){
		 	           			if(status[i][j]==1){
		 	           				Circle c = new Circle();
		 	           				c.setRadius(5);
		 	           				c.setCenterX(155+67*i);
		 	           				c.setCenterY(86+95*j);
		 	           			c.setFill(Color.GREEN);
		 	           		System.out.println("circle");
		 	           			a1.getChildren().add(c);
		 	           		circles.add(c);
		 	           			}//revolution	
		 	           		if(status[i][j]==2){
		 	           		Circle c2 = new Circle();
		           				c2.setRadius(5);
		           				c2.setCenterX(155+67*i);
		           				c2.setCenterY(86+95*j);
		           			c2.setFill(Color.RED);
		           		System.out.println("circle2");
		           			a1.getChildren().add(c2);	
		           			circles.add(c2);
	 	           				
	 	           			}	
		 	           				
		 	           				
		 	           				
		 	           			}
		 	           			
		 	            		}//
	    					 for(int i = 0;i<circles.size();i++){
	    			    			Circle ss = circles.get(i);
	    			    			ss.setOpacity(0);
	    			    			
	    			    		}
	    					s.setScene(sc1);//onoaiiaea noaiu
		    			s.show();//caione noaea?a
	    			}
	    			}	
	    			MOVE_C=1;
	    			
	    			}}
	    				
	    				
	    			});//
	    			System.out.println("lol");
	    			if(status[(int) x][(int) y]==0){
	    				owner.setVisible(true);
	    			
	    				owner.setText("Not Defined");
	    				s.setScene(sc1);//onoaiiaea noaiu
		    			s.show();//caione noaea?a
	    			}
	    			if(status[(int) x][(int) y]==1){
	    				owner.setVisible(true);
	    				owner.setText("Yours");
	    				s.setScene(sc1);//onoaiiaea noaiu
		    			s.show();//caione noaea?a
	    			}
	    			
	    			if(status[(int) x][(int) y]==2){
	    				owner.setText("Your Enemy");
	    				owner.setVisible(true);
	    				
	    			}
	    			qinfo.setVisible(true);
	    			cpt.setVisible(true);
	    			qcost.setVisible(true);
	    			salary.setVisible(true);
	    			lpanel.setVisible(false);
	    			buyq.setDisable(false);
	    			
	    			oType.setLayoutY(155);
	    			name.setLayoutY(170);
	    			level.setLayoutY(250);
	    			description.setLayoutY(170);
	    			
	    			closeim.setDisable(false);
	    			closeim.setOnAction(cl->{
	    				a1.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
	    				qinfo.setVisible(false);
		    			lpanel.setVisible(true);
		    			buyq.setDisable(true);
		    			
		    			oType.setLayoutY(665);
		    			name.setLayoutY(680);
		    			owner.setVisible(false);
		    			level.setLayoutY(735);
		    			cpt.setVisible(false);	
		    			description.setLayoutY(680);
		    			salary.setVisible(false);
		    			qcost.setVisible(false);
		    			for(int i = 0;i<circles.size();i++){
			    			Circle s = circles.get(i);
			    			s.setOpacity(1);
			    			
			    		}
	    			});
	    			
	    			s.setScene(sc1);//onoaiiaea noaiu
	    			s.show();//caione noaea?a
	    			
	    		}	
	    		if(oType.getImage()==r){
	    			
	    			buyq.setOnAction(ha->{
	    				System.out.println("status"+status[(int) x][(int) y]);
	    				if(nextTurn.isDisable()==false){
	    				if(MOVE_C==0&&status[(int) x][(int) y]==0){
		    				char l = level.getText().charAt(0);	
		    			String l2 = ""+l;
		    			int ll = Integer.parseInt(l2);
		    			System.out.println(ll);
		    			if(ll==1&&money>12000&&status[(int) x][(int) y]==0){
		    				if(nextTurn.isDisable()==false){
		    					listp.add(5);
		    					m2++;
		    					LOSS = LOSS+450;
		    				
		    				System.out.println("bp");
		    				money = money-12000;
		    				moneyl.setText(""+money);
		    				double dwinp = money/1000000.0;
		    				winp.setProgress(dwinp);
		    				status[(int) x][(int) y]=1;
		    				if(status[(int) x][(int) y]==0){
			    				owner.setVisible(true);
			    			
			    				owner.setText("Not Defined");
			    				s.setScene(sc1);//onoaiiaea noaiu
				    			s.show();//caione noaea?a
			    			}
			    			if(status[(int) x][(int) y]==1){
			    				owner.setVisible(true);
			    				owner.setText("Yours");
			    				s.setScene(sc1);//onoaiiaea noaiu
				    			s.show();//caione noaea?a
			    			}
			    			if(status[(int) x][(int) y]==2){
			    				owner.setText("Your Enemy");
			    				owner.setVisible(true);
			    				
			    			}
			    			for(int i=0;i<12;i++){
		 	           			for(int j = 0;j<6;j++){
		 	           			if(status[i][j]==1){
		 	           				Circle c = new Circle();
		 	           				c.setRadius(5);
		 	           				c.setCenterX(155+67*i);
		 	           				c.setCenterY(86+95*j);
		 	           			c.setFill(Color.GREEN);
		 	           		System.out.println("circle");
		 	           			a1.getChildren().add(c);
		 	           		circles.add(c);
		 	           			}//revolution	
		 	           		if(status[i][j]==2){
		 	           		Circle c2 = new Circle();
		           				c2.setRadius(5);
		           				c2.setCenterX(155+67*i);
		           				c2.setCenterY(86+95*j);
		           			c2.setFill(Color.RED);
		           		System.out.println("circle2");
		           			a1.getChildren().add(c2);	
		           			circles.add(c2);
	 	           				
	 	           			}	
		 	           				
		 	           				
		 	           				
		 	           			}
		 	           			
		 	            		}//
			    			 for(int i = 0;i<circles.size();i++){
			 	    			Circle ss = circles.get(i);
			 	    			ss.setOpacity(0);
			 	    			
			 	    		}
			    			s.setScene(sc1);//onoaiiaea noaiu
			    			s.show();//caione noaea?a
		    			}}
		    				
		    				
		    			if(ll==2&&money>24000&&status[(int) x][(int) y]==0){
		    				if(nextTurn.isDisable()==false){
		    				listp.add(6);
		    				y2++;
		    					System.out.println("bp");
		    				
		    				LOSS = LOSS+900;
		    				
		    				money = money-24000;
		    				double dwinp = money/1000000.0;
		    				winp.setProgress(dwinp);
		    				moneyl.setText(""+money);
		    				status[(int) x][(int) y]=1;
		    				if(status[(int) x][(int) y]==0){
			    				owner.setVisible(true);
			    			
			    				owner.setText("Not Defined");
			    				s.setScene(sc1);//onoaiiaea noaiu
				    			s.show();//caione noaea?a
			    			}
			    			if(status[(int) x][(int) y]==1){
			    				owner.setVisible(true);
			    				owner.setText("Yours");
			    				s.setScene(sc1);//onoaiiaea noaiu
				    			s.show();//caione noaea?a
			    			}
			    			if(status[(int) x][(int) y]==2){
			    				owner.setText("Your Enemy");
			    				owner.setVisible(true);
			    				
			    			}
			    			for(int i=0;i<12;i++){
		 	           			for(int j = 0;j<6;j++){
		 	           			if(status[i][j]==1){
		 	           				Circle c = new Circle();
		 	           				c.setRadius(5);
		 	           				c.setCenterX(155+67*i);
		 	           				c.setCenterY(86+95*j);
		 	           			c.setFill(Color.GREEN);
		 	           		System.out.println("circle");
		 	           			a1.getChildren().add(c);
		 	           		circles.add(c);
		 	           			}//revolution	
		 	           		if(status[i][j]==2){
		 	           		Circle c2 = new Circle();
		           				c2.setRadius(5);
		           				c2.setCenterX(155+67*i);
		           				c2.setCenterY(86+95*j);
		           			c2.setFill(Color.RED);
		           		System.out.println("circle2");
		           			a1.getChildren().add(c2);	
		           			circles.add(c2);
	 	           				
	 	           			}	
		 	           				
		 	           				
		 	           				
		 	           			}
		 	           			
		 	            		}//
			    			 for(int i = 0;i<circles.size();i++){
			 	    			Circle ss = circles.get(i);
			 	    			ss.setOpacity(0);
			 	    			
			 	    		}
			    			s.setScene(sc1);//onoaiiaea noaiu
			    			s.show();//caione noaea?a
		    				
		    				
		    			}}	
		    			if(ll==3&&money>48000&&status[(int) x][(int) y]==0){
		    				if(nextTurn.isDisable()==false){
		    					listp.add(7);
		    					j2++;
		    					System.out.println("bp");
		    				LOSS = LOSS+1800;
		    				
		    				money = money-48000;
		    				double dwinp = money/1000000.0;
		    				winp.setProgress(dwinp);
		    				moneyl.setText(""+money);
		    				status[(int) x][(int) y]=1;
		    				if(status[(int) x][(int) y]==0){
			    				owner.setVisible(true);
			    			
			    				owner.setText("Not Defined");
			    				s.setScene(sc1);//onoaiiaea noaiu
				    			s.show();//caione noaea?a
			    			}
			    			if(status[(int) x][(int) y]==1){
			    				owner.setVisible(true);
			    				owner.setText("Yours");
			    				s.setScene(sc1);//onoaiiaea noaiu
				    			s.show();//caione noaea?a
			    			}
			    			if(status[(int) x][(int) y]==2){
			    				owner.setText("Your Enemy");
			    				owner.setVisible(true);
			    				
			    			}
			    			for(int i=0;i<12;i++){
		 	           			for(int j = 0;j<6;j++){
		 	           			if(status[i][j]==1){
		 	           				Circle c = new Circle();
		 	           				c.setRadius(5);
		 	           				c.setCenterX(155+67*i);
		 	           				c.setCenterY(86+95*j);
		 	           			c.setFill(Color.GREEN);
		 	           		System.out.println("circle");
		 	           			a1.getChildren().add(c);
		 	           		circles.add(c);
		 	           			}//revolution	
		 	           		if(status[i][j]==2){
		 	           		Circle c2 = new Circle();
		           				c2.setRadius(5);
		           				c2.setCenterX(155+67*i);
		           				c2.setCenterY(86+95*j);
		           			c2.setFill(Color.RED);
		           		System.out.println("circle2");
		           			a1.getChildren().add(c2);	
		           			circles.add(c2);
	 	           				
	 	           			}	
		 	           				
		 	           				
		 	           				
		 	           			}
		 	           			
		 	            		}//
			    			 for(int i = 0;i<circles.size();i++){
			 	    			Circle ss = circles.get(i);
			 	    			ss.setOpacity(0);
			 	    			
			 	    		}
			    			s.setScene(sc1);//onoaiiaea noaiu
			    			s.show();//caione noaea?a
		    				}
		    				
		    			}	
		    			if(ll==4&&money>96000&&status[(int) x][(int) y]==0){
		    				if(nextTurn.isDisable()==false){
		    					listp.add(8);
		    					k2++;
		    					System.out.println("bp");
		    				LOSS = LOSS+3600;
		    				
		    				money = money-96000;
		    				double dwinp = money/1000000.0;
		    				winp.setProgress(dwinp);
		    				moneyl.setText(""+money);
		    				status[(int) x][(int) y]=1;
		    				if(status[(int) x][(int) y]==0){
			    				owner.setVisible(true);
			    			
			    				owner.setText("Not Defined");
			    				s.setScene(sc1);//onoaiiaea noaiu
				    			s.show();//caione noaea?a
			    			}
			    			if(status[(int) x][(int) y]==1){
			    				owner.setVisible(true);
			    				owner.setText("Yours");
			    				s.setScene(sc1);//onoaiiaea noaiu
				    			s.show();//caione noaea?a
			    			}
			    			if(status[(int) x][(int) y]==2){
			    				owner.setText("Your Enemy");
			    				owner.setVisible(true);
			    				
			    			}
			    			for(int i=0;i<12;i++){
		 	           			for(int j = 0;j<6;j++){
		 	           			if(status[i][j]==1){
		 	           				Circle c = new Circle();
		 	           				c.setRadius(5);
		 	           				c.setCenterX(155+67*i);
		 	           				c.setCenterY(86+95*j);
		 	           			c.setFill(Color.GREEN);
		 	           		System.out.println("circle");
		 	           			a1.getChildren().add(c);
		 	           		circles.add(c);
		 	           			}//revolution	
		 	           		if(status[i][j]==2){
		 	           		Circle c2 = new Circle();
		           				c2.setRadius(5);
		           				c2.setCenterX(155+67*i);
		           				c2.setCenterY(86+95*j);
		           			c2.setFill(Color.RED);
		           		System.out.println("circle2");
		           			a1.getChildren().add(c2);	
		           			circles.add(c2);
	 	           				
	 	           			}	
		 	           				
		 	           				
		 	           				
		 	           			}
		 	           			
		 	            		}//
			    			 for(int i = 0;i<circles.size();i++){
			 	    			Circle ss = circles.get(i);
			 	    			ss.setOpacity(0);
			 	    			
			 	    		}
			    			s.setScene(sc1);//onoaiiaea noaiu
			    			s.show();//caione noaea?a
		    			
		    				}
		    			}	
		    			MOVE_C=1;
		    			}
		    			}
		    				
		    				
		    			});//
	    			
	    			
	    			
	    			
	    			char l = level.getText().charAt(0);	
	    			String l2 = ""+l;
	    			int ll2 = Integer.parseInt(l2);
	    			System.out.println("lol");
	    			finfo.setVisible(true);
	    			lpanel.setVisible(false);
	    			oType.setLayoutY(155);
	    			er.setVisible(true);
	    			name.setLayoutY(170);
	    			buyq.setDisable(false);
	    			level.setLayoutY(250);
	    			description.setLayoutY(170);
	    			use.setDisable(false);
	    			er.setDisable(false);
	    			owner.setVisible(true);
	    			
	    			///
	    			
	    			cpt.setVisible(true);
	    			qcost.setVisible(true);
	    			salary.setVisible(true);
	    			
	    			buyq.setDisable(false);
	    			
	    			oType.setLayoutY(155);
	    			name.setLayoutY(170);
	    			level.setLayoutY(250);
	    			description.setLayoutY(170);
	    			
	    			use.setOnAction(clicked->{
	    				
	    				if(nextTurn.isDisable()==false&&status[(int) x][(int) y]==1){
	    					eres = Integer.parseInt(er.getText());
	    					System.out.println("pressed+"+"//"+eres+"/"+er.getText());
	    					if(ll2==1&&eres<=9&&ore>=eres&&(9-usr[(int) x][(int) y])>eres){
	    						System.out.println("pressed2");
	    						ore  =ore- eres;
	    						usr[(int) x][(int) y]+=eres;
	    						RES = RES+eres;
	    					orel.setText(""+ore);
	    					
	    				}
	    				if(ll2==2&&eres<=18&&ore>=eres&&(18-usr[(int) x][(int) y])>eres){
	    					ore  =ore-  eres;
	    					RES = RES+eres;
		    				orel.setText(""+ore);	
		    				usr[(int) x][(int) y]+=eres;
		    				}
	    				if(ll2==3&&eres<=36&&ore>=eres&&(36-usr[(int) x][(int) y])>eres){
	    					ore  =ore-  eres;
	    					RES = RES+eres;
		    				orel.setText(""+ore);
		    				usr[(int) x][(int) y]+=eres;	
		    				}
	    				if(ll2==4&&eres<=72&&ore>=eres&&(72-usr[(int) x][(int) y])>eres){
	    					ore  =ore- eres;
	    					RES = RES+eres;
		    				orel.setText(""+ore);	
		    				usr[(int) x][(int) y]+=eres;	
		    				}
	    				
	    				
	    				
	    				}});
	    			
	    			
	    			
	    			if(status[(int) x][(int) y]==0){
	    				owner.setText("Not Defined");
	    				owner.setVisible(true);
	    				
	    			}
	    			
	    			if(status[(int) x][(int) y]==1){
	    				owner.setText("Yours");
	    				owner.setVisible(true);
	    				
	    			}
	    			if(status[(int) x][(int) y]==2){
	    				owner.setText("Your Enemy");
	    				owner.setVisible(true);
	    				
	    			}closeim.setDisable(false);
	    			closeim.setOnAction(cl->{
	    				a1.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
	    				er.setDisable(true);
	    				use.setDisable(true);
	    				er.setVisible(false);
	    				finfo.setVisible(false);
		    			lpanel.setVisible(true);
		    			oType.setLayoutY(665);
		    			name.setLayoutY(680);
		    			buyq.setDisable(true);
		    			level.setLayoutY(735);
		    			description.setLayoutY(680);
		    			owner.setVisible(false);
		    			lpanel.setVisible(true);
		    			buyq.setDisable(true);
		    			
		    			oType.setLayoutY(665);
		    			name.setLayoutY(680);
		    			owner.setVisible(false);
		    			level.setLayoutY(735);
		    			cpt.setVisible(false);	
		    			description.setLayoutY(680);
		    			salary.setVisible(false);
		    			qcost.setVisible(false);
		    			
		    			
		    			
		    			for(int i = 0;i<circles.size();i++){
			    			Circle s = circles.get(i);
			    			s.setOpacity(1);
			    			
			    		}
		    			
	    			});
	    			
	    			s.setScene(sc1);//onoaiiaea noaiu
	    			s.show();//caione noaea?a
	    			
	    			
	    		}});
	    		infomenu.setDisable(false);
	    		
	    		
		    	event.consume();
		    }
	    		}
		};
		
		a1.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		
		
		
	s.setFullScreen(true);//ooeene?ei
	s.setScene(sc1);//onoaiiaea noaiu
	s.show();//caione noaea?a
	mSecondThread = new AffableThread();	//Nicaaiea iioiea
	mSecondThread.start();	
	try {
		
		for(int i = 0;i<12;i++){
			for(int j = 0;j<6;j++){
				pmass = pmass+status[i][j];
				
				
			}
		}
		socketWriter.write(pmass);
		socketWriter.write("\n"); //aiaaaeyai "iiai? no?ieo", aaau readLine() na?aa?a n?aaioae
        socketWriter.flush(); // ioi?aaeyai
	pmass = "";	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} //ieoai no?ieo iieuciaaoaey
	System.out.println(lin2e);
	
    }

	
  
   

	
	
	public static void main(String[] args) throws Exception {
		
   
		
		  
		
	launch(args);
		
	}
public void updateUi(Stage s){
	s.show();
}
	 private class Receiver implements Runnable{
	   
		 /**
	         * run() auciaaony iinea caionea ieoe ec eiino?oeoi?a eeeaioa ?aoa.
	         */
	        public void run() {
	            while (!so.isClosed()) { //noiao i?iaa?yai eiiiaeo.
	                
	                try {
	                    line = socketReader.readLine(); // i?iaoai i?i?anou
	               
	                    
	                    if(tid==0){
	                    String[]parts = line.split("/");
	               tt = parts[1];
	               if(TURN_ID.equals("")){
	            	   TURN_ID = tt;
	            	   
	               }
	               if(TURN_ID.equals("1")){
	            	   TURN_ID = "1";
	            	   
	               }
	               tid=1;
	               } 
	                 if(TURN_ID.equals("2")){
	                	 Platform.runLater(() -> {
	                	 nextTurn.setDisable(true);   
	                eb.setImage(bb2);});
	                 }
	                    System.out.println("Turnid2"+TURN_ID);
	                    String[]parts = line.split("/");
	 	               tt = parts[1];
	 	             fmass = parts[0];
	 	               System.out.println(":"+tt+"/"+TURN_ID);
	 	              System.out.println("fmass "+fmass);
	 	               int smass[] = new int[72];
	 	              
	 	               for(int i=0;i<72;i++){
	 	            	  char ch = fmass.charAt(i);
	 	            	  String mch = ""+ch;
	 	            	   smass[i]=Integer.parseInt(mch) ;
	 	            	   
	 	               }
	 	               
	 	              if(TURN_ID.equals("1")){
	 	            	  if(tt.equals("2")){
	 	            		 for(int j=0;j<12;j++){ 
	 		 	            	 for(int k = 0;k<6;k++){ 
	 		 	            	 status[j][k]=smass[h]; 
	 		 	            	 if(status[j][k]==1){ 
	 		 	            	 status[j][k]=2; 
	 		 	            	 } 

	 		 	            	 else if(status[j][k]==2){ 
	 		 	            		status[j][k]=1; 

	 		 	            	 } 
	 		 	            	else if(status[j][k]==3){
	 		 	            		status[j][k]=4; 	 
	 		 	            	 }
	 		 	            	
	 		 	            	 h++; 
	 		 	            	
	 		 	            	 } }
	 		 	           h=0;
	 		 	               
	 		 	           String ststring = "";
	 		 	           for(int i = 0;i<12;i++){
	 		 	        	   for(int j = 0;j<6;j++){
	 		 	        		   ststring+=status[i][j];
	 		 	        		   
	 		 	        		   
	 		 	        	   }
	 		 	           }
	 		 	           System.out.println("status"+ststring);
	 		 	         ststring = "";  
	 	            	  }
	 	              }
	 	             if(TURN_ID.equals("2")){
	 	            	  if(tt.equals("1")){
	 	            		 for(int j=0;j<12;j++){ 
	 		 	            	 for(int k = 0;k<6;k++){ 
	 		 	            	 status[j][k]=smass[h]; 
	 		 	            	 if(status[j][k]==1){ 
	 		 	            	 status[j][k]=2; 
	 		 	            	 } 

	 		 	            	 else if(status[j][k]==2){ 
	 		 	            		status[j][k]=1; 

	 		 	            	 } 
	 		 	            	
	 		 	            	else if(status[j][k]==3){
	 		 	            		status[j][k]=4; 	 
	 		 	            	 }
	 		 	            	else if(status[j][k]==10){
	 		 	            		a1.removeEventHandler(MouseEvent.MOUSE_CLICKED, handler);
	 	 	            			winl.setImage(wini);
	 	 	            		winl.setOpacity(1); 
	 		 	            	 }
	 		 	            	
	 		 	            	 
	 		 	            	 
	 		 	            	 h++; 
	 		 	            	
	 		 	            	 } }
	 		 	           h=0;
	 		 	               
	 		 	           String ststring = "";
	 		 	           for(int i = 0;i<12;i++){
	 		 	        	   for(int j = 0;j<6;j++){
	 		 	        		   ststring+=status[i][j];
	 		 	        		   
	 		 	        		   
	 		 	        	   }
	 		 	           }
	 		 	           System.out.println("status"+ststring);
	 		 	         ststring = "";  
	 	            	  }
	 	              }
	 	           
	 	               if(TURN_ID.equals("1")){
	 	            	  System.out.println("+"+tt);
	 	            	
	 	            	  if(tt.equals("2")){
	 	            		
	 	            		  
	 	            		
	 	            		  for(int i = 0;i<12;i++){
	 	 	        			for(int j = 0;j<6;j++){
	 	 	        				
	 	 	        				usr[i][j]=0;
	 	 	        			}
	 	 	        			
	 	 	        		}	
	 	            		  System.out.println("+++++++");
	 	            		  Platform.runLater(() -> {
	 	            			
	 	            			 if(money<=0){
	 	 	            			a1.removeEventHandler(MouseEvent.MOUSE_CLICKED, handler);
	 	 	            			winl.setImage(losei);
	 	 	            		winl.setOpacity(1);
	 	 	            		try {
									status[0][0]=10;
	 	 	            			socketWriter.write(pmass+"/2");
									socketWriter.write("\n"); //aiaaaeyai "iiai? no?ieo", aaau readLine() na?aa?a n?aaioae
		 	 				        socketWriter.flush(); // ioi?aaeyai
	 	 	            		} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
	 	 						
	 	 	            		}  
	 	 	            		  
	 	            			  System.out.println("+++++++");
	 	            			  nextTurn.setDisable(false);    
	 	            			 eb.setImage(bb);	
	 	            		 ore = ore+QPROFIT;
	 	            		 orel.setText(""+ore);
	 	            		 
	 	            		res = res+RES;
	 	            		 resl.setText(""+res); 
	 	            		RES= 0;
	 	            		T_COUNT = 0;
	 	            		A_COUNT = 0;
	 	            		B_COUNT = 0;
	 	            		money = money+TURN_P;
	 	            		moneyl.setText(""+money);
	 	            		for(int i=0;i<12;i++){
	 	           			for(int j = 0;j<6;j++){
	 	           			if(status[i][j]==1){
	 	           				Circle c = new Circle();
	 	           				c.setRadius(5);
	 	           				c.setCenterX(155+67*i);
	 	           				c.setCenterY(86+95*j);
	 	           			c.setFill(Color.GREEN);
	 	           		System.out.println("circle");
	 	           			a1.getChildren().add(c);
	 	           			circles.add(c);
	 	           			}	
	 	           		if(status[i][j]==2){
	 	           		Circle c2 = new Circle();
	           				c2.setRadius(5);
	           				c2.setCenterX(155+67*i);
	           				c2.setCenterY(86+95*j);
	           			c2.setFill(Color.RED);
	           		System.out.println("circle2");
	           			a1.getChildren().add(c2);	
	           			circles.add(c2);
 	           				
 	           			}	
	 	           	if(status[i][j]==3){
	 	           		Circle c2 = new Circle();
	           				c2.setRadius(5);
	           				c2.setCenterX(155+67*i);
	           				c2.setCenterY(86+95*j);
	           			c2.setFill(Color.ORANGE);
	           		System.out.println("circle2");
	           			a1.getChildren().add(c2);	
	           			circles.add(c2);
 	           				
 	           			}			
	 	       	if(status[i][j]==4){
 	           		Circle c2 = new Circle();
           				c2.setRadius(5);
           				c2.setCenterX(155+67*i);
           				c2.setCenterY(86+95*j);
           			c2.setFill(Color.YELLOW);
           		System.out.println("circle2");
           			a1.getChildren().add(c2);	
           			circles.add(c2);
	           				
	           			}			
	 	           				
	 	           			}
	 	           			
	 	            		}//
	 	            		  });
	 	            		
	 	            	  }
	 	               }
	 	               if(TURN_ID.equals("2")){
	 	            	  
	 	            	   if(tt.equals("1")){
	 	            		  System.out.println("+++++++");
	 	            		 for(int i = 0;i<12;i++){
	 	 	        			for(int j = 0;j<6;j++){
	 	 	        				
	 	 	        				usr[i][j]=0;
	 	 	        			}
	 	 	        			
	 	 	        		}	   
	 	            		
	 	            		
	 	            		  Platform.runLater(() -> {
	 	            			 if(money<=0){
		 	 	            			a1.removeEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		 	 	            			winl.setImage(losei);
		 	 	            		winl.setOpacity(1);
		 	 	            		try {
										status[0][0]=10;
		 	 	            			socketWriter.write(pmass+"/2");
										socketWriter.write("\n"); //aiaaaeyai "iiai? no?ieo", aaau readLine() na?aa?a n?aaioae
			 	 				        socketWriter.flush(); // ioi?aaeyai
		 	 	            		} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
		 	 						
		 	 	            		}  
	 	            			  System.out.println("+++++++");
	 	            			  nextTurn.setDisable(false);    
	 	            			 eb.setImage(bb);
	 	            			 ore = ore+QPROFIT;
		 	            		 orel.setText(""+ore);
		 	            		res = res+RES;
		 	            		 resl.setText(""+res); 
		 	            		RES= 0;
		 	            		T_COUNT = 0;
		 	            		A_COUNT = 0;
		 	            		B_COUNT = 0;
		 	            		money = money+TURN_P;
		 	            		moneyl.setText(""+money);
		 	            		
		 	            		for(int i=0;i<12;i++){
			 	           			for(int j = 0;j<6;j++){
			 	           			if(status[i][j]==1){
			 	           				Circle c = new Circle();
			 	           				c.setRadius(5);
			 	           				c.setCenterX(155+67*i);
			 	           				c.setCenterY(86+95*j);
			 	           			c.setFill(Color.GREEN);
			 	           		System.out.println("circle");
			 	           			a1.getChildren().add(c);
			 	           		circles.add(c);
			 	           			}//revolution	
			 	           		if(status[i][j]==2){
			 	           		Circle c2 = new Circle();
			           				c2.setRadius(5);
			           				c2.setCenterX(155+67*i);
			           				c2.setCenterY(86+95*j);
			           			c2.setFill(Color.RED);
			           		System.out.println("circle2");
			           			a1.getChildren().add(c2);	
			           			circles.add(c2);
		 	           				
		 	           			}	
			 	           	if(status[i][j]==3){
			 	           		Circle c2 = new Circle();
			           				c2.setRadius(5);
			           				c2.setCenterX(155+67*i);
			           				c2.setCenterY(86+95*j);
			           			c2.setFill(Color.ORANGE);
			           		System.out.println("circle2");
			           			a1.getChildren().add(c2);	
			           			circles.add(c2);
		 	           				
		 	           			}		
			 	       	if(status[i][j]==4){
		 	           		Circle c2 = new Circle();
		           				c2.setRadius(5);
		           				c2.setCenterX(155+67*i);
		           				c2.setCenterY(86+95*j);
		           			c2.setFill(Color.YELLOW);
		           		System.out.println("circle2");
		           			a1.getChildren().add(c2);	
		           			circles.add(c2);
	 	           				
	 	           			}		
			 	           				
			 	           			}
			 	           			
			 	            		}//
	 	            		  
	 	            		  });
	 	            		   
	 	            	   }
	 	               }
	 	               System.out.println("message"+line+"/"+TURN_ID);
	                    
	                } catch (IOException e) { // +anee a iiiaio ?oaiey ioeaea, oi...
	                    // i?iaa?ei, ?oi yoi ia aaiaeuiia ooaoiia cae?uoea nieaoa na?aa?ii
	                    if ("Socket closed".equals(e.getMessage())) {
	                        break;
	                    }
	                    System.out.println("Connection lost"); // a n?aa iu iiiaaai a neo?aa ioeaie naoe.
	                    close(); // io e cae?uaaai nieao (enoaoe, aucaaaony iaoia eeanna ChatClient, anou ainooi)
	                }
	                if (line == null) {  // no?iea aoaao null anee na?aa? i?ee?ue eiiiaeo ii naiae eieoeaoeaa, naou ?aaioaao
	                    System.out.println("Server has closed connection");
	                    close(); // ...cae?uaaainy
	                } else { // eia?a ia?aoaai oi, ?oi i?eneae na?aa?.
	                  //  System.out.println("Server:" + line);
	                	//System.out.println(line);
	                	lin2e += line;
	                	
	                
	                	 
	                }
	            }
	        }
	    }

	 class AffableThread extends Thread
	 {
	 	@Override
	 	public void run()	//Yoio iaoia aoaao auiieiai a iiai?iii iioiea
	 	{
	 			 		
	 		
            
		       
			 
	 	}
	 }
}