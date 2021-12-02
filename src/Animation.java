import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferedImage ;

public class Animation {

	private List<BufferedImage> frames ;
	private int currFrame = 0 ; 
	private int changeTime ;
	private long previousTime ; 
	
	
	 public Animation(int changeTime) {
		 this.changeTime = changeTime ;
		frames = new ArrayList<BufferedImage> ();
	}
	
	public void update() {
		if(System.currentTimeMillis() - previousTime > changeTime) {
		currFrame ++ ; 
		if(currFrame >= frames.size()) {
			currFrame = 0 ;
		}
		previousTime = System.currentTimeMillis() ;
		}
	}
	
	public void addFrame(BufferedImage frame) {
		frames.add(frame) ;
	}
	
	public BufferedImage getFrame() {
		if(frames.size()>0) {
			return frames.get(currFrame) ;
		}
		return null ;
	}
	
	
}