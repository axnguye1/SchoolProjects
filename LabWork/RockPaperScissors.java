//Amanda Nguyen Problem 7 Rock Paper Scissors
import java.util.Scanner;
public class RockPaperScissors{
	public static void main(String[] args){

		Scanner in = new Scanner(System.in);
		int number_testcase = in.nextInt();
		
		String player1="";
		String player2="";

		for(int j=0; j<number_testcase;j++){

		 	player1 = in.next();

			player2 = in.next();
		

		if(player1.equals(player2)){
			System.out.println("Tie!");
		}
		else if(((player1.equals("rock")) && player2.equals("scissors")) || ((player1.equals("paper")) && player2.equals("rock")) || ((player1.equals("scissors")) && player2.equals("paper"))){
			System.out.println("Player 1 wins!");
		}
		else if(((player1.equals("scissors")) && player2.equals("rock")) || ((player1.equals("rock")) && player2.equals("paper")) || ((player1.equals("paper")) && player2.equals("scissors"))){
			System.out.println("Player 2 wins!");
		}
		}
	}
}
