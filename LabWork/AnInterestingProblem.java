//Amanda Nguyen Problem 3 An Interesting Problem
import java.util.Scanner;
public class AnInterestingProblem{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        input.nextLine();
        int balance = 1000000;
        int time = 1;

        for(int test = 0; test<cases; test++){
            String sequence = input.nextLine();
            Scanner reader = new Scanner(sequence); 
            while (reader.hasNextInt()){
                double deposit = reader.nextDouble();          
                double rate = reader.nextDouble();       
                double rate2 = (rate / 100);
                double amount = 0;
               
               for(time = 1; amount <= balance; time++){
                    amount = deposit*Math.pow(1 + rate2, time);
               } 
     
               
              if (deposit < 1000000){
               System.out.println((time - 1) + " years");   
               }
               else if(deposit >= 1000000){
               	System.out.println("0 years");
               }                  
            }    
        }  
    }
}


