import java.util.Scanner;

/**
 * 
 */

/**
 * @author MaoGeng Lin
 *
 */
public class Pyramid {

	private int height;
	
	Pyramid(int height){	
		this.height = height;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int height=1;
		Pyramid pyramid;
		Scanner userInput = new Scanner(System.in);
		String prompt = "\nPlease enter the height of thePyramid to continue-> ";
		System.out.print(prompt);

		
		while(userInput.hasNext()) {
			
			if(userInput.hasNextInt()) {
				height = userInput.nextInt(); 
				System.out.println("Here is your Pyramid with height " + height);
				pyramid = new Pyramid(height);
				pyramid.print();
				System.out.print(prompt);
			}
			
			else {
				System.out.println("We can't form a Pyramid with " + userInput.next());
				System.out.print(prompt);
			}
		}
		userInput.close();
		System.out.println("\nProgram halted by user");
		System.exit(0);
	}
		
	public void print() {
		
		//int width=2,line,num,i;
		int headSpace,width,num,i,breakPoint;
		Integer level;
		String header,defaultFormat;
		
		if(height>0) {
			level = height;
			breakPoint = level;
			i=0;
		}
		
		else {
			level = height*-1;
			breakPoint = -1;
			i=level-1;
		}
		
		width = level.toString().length()+1;
		defaultFormat = "%" + width + "d";
		System.out.print("\n");

		while(i!=breakPoint) {
			headSpace = (level-i)*width-1;
			header = "%" + headSpace + "d";
			System.out.printf(header, 1);
			
			for(num=2;num-2<i;num++) {
				System.out.printf(defaultFormat,num);
			}
			
			while(num>2) {
				System.out.printf(defaultFormat,num-2);
				num--;
			}
			
			System.out.print("\n");
			if(height>0) {
				i++;
			}
			
			else {
				i--;
			}
		}
		/*
		if(width > 1) {
			width = (width*-1)-1;
		}
		
		else {
			width = -2;
		}
		
		String defaultFormat = "%"+ width +"s";
		line=num=1;
		
		while(line<=height) {
			for(i=height; i>=1; i--) {
				if(i>line) {
					System.out.printf(defaultFormat, "");
				}
				else {
					System.out.printf(defaultFormat, num++);
				}
			}
			
			num--;
			
			while(num>1) {
				System.out.printf(defaultFormat, --num);
			}
			
			line++;
			System.out.print("\n");
		}
		*/
	}

}
