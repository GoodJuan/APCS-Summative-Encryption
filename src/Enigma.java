
public class Enigma {
	
	
	public String encrypt1(String inputString){
		String message = "";
		int count = 0;
		inputString = inputString.toLowerCase();
		char[][] codeArr = new char[(int)inputString.length()/5 + 1][5];
		
		//number of:             rows                            columns
		//The 2d array that will be made will always consist of 5 columns.
		//However, the number of rows will vary depending on the length of the String.
		for (int i = 0; i < (int)inputString.length()/5 + 1; i++ ){
			for(int z = 0; z < 5; z++){
				if (count >= inputString.length()){
					
					break;
					//I did >= because length() gets the actual length, not counting 0
					//Because I'm using charAt(), I need int count to start at 0. Thus making me do >=
					//or else I'll risk being thrown an out of bounds exception.
				}
				
				codeArr[i][z] = inputString.charAt(count);
				count++;
			}
		}
		
		for (int a = 0; a < 5; a++){
			for (int b = 0; b < (int)inputString.length()/5 + 1; b++){
				message += codeArr[b][a]; 
			}

		}
		
		//printCharArray(codeArr);
		//System.out.println(message.length());
		return message;
	}
	
	public static void printCharArray(char[][] arr) {
		// TODO Auto~generated method stub
		for (char[] rows : arr){
			for (char i : rows){
				System.out.print(" " + i );
			}
			System.out.println();
		}
		
	}
	
	public String decrypt1(String inputString){
		String message = "";
		int numRow = (int)inputString.length()/5;
		int count = 0;
		char[][] codeArr = new char[numRow][5]; 
		
		for (int i = 0; i < 5; i++){
			for (int z = 0; z < numRow; z++){
				if (count >= inputString.length()){
					break;
				}
				codeArr[z][i] = inputString.charAt(count);
				count++;
			}
		}
		for (int a = 0; a < numRow; a++){
			for (int b = 0; b < 5; b++){
				message += codeArr[a][b];
			}
		}
		return message;
	}
	
	public String encrypt2(String inputString)
	{
		//This will make it so the ascii code equivalent of the char
		//in the string will be added by its index of it's string to change the char
		//as the ascii code for the char will be changed.
		//I know I didn't use .indexOf, however I'm basically using it through my for loop.
		
		String newStr = "";
		char[] charArr = new char[inputString.length()];
		String result = "";
		
		for (int i = 0; i < inputString.length(); i++){
			if (inputString.charAt(i) == ' '){
				charArr[i] = ' ';
			}
			else {
				char charOfStr = inputString.charAt(i);
				int newInt = (int) charOfStr-i;
				char newChar= (char) newInt;
				charArr[i] = newChar;
			}
		}
		
		for (int z = 0; z < inputString.length(); z++){
			newStr += charArr[z];
		}
		//Here, I swap the placing of the first half of the String with the end.
		
		String second = newStr.substring(newStr.length()/2);
		String first = newStr.substring(0, newStr.length()/2);
		
		result = second.concat(first);

		return result;
	}
	
	public String decrypt2(String inputString){
		String second = "";
		String first = "";
		
		//Here I had to add the +1 thing in case inputString's length would be odd.
		//Because I plan to split the string into 2, and the way integers work, I need to add the indexes by 1
		//to prevent bugs. I want the second substring part of the inputString to be always less than the first substring.
		
		if (inputString.length() % 2 == 1){
			second = inputString.substring(inputString.length()/2+1);
			first = inputString.substring(0, inputString.length()/2+1);
		}
		
		//Here would be the "normal" process when the length in even. 
		else {
			second = inputString.substring(inputString.length()/2);
			first = inputString.substring(0, inputString.length()/2);
		}
		
		String newStr = second.concat(first);
		String result = "";
		
		char[] charArr = new char[newStr.length()];
		
		for (int i = 0; i < newStr.length(); i++){
			if (newStr.charAt(i) == ' '){
				charArr[i] = ' ';
			}
			else {
				char charOfStr = newStr.charAt(i);
				int newInt = (int) charOfStr+i;
				char newChar= (char) newInt;
				charArr[i] = newChar;
			}
		}
		
		for (int z = 0; z < inputString.length(); z++){
			result += charArr[z];
		}
		
		return result; 
		
	}
	
	
}
