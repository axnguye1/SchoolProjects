//Amanda Nguyen Problem 6 FizzBuzz
import java.util.Scanner;
public class FizzBuzz{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
			
			input.nextLine();

			for(int test=0; test<cases; test++){
			int number = input.nextInt();
			if( number % 3  == 0 && number % 5 != 0) {
				System.out.println("fizz"); 
			}
			else if( number % 3  != 0 && number % 5 == 0){
				System.out.println("buzz"); 
			}
			else if( number % 3  != 0 && number % 5 != 0){
				System.out.println(number); 
			}
			else if( number % 3  == 0 && number % 5 == 0){
				System.out.println("fizzbuzz"); 
			}
							
			
					
		}

	}
}