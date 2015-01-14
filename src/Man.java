import static org.lwjgl.opengl.GL11.*;

import org.newdawn.slick.opengl.Texture;

public class Man extends AbstractMovableEntity {

	private Texture texture;
	
	public Man(double x, double y, double width, double height, Texture texture) {
        super(x, y, width, height);
        this.texture = texture;
	}
	
	 @Override
     public void draw() {
		 double x = getX();
		 double y = getY();
         renderTexture2();
	 }
	 
	 private void renderTexture2() {

//			glClear(GL_COLOR_BUFFER_BIT);
			
			texture.bind();

			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
			
			glBegin(GL_TRIANGLES);
			
				glTexCoord2f(1, 0);
				glVertex2i((int)(getX() + getWidth()), (int)getY());//top-right
				
				glTexCoord2f(0, 0);
				glVertex2i((int)getX(), (int)getY());//top-left
				
				glTexCoord2f(0, 1);
				glVertex2i((int)getX(), (int)(getY() + getHeight()) );//bottom-left
				
				glTexCoord2f(0, 1);
				glVertex2i((int)getX(), (int)(getY() + getHeight()));//bottom-left
				
				glTexCoord2f(1, 1);
				glVertex2i((int)(getX() + getWidth()), (int)(getY() + getHeight()));//bottom-right
				
				glTexCoord2f(1, 0);
				glVertex2i((int)(getX() + getWidth()), (int)getY());//top-right
				
			glEnd();
	}
		

	
}
 