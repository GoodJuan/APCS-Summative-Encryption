import java.util.Scanner;


public class EnigmaRunner {

	public static void main(String[] args) {
		
		//I couldn't think of a name for my object... So I just used sausage.
		Enigma sausage = new Enigma();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please input a sentence you would like to encrypt.");
		String meme = input.nextLine();
		
		System.out.println("There are 2 encryption functions.\n"
						 + "Please enter 1) for encryption 1, or 2) for encryption 2.");
		int choice = input.nextInt();
		
		if (choice == 1){
			System.out.println("\nHere is your encrypted string: " + sausage.encrypt1(meme) + "\n");
			System.out.println("Would you like to 1) decrypt that string now? 2) Or would you like to exit?");
			int choice2 = input.nextInt();
			if (choice2 ==  1) {
				System.out.println("\nHere is your decrypted string: " + sausage.decrypt1(sausage.encrypt1(meme)) + "\n");
			}
			else {
				System.out.print("Bye!");
				System.exit(0);
			}
			
		}
		else {
			System.out.println("\nHere is your encrypted string: " + sausage.encrypt2(meme));
			System.out.println("Would you like to 1) decrypt that string now? 2) Or would you like to exit?");
			int choice2 = input.nextInt();
			if (choice2 ==  1) {
				System.out.println("\nHere is your decrypted string: " + sausage.decrypt2(sausage.encrypt2(meme)));
				
			}
			else {
				System.out.print("Bye!");
				System.exit(0);
			}
		}
		 

	}

}
