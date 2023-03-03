package textExcel;

public class RealCell implements Cell
{
	private String s;
	public RealCell(String string)
	{
		s=string;
	}
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
	public String toString()
	{
		return s;
	}
}
