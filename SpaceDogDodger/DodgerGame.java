
public class DodgerGame {
	private Scene scene;
	private boolean isOver;
	private long startTime;
	private Controller controller;
	private Controller2 controller2;
	private int timer;
	private int oxygenleft;
	private int score;

	public DodgerGame() {
		isOver = false;
		scene = new Scene();
		startTime = System.currentTimeMillis();
		Player player = new Player(250, 187.5);
		Dog dog = new Dog(180,300);
		this.scene.setPlayer(player);
		this.scene.setDog(dog);
		controller = new Controller(player);
		controller2 = new Controller2(dog);
		this.timer = 0;
		this.oxygenleft= 150;
		this.score = 0;

	}
	public void update() {
		controller.update();
		controller2.update();
		long now = System.currentTimeMillis();
		if (now - this.startTime > 200) {
			scene.addMonster();
			this.timer++;
			this.startTime = now;
			this.oxygenleft--;
		}
		if (timer%5==0){
			scene.addTank();
			scene.addCrystal();
		}
		

		scene.update();
		Player player = scene.getPlayer();
		Dog dog = scene.getDog();

		for (Enemy monster: scene.getMonsters() ){
			if(player.isTouching(monster) ){
				isOver = true;
			}
		}
		for (Oxygen tank: scene.getTanks() ){
		if(dog.isTouching2(tank) ){
			oxygenleft += 25;

		}
		for (Gem crystal: scene.getCrystals() ){
			if(dog.isTouching3(crystal) ){
				score++;

			}
		}
	}

		if ( oxygenleft == 0){
			isOver = true;
		}

	}
	public void render() {
		scene.draw();
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(64,32,"Time: "+timer/5);
		StdDraw.text(64,64,"Oxygen: "+oxygenleft/5);
		StdDraw.text(64,96,"Score: "+score/5);
		StdDraw.show(100);

	}
	public static void main(String[] args) {
		DodgerGame game = new DodgerGame();
		while (game.isOver == false) {
			game.update();
			game.render();
		}
	}
}