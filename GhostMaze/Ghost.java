
import java.util.Random;

public class Ghost {
	public static final int TILE_SIZE = 32;
	private static int x;
	private static int y;
	private static String image;
	private static long time;

	//String[] ghosts = {"Ghost", "Ghost2", "Ghost3"};


	public static void start(int x, int y){
		Ghost.x = x;
		Ghost.y = y;
		image = "Assets/Ghost.png";
		time = System.currentTimeMillis();

	}
	public static void draw() {
		int tileX = x * TILE_SIZE + TILE_SIZE/2;
		int tileY = y * TILE_SIZE + TILE_SIZE/2;
		StdDraw.picture(tileX, tileY, image);
	}


	public static void move() {
		int choice = (int) (Math.random()*4);

		if ( (choice == 0) && Scene.canMove(x,y-1)){
				y--;
			}
			else if ((choice == 1) && Scene.canMove(x,y+1)) {
				y++;
			}
			else if ((choice == 2) && Scene.canMove(x-1,y)) {
				x--;
			}
			else if ((choice == 3) && Scene.canMove(x+1,y)) {
				x++;
			}
		time = System.currentTimeMillis();						
		}
	public static void update() {
		//randomize ghost movement , every 3-5 seconds or something. 
		//use array to have multiple ghosts on map
		long now = System.currentTimeMillis();
		if (now - time > 1000){
			Ghost.move();
		}
		
	}		

	public static int getX() {
		return x;
	}
	public static int getY() {
		return y;
	}
	
}