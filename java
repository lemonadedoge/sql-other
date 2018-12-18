/*  Chapter No. 6 Exercise No. 2
	File Name: A6_P2_Yang_Lucy.java
	Programmer: Lucy Yang
	Date Last Modified: September 27, 2016
	Problem Statement: - Ask the user to enter the amount of money he or she wants to enter into the slot machine.

- Instead of displaying images, have the program randomly select a word from the following list: 
Cherries, Oranges, Plums, Bells, Melons, Bars

(To select a word, the program can generate a random number in the range of 0 through 5. 
If the number is 0, the selected word is Cherries, if the number is 1, the selected word is Oranges, and so forth. 
The program should randomly select a word from the list three times and display all three of the words.)

- If none of the randomly selected words match, the program informs the user that he or she has won $0. 
If two of the words match, the program informs the user that he or she has won two times the amount entered. 
If three of the words match, the program informs the user that he or she has won three times the amount entered.

- The program asks if the user wants to play again. If so, these steps are repeated. 
If not, the program displays the total amount of money entered into the slot machine and the total amount won.

	Overall Plan:
	1) declare variables, create instances of scanner and random classes                      
	2) create while loop which ends with user input other than 'Y'
	3) get input from user and accumulate total money bet
	4) generate one of the words randomly with if/else statement and random number
	5) if/else statement to determine how much bet should be multipled by
	6) calculate how much money won or lost and accumulate winnnings
	7) display results

	Classes needed and Purpose: ‘java.util’ will be needed for general purpose
	input and output from the terminal
*/
// import the java utility package for the Scanner class
import java.util.*;
public class A6_P2_Yang_Lucy
{
	public static void main(String[] args)
	{
		//declare variables 
		String s1,s2,s3;
		int bet,i,payMultiplier,totalbet=0,totalwin=0;
		char again;
		
		//Create an instance of Scanner class
		Scanner in = new Scanner(System.in);
		
		//creating an object from the random class
		Random r=new Random();
		
		//initiate first while loop
		again='Y';
		while(Character.toUpperCase(again)=='Y')
		{	
			//prompt user for number 
			System.out.print("How much are you betting? ");
			bet=in.nextInt();
			in.nextLine();
			
			//accumulator for total bet
			totalbet+=bet;
			
			//get three random words
			s1=Pullone(r);
			s2=Pullone(r);
			s3=Pullone(r);
			
			//display words	
			System.out.println(s1);
			System.out.println(s2);
			System.out.println(s3);
			
			//call GetPayMultiplier
			payMultiplier= GetPayMultiplier( s1, s2, s3);
			
			//accumulator for total won
			totalwin+=Display(bet,payMultiplier);
			
			//prompts user for input
			System.out.print("Another game (Y/N)? ");
			again=in.nextLine().charAt(0);
		}
		
	//display results
	System.out.println("Total amount bet: $"+totalbet);
	System.out.println("Total amout won: $"+totalwin);
	System.out.println("For a net win of: $"+(totalwin-totalbet));
	
	}

	
	public static String Pullone(Random r)
	{
		//declare variables 
		int index;
		
		//get random from 0-5
		index=r.nextInt(6);
		
		//get random word from random number and return it
		if(index==0)
		return "cherries";
		else if(index==1)
		return "oranges ";
		else if(index==2)
		return "plums";
		else if(index==3)
		return "bells";
		else if(index==4)
		return "melons";
		else
		return "bars";
	
	}
	
	public static int GetPayMultiplier(String s1, String s2, String s3)
	{
		//declare variables 
		int num;
		
		//check if which words are the same and return multiplier needed for results
		if(s1==s2&&s2==s3)
		{
			//display
			System.out.println("You won triple your money");
			return 3;
		}
		else
		if(s1==s2||s2==s3||s1==s3)
		{
			//display
			System.out.println("You won double your money");
			return 2;
		}
		else
		return 0;
	}
	
	public static int Display(int bet,int payMultiplier)	
	{
		//declare variables
		int win;
		
		//calculate amount win	
		win=bet*payMultiplier;
		
		//display if lost or how much money won
		if(payMultiplier==0)
		
		//display
		System.out.println("Sorry, you lose");
		else
		
		//display winnings
		System.out.println("You won $"+win);
		
		//return amount won
		return win;
	}
}
