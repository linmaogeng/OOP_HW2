import java.util.Scanner;

public class Palindrome {
	
	public static boolean isPalindrome(String str) {
		if(str == null) {
			return false;
		}

		int end = str.length();
		
		if(end <= 1) {
			return true;
		}

		char[] ary = str.toCharArray();


		int mid = end -->> 1;
		
		for(int i=0;i<mid;i++) {
			if(ary[i]!=ary[end-i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner userInput = new Scanner(System.in);				//refer to https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html
		boolean caseSensitive = false;
		String nextString, prompt = "Please enter your string";
		System.out.println("Please tell me if palindrome is case sensitive or not");
		nextString = userInput.next();
		
		if(nextString.toLowerCase().equals("yes")){
			caseSensitive = true;
			System.out.println("capitalization check is on!");
		}

		else{
			System.out.println("capitalization check is off!");
		}					
		
		System.out.println(prompt);
		//userInput.useDelimiter(","); Question 5
		//userInput.useDelimiter("");  Question 6
		while(userInput.hasNext()) {

			if(caseSensitive){
				nextString=userInput.next();
			}

			else{
				nextString=userInput.next().toLowerCase();
			}

			if(Palindrome.isPalindrome(nextString)) {
				System.out.println(nextString + " is a palindrome");
			}
			
			else {
				System.out.println(nextString + " is not a palindrome");
			}
			System.out.println(prompt);
		}
		userInput.close();
		System.out.println("program halted");
		System.exit(0);

	}

}
