//Amanda Nguyen problem 1: Summing It Up

import java.util.Scanner;

public class SummingItUp{
	public static void main(String[] args){
		Scanner inputScanner = new Scanner(System.in);
			int number_testcase = inputScanner.nextInt();
			for(int j=0; j<number_testcase;j++)
			{
				int result=0;

				int x = inputScanner.nextInt();
				int y = inputScanner.nextInt();

				int start, end;

				if (x<y) {
						start=x;
						end=y;
				}
				else
				{
					start=y;
					end=x;
				}
				for(int i=start;i<=end;i++)
				{
					result+=i;
				}
				System.out.println(result);
			}
	}
}