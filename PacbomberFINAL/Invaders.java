package version29;
/**
 * Curso Básico de desarrollo de Juegos en Java - Invaders
 * 
 * (c) 2004 Planetalia S.L. - Todos los derechos reservados. Prohibida su reproducción
 * 
 * http://www.planetalia.com
 * 
 */

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Invaders extends Canvas implements Stage, KeyListener {
	
	private BufferStrategy strategy;
	private long usedTime;
	
	private SpriteCache spriteCache;
	private SoundCache soundCache;
	private ArrayList actors;
	private ArrayList players; 
	private Player player;
	private MonsterPlayer m1;
	private MonsterPlayer2 m2;
	private BufferedImage background, backgroundTile;
	private int backgroundY;
	
	private boolean gameEnded=false;
	private boolean pacmanWin = false;
	
	public Invaders() {
		spriteCache = new SpriteCache();
		soundCache = new SoundCache();
		
		
		JFrame ventana = new JFrame("Invaders");
		JPanel panel = (JPanel)ventana.getContentPane();
		setBounds(0,0,Stage.WIDTH,Stage.HEIGHT);
		panel.setPreferredSize(new Dimension(Stage.WIDTH,Stage.HEIGHT));
		panel.setLayout(null);
		panel.add(this);
		ventana.setBounds(0,0,Stage.WIDTH,Stage.HEIGHT);
		ventana.setVisible(true);
		ventana.addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		ventana.setResizable(false);
		createBufferStrategy(2);
		strategy = getBufferStrategy();
		requestFocus();
		addKeyListener(this);
		
    setIgnoreRepaint(true);
    
		BufferedImage cursor = spriteCache.createCompatible(10,10,Transparency.BITMASK);
		Toolkit t = Toolkit.getDefaultToolkit();
		Cursor c = t.createCustomCursor(cursor,new Point(5,5),"null");
		setCursor(c);
	}
	
	public void gameOver() {
		gameEnded = true;
	}
	
	public void pacmanWins() {
		pacmanWin = true;
	}

	public void initWorld() {
    actors = new ArrayList();
    players = new ArrayList();
    
    Obstacle wall1, wall2, wall3, wall4, wall5, wall6, wall7, wall8, wall9, wall10,
    	wall11, wall12, wall13, wall14, wall15, wall16, wall17, wall18, wall19, 
    	wall20, wall21, wall22, wall23, wall24, wall25, wall26, wall27, wall28,
    	wall29, wall30, wall31, wall32, wall33, wall34, wall35, wall36, wall37,
    	wall38, wall39, wall40, wall41, wall42, wall43, wall44, wall45, wall46,
    	wall47, wall48, wall49, wall50, wall51, wall52, wall53, wall54, wall55, wall56;
    
    wall1 = new Obstacle(this);
    wall1.setX(30);
    wall1.setY(26);
    wall1.setWidth(736);
    wall1.setHeight(8);
    
    wall2 = new Obstacle(this);
    wall2.setX(30);
    wall2.setY(26);
    wall2.setWidth(8);
    wall2.setHeight(156);
    
    wall3 = new Obstacle(this);
    wall3.setX(758);
    wall3.setY(32);
    wall3.setWidth(8);
    wall3.setHeight(156);
    
    wall4 = new Obstacle(this);
    wall4.setX(389);
    wall4.setY(35);
    wall4.setWidth(19);
    wall4.setHeight(58);
    
    wall5 = new Obstacle(this);
    wall5.setX(97);
    wall5.setY(71);
    wall5.setWidth(67);
    wall5.setHeight(22);
    
    wall6 = new Obstacle(this);
    wall6.setX(231);
    wall6.setY(71);
    wall6.setWidth(94);
    wall6.setHeight(22);    

    wall7 = new Obstacle(this);
    wall7.setX(470);
    wall7.setY(71);
    wall7.setWidth(94);
    wall7.setHeight(22);
    
    wall8 = new Obstacle(this);
    wall8.setX(629);
    wall8.setY(71);
    wall8.setWidth(67);
    wall8.setHeight(22);    

    wall9 = new Obstacle(this);
    wall9.setX(97);
    wall9.setY(132);
    wall9.setWidth(67);
    wall9.setHeight(14);
    
    wall10 = new Obstacle(this);
    wall10.setX(630);
    wall10.setY(132);
    wall10.setWidth(67);
    wall10.setHeight(14);  
    
    wall11 = new Obstacle(this);
    wall11.setX(310);
    wall11.setY(132);
    wall11.setWidth(174);
    wall11.setHeight(14);
    
    wall12 = new Obstacle(this);
    wall12.setX(229);
    wall12.setY(132);
    wall12.setWidth(20);
    wall12.setHeight(110);
    
    wall13 = new Obstacle(this);
    wall13.setX(548);
    wall13.setY(132);
    wall13.setWidth(20);
    wall13.setHeight(110);
    
    wall14 = new Obstacle(this);
    wall14.setX(391);
    wall14.setY(150);
    wall14.setWidth(15);
    wall14.setHeight(45);    	              

    wall15 = new Obstacle(this);
    wall15.setX(253);
    wall15.setY(182);
    wall15.setWidth(72);
    wall15.setHeight(13);
    
    wall16 = new Obstacle(this);
    wall16.setX(467);
    wall16.setY(182);
    wall16.setWidth(72);
    wall16.setHeight(13);
    
    wall17 = new Obstacle(this);
    wall17.setX(35);
    wall17.setY(182);
    wall17.setWidth(131);
    wall17.setHeight(8);
    
    wall18 = new Obstacle(this);
    wall18.setX(629);
    wall18.setY(182);
    wall18.setWidth(131);
    wall18.setHeight(8);        

    wall19 = new Obstacle(this);
    wall19.setX(162);
    wall19.setY(182);
    wall19.setWidth(8);
    wall19.setHeight(65);
    
    wall20 = new Obstacle(this);
    wall20.setX(625);
    wall20.setY(182);
    wall20.setWidth(8);
    wall20.setHeight(65);    

    wall21 = new Obstacle(this);
    wall21.setX(18);
    wall21.setY(240);
    wall21.setWidth(148);
    wall21.setHeight(8);
    
    wall22 = new Obstacle(this);
    wall22.setX(628);
    wall22.setY(240);
    wall22.setWidth(148);
    wall22.setHeight(8);
    
    wall23 = new Obstacle(this);
    wall23.setX(18);
    wall23.setY(240);
    wall23.setWidth(8);
    wall23.setHeight(50);        

    wall24 = new Obstacle(this);
    wall24.setX(768);
    wall24.setY(240);
    wall24.setWidth(8);
    wall24.setHeight(50);
    
    wall25 = new Obstacle(this);
    wall25.setX(18);
    wall25.setY(281);
    wall25.setWidth(148);
    wall25.setHeight(8); 
    
    wall26 = new Obstacle(this);
    wall26.setX(627);
    wall26.setY(281);
    wall26.setWidth(148);
    wall26.setHeight(8);       

    wall27 = new Obstacle(this);
    wall27.setX(306);
    wall27.setY(232);
    wall27.setWidth(54);
    wall27.setHeight(6);
    
    wall28 = new Obstacle(this);
    wall28.setX(433);
    wall28.setY(232);
    wall28.setWidth(54);
    wall28.setHeight(6);
    
    wall29 = new Obstacle(this);
    wall29.setX(306);
    wall29.setY(232);
    wall29.setWidth(8);
    wall29.setHeight(63);
    
    wall30 = new Obstacle(this);
    wall30.setX(479);
    wall30.setY(232);
    wall30.setWidth(8);
    wall30.setHeight(63);
    
    wall31 = new Obstacle(this);
    wall31.setX(308);
    wall31.setY(289);
    wall31.setWidth(179);
    wall31.setHeight(6);
    
    wall32 = new Obstacle(this);
    wall32.setX(158);
    wall32.setY(285);
    wall32.setWidth(8);
    wall32.setHeight(59); 
    
    wall33 = new Obstacle(this);
    wall33.setX(624);
    wall33.setY(285);
    wall33.setWidth(8);
    wall33.setHeight(59);
    
    wall34 = new Obstacle(this);
    wall34.setX(226);
    wall34.setY(286);
    wall34.setWidth(22);
    wall34.setHeight(56);
    
    wall35 = new Obstacle(this);
    wall35.setX(545);
    wall35.setY(286);
    wall35.setWidth(22);
    wall35.setHeight(56);
    
    wall36 = new Obstacle(this);
    wall36.setX(309);
    wall36.setY(332);
    wall36.setWidth(175);
    wall36.setHeight(14);                               

    wall37 = new Obstacle(this);
    wall37.setX(389);
    wall37.setY(347);
    wall37.setWidth(20);
    wall37.setHeight(44);
    
    wall38 = new Obstacle(this);
    wall38.setX(26);
    wall38.setY(340);
    wall38.setWidth(136);
    wall38.setHeight(8); 
    
    wall39 = new Obstacle(this);
    wall39.setX(627);
    wall39.setY(340);
    wall39.setWidth(136);
    wall39.setHeight(8);
    
    wall40 = new Obstacle(this);
    wall40.setX(29);
    wall40.setY(340);
    wall40.setWidth(8);
    wall40.setHeight(185);
    
    wall41 = new Obstacle(this);
    wall41.setX(758);
    wall41.setY(340);
    wall41.setWidth(8);
    wall41.setHeight(185);
    
    wall42 = new Obstacle(this);
    wall42.setX(228);
    wall42.setY(384);
    wall42.setWidth(98);
    wall42.setHeight(10);
    
    wall43 = new Obstacle(this);
    wall43.setX(469);
    wall43.setY(384);
    wall43.setWidth(98);
    wall43.setHeight(10);
    
    wall44 = new Obstacle(this);
    wall44.setX(96);
    wall44.setY(384);
    wall44.setWidth(69);
    wall44.setHeight(10);
    
    wall45 = new Obstacle(this);
    wall45.setX(626);
    wall45.setY(384);
    wall45.setWidth(69);
    wall45.setHeight(10); 
    
    wall46 = new Obstacle(this);
    wall46.setX(148);
    wall46.setY(396);
    wall46.setWidth(19);
    wall46.setHeight(47);
    
    wall47 = new Obstacle(this);
    wall47.setX(628);
    wall47.setY(396);
    wall47.setWidth(19);
    wall47.setHeight(47);
    
    wall48 = new Obstacle(this);
    wall48.setX(38);
    wall48.setY(431);
    wall48.setWidth(47);
    wall48.setHeight(13);                                         

    wall49 = new Obstacle(this);
    wall49.setX(308);
    wall49.setY(431);
    wall49.setWidth(176);
    wall49.setHeight(13);
    
    wall50 = new Obstacle(this);
    wall50.setX(707);
    wall50.setY(431);
    wall50.setWidth(47);
    wall50.setHeight(13);
    
    wall51 = new Obstacle(this);
    wall51.setX(227);
    wall51.setY(435);
    wall51.setWidth(22);
    wall51.setHeight(53);
    
    wall52 = new Obstacle(this);
    wall52.setX(546);
    wall52.setY(435);
    wall52.setWidth(22);
    wall52.setHeight(53);
    
    wall53 = new Obstacle(this);
    wall53.setX(386);
    wall53.setY(445);
    wall53.setWidth(22);
    wall53.setHeight(48);
    
    wall54 = new Obstacle(this);
    wall54.setX(96);
    wall54.setY(483);
    wall54.setWidth(227);
    wall54.setHeight(11);
    
    wall55 = new Obstacle(this);
    wall55.setX(469);
    wall55.setY(483);
    wall55.setWidth(227);
    wall55.setHeight(11);
    
    wall56 = new Obstacle(this);
    wall56.setX(26);
    wall56.setY(530);
    wall56.setWidth(738);
    wall56.setHeight(8);                           
                
    actors.add(wall1);
    actors.add(wall2);
    actors.add(wall3);
    actors.add(wall4);
    actors.add(wall5);
    actors.add(wall6);
    actors.add(wall7);
    actors.add(wall8);
    actors.add(wall9);
    actors.add(wall10);
    actors.add(wall11);
    actors.add(wall12);
    actors.add(wall13);
    actors.add(wall14);
    actors.add(wall15);
    actors.add(wall16);
    actors.add(wall17);
    actors.add(wall18);
    actors.add(wall19);
    actors.add(wall20);
    actors.add(wall21);
    actors.add(wall22);
    actors.add(wall23);
    actors.add(wall24);
    actors.add(wall25);
    actors.add(wall26);
    actors.add(wall27);
    actors.add(wall28);
    actors.add(wall29);
    actors.add(wall30);
    actors.add(wall31);
    actors.add(wall32);
    actors.add(wall33);
    actors.add(wall34);
    actors.add(wall35);
    actors.add(wall36);
    actors.add(wall37);
    actors.add(wall38);
    actors.add(wall39);
    actors.add(wall40);
    actors.add(wall41);
    actors.add(wall42);
    actors.add(wall43);
    actors.add(wall44);
    actors.add(wall45);
    actors.add(wall46);
    actors.add(wall47);
    actors.add(wall48);
    actors.add(wall49);
    actors.add(wall50);
    actors.add(wall51);
    actors.add(wall52);
    actors.add(wall53);
    actors.add(wall54);
    actors.add(wall55);
    actors.add(wall56);
    
    //3 cherries
    CherryLife life1,life2,life3;
    
    life1 = new CherryLife(this);
    life1.setX(350);
    life1.setY(Stage.PLAY_HEIGHT + 5);
    
    life2 = new CherryLife(this);
    life2.setX(325);
    life2.setY(Stage.PLAY_HEIGHT + 5);
    
    life3 = new CherryLife(this);
    life3.setX(300);
    life3.setY(Stage.PLAY_HEIGHT + 5);
    
    actors.add(life1);
    actors.add(life2);
    actors.add(life3);
    
    //244 dots
    
    Dots dot1, dot2, dot3, dot4, dot5, dot6, dot7, dot8, dot9, dot10, 
    dot11, dot12, dot13, dot14, dot15, dot16, dot17, dot18, dot19, dot20, 
    dot21, dot22, dot23, dot24, dot25, dot26, dot27, dot28, dot29, dot30, 
    dot31, dot32, dot33, dot34, dot35, dot36, dot37, dot38, dot39, dot40, 
    dot41, dot42, dot43, dot44, dot45, dot46, dot47, dot48, dot49, dot50,
	dot51, /*dot52bomb,*/ dot53, dot54, dot55, dot56, dot57, dot58, dot59, dot60,
    /*dot61bomb,*/ dot62, dot63, dot64, dot65, dot66, dot67, dot68, dot69, dot70,
   	dot71, dot72, dot73, dot74, dot75, dot76, dot77, dot78, dot79, dot80,
    dot81, dot82, dot83, dot84, dot85, dot86, dot87, dot88, dot89, dot90,
   	dot91, dot92, dot93, dot94, dot95, dot96, dot97, dot98, dot99, dot100,
    dot101, dot102, dot103, dot104, dot105, dot106, dot107, dot108, dot109, dot110,
    dot111, dot112, dot113, dot114, dot115, dot116, dot117, dot118, dot119, dot120,
    dot121, dot122, dot123, dot124, dot125, dot126, dot127, dot128, dot129, dot130,
    dot131, dot132, dot133, dot134, dot135, /*dot136,*/ dot137, dot138, dot139, dot140,
    dot141, dot142, dot143, dot144, /*dot145,*/ dot146, dot147, dot148, dot149, dot150,
    dot151, dot152, dot153, dot154, dot155, dot156, dot157, dot158, dot159, dot160,
    dot161, dot162, dot163, dot164, dot165, dot166, dot167, dot168, dot169, dot170,
    dot171, dot172, dot173, dot174, dot175, dot176, dot177, dot178, dot179, dot180,
    dot181, dot182, dot183, dot184, dot185, dot186, dot187, dot188, dot189, dot190,
    dot191, dot192, dot193, dot194, dot195, dot196, dot197, dot198, dot199, dot200,
    dot201, dot202, dot203, dot204, dot205, dot206, dot207, dot208, dot209, dot210,
    dot211, dot212, dot213, dot214, dot215, dot216, dot217, dot218, dot219, dot220,
    dot221, dot222, dot223, dot224, dot225, dot226, dot227, dot228, dot229, dot230,
    dot231, dot232, dot233, dot234, dot235, dot236, dot237, dot238, dot239, dot240,
    dot241, dot242, dot243, dot244;
    
    Dots2 dot61, dot52, dot136, dot145;
     
    dot1 = new Dots(this);
    dot1.setX(61);
    dot1.setY(43);
        
    dot2 = new Dots(this);
    dot2.setX(88);
    dot2.setY(43);
        
    dot3 = new Dots(this);
    dot3.setX(114);
    dot3.setY(43);
        
    dot4 = new Dots(this);
    dot4.setX(141);
    dot4.setY(43);
        
    dot5 = new Dots(this);
    dot5.setX(168);
    dot5.setY(43);
        
    dot6 = new Dots(this);
    dot6.setX(194);
    dot6.setY(43);
        
    dot7 = new Dots(this);
    dot7.setX(220);
    dot7.setY(43);
        
    dot8 = new Dots(this);
    dot8.setX(246);
    dot8.setY(43);
        
    dot9 = new Dots(this);
    dot9.setX(273);
    dot9.setY(43);
        
    dot10 = new Dots(this);
    dot10.setX(301);
    dot10.setY(43);
        
    dot11 = new Dots(this);
    dot11.setX(326);
    dot11.setY(43);
        
    dot12 = new Dots(this);
    dot12.setX(353);
    dot12.setY(43);
        
    dot13 = new Dots(this);
    dot13.setX(434);
    dot13.setY(43);
    
    dot14 = new Dots(this);
    dot14.setX(460);
    dot14.setY(43);
    
    dot15 = new Dots(this);
    dot15.setX(486);
    dot15.setY(43);
    
    dot16 = new Dots(this);
    dot16.setX(513);
    dot16.setY(43);
    
    dot17 = new Dots(this);
    dot17.setX(540);
    dot17.setY(43);
    
    dot18 = new Dots(this);
    dot18.setX(565);
    dot18.setY(43);
    
    dot19 = new Dots(this);
    dot19.setX(594);
    dot19.setY(43);
    
    dot20 = new Dots(this);
    dot20.setX(620);
    dot20.setY(43);
    
    dot21 = new Dots(this);
    dot21.setX(646);
    dot21.setY(43);
    
    dot22 = new Dots(this);
    dot22.setX(673);
    dot22.setY(43);
    
    dot23 = new Dots(this);
    dot23.setX(699);
    dot23.setY(43);
    
    dot24 = new Dots(this);
    dot24.setX(727);
    dot24.setY(43);
    
    dot25 = new Dots(this);
    dot25.setX(61);
    dot25.setY(509);
        
    dot26 = new Dots(this);
    dot26.setX(88);
    dot26.setY(509);
        
    dot27 = new Dots(this);
    dot27.setX(114);
    dot27.setY(509);
        
    dot28 = new Dots(this);
    dot28.setX(141);
    dot28.setY(509);
        
    dot29 = new Dots(this);
    dot29.setX(168);
    dot29.setY(509);
        
    dot30 = new Dots(this);
    dot30.setX(194);
    dot30.setY(509);
        
    dot31 = new Dots(this);
    dot31.setX(220);
    dot31.setY(509);
        
    dot32 = new Dots(this);
    dot32.setX(246);
    dot32.setY(509);
        
    dot33 = new Dots(this);
    dot33.setX(273);
    dot33.setY(509);
        
    dot34 = new Dots(this);
    dot34.setX(301);
    dot34.setY(509);
        
    dot35 = new Dots(this);
    dot35.setX(326);
    dot35.setY(509);
        
    dot36 = new Dots(this);
    dot36.setX(353);
    dot36.setY(509);
        
    dot37 = new Dots(this);
    dot37.setX(434);
    dot37.setY(509);
    
    dot38 = new Dots(this);
    dot38.setX(460);
    dot38.setY(509);
    
    dot39 = new Dots(this);
    dot39.setX(486);
    dot39.setY(509);
    
    dot40 = new Dots(this);
    dot40.setX(513);
    dot40.setY(509);
    
    dot41 = new Dots(this);
    dot41.setX(540);
    dot41.setY(509);
    
    dot42 = new Dots(this);
    dot42.setX(565);
    dot42.setY(509);
    
    dot43 = new Dots(this);
    dot43.setX(594);
    dot43.setY(509);
    
    dot44 = new Dots(this);
    dot44.setX(620);
    dot44.setY(509);
    
    dot45 = new Dots(this);
    dot45.setX(646);
    dot45.setY(509);
    
    dot46 = new Dots(this);
    dot46.setX(673);
    dot46.setY(509);
    
    dot47 = new Dots(this);
    dot47.setX(699);
    dot47.setY(509);
    
    dot48 = new Dots(this);
    dot48.setX(727);
    dot48.setY(509);
    
    dot49 = new Dots(this);//middle
    dot49.setX(381);
    dot49.setY(509);
    
    dot50 = new Dots(this);//middle
    dot50.setX(406);
    dot50.setY(509);
    
    dot51 = new Dots(this);
    dot51.setX(60);
    dot51.setY(60);
    
    dot52 = new Dots2(this);//BOMB!!!!
    dot52.setX(60);
    dot52.setY(78);
    
    dot53 = new Dots(this);
    dot53.setX(60);
    dot53.setY(93);
    
    dot54 = new Dots(this);
    dot54.setX(60);
    dot54.setY(109);
    
    dot55 = new Dots(this);
    dot55.setX(60);
    dot55.setY(126);
    
    dot56 = new Dots(this);
    dot56.setX(60);
    dot56.setY(144);
    
    dot57 = new Dots(this);
    dot57.setX(60);
    dot57.setY(160);
    
    dot58 = new Dots(this);
    dot58.setX(60);
    dot58.setY(360);
    
    dot59 = new Dots(this);
    dot59.setX(60);
    dot59.setY(376);
    
    dot60 = new Dots(this);
    dot60.setX(60);
    dot60.setY(392);
    
	dot61 = new Dots2(this);//bomb!!!!
    dot61.setX(60);
    dot61.setY(410);
    
    dot62 = new Dots(this);
    dot62.setX(60);
    dot62.setY(459);
    
    dot63 = new Dots(this);
    dot63.setX(60);
    dot63.setY(477);
    
    dot64 = new Dots(this);
    dot64.setX(60);
    dot64.setY(493);
    
    dot65 = new Dots(this);//LALALLALA
    dot65.setX(87);
    dot65.setY(111);
    
    dot66 = new Dots(this);
    dot66.setX(87);
    dot66.setY(160);
    
    dot67 = new Dots(this);
    dot67.setX(87);
    dot67.setY(360);
    
    dot68 = new Dots(this);
    dot68.setX(87);
    dot68.setY(409);
    
    dot69 = new Dots(this);
    dot69.setX(87);
    dot69.setY(460);
    //LALALLALA
    dot70 = new Dots(this);
    dot70.setX(114);
    dot70.setY(111);
    
    dot71 = new Dots(this);
    dot71.setX(114);
    dot71.setY(160);
    
    dot72 = new Dots(this);
    dot72.setX(114);
    dot72.setY(360);
    
    dot73 = new Dots(this);
    dot73.setX(114);
    dot73.setY(409);
    
    dot74 = new Dots(this);
    dot74.setX(114);
    dot74.setY(427);
    
    dot75 = new Dots(this);
    dot75.setX(114);
    dot75.setY(444);
    
    dot76 = new Dots(this);
    dot76.setX(114);
    dot76.setY(460);
    //LALALAL
    dot77 = new Dots(this);
    dot77.setX(141);
    dot77.setY(111);
    
    dot78 = new Dots(this);
    dot78.setX(141);
    dot78.setY(160);
    
    dot79 = new Dots(this);
    dot79.setX(141);
    dot79.setY(360);
    
    dot80 = new Dots(this);
    dot80.setX(141);
    dot80.setY(460);
    
    dot81 = new Dots(this);
    dot81.setX(167);
    dot81.setY(111);
    
    dot82 = new Dots(this);
    dot82.setX(167);
    dot82.setY(160);
    
    dot83 = new Dots(this);
    dot83.setX(167);
    dot83.setY(360);
    
    dot84 = new Dots(this);
    dot84.setX(167);
    dot84.setY(460);
    //LALALLA
    dot85 = new Dots(this);
    dot85.setX(195);
    dot85.setY(60);
    
    dot86 = new Dots(this);
    dot86.setX(195);
    dot86.setY(76);
    
    dot87 = new Dots(this);
    dot87.setX(195);
    dot87.setY(94);
    
    dot88 = new Dots(this);
    dot88.setX(195);
    dot88.setY(111);
    
    dot89 = new Dots(this);
    dot89.setX(195);
    dot89.setY(126);
    
    dot90 = new Dots(this);
    dot90.setX(195);
    dot90.setY(144);
    
    dot91 = new Dots(this);
    dot91.setX(195);
    dot91.setY(160);
    
    dot92 = new Dots(this);
    dot92.setX(195);
    dot92.setY(176);
    
    dot93 = new Dots(this);
    dot93.setX(195);
    dot93.setY(193);
    
    dot94 = new Dots(this);
    dot94.setX(195);
    dot94.setY(211);
    
    dot95 = new Dots(this);
    dot95.setX(195);
    dot95.setY(226);
    
    dot96 = new Dots(this);
    dot96.setX(195);
    dot96.setY(243);
    
    dot97 = new Dots(this);
    dot97.setX(195);
    dot97.setY(259);
    
    dot98 = new Dots(this);
    dot98.setX(195);
    dot98.setY(276);
    
    dot99 = new Dots(this);
    dot99.setX(195);
    dot99.setY(293);
    
    dot100 = new Dots(this);
    dot100.setX(195);
    dot100.setY(310);
    
    dot101 = new Dots(this);
    dot101.setX(195);
    dot101.setY(326);
    
    dot102 = new Dots(this);
    dot102.setX(195);
    dot102.setY(343);
    
    dot103 = new Dots(this);
    dot103.setX(195);
    dot103.setY(360);
    
    dot104 = new Dots(this);
    dot104.setX(195);
    dot104.setY(376);
    
    dot105 = new Dots(this);
    dot105.setX(195);
    dot105.setY(393);
    
    dot106 = new Dots(this);
    dot106.setX(195);
    dot106.setY(409);
    
    dot107 = new Dots(this);
    dot107.setX(195);
    dot107.setY(426);
    
    dot108 = new Dots(this);
    dot108.setX(195);
    dot108.setY(443);
    
    dot109 = new Dots(this);
    dot109.setX(195);
    dot109.setY(460);
    
    dot110 = new Dots(this);//LALALLALALA
    dot110.setX(594);
    dot110.setY(60);
    
    dot111 = new Dots(this);
    dot111.setX(594);
    dot111.setY(76);
    
    dot112 = new Dots(this);
    dot112.setX(594);
    dot112.setY(94);
    
    dot113 = new Dots(this);
    dot113.setX(594);
    dot113.setY(111);
    
    dot114 = new Dots(this);
    dot114.setX(594);
    dot114.setY(126);
    
    dot115 = new Dots(this);
    dot115.setX(594);
    dot115.setY(144);
    
    dot116 = new Dots(this);
    dot116.setX(594);
    dot116.setY(160);
    
    dot117 = new Dots(this);
    dot117.setX(594);
    dot117.setY(176);
    
    dot118 = new Dots(this);
    dot118.setX(594);
    dot118.setY(193);
    
    dot119 = new Dots(this);
    dot119.setX(594);
    dot119.setY(211);
    
    dot120 = new Dots(this);
    dot120.setX(594);
    dot120.setY(226);
    
    dot121 = new Dots(this);
    dot121.setX(594);
    dot121.setY(243);
    
    dot122 = new Dots(this);
    dot122.setX(594);
    dot122.setY(259);
    
    dot123 = new Dots(this);
    dot123.setX(594);
    dot123.setY(276);
    
    dot124 = new Dots(this);
    dot124.setX(594);
    dot124.setY(293);
    
    dot125 = new Dots(this);
    dot125.setX(594);
    dot125.setY(310);
    
    dot126 = new Dots(this);
    dot126.setX(594);
    dot126.setY(326);
    
    dot127 = new Dots(this);
    dot127.setX(594);
    dot127.setY(343);
    
    dot128 = new Dots(this);
    dot128.setX(594);
    dot128.setY(360);
    
    dot129 = new Dots(this);
    dot129.setX(594);
    dot129.setY(376);
    
    dot130 = new Dots(this);
    dot130.setX(594);
    dot130.setY(393);
    
    dot131 = new Dots(this);
    dot131.setX(594);
    dot131.setY(409);
    
    dot132 = new Dots(this);
    dot132.setX(594);
    dot132.setY(426);
    
    dot133 = new Dots(this);
    dot133.setX(594);
    dot133.setY(443);
    
    dot134 = new Dots(this);
    dot134.setX(594);
    dot134.setY(460);
    
    dot135 = new Dots(this);
    dot135.setX(727);
    dot135.setY(60);
    
    dot136 = new Dots2(this);//bomb!!!!
    dot136.setX(727);
    dot136.setY(78);
    
    dot137 = new Dots(this);
    dot137.setX(727);
    dot137.setY(93);
    
    dot138 = new Dots(this);
    dot138.setX(727);
    dot138.setY(109);
    
    dot139 = new Dots(this);
    dot139.setX(727);
    dot139.setY(126);
    
    dot140 = new Dots(this);
    dot140.setX(727);
    dot140.setY(144);
    
    dot141 = new Dots(this);
    dot141.setX(727);
    dot141.setY(160);
    
    dot142 = new Dots(this);
    dot142.setX(727);
    dot142.setY(360);
    
    dot143 = new Dots(this);
    dot143.setX(727);
    dot143.setY(376);
    
    dot144 = new Dots(this);
    dot144.setX(727);
    dot144.setY(392);
    
	dot145 = new Dots2(this);//bomb!!!!
    dot145.setX(727);
    dot145.setY(410);
    
    dot146 = new Dots(this);
    dot146.setX(727);
    dot146.setY(459);
    
    dot147 = new Dots(this);
    dot147.setX(727);
    dot147.setY(477);
    
    dot148 = new Dots(this);
    dot148.setX(727);
    dot148.setY(493);///LALLALA end
    
    dot149 = new Dots(this);//LALALLALA
    dot149.setX(700);
    dot149.setY(111);
    
    dot150 = new Dots(this);
    dot150.setX(700);
    dot150.setY(160);
    
    dot151 = new Dots(this);
    dot151.setX(700);
    dot151.setY(360);
    
    dot152 = new Dots(this);
    dot152.setX(700);
    dot152.setY(409);
    
    dot153 = new Dots(this);
    dot153.setX(700);
    dot153.setY(460);
    
    dot154 = new Dots(this);
    dot154.setX(674);
    dot154.setY(111);
    
    dot155 = new Dots(this);
    dot155.setX(674);
    dot155.setY(160);
    
    dot156 = new Dots(this);
    dot156.setX(674);
    dot156.setY(360);
    
    dot157 = new Dots(this);
    dot157.setX(674);
    dot157.setY(409);
    
    dot158 = new Dots(this);
    dot158.setX(674);
    dot158.setY(427);
    
    dot159 = new Dots(this);
    dot159.setX(674);
    dot159.setY(444);
    
    dot160 = new Dots(this);
    dot160.setX(674);
    dot160.setY(460);//lalalaal
    
    dot161 = new Dots(this);
    dot161.setX(646);
    dot161.setY(111);
    
    dot162 = new Dots(this);
    dot162.setX(646);
    dot162.setY(160);
    
    dot163 = new Dots(this);
    dot163.setX(646);
    dot163.setY(360);
    
    dot164 = new Dots(this);
    dot164.setX(646);
    dot164.setY(460);
    
    dot165 = new Dots(this);
    dot165.setX(620);
    dot165.setY(111);
    
    dot166 = new Dots(this);
    dot166.setX(620);
    dot166.setY(160);
    
    dot167 = new Dots(this);
    dot167.setX(620);
    dot167.setY(360);
    
    dot168 = new Dots(this);
    dot168.setX(620);
    dot168.setY(460);
    
    dot169 = new Dots(this);
    dot169.setX(220);
    dot169.setY(111);
    
    dot170 = new Dots(this);
    dot170.setX(220);
    dot170.setY(360);
    
    dot171 = new Dots(this);
    dot171.setX(220);
    dot171.setY(409);
    
	dot172 = new Dots(this);
    dot172.setX(567);
    dot172.setY(111);
    
    dot173 = new Dots(this);
    dot173.setX(567);
    dot173.setY(360);
    
    dot174 = new Dots(this);
    dot174.setX(567);
    dot174.setY(409);
    
    dot175 = new Dots(this);
    dot175.setX(246);
    dot175.setY(111);
    
    dot176 = new Dots(this);
    dot176.setX(246);
    dot176.setY(360);
    
    dot177 = new Dots(this);
    dot177.setX(246);
    dot177.setY(409);
    
    dot178 = new Dots(this);
    dot178.setX(541);
    dot178.setY(111);
    
    dot179 = new Dots(this);
    dot179.setX(541);
    dot179.setY(360);
    
    dot180 = new Dots(this);
    dot180.setX(541);
    dot180.setY(409);//lalalla
    
    dot181 = new Dots(this);
    dot181.setX(274);
    dot181.setY(111);
    
    dot182 = new Dots(this);
    dot182.setX(274);
    dot182.setY(126);
    
    dot183 = new Dots(this);
    dot183.setX(274);
    dot183.setY(144);
    
    dot184 = new Dots(this);
    dot184.setX(274);
    dot184.setY(160);
    
    dot185 = new Dots(this);
    dot185.setX(274);
    dot185.setY(360);
    
    dot186 = new Dots(this);
    dot186.setX(274);
    dot186.setY(409);
    
    dot187 = new Dots(this);
    dot187.setX(274);
    dot187.setY(426);
    
    dot188 = new Dots(this);
    dot188.setX(274);
    dot188.setY(443);
    
    dot189 = new Dots(this);
    dot189.setX(274);
    dot189.setY(460);
    
    dot190 = new Dots(this);
    dot190.setX(513);
    dot190.setY(111);
    
    dot191 = new Dots(this);
    dot191.setX(513);
    dot191.setY(126);
    
    dot192 = new Dots(this);
    dot192.setX(513);
    dot192.setY(144);
    
    dot193 = new Dots(this);
    dot193.setX(513);
    dot193.setY(160);
    
    dot194 = new Dots(this);
    dot194.setX(513);
    dot194.setY(360);
    
    dot195 = new Dots(this);
    dot195.setX(513);
    dot195.setY(409);
    
    dot196 = new Dots(this);
    dot196.setX(513);
    dot196.setY(426);
    
    dot197 = new Dots(this);
    dot197.setX(513);
    dot197.setY(443);
    
    dot198 = new Dots(this);
    dot198.setX(513);
    dot198.setY(460);
    
	dot199 = new Dots(this);
    dot199.setX(300);
    dot199.setY(111);
    
    dot200 = new Dots(this);
    dot200.setX(300);
    dot200.setY(160);
    
    dot201 = new Dots(this);
    dot201.setX(300);
    dot201.setY(360);
    
    dot202 = new Dots(this);
    dot202.setX(300);
    dot202.setY(409);
    
    dot203 = new Dots(this);
    dot203.setX(300);
    dot203.setY(460);
    
    dot204 = new Dots(this);
    dot204.setX(326);
    dot204.setY(111);
    
    dot205 = new Dots(this);
    dot205.setX(326);
    dot205.setY(160);
    
    dot206 = new Dots(this);
    dot206.setX(326);
    dot206.setY(360);
    
    dot207 = new Dots(this);
    dot207.setX(326);
    dot207.setY(409);
    
    dot208 = new Dots(this);
    dot208.setX(326);
    dot208.setY(460);
    
    dot209 = new Dots(this);
    dot209.setX(459);
    dot209.setY(111);
    
    dot210 = new Dots(this);
    dot210.setX(459);
    dot210.setY(160);
    
    dot211 = new Dots(this);
    dot211.setX(459);
    dot211.setY(360);
    
    dot212 = new Dots(this);
    dot212.setX(459);
    dot212.setY(409);
    
    dot213 = new Dots(this);
    dot213.setX(459);
    dot213.setY(460);
    
    dot214 = new Dots(this);
    dot214.setX(485);
    dot214.setY(111);
    
    dot215 = new Dots(this);
    dot215.setX(485);
    dot215.setY(160);
    
    dot216 = new Dots(this);
    dot216.setX(485);
    dot216.setY(360);
    
    dot217 = new Dots(this);
    dot217.setX(485);
    dot217.setY(409);
    
    dot218 = new Dots(this);
    dot218.setX(485);
    dot218.setY(460);
    
    dot219 = new Dots(this);
    dot219.setX(380);
    dot219.setY(111);
    
    dot220 = new Dots(this);
    dot220.setX(404);
    dot220.setY(111);//lalaal
    
    dot221 = new Dots(this);
    dot221.setX(354);
    dot221.setY(60);
    
    dot222 = new Dots(this);
    dot222.setX(354);
    dot222.setY(76);
    
    dot223 = new Dots(this);
    dot223.setX(354);
    dot223.setY(94);
    
    dot224 = new Dots(this);
    dot224.setX(354);
    dot224.setY(111);
    
    dot225 = new Dots(this);
    dot225.setX(354);
    dot225.setY(160);
    
    dot226 = new Dots(this);
    dot226.setX(354);
    dot226.setY(360);
    
    dot227 = new Dots(this);
    dot227.setX(354);
    dot227.setY(376);
    
    dot228 = new Dots(this);
    dot228.setX(354);
    dot228.setY(393);
    
    dot229 = new Dots(this);
    dot229.setX(354);
    dot229.setY(409);
    
    dot230 = new Dots(this);
    dot230.setX(354);
    dot230.setY(460);
    
    dot231 = new Dots(this);
    dot231.setX(354);
    dot231.setY(478);
    
    dot232 = new Dots(this);
    dot232.setX(354);
    dot232.setY(495);
    
    //lalla
    dot233 = new Dots(this);
    dot233.setX(434);
    dot233.setY(60);
    
    dot234 = new Dots(this);
    dot234.setX(434);
    dot234.setY(76);
    
    dot235 = new Dots(this);
    dot235.setX(434);
    dot235.setY(94);
    
    dot236 = new Dots(this);
    dot236.setX(434);
    dot236.setY(111);
    
    dot237 = new Dots(this);
    dot237.setX(434);
    dot237.setY(160);
    
    dot238 = new Dots(this);
    dot238.setX(434);
    dot238.setY(360);
    
    dot239 = new Dots(this);
    dot239.setX(434);
    dot239.setY(376);
    
    dot240 = new Dots(this);
    dot240.setX(434);
    dot240.setY(393);
    
    dot241 = new Dots(this);
    dot241.setX(434);
    dot241.setY(409);
    
    dot242 = new Dots(this);
    dot242.setX(434);
    dot242.setY(460);
    
    dot243 = new Dots(this);
    dot243.setX(434);
    dot243.setY(478);
    
    dot244 = new Dots(this);
    dot244.setX(434);
    dot244.setY(495);
    
    
    //LALALLALA
    actors.add(dot1);
    actors.add(dot2);
    actors.add(dot3);
    actors.add(dot4);
    actors.add(dot5);
    actors.add(dot6);
    actors.add(dot7);
    actors.add(dot8);
    actors.add(dot9);
    actors.add(dot10);
    actors.add(dot11);
    actors.add(dot12);
    actors.add(dot13);
    actors.add(dot14);
    actors.add(dot15);
    actors.add(dot16);
    actors.add(dot17);
    actors.add(dot18);
    actors.add(dot19);
    actors.add(dot20);
    actors.add(dot21);
    actors.add(dot22);
    actors.add(dot23);
    actors.add(dot24);
    actors.add(dot25);
    actors.add(dot26);
    actors.add(dot27);
    actors.add(dot28);
    actors.add(dot29);
    actors.add(dot30);
    actors.add(dot31);
    actors.add(dot32);
    actors.add(dot33);
    actors.add(dot34);
    actors.add(dot35);
    actors.add(dot36);
    actors.add(dot37);
    actors.add(dot38);
    actors.add(dot39);
    actors.add(dot40);
    actors.add(dot41);
    actors.add(dot42);
    actors.add(dot43);
    actors.add(dot44);
    actors.add(dot45);
    actors.add(dot46);
    actors.add(dot47);
    actors.add(dot48);
    actors.add(dot49);
    actors.add(dot50);
    actors.add(dot51);
    actors.add(dot52);
    actors.add(dot53);
    actors.add(dot54);
    actors.add(dot55);
    actors.add(dot56);
    actors.add(dot57);
    actors.add(dot58);
    actors.add(dot59);
    actors.add(dot60);
    actors.add(dot61);
    actors.add(dot62);
    actors.add(dot63);
    actors.add(dot64);
    actors.add(dot65);
    actors.add(dot66);
    actors.add(dot67);
    actors.add(dot68);
    actors.add(dot69);
    actors.add(dot70);
    actors.add(dot71);
    actors.add(dot72);
    actors.add(dot73);
    actors.add(dot74);
    actors.add(dot75);
    actors.add(dot76);
    actors.add(dot77);
    actors.add(dot78);
    actors.add(dot79);
    actors.add(dot80);
    actors.add(dot81);
    actors.add(dot82);
    actors.add(dot83);
    actors.add(dot84);
    actors.add(dot85);
    actors.add(dot86);
    actors.add(dot87);
    actors.add(dot88);
    actors.add(dot89);
    actors.add(dot90);
    actors.add(dot91);
    actors.add(dot92);
    actors.add(dot93);
    actors.add(dot94);
    actors.add(dot95);
    actors.add(dot96);
    actors.add(dot97);
    actors.add(dot98);
    actors.add(dot99);
    actors.add(dot100);
    actors.add(dot101);
    actors.add(dot102);
    actors.add(dot103);
    actors.add(dot104);
    actors.add(dot105);
    actors.add(dot106);
    actors.add(dot107);
    actors.add(dot108);
    actors.add(dot109);
    actors.add(dot110);
    actors.add(dot111);
    actors.add(dot112);
    actors.add(dot113);
    actors.add(dot114);
    actors.add(dot115);
    actors.add(dot116);
    actors.add(dot117);
    actors.add(dot118);
    actors.add(dot119);
    actors.add(dot120);
    actors.add(dot121);
    actors.add(dot122);
    actors.add(dot123);
    actors.add(dot124);
    actors.add(dot125);
    actors.add(dot126);
    actors.add(dot127);
    actors.add(dot128);
    actors.add(dot129);
    actors.add(dot130);
    actors.add(dot131);
    actors.add(dot132);
    actors.add(dot133);
    actors.add(dot134);
    actors.add(dot135);
    actors.add(dot136);
    actors.add(dot137);
    actors.add(dot138);
    actors.add(dot139);
    actors.add(dot140);
    actors.add(dot141);
    actors.add(dot142);
    actors.add(dot143);
    actors.add(dot144);
    actors.add(dot145);
    actors.add(dot146);
    actors.add(dot147);
    actors.add(dot148);
    actors.add(dot149);
    actors.add(dot150);
    actors.add(dot151);
    actors.add(dot152);
    actors.add(dot153);
    actors.add(dot154);
    actors.add(dot155);
    actors.add(dot156);
    actors.add(dot157);
    actors.add(dot158);
    actors.add(dot159);
    actors.add(dot160);
    actors.add(dot161);
    actors.add(dot162);
    actors.add(dot163);
    actors.add(dot164);
    actors.add(dot165);
    actors.add(dot166);
    actors.add(dot167);
    actors.add(dot168);
    actors.add(dot169);
    actors.add(dot170);
    actors.add(dot171);
    actors.add(dot172);
    actors.add(dot173);
    actors.add(dot174);
    actors.add(dot175);
    actors.add(dot176);
    actors.add(dot177);
    actors.add(dot178);
    actors.add(dot179);
    actors.add(dot180);
    actors.add(dot181);
    actors.add(dot182);
    actors.add(dot183);
    actors.add(dot184);
    actors.add(dot185);
    actors.add(dot186);
    actors.add(dot187);
    actors.add(dot188);
    actors.add(dot189);
    actors.add(dot190);
    actors.add(dot191);
    actors.add(dot192);
    actors.add(dot193);
    actors.add(dot194);
    actors.add(dot195);
    actors.add(dot196);
    actors.add(dot197);
    actors.add(dot198);
    actors.add(dot199);
    actors.add(dot200);
    actors.add(dot201);
    actors.add(dot202);
    actors.add(dot203);
    actors.add(dot204);
    actors.add(dot205);
    actors.add(dot206);
    actors.add(dot207);
    actors.add(dot208);
    actors.add(dot209);
    actors.add(dot210);
    actors.add(dot211);
    actors.add(dot212);
    actors.add(dot213);
    actors.add(dot214);
    actors.add(dot215);
    actors.add(dot216);
    actors.add(dot217);
    actors.add(dot218);
    actors.add(dot219);
    actors.add(dot220);
    actors.add(dot221);
    actors.add(dot222);
    actors.add(dot223);
    actors.add(dot224);
    actors.add(dot225);
    actors.add(dot226);
    actors.add(dot227);
    actors.add(dot228);
    actors.add(dot229);
    actors.add(dot230);
    actors.add(dot231);
    actors.add(dot232);
    actors.add(dot233);
    actors.add(dot234);
    actors.add(dot235);
    actors.add(dot236);
    actors.add(dot237);
    actors.add(dot238);
    actors.add(dot239);
    actors.add(dot240);
    actors.add(dot241);
    actors.add(dot242);
    actors.add(dot243);
    actors.add(dot244);
    
    player = new Player(this);
    player.setX(388);
    player.setY(401); //changes start location of player
    
    m1 = new MonsterPlayer(this);
    m1.setX(385);
    m1.setY(250);
    
    m2 = new MonsterPlayer2(this);
    m2.setX(385);
    m2.setY(250);
    
    players.add(player);
    players.add(m1);
    players.add(m2);
    
    soundCache.loopSound("house.wav");
  	backgroundTile = spriteCache.getSprite("PacmanBG.png");
	  background = spriteCache.createCompatible(
	               Stage.WIDTH,  
	     					 Stage.HEIGHT+backgroundTile.getHeight(),
	               Transparency.OPAQUE);
	  Graphics2D g = (Graphics2D)background.getGraphics();
	  g.setPaint( new TexturePaint( backgroundTile, 
	                                new Rectangle(0,0,backgroundTile.getWidth(),backgroundTile.getHeight())));
	  g.fillRect(0,0,background.getWidth(),background.getHeight());
	  backgroundY = backgroundTile.getHeight();
    
	}
	
	public void addActor(Actor a) {
		actors.add(a);
	}	
	
	public Player getPlayer() {
		return player;
	}
	
	public void updateWorld() {
		int i = 0;
		while (i < actors.size()) {
			Actor m = (Actor)actors.get(i);
			if (m.isMarkedForRemoval()) {
				actors.remove(i);
			} else {
				m.act();
				i++;
			}
		}
		int k = 0;
		while (k < players.size())
		{
			Player m = (Player)players.get(k);
			if (m.isMarkedForRemoval())
			{
				m.setPrevX(390);
				m.setPrevY(250);
				m.notMarked();
			}
			else{
			m.act();
			k++;}	
		}
		}
	
	public void checkCollisions() {
		Rectangle playerBounds = player.getBounds();
		Rectangle m1Bounds = m1.getBounds();
		Rectangle m2Bounds = m2.getBounds();
		
		for (int i = 0; i < actors.size(); i++) {
			Actor a1 = (Actor)actors.get(i);
			Rectangle r1 = a1.getBounds();
			if (r1.intersects(playerBounds)) {
				player.collision(a1);
				a1.collision(player);
			}
			if (r1.intersects(m1Bounds)) {
				m1.collision(a1);
				a1.collision(m1);
			}
			if (r1.intersects(m2Bounds)) {
				m2.collision(a1);
				a1.collision(m2);
			}
			if (m1Bounds.intersects(playerBounds))
			{
				player.collision(m1);
			}
			if (m2Bounds.intersects(playerBounds))
			{
				player.collision(m2);
			}
		  for (int j = i+1; j < actors.size(); j++) {
		  	Actor a2 = (Actor)actors.get(j);
		  	Rectangle r2 = a2.getBounds();
		  	if (r1.intersects(r2)) {
		  		a1.collision(a2);
		  		a2.collision(a1);
		  	}
		  }
		}
	}
	
	public void paintShields(Graphics2D g) {
		//g.setPaint(Color.red);
		//g.fillRect(280,Stage.PLAY_HEIGHT,Player.MAX_SHIELDS,30);
		//g.setPaint(Color.blue);
		//g.fillRect(280+Player.MAX_SHIELDS-player.getShields(),Stage.PLAY_HEIGHT,player.getShields(),30);
		//g.setFont(new Font("Arial",Font.BOLD,20));
		//g.setPaint(Color.green);
		//g.drawString("",170,Stage.PLAY_HEIGHT+20);
    	
	}
    
	public void paintScore(Graphics2D g) {
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.setPaint(Color.green);
		g.drawString("Score:",40,Stage.PLAY_HEIGHT + 25);
		g.setPaint(Color.red);
		g.drawString(player.getScore()+"",125,Stage.PLAY_HEIGHT  + 25);
	}
	
	public void paintAmmo(Graphics2D g) {
		int xBase = 500;
		for (int i = 0; i < player.getClusterBombs();i++) {
			BufferedImage bomb = spriteCache.getSprite("bombUL.gif");
			g.drawImage( bomb ,xBase,Stage.PLAY_HEIGHT + 10,this);
			xBase += bomb.getWidth();
		}
		
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.setPaint(Color.green);
		g.drawString("BOMBS:",400,Stage.PLAY_HEIGHT + 25);
	}
	
	public void paintfps(Graphics2D g) {
		g.setFont( new Font("Arial",Font.BOLD,12));
		g.setColor(Color.white);
		if (usedTime > 0)
		  g.drawString(String.valueOf(1000/usedTime)+" fps",Stage.WIDTH-50,Stage.PLAY_HEIGHT + 25);
  	else
	  	g.drawString("--- fps",Stage.WIDTH-50,Stage.PLAY_HEIGHT);
	}
	
	
	public void paintStatus(Graphics2D g) {
	  paintScore(g);
	  paintShields(g);
	  paintAmmo(g);
	  paintfps(g);
	  paintLives(g);	
	}
	
	public void paintWorld() {
		Graphics2D g = (Graphics2D)strategy.getDrawGraphics();
		g.drawImage( background,
		             0,0,Stage.WIDTH,Stage.HEIGHT,
		             0,backgroundY,Stage.WIDTH,backgroundY+Stage.HEIGHT,this);
		for (int i = 0; i < actors.size(); i++) {
			Actor m = (Actor)actors.get(i);
			m.paint(g);
		}
		for (int i = 0; i < players.size(); i++)
		{
			Player m = (Player)players.get(i);
			m.paint(g);
		}

	  	
	  paintStatus(g);
		strategy.show();
	}
	
	public void paintGameOver() {
		Graphics2D g = (Graphics2D)strategy.getDrawGraphics();
		g.setColor(Color.white);
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.drawString("GAME OVER",Stage.WIDTH/2-50,Stage.HEIGHT/2);
		strategy.show();
	}
	
	public void paintpacmanWins() {
		Graphics2D g = (Graphics2D)strategy.getDrawGraphics();
		g.setColor(Color.white);
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.drawString("PACMAN WINS!",Stage.WIDTH/2-50,Stage.HEIGHT/2);
		strategy.show();
	}
	
	public void paintLives(Graphics2D g) {
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.setPaint(Color.green);
		g.drawString("LIVES:",225,Stage.PLAY_HEIGHT + 25);
	}
	
	public SpriteCache getSpriteCache() {
		return spriteCache;
	}
	
	public SoundCache getSoundCache() {
		return soundCache;
	}
	
	public void keyPressed(KeyEvent e) {
		player.keyPressed(e);
		m1.keyPressed(e);
		m2.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e) {
		player.keyReleased(e);
		m1.keyReleased(e);
		m2.keyReleased(e);
	}
	public void keyTyped(KeyEvent e) {}
	
	public void game() {
		usedTime=1000;
		initWorld();
		while (isVisible() && !gameEnded && !pacmanWin) {
			long startTime = System.currentTimeMillis();
			/*backgroundY--;
			if (backgroundY < 0)
			  backgroundY = backgroundTile.getHeight();*/ //makes the map move
			updateWorld();
			int prevShield = player.getShields();
			checkCollisions();
			if (player.getShields() < prevShield)
				actors.remove(56);
			paintWorld();
			usedTime = System.currentTimeMillis()-startTime;
			do {
  			Thread.yield();
			} while (System.currentTimeMillis()-startTime< 17);
		}
		if (gameEnded)
			paintGameOver();
			
		if (pacmanWin)
			paintpacmanWins();
	}
	
	public static void main(String[] args) {
		Invaders inv = new Invaders();
		inv.game();
	}
}
