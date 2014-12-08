import java.awt.*;


public class AbstractEntity implements Entity {

    double x;
    double y;
    double width;
    double height;
    private final Rectangle hitbox = new Rectangle();

    AbstractEntity(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public boolean intersects(Entity other) {
        hitbox.setBounds((int) x, (int) y, (int) width, (int) height);
        return hitbox.intersects(other.getX(), other.getY(), other.getWidth(), other.getHeight());
    }

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(int delta) {
		// TODO Auto-generated method stub
		
	}
}
