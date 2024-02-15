public class Game {
	public static void main(String[] args) {
	 start();//Start Game
	 while (gameOver == false){//Game Loop
	 	update();//1. update game
	 	render();//2. render game
		 }
	}

	public static void render() {
		Scene.draw();//draw scene
		Enemy.draw();//draw enemy
		Player.draw(); //draw player
		StdDraw.show();
		StdDraw.pause(400);
		StdDraw.text(64,32,"Score:" + score);
		
	}

	public static void update() {
		Enemy.move();
		Player.update();
		//check for input
		//update player
		Enemy.update();//update enemy
	}

	public static void start() {
		Scene.start();
		Enemy.start();
		Player.start();
		//setup all game data
	}

	public static void addScore(){
		score++;
	}

	private static int score = 0;
	private static boolean gameOver = false;

}

