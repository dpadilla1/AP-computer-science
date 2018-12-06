/**
 * Curso Básico de desarrollo de Juegos en Java - Invaders
 * 
 * (c) 2004 Planetalia S.L. - Todos los derechos reservados. Prohibida su reproducción
 * 
 * http://www.planetalia.com
 * 
 */
package version29;

import java.awt.event.KeyEvent;
import java.awt.Rectangle;

public class MonsterPlayer extends Player {
	public static final int MAX_SHIELDS = 0;
	public static final int MAX_BOMBS = 0;
	protected static final int PLAYER_SPEED = 4;
	protected int vx;
	protected int vy;
	private boolean up,down,left,right;
	private int clusterBombs; 
	private int score;
	private int shields;
	public  double prevX;
	public  double prevY;
		
	
	public MonsterPlayer(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"PacmanGhost.png"});
		clusterBombs = MAX_BOMBS;
		shields = MAX_SHIELDS;
		score = 0;
	}
	
	public void act() {
		
		prevX = x;
		prevY= y;
		
		x +=vx;
		y+=vy;
		if (x < 0 ) 
		  x = 0;
		if (x > Stage.WIDTH - getWidth())
		  x = Stage.WIDTH - getWidth();
		if (y < 0 )
		  y = 0;
		if ( y > Stage.PLAY_HEIGHT-getHeight())
		  y = Stage.PLAY_HEIGHT - getHeight();
	}
	

	public void setPrevX(int i){x = i;
	}
	public void setPrevY(int i){y = i;
	}
	
	public int getVx() { return vx; }
	public void setVx(int i) {vx = i;	}
 	public int getVy() { return vy; }
  	public void setVy(int i) {vy = i;	}
  
  
  protected void updateSpeed() {
  	vx=0;vy=0;
  	if (down) vy = PLAYER_SPEED;
  	if (up) vy = -PLAYER_SPEED;
  	if (left) vx = -PLAYER_SPEED;
  	if (right) vx = PLAYER_SPEED;
  }
  
  public void keyReleased(KeyEvent e) {
   	switch (e.getKeyCode()) {
  		case KeyEvent.VK_S : down = false;break;
		  case KeyEvent.VK_W : up = false; break;
		  case KeyEvent.VK_A : left = false; break; 
		  case KeyEvent.VK_D : right = false;break;
   	}
   	updateSpeed();
  }
  
  public void keyPressed(KeyEvent e) {
  	switch (e.getKeyCode()) {
		  case KeyEvent.VK_W : up = true; break;
		  case KeyEvent.VK_A : left = true; break;
		  case KeyEvent.VK_D : right = true; break;
		  case KeyEvent.VK_S : down = true;break;
		  //case KeyEvent.VK_SPACE : fire(); break;
  	}
  	updateSpeed();
  }
  
  /*public void fire() {
   	Bullet b = new Bullet(stage);
   	b.setX(x);
   	b.setY(y - b.getHeight());
   	stage.addActor(b);
   	stage.getSoundCache().playSound("missile.wav");
  }*/
  

  
  public int getScore() {		return score;	}
  public void setScore(int i) {	score = i;	}
  public void addScore(int i) { score += i;  }

	public int getShields() {	return shields;	}
	public void setShields(int i) {	shields = i;	}
	public void addShields(int i) {
		shields += i;
		if (shields > MAX_SHIELDS) shields = MAX_SHIELDS;
	}
	
	public void collision(Actor a) {
		if (a instanceof Monster ) {
		  a.remove();
		  addShields(-40);
		}
		
		if(a instanceof Obstacle)
		{
			Rectangle intersection = a.getBounds().intersection(this.getBounds());
			if (intersection.getY()+intersection.getHeight() == a.getY()+ a.getHeight())//bottom
			{
				y = prevY;
				if (intersection.getX() == a.getX())//bottom + left
				{					
					x = prevX;
					y = prevY;				
				}
				else if(intersection.getX()+intersection.getWidth() 
				== a.getX() + a.getWidth())//bottom + right
				{
					x = prevX;
					y = prevY;
				}
			}
			else if(intersection.getX()+intersection.getWidth() == a.getX() + a.getWidth())//right
			{
				x = prevX;
				if (intersection.getY() == a.getY())
				{
					x = prevX;
					y = prevY;	
				}
			}
			else if (intersection.getY() == a.getY())//top
			{	
				y = prevY;
				if (intersection.getX() == a.getX())//top + left
				{
					x = prevX;
					y = prevY;
				}
				else if(intersection.getX()+intersection.getWidth() == a.getX() + a.getWidth())//top + right
				{
					x = prevX;
					y = prevY;
				}		
			}
			else if (intersection.getX() == a.getX())//left
			{
				x = prevX;		
			}
		}
		
		if (a instanceof Bomb ) {
			a.remove();
			remove();
		}
		//if (getShields() < 0)
		//    this.remove();
	}	
	
	public void remove() {
		markedForRemoval = true;
	}

	public int getClusterBombs() {	return clusterBombs;	}
	public void setClusterBombs(int i) {	clusterBombs = i;	}

}
