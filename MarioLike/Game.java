public class Game {
	private World world;
	private boolean isOver;
	private int level;
	private Scene scene;
	private Controller controller;

	public Game(){
		this.isOver=false;
		this.level = 0;
		world = new World();
		String[][] map = world.getLevel(level);
		this.scene = new Scene(map);
		Player player = scene.getPlayer();
		this.controller = new Controller(player);

	} public void update() {
		controller.update();
		scene.update();
		this.isOver=scene.isPlayerDead();
		if (scene.getExit().isTouching(scene.getPlayer() ) ){
			this.level++;
			if(this.level < world.getLength() ){
				String[][] map = world.getLevel(this.level);
				this.scene= new Scene(map);
				this.controller = new Controller(this.scene.getPlayer() );
			} else {
				this.isOver = true;
			}
		}


	}//end update
	 public void render() {
		scene.draw();
		StdDraw.show(10);

	}public static void main(String[] args){
		Game game = new Game();
		while (game.isOver == false){
			game.update();
			game.render();
		}
	}

}