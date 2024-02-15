//Amanda Nguyen Problem 3 Point2D
public class Point2D{
	private double x;
	private double y;

	public Point2D(double x, double y){
		this.x = x;
		this.y = y;
	}
	public double getX() {return this.x;}
	public double getY() {return this.y;}

	public void moveTo(double x, double y){
		this.x = x;
		this.y = y;

	}public void moveBy(double dx, double dy){
		this.x += dx;
		this.y += dy;

	} public double distance(Point2D other){
	double dx = other.getX() - this.getX();
	double dy = other.getY() - this.getY();
	return Math.sqrt(dx*dx + dy*dy);

	}public String toString() {
		return String.format("(%.1f,%.1f)",x,y);
	}
}