package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import controller.IOrderPerformer;

public class CreatPicture {
	private BufferedImage image;
	int imageSpritX;
	int imageSpritY;
	CreatPicture(){
		
	}
	public void buildImage(final int imagePositionX, final int imagePositionY, final char picture,IOrderPerformer orderPerformer) throws IOException {

		File f = new File(".");
		ViewFacade view = new ViewFacade(orderPerformer);
		System.out.println(f.getCanonicalPath() + "/");
		switch(picture){
		case 'O': imageSpritX = 7; imageSpritY = 0;
		break;
		case 'X': imageSpritX = 8; imageSpritY = 0;
		break;
		case 'R': imageSpritX = 9; imageSpritY = 0;
		break;
		case 'D': imageSpritX = 10; imageSpritY = 0;
		break;
		case 'S': imageSpritX = 13; imageSpritY = 1;
		break;
		case 'P': imageSpritX = 2; imageSpritY = 2;
		break;
		case 'E': imageSpritX = 16; imageSpritY = 1;
		break;
		case 'W': imageSpritX = 6; imageSpritY = 0;
		break;
		default:
		break;
		}
		BufferedImage imageSource = ImageIO.read(new File(f.getCanonicalPath() + "/Image/BoulderDash.png"));
		this.image = (imageSource).getSubimage(imageSpritX * 16, imageSpritY * 16, 16, 16);
		view.drawImage(image, imagePositionX, imagePositionY);
		
	}
	
	
	
}
