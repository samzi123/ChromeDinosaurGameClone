import java.awt.Graphics ;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level; 
import java.util.logging.Logger ;

public class Canvas extends JPanel implements Runnable, KeyListener {

	public static final float GROUNDY = 120 ; 
	private Dinosaur mainChar ;
	private Land land ;  
	private Cactus cactus ; 
	Thread thread ;
	float speedY= 0 ;
	
	public Canvas() {
		thread = new Thread(this) ;
		mainChar = new Dinosaur() ; 
		land = new Land() ;
		cactus = new Cactus() ;
	}
	
	public void beginGame() {
		thread.start(); 
	}

	@Override
	public void run() {
		while(true) {
			try {
				mainChar.updatePos();
				land.update();
				cactus.update();
				if(cactus.getBound().intersects(mainChar.getBound())) {
					System.out.println("There's a collision"); 
				}
				repaint() ;
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.decode("#f7f7f7"));
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.red) ;
		g.drawLine(0, (int) GROUNDY, getWidth(), (int) GROUNDY) ; 
		land.draw(g);
		mainChar.draw(g);
		cactus.draw(g);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		mainChar.jump();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("released");
		
	}
	
}
