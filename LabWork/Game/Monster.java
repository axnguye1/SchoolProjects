//Amanda Nguyen problem 5 : Monster Factory
public class Monster{
	private String name;
	private int health;
	private int strength;
	private int xp;

	public Monster(String name, int health, int strength, int xp){
		this.name = name;
		this.health = health;
		this.strength = health;
		this.xp = xp;
	}

	public String getName(){
		return name;
	}

	public int getHealth(){
		return health;
	}

	public int getStrength(){
		return strength;
	}

	public int getXp(){
		return xp;
	}
	public static Monster spawn(String monsterName){
	
		
		if(monsterName == "goblin"){
			return new Monster("goblin", 60, 8, 1);
		}

		if(monsterName == "orc"){
			return new Monster("orc", 100, 12, 3);
		}

		if(monsterName =="troll"){
			return new Monster("troll", 150, 15, 5);
		}
		
		return "monsterName"();
	}

	public void takeDamage(int damage){
		if(damage >0)
			health = health - damage;
	}

	public String toString(){
		return String.format("[%s] HP:%d. STR: %d",name,health,strength);
	}
	public void attack(Player hero){
		hero.takeDamage(this.strength);
		System.out.println(String.format("%s attacks player for %d damage",name, strength));
	}
	
}