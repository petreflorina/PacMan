import org.newdawn.slick.opengl.Texture;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

public class Renderer {

	private static Texture texture = null;
	private static int SCREEN_WIDTH = 640, SCREEN_HEIGHT = 480;
	private static Man pacMan;
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
		//	logic(getDelta());
            input();
            Display.update();
            Display.sync(60);
          }
	}

	private static void updateDisplay() {
		Display.update();
		Display.sync(60);

	}

	public static void loadMedia() {
		texture = MediaUtils.loadTexture("koala");
	}
	
	public static void setUpOpenGl(){
		
		glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, 640, 480, 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
		
	}

	private static void renderTexture() {
		  glClear(GL_COLOR_BUFFER_BIT);
	        pacMan.draw();
	}

	private static void input(){
		
   if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
        pacMan.setDY(-.2);
    } else if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
        pacMan.setDY(.2);
    } else {
    	pacMan.setDY(0);
    }
	    
	}
	 
	private static long lastFrame;

	    private static long getTime() {
	        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	    }
	    
    private static int getDelta() {
        long currentTime = getTime();
        int delta = (int) (currentTime - lastFrame);
        lastFrame = getTime();
        return delta;
    }
}
