package textExcel;

public class ValueCell extends RealCell
{
	
	public ValueCell(String string)
	{
		super(string);
	}
	public String abbreviatedCellText()
	{
		String r = super.toString();
		
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
		return super.toString();
	}
	
	public double getDoubleValue()
	{
		return Double.parseDouble(super.toString());
	}
}
