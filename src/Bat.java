import static org.lwjgl.opengl.GL11.*;

public class Bat extends AbstractMovableEntity {

	public Bat(double x, double y, double width, double height) {
        super(x, y, width, height);
	}
	
	 @Override
     public void draw() {
		 double x = getX();
		 double y = getY();
         glRectd(x, y, x + width, y + height);

	 }
}
