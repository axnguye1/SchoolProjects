public class Controller2 {
	private Dog dog;
	private static double x;
	private static double y;

	

	public Controller2( Dog dog){
		this.dog = dog;
	}

	
	public void moveDog() {
		if (StdDraw.hasNextKeyTyped() == true) {

			double dogX = dog.getX();
			double dogY = dog.getY();
			char key = StdDraw.nextKeyTyped();

			if (key == 'a') dogX-= dog.getSpeed();
			if (key == 'd') dogX+= dog.getSpeed();
			dog.move(dogX,dogY);
				
				
			
			}
		}
	
	
	public void update(){
		
		moveDog();
	}
}
