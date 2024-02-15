//Amanda Nguyen Problem 7 Simple Calculator
import java.util.Scanner;
public class SimpleCalculator{
	public static void main(String args[] ){
		Scanner input = new Scanner(System.in);
		String operator;
		int num1, num2, result;

		
		
int cases = input.nextInt();
for(int test=0; test<cases; test++){
	
		num1 = input.nextInt();
		operator = input.next();
		num2 = input.nextInt();

		switch (operator) {
		case "+":
			result = num1 + num2;
			System.out.println(result);
			break;

		case "-":
			result = num1 - num2;
			System.out.println(result);
			break;

		case "*":
			result = num1 * num2;
			System.out.println(result);
			break;	

		case "/":
			result = num1 / num2;
			System.out.println(result);
			break;

		case "%":
			result = num1 % num2;
			System.out.println(result);
			break;

		case "**":
			result = (int)Math.pow(num1,num2);
			System.out.println(result);
			break;
		}

		}
	}
}