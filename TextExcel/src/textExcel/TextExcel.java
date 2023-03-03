package textExcel;

import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
	    // Add your command loop here
		Spreadsheet spreadsheet = new Spreadsheet();
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		while (!(input.equals("quit")))
		{
			if (input.equals(""))
			{
				
			}
			
			else
			{
				String print = spreadsheet.processCommand(input);
				System.out.println(print);
			}
			
			input = scanner.nextLine();
		}
	}
}
