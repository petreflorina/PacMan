import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

import static org.lwjgl.opengl.GL11.*;

public class Renderer {
	private static Texture texture = null;
	private static int SCREEN_WIDTH = 640, SCREEN_HEIGHT = 480;

	public static void initializeDisplay() {

		try {
			Display.setDisplayMode(new DisplayMode(SCREEN_WIDTH, SCREEN_HEIGHT));
			Display.setTitle("PacMan");
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}

	public static void gameLoop() {
		while (!Display.isCloseRequested()) {
			renderTexture();
			updateDisplay();
			
		}
	}

	private static void updateDisplay() {
		Display.update();
		Display.sync(60);

	}

	public static void loadMedia() {
		texture = MediaUtils.loadTexture("koala");
	}
	
	public static void initializeMatrices(){

		glMatrixMode(GL_PROJECTION);
		glOrtho(0, SCREEN_WIDTH, SCREEN_HEIGHT, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		
	}

	private static void renderTexture() {

			glClear(GL_COLOR_BUFFER_BIT);
			
			texture.bind();
			
			glBegin(GL_TRIANGLES);
			
				glTexCoord2f(1, 0);
				glVertex2i(450, 10);
				
				glTexCoord2f(0, 0);
				glVertex2i(10, 10);
				
				glTexCoord2f(0, 1);
				glVertex2i(10, 450);
				
				glTexCoord2f(0, 1);
				glVertex2i(10, 450);
				
				glTexCoord2f(1, 1);
				glVertex2i(450, 450);
				
				glTexCoord2f(1, 0);
				glVertex2i(450, 10);
				
			glEnd();

	}

}
