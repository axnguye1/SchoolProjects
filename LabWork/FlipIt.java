//Amanda Nguyen Problem 7
import java.util.Scanner;
public class FlipIt {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		input.nextLine();

		for (int test=0; test<cases; test++){
			String text = input.nextLine();
			text = reverse(text);
			System.out.println(text);
		}
	}
	public static String reverse(String text){
		String reversedText = "";
		Scanner reader = new Scanner(text);
		reader.useDelimiter( "" );
		while (reader.hasNext() == true){
			reversedText = reader.next() + reversedText;
			//System.out.println(reversedText);
		}
		return reversedText;
	}
 
}