//Amanda Nguyen Problem 2 Point of Sale System

import java.util.Scanner;

public class PointOfSaleSystem{
	public static void main(String[] args){
		Scanner inputScanner = new Scanner(System.in);
			int number_testcase = inputScanner.nextInt();
			inputScanner.nextLine();
				double regburger = 1.50;
				double regcheese = 1.75;
				double fish = 2.50;
				double halflbcheese = 2.75;
				double fries = 0.99;
				double lrgdrink = 1.25;
				double tax = 0.065;
				double total = 0;
				double price = 0;


			for(int j=0; j<number_testcase;j++){
				String r = inputScanner.nextLine();
				Scanner d = new Scanner(r);


				
				while (d.hasNextInt()){
					int item = d.nextInt();

				switch (item) {
					case 1:
						item = 1;
						total += regburger;
						break;
					case 2:
						item = 2;
						total += regcheese;
						break;
					case 3:
						item = 3;
						total += fish;
						break;
					case 4:
						item = 4;
						total += halflbcheese;
						break;
					case 5:
						item = 5;
						total += fries;
						break;
					case 6:
						item = 6;
						total += lrgdrink;
						break;


						}
					}
			}
			price +=(total*tax+total);
			double round = Math.round(price*100.0)/100.0;
			System.out.println("Please pay $" + String.format("%.2f",round));
			System.out.println("Thank you for eating at McDowell's!");
		}

	}
