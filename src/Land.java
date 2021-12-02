import java.awt.Graphics ;
import java.awt.image.BufferedImage ;
import java.util.ArrayList;
import java.util.List;

public class Land {
	
	public static final int GROUND = 120 ; 
	private BufferedImage imgLand1, imgLand2, imgLand3 ;
	private List<ImageLand> listImg ;
	
	public Land() {
		 imgLand1 = Data.getDataImage("/Users/moezboussarsar/Documents/CSC 171/Project 3/Downasaur/media/land1.png") ;
		 imgLand2 = Data.getDataImage("/Users/moezboussarsar/Documents/CSC 171/Project 3/Downasaur/media/land2.png") ;
		 listImg = new ArrayList<ImageLand>() ;
		 
		 for(int i = 0 ; i<25 ; i=i+2  ) {
			 ImageLand imageLand = new ImageLand() ;
			 ImageLand imgland = new ImageLand() ;
			 imageLand.posX = (int) (i * imgLand1.getWidth()) ;
			 imageLand.img = imgLand1 ;
			 imgland.posX = (int) ((i+1) * imgLand2.getWidth()) ;
			 imgland.img = imgLand2 ;
			 listImg.add(imageLand);
			 listImg.add(imgland);
			 
		 }
	}
	public void draw(Graphics g) {
		for(ImageLand imageLand:listImg) {
		    g.drawImage(imageLand.img , imageLand.posX , GROUND -23   , null) ;
		}
	}
	public void update() {
		for (ImageLand imageLand:listImg) {
			imageLand.posX -- ;
		}
		ImageLand first = listImg.get(0) ; 
		if(first.posX + imgLand1.getWidth()<0) {
			first.posX = listImg.get(listImg.size() - 1 ).posX +  imgLand1.getWidth() ;
			listImg.add(first );
			listImg.remove(0) ;
		}
	}
	
	private class ImageLand {
		int posX ;
		BufferedImage img ;
	}
	
}
