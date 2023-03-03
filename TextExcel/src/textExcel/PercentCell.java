package textExcel;

public class PercentCell extends RealCell
{
	public PercentCell(String string)
	{
		super(string);
	}
	public String abbreviatedCellText()
	{
		String r = super.toString();
		r = r.substring(0, r.indexOf("."));
		r = r + "%";
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
		String percent = super.toString();
		String beforeDecimal = percent.substring(0, percent.indexOf("."));
		String afterDecimal = percent.substring(percent.indexOf(".") + 1);
		String r="";
		
		if (beforeDecimal.length() >= 3)
		{
			String printBeforeDec = beforeDecimal.substring(0, beforeDecimal.length() - 2);
			String afterdec = beforeDecimal.substring(beforeDecimal.length() - 2) + afterDecimal;
			r = printBeforeDec + "." + afterdec;
		}
		
		else if (beforeDecimal.length() == 2)
		{
			r = "0." + beforeDecimal + afterDecimal;
		}
		else if (beforeDecimal.length() == 1)
		{
			r = "0.0" + beforeDecimal + afterDecimal;
		}

		return r;
	}
	
	public double getDoubleValue()
	{
		double decimalForm = Double.parseDouble(super.toString());
		decimalForm /= 100; 
		return decimalForm;
		
	}
}
