package textExcel;

public class HistoryStore
{
	private String[] HistoryList;
	
	public HistoryStore(int n)
	{
		HistoryList = new String[n];
		for (int i = 0; i < HistoryList.length; i++)
		{
			HistoryList[i] = "";
			
		}
	}
	
	public void store(String s)
	{
		String placeholder = HistoryList[0];
		for (int i = 1; i < HistoryList.length; i++ )
		{
			String anotherplaceholder = HistoryList[i];
			HistoryList[i] = placeholder;
			placeholder = anotherplaceholder;
		}
		HistoryList[0] = s;
	}
	
	public String getHistory()
	{
		String r = "";
		for (int i = 0; i < HistoryList.length; i++)
		{
			if (HistoryList[i] != "") 
			{
				r = r + HistoryList[i] + "\n";
			}
			
		}
		return r;		
	}
	
	public void historyStop()
	{
		for (int i = 0; i < HistoryList.length; i++)
		{
			HistoryList[i] = "";
		}
	}
	
	public void historyClear(int n)
	{
		boolean command = true;
		int i = 0;
		while (command)
		{
			
			if (HistoryList[i].equals(""))
			{
				command = false;
			}
			else if (i >= HistoryList.length - 1)
			{
				command = false;
				i++;
			}
			else
			{
				i++;
			}
		}
		i--;
		for (int j = 0; j < n; i--)
		{
			if (i >= 0)
			{
				HistoryList[i] = "";
			}
			j++;
		}
	}
	
}
