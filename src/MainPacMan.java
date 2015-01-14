
import java.io.IOException;

import org.lwjgl.opengl.*;


public class MainPacMan {

	public MainPacMan() throws IOException{
		
		Renderer.initializeDisplay();
		Renderer.setUpOpenGl();
		Renderer.setUpEntities();
		//Renderer.loadMedia();
		
		Renderer.gameLoop();
		
		Display.destroy();
	}
	
	public static void main(String[] args) throws IOException {
		new MainPacMan();
	}
}
