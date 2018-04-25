import java.util.Scanner;

public class fizzbuzz {
  public static void main(String[] args){
	
	  Scanner in = new Scanner(System.in);
	 
	  System.out.println("Enter input");
       int input = in.nextInt();
	  
	if (input % 3 == 0){
		if (input % 5 == 0){
			System.out.printf("fizzbuzz");
		}
		else {
			System.out.println("fizz");
		}
		
	}
	else if (input % 5 == 0){
		System.out.println("buzz");}

  }
    }
