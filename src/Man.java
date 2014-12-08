import static org.lwjgl.opengl.GL11.*;

import org.newdawn.slick.opengl.Texture;

public class Man extends AbstractMovableEntity {

	private static MediaUtils texture;
	
	public Man(double x, double y, double width, double height) {
        super(x, y, width, height);
	}
	
	 @Override
     public void draw() {
         glRectd(x, y, x + width, y + height);
         texture.loadTexture("koala");
	 }
	
}
 