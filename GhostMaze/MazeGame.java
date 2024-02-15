
public class MazeGame {
private static boolean gameOver;
private static int level;
private static boolean gotKey;
private static boolean takeDamage;

public static void main(String[] args) {
	start();

	while (gameOver == false) {
		update();
		render();
		
	}
}
	public static void start() {
	gameOver = false;
	level = 0;
	World.start();
	Scene.start(level);
		}

	public static void update() {
		Ghost.move();
		Player.update();
		Ghost.update();
		Ghost2.move();
		Ghost2.update();
		Ghost3.move();
		Ghost3.update();
		
		
		
	if (Player.getX() == Key.getX() && Player.getY() == Key.getY() ) {
				gotKey = true;
				System.out.println("You got the Key! Get to the Exit!");
			}
	if (Player.getX() == Ghost.getX() && Player.getY() == Ghost.getY() ){
		gameOver = true;
				System.out.println("Game Over. You Died.");
			}
	if (Player.getX() == Ghost2.getX() && Player.getY() == Ghost2.getY() ){
		gameOver = true;
		System.out.println("Game Over. You Died.");
			}
	if (Player.getX() == Ghost3.getX() && Player.getY() == Ghost3.getY() ){
		gameOver = true;
		System.out.println("Game Over. You Died.");
			}

	if (Player.getX() == Exit.getX() && Player.getY() == Exit.getY() && gotKey== true){
			level++; 
			if (level == World.getLength() ){
				gameOver = true; 
				System.out.println("Game Over. You Escaped!");
				//System.out.println("Game Over.");
			} else {
					Scene.start(level);
					gotKey = false;
				}		
			
		}

		}

	public static void render() {
			Scene.draw();
			Exit.draw();
			Player.draw();
			if(gotKey==false){
			Key.draw();
		}
			Ghost.draw();
			Ghost2.draw();
			Ghost3.draw();
			//StdDraw.pause(1000);
			StdDraw.show(100);
			

			
		}

		




}


	
	


