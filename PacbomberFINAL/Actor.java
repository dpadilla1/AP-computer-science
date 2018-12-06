/**
 * Curso Básico de desarrollo de Juegos en Java - Invaders
 * 
 * (c) 2004 Planetalia S.L. - Todos los derechos reservados. Prohibida su reproducción
 * 
 * http://www.planetalia.com
 * 
 */
package version29;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Actor
{
	protected double x,y;
	public int width, height;
	public String[] spriteNames;
	public int currentFrame;
	public int frameSpeed;
	public int t;
	public Stage stage;
	public SpriteCache spriteCache;
	public boolean markedForRemoval;
	public static int bulletAmount = 0;
	
	public Actor(Stage stage) 
	{
		this.stage = stage;
		spriteCache = stage.getSpriteCache();
		currentFrame = 0;
		frameSpeed = 1;
		t=0;
	}
	
	public void remove() 
	{
		markedForRemoval = true;
	}
	
	public void notMarked()
	{
		markedForRemoval = false;
	}
	
	public boolean isMarkedForRemoval()
	{
		return markedForRemoval;
		
	}
	
	public void paint(Graphics2D g)
	{
		g.drawImage( spriteCache.getSprite(spriteNames[0]), (int)x,(int)y, stage );
	}
	
	public double getX()  { return x; }
	public void setX(double i) {	x = i; }

	public double getY() {	return y; }
	public void setY(double i) { y = i; }
	
	public double getFrameSpeed() {return frameSpeed;	}
	public void setFrameSpeed(int i) {frameSpeed = i;	}
	
	
	public void setSpriteNames(String[] names) 
	{ 
		spriteNames = names;
		height = 0;
		width = 0;
		for (int i = 0; i < names.length; i++ )
		{
	  		BufferedImage image = spriteCache.getSprite(spriteNames[i]);
		  	height = Math.max(height,image.getHeight());
			width = Math.max(width,image.getWidth());
		}
	}			
	
	public int getHeight() { return height; }
	public int getWidth() {	return width;	}
	public void setHeight(int i) {height = i;	}
	public void setWidth(int i) {	width = i;	}

	public void act() 
	{
		t++;
		if (t % frameSpeed == 0)
		{
			t=0;
  			//currentFrame = (currentFrame + 1) % spriteNames.length;
		}
	}
	
	public Rectangle getBounds() 
	{
		return new Rectangle((int)x,(int)y,width,height);
	}
	
	public void collision(Actor a)
	{
		
	}
	
   
}

