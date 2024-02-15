//Amanda Nguyen Problem 8 Factorials
import java.util.Scanner;
import java.math.BigInteger;
public class Factorials{
	public static void main(String args[] ){
		Scanner input = new Scanner(System.in);
		int cases= input.nextInt();
		for(int test=0; test<cases; test++){

		int j = 1;
		int number = input.nextInt();
		BigInteger factorial = BigInteger.valueOf(1);
		for (j = 1; j <= number; j++)
			factorial = factorial.multiply(BigInteger.valueOf(j));
		
		System.out.println(factorial);
		}
	}
}