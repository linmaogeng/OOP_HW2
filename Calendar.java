import java.util.Scanner;

/**
 * 
 */

/**
 * @author MaoGeng Lin
 *
 */
public class Calendar {

	protected int year,day,numDays,month;
	
	public Calendar(int year, int day) {
		this.year = year;
		this.day = day%7;
		if(this.day<0) {
			this.day=7+this.day;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner userInput = new Scanner(System.in);
		Calendar calendar;
		int year,day;
		String 	input, 
				askForYear = "Please enter your desire year->", 
				askForDay = "Please tell me, what day does the first of January fell on ->",
				invalidInput = " is not a valid input";
		System.out.print(askForYear);
		while(userInput.hasNext()) {
			if(userInput.hasNextInt()) {
				
				year = userInput.nextInt();
				System.out.print(askForDay);
				
				while(userInput.hasNext()) {
					input = userInput.next();
					day = shift(input);
					if(day!=-1) {
						calendar = new Calendar(year,day);
						calendar.print();
						System.out.print(askForYear);
						break;
					}
					
					else {
						System.out.println(input + invalidInput);
						System.out.print(askForDay);
					}
				}
			}
			
			else {
				System.out.print(userInput.next() + invalidInput);
				System.out.print(askForYear);
			}
		}
		userInput.close();
		System.out.println("Program halfed by user.");
		System.exit(0);
	}
	
	public void print() {
		int offSet,shift;
		String title,header = "Su Mo Tu We Th Fr Sa";
		String[] nameOfMonth = {"January", 
								"February", 
								"March", 
								"April", 
								"May", 
								"June", 
								"July", 
								"August", 
								"September", 
								"October", 
								"November", 
								"December"};
		shift = day;
		
		for(month=1;month<=12;month++) {
			if(year>0) {
				title = nameOfMonth[month-1] + " " + year;
			}
			
			else {
				title = nameOfMonth[month-1] + " " + (year-1)*-1 + "(BC)";	
			}
			
			offSet = 10 + title.length()/2;
			System.out.printf("\n\n%" + offSet + "s\n%s\n", title,header);
			
			
			offSet= shift;
			if(offSet>0) {
				System.out.printf("%" + offSet*3 + "s", " ");
			}
			getNumOfDays();
			int i;
			for(i=1;i<=numDays;i++) {
				System.out.printf("%2s ",i);
				
				if((offSet+i)%7==0){
					System.out.print("\n");
				}
			}
			shift = (offSet + --i)%7;
		}
		System.out.println("\n");
	}
	
	private void getNumOfDays() {
			switch(month) {						//refer to https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html
	        case 4: 
	        case 6:
	        case 9: 
	        case 11:
	            numDays = 30;
	            break;
	            
	        case 2:
	            if (year%4 == 0 && year%100 != 0 || year%400 == 0)
	                numDays = 29;
	            else
	                numDays = 28;
	            break;
	       
	        default:
	        	numDays = 31;
	            break;
		}
	}
	
	
	public static int shift(String name) {

		switch(name.toLowerCase()) {
			case "monday":
			case "mon":
			case "mo":
			case "m":
				return 1;
			
			case "tuesday":
			case "tus":
			case "tu":
				return 2;

			case "wednesday" :
			case "wed":
			case "we":
			case "w":
				return 3;
				
			case "thursday" :
			case "thur":
			case "thu":
			case "th":
				return 4;
			
			case "friday" :
			case "fri" :
			case "fr" :
			case "f":
				return 5;
			
			case "saturday" :
			case "sat" :
			case "sa":
				return 6;
			
			case "sunday" :
			case "sun" :
			case "su" :
				return 0;
				
			default:
				return -1;
		}
	}
}
