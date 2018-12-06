package version29;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Dots extends Actor
{
	
	public Dots(Stage stage)
	{
		super(stage);
		setSpriteNames( new String[] {"dots.png"});
	}
}