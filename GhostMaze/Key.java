public class Key {
	public static final int TILE_SIZE = 32;
	private static int x;
	private static int y;
	private static String image;

	public static void start(int x, int y) {
		Key.x = x;
		Key.y = y;
		image = "Assets/Key.png";
	}

	public static void draw() {
		int tileX = x * TILE_SIZE + TILE_SIZE/2;
		int tileY = y * TILE_SIZE + TILE_SIZE/2;
		StdDraw.picture(tileX, tileY, image);
	}
	public static int getX() {
		return x;
	}
	public static int getY() {
		return y;
	}	
}