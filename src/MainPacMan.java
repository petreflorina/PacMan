
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.*;
import org.lwjgl.*;


public class MainPacMan {

	public MainPacMan(){
		
		Renderer.initializeDisplay();
		Renderer.initializeMatrices();
		Renderer.loadMedia();
		
		Renderer.gameLoop();
		
		Display.destroy();
	}
	
	public static void main(String[] args) {
		new MainPacMan();
	}
}
