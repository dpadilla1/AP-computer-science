package version29;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
public class Obstacle extends Actor
{
	
	public Obstacle(Stage stage)
	{
		super(stage);
		
	}
	
	public void paint(Graphics2D g)
	{
		/*g.setColor(Color.red);
		g.fillRect((int)x, (int)y, width, height );*/
		
	}
	
	public void collision(Actor a)
	{
		if (a instanceof Bomb)
		{
			a.remove();
			stage.getSoundCache().playSound("explosion.wav");
		}
	}
}