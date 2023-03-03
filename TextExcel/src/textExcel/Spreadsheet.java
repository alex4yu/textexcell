package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{

	//Override
	private Cell[][] excel;
	private HistoryStore history;
	private boolean recordingHistory;
	public Spreadsheet()
	{
		excel = new Cell[20][12];
		
		for (int i = 0; i < 20; i++)
		{
			for(int j = 0; j < 12; j++)
			{
				excel[i][j] = new EmptyCell();
			}
		}	
		recordingHistory = false;
	}
	
	public String processCommand(String command)
	{
		// TODO Auto-generated method stub
		String r = "";
		boolean historyCalled = false;
		// check clear all command
		if (command.length() == 5 && command.substring(0, 5).toUpperCase().equals("CLEAR"))
		{
			for (int i = 0; i < 20; i++)
			{
				for(int j = 0; j < 12; j++)
				{
					excel[i][j] = new EmptyCell();
				}
			}		
			r = getGridText();
		}
		// check clear specific cell
		else if (command.length() > 6 && command.substring(0, 5).toUpperCase().equals("CLEAR"))
		{
			SpreadsheetLocation location = new SpreadsheetLocation(command.substring(command.indexOf(" ") + 1));
			
			excel[location.getRow()][location.getCol()] = new EmptyCell();
			
			r = getGridText();
		}
		// check text cell command
		else if (command.indexOf("\"") != -1)
		{
			SpreadsheetLocation location = new SpreadsheetLocation(command.substring(0, command.indexOf("=") - 1));
			
			excel[location.getRow()][location.getCol()] = new TextCell(command.substring(command.indexOf("\"")));
			
			r = getGridText();
		}
		// check return cell at location
		else if (command.length() == 3 || command.length() == 2)
		{
			SpreadsheetLocation location = new SpreadsheetLocation(command);
			r = excel[location.getRow()][location.getCol()].fullCellText();
		}
		// check for formula cell 
		else if (command.indexOf("(") != -1)
		{
			SpreadsheetLocation location = new SpreadsheetLocation(command.substring(0, command.indexOf("=") - 1));
			
			excel[location.getRow()][location.getCol()] = new FormulaCell(command.substring(command.indexOf("=") + 2));
			
			r = getGridText();
		}
		// check for percent cell
		else if (command.indexOf(".") != -1 && command.indexOf("%") != -1)
		{
			SpreadsheetLocation location = new SpreadsheetLocation(command.substring(0, command.indexOf("=") - 1));
			
			excel[location.getRow()][location.getCol()] = new PercentCell(command.substring(command.indexOf("=") + 2, command.length() - 1));
			
			r = getGridText();
		}
		// check for value cell, would be an else statement except
		// that I attempted the history extra credit which introduced
		// a bunch more commands to check
		else if (command.indexOf("=") != -1)
		{
			SpreadsheetLocation location = new SpreadsheetLocation(command.substring(0, command.indexOf("=") - 1));
			
			excel[location.getRow()][location.getCol()] = new ValueCell(command.substring(command.indexOf("=") + 2));
			
			r = getGridText();
		}
		
		else if (command.indexOf("history start") != -1)
		{
			int n = Integer.parseInt(command.substring(14));
			historyCalled = true;
			history = new HistoryStore(n);
			recordingHistory = true;
		}
		else if (command.indexOf("history displa") != -1)
		{
			r = history.getHistory();
			historyCalled = true;
		}
		else if (command.indexOf("history clea") != -1)
		{
			history.historyClear(Integer.parseInt(command.substring(14)));
			historyCalled = true;
		}
		else if (command.indexOf("history sto") != -1)
		{
			recordingHistory = false;
			history.historyStop();		
			historyCalled = true;
		}
		if (recordingHistory == true && historyCalled == false)
		{
			history.store(command);
		}
		return r;
	}

	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return excel.length;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return excel[0].length;
	}

	@Override
	public Cell getCell(Location loc)
	{
		// TODO Auto-generated method stub
		return excel[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
		String r = Spreadsheet.addSpace(3)+"|";
		for (int i = 0; i < 12; i++)
		{
			r = r + Spreadsheet.getColumnLetterFromColumnNumber(i) + Spreadsheet.addSpace(9)+"|";
		}
		r = r + "\n";
		for (int row = 1; row <= 20; row++)
		{
			if (row >= 10)
			{
				r = r + row + Spreadsheet.addSpace(1)+"|";
			}
			else
			{
				r = r + row + Spreadsheet.addSpace(2)+"|";
			}
			for (int col = 1; col <= 12; col++)
			{
				
				r = r + excel[row-1][col-1].abbreviatedCellText()+"|";
			}
			r = r + "\n";
					
		}
		return r;
	}
	
	// You are free to use this helper method.  It takes a column letter (starting at "A")
	// and returns the column number corresponding to that letter (0 for "A", 1 for "B", etc.)  
	// WARNING!!  If the parameter is not a single, capital letter in the range of your Spreadsheet,
	// bad things might happen!
	public static int getColumnNumberFromColumnLetter(String columnLetter)
	{
		return Character.toUpperCase(columnLetter.charAt(0)) - 'A';
	}

	// You are free to use this helper method.  It takes a column number (starting at 0)
	// and returns the column letter corresponding to that number ("A" for 0, "B" for 1, etc.)
	// WARNING!!  If the parameter is not a number in the range of your Spreadsheet,
	// bad things might happen!
	public static String getColumnLetterFromColumnNumber(int columnNumber)
	{
		return "" + (char) ('A' + columnNumber);
	}
	
	// Adds spaces for you so you don't have to count yourself.
	public static String addSpace(int numOfSpace)
	{
		String r = "";
		
		for (int i = 1; i <= numOfSpace; i++)
		{
			r += " ";
		}
		
		return r;
	}
	
}
