package textExcel;

public class EmptyCell implements Cell
{
	public String abbreviatedCellText()
	{
		return Spreadsheet.addSpace(10);
	}
	
	public String fullCellText()
	{
		return "";
	}
	
	public double getDoubleValue()
	{
		return 0;
	}
}
