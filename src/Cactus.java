import java.awt.image.BufferedImage;
import java.awt.Graphics; 
import java.awt.Rectangle; 

public class Cactus {

	private BufferedImage image ;
	private int posX, posY ;
	private Rectangle rect ;
	
	public Cactus() {
		image = Data.getDataImage("/Users/moezboussarsar/Documents/CSC 171/Project 3/media/cactus1.png") ;
		posX = 200; 
		posY = 120 - image.getHeight() ; 
		rect = new Rectangle() ;
	}
	
	public void update() {
		posX = posX -2 ;  
		rect.x = posX ; 
		rect.y  = posY ; 
		rect.width = image.getWidth() ;
		rect.height = image.getHeight() ;
	} 
	
	public Rectangle getBound() {
		return rect ;
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, posX, posY , null) ; 
	
	}
}
