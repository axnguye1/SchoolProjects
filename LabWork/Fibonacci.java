//Amanda Nguyen Problem 9 Fibonacci
import java.util.Scanner;
public class Fibonacci
{
	public static void main(String[] args)
	{

		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();

		for(int test=0; test<cases; test++)
		{
			int position = input.nextInt();
			int num1=0;
			int num2=1;

			for(int i=2; i<position; i++)
			{
				int temp = num1;
				num1 = num2;
				num2 += temp;
			}
			int result = (position< 1) ? 0 : num1 + num2;
			System.out.println(result);

		}

	}
}