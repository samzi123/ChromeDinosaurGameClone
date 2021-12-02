import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.Graphics ;
import java.awt.image.BufferedImage ;
import javax.swing.JFrame ;
import java.io.File;
import java.io.IOException; 

public class Window extends JFrame{
 
	Canvas gameScreen ;
	
	public Window() {
		
		super("Dinosaur game") ; 
		setSize(600, 175) ; 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameScreen = new Canvas() ; 
		add(gameScreen) ; 
		addKeyListener(gameScreen) ;
	}
	
	public void paint(Graphics g) {
		
		super.paint(g) ;
		
		
	}
	
	public void beginGame() {
		gameScreen.beginGame() ;
	}
	
	public static void main(String args[]) {
		Window w = new Window() ;
	    w.setVisible(true) ;
		w.beginGame() ;
	}
}
