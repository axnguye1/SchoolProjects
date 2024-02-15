public class Dog {
	private String image;
	private int width;
	private int height;
	private double x;
	private double y;
	private int speed;

	public Dog(double x ,double y){
		this.x = x;
		this.y = y;
		this.width=32;
		this.height=32;
		this.image="assets/spacedog.png";
		this.speed = 10;

	} public void draw() {
		StdDraw.picture(x, y, image, width, height);

	}public void move(double x,double y){
		this.y = y;
		this.x = x;

	}public double getX(){
	 return this.x; 

	} public double getY(){
	 return this.y; 

	}public double getSpeed(){
	 return this.speed; 
	}

	
	//o2 collection
	public boolean isTouching2X( Oxygen gameObject){
		int hitzone = 24;
		return this.x <= gameObject.getX()+hitzone && gameObject.getX() <= this.x+hitzone;

	}
	public boolean isTouching2Y( Oxygen gameObject){
		int hitzone = 24;
		return this.y <= gameObject.getY()+hitzone && gameObject.getY() <= this.y+hitzone;
	}
	public boolean isTouching2( Oxygen gameObject) {
		return this.isTouching2X(gameObject) && this.isTouching2Y(gameObject);
	}
	//gem
	public boolean isTouching3X( Gem gameObject){
		int hitzone = 24;
		return this.x <= gameObject.getX()+hitzone && gameObject.getX() <= this.x+hitzone;

	}
	public boolean isTouching3Y( Gem gameObject){
		int hitzone = 24;
		return this.y <= gameObject.getY()+hitzone && gameObject.getY() <= this.y+hitzone;
	}
	public boolean isTouching3( Gem gameObject) {
		return this.isTouching3X(gameObject) && this.isTouching3Y(gameObject);
	}

}