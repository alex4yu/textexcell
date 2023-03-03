package textExcel;

public class TextCell implements Cell
{
	private String string;
	public TextCell(String s)
	{
		string = s;
	}
	public String abbreviatedCellText()
	{
		String r = string;
		r = r.substring(1,r.length()-1);
		if (r.length() >= 10)
		{
			r = r.substring(0,10);
		}
		else if (r.length() < 10)
		{
			while(r.length() < 10)
			{
				r = r + " ";
			}
		}
		
		return r;
	}
	public String fullCellText()
	{
		return string;
	}
	public double getDoubleValue()
	{
		return 0;
	}
}
