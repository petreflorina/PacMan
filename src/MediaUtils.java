import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;


public class MediaUtils {

	public static Texture loadTexture(String name){
	
		Texture texture = null;
		try {
            // Load the texture 
			texture = TextureLoader.getTexture("PNG", new FileInputStream(new File("textures/"+name+".png")));
        } catch (IOException e) {
            e.printStackTrace();
            Display.destroy();
            System.exit(1);
        }
		
		return texture;
	}
}
