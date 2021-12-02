import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

public class Dinosaur {

	public static final float GRAVITY = 0.1f ; 
	public static final float GROUNDY = 120 ; 
	private float x = 40 ;
	private float y = 40  ; 
	private float speedY = 0 ;
	private BufferedImage DinoImage ;
	private Animation characterRunning ;
	private Rectangle rect ;
	
	public Dinosaur() {
		characterRunning = new Animation(200
				) ;
		characterRunning.addFrame(Data.getDataImage("/Users/moezboussarsar/Documents/CSC 171/Project 3/Downasaur/media/main-character1.png")) ;
		characterRunning.addFrame(Data.getDataImage("/Users/moezboussarsar/Documents/CSC 171/Project 3/Downasaur/media/main-character2.png")) ;
		DinoImage = Data.getDataImage("/Users/moezboussarsar/Documents/CSC 171/Project 3/Downasaur/media/main-character1.png");
		rect = new Rectangle() ; 
	}
	
	public void updatePos() {
		
		characterRunning.update();
		if(y>= GROUNDY - characterRunning.getFrame().getHeight()) {
			speedY = 0 ; 
			y = GROUNDY - characterRunning.getFrame().getHeight() ;
		}
		speedY+=GRAVITY ;
		y+=speedY ; 
		rect.x = (int) x ; 
		rect.y  = (int) y ; 
		rect.width = DinoImage.getWidth() ;
		rect.height = DinoImage.getHeight() ;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.black) ;
		g.drawImage(characterRunning.getFrame(), (int) x, (int) y, null) ;
	}
	
	public Rectangle getBound() {
		return rect ;
	}
	
	public void jump() {
		speedY = -3.5f ;
		y += speedY ;
	}
	
	public float getX() {
		return x ;
	}
	
	public void setX(float x) {
		this.x = x ;
	}
	
	public float getY() {
		return y ;
	}
	
	public void setY(float y) {
		this.y   = y ;
	}
	
	public float getspeedY() {
		return speedY ;
	}
	
	public void setspeedY(float speedY) {
		this.speedY   = speedY ;
	}
}
