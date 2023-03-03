package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private String loc;
	public SpreadsheetLocation(String loc)
	{
		this.loc = loc.toUpperCase();
	}
    @Override
    public int getRow()
    {
        // TODO Auto-generated method stub
    	int row = Integer.parseInt(loc.substring(1)) - 1;
    	
        return row;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
    	String letter = loc.substring(0,1);
    	
    	int col = Spreadsheet.getColumnNumberFromColumnLetter(letter);
        return col;
    }
    
  
}
