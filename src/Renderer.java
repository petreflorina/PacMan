import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
	private static String path;
	private static ArrayList<Bat> bat = new ArrayList<Bat>(); 
	
	private static boolean collide=false;
	private static double lastX, lastY;
	
	public static void initializeDisplay() {

		try {
			Display.setDisplayMode(new DisplayMode(SCREEN_WIDTH, SCREEN_HEIGHT));
			Display.setTitle("PacMan");
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}

	public static void gameLoop() throws IOException {
		
		setUpEntities();
		
		while (!Display.isCloseRequested()) {
			renderTexture();
			input();
			logic(getDelta());
            
			updateDisplay();
          }
	}

	private static void updateDisplay() {
		Display.update();
		Display.sync(60);

	}

	
	
	public static void setUpOpenGl(){
		
		glMatrixMode(GL_PROJECTION);
        glOrtho(0, SCREEN_WIDTH, SCREEN_HEIGHT, 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
	}
	
	

	public static void loadMedia() {
		texture = MediaUtils.loadTexture("koala");
	}
	
	private static void readBatDetails() throws IOException{
		
		String fileName="E:/PacMan.git/batDetails.txt";
		
		FileReader in = new FileReader(fileName);
		BufferedReader textReader = new BufferedReader(in);
		
		String str="", batDetails="", nr="";
		
		while((str=textReader.readLine())!=null){
			batDetails = str;
	
		String[] splitted = batDetails.split(" ");
		
			Bat temporaryBat = new Bat(Double.parseDouble(splitted[0]), Double.parseDouble(splitted[1]),
					Double.parseDouble(splitted[2]), Double.parseDouble(splitted[3]));
		
			bat.add(temporaryBat);
		}
	}
	
	public static void setUpEntities() throws IOException {
		
		loadMedia();
        
		pacMan= new Man(SCREEN_WIDTH / 2 - 100, SCREEN_HEIGHT / 2 - 100 / 2, 40, 40, texture);
      	readBatDetails();
      	System.out.println(bat.size());
      
	}

	
	private static void renderTexture() {
		glClear(GL_COLOR_BUFFER_BIT);
	        
		  pacMan.draw();
		  for(int i=0; i<bat.size(); i++){
		        bat.get(i).draw();	
	        }
	        
	}

	private static void input(){
		
	lastX = pacMan.getX();
	lastY= pacMan.getY();
	
   if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
	   if(!collide)
        pacMan.setY(pacMan.getY()-5);
    } else if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
 	   if(!collide)
        pacMan.setY(pacMan.getY()+5);
    } else if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
 	   if(!collide)
    	pacMan.setX(pacMan.getX()-5);
    } else if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
 	   if(!collide)
    	pacMan.setX(pacMan.getX()+5);
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
    private static boolean isCollisionOnVertical(Bat bat){
    	
    	if((pacMan.getY() + pacMan.getHeight() >= bat.getY() && pacMan.getY() <= bat.getY()) ||
    			(pacMan.getY()  <= bat.getY() +bat.getHeight() && pacMan.getY() >= bat.getY())) 
        {
    		return true;
    	}
    	return false;
    }
    
private static boolean isCollisionOnHorizontal(Bat bat){
    	
    	if((pacMan.getX() <= bat.getX()+bat.getWidth()  && pacMan.getX()  >= bat.getX()) ||
    			(pacMan.getX() + pacMan.getWidth() <= bat.getX()+bat.getWidth()  && pacMan.getX() + pacMan.getWidth()  >= bat.getX())) 
        {
    		return true;
    	}
    	return false;
    }
    
private static boolean isCollision(){
	
	for(int i=0; i<bat.size();i++){
	if(isCollisionOnHorizontal(bat.get(i)) && isCollisionOnVertical(bat.get(i)))
		return true;
		}
	return false;
}
    private static void logic(int delta) {
    	
        pacMan.update(delta);
        for(int i=0; i<bat.size(); i++){
        	bat.get(i).update(delta);
        }
        
        	if(isCollision()){
        		pacMan.setX(lastX);
            	pacMan.setY(lastY);

        	}
    }
    
}
