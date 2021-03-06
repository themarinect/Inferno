package models.Item;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class CombatItem extends Item
{
	private String associatedPuzzle;
	private String usage;
	
	public CombatItem()
	{

	}
	
	public static CombatItem readCombatItem(BufferedReader reader)
	{
		CombatItem combatItem = new CombatItem();
		try
		{
			String line = reader.readLine();
			if(line == null)
				return null;
			combatItem.setItemID(line);
			combatItem.setItemName(reader.readLine());
			combatItem.setItemType(reader.readLine());
			
			//reads description
			line = reader.readLine();
			ArrayList<String> itemDescList = new ArrayList<String>(); 
			String[] temp = null;
			itemDescList.add(line);
			temp = new String[itemDescList.size()];
			int i = 0;
			for(String descLine : itemDescList)
				temp[i++] = descLine;
			combatItem.setItemDesc(temp);
			
			//reads location(s)
			while(true)
			{
				String data = reader.readLine();
				if(data.equals("-----"))
					break;
				String[] location = data.split("/",-2);
				ArrayList<String> locationList = new ArrayList<>();
				for(String a : location)
					locationList.add(a);
				combatItem.setItemLocation(locationList);
			}
			/*-------------------------------------------------------*/
			
			//read associated Puzzle
			line = reader.readLine();
			combatItem.associatedPuzzle = line;
			
			//reads usage
			while(true)
			{
				line = reader.readLine();
				if(line == null || line.equals(""))
					break;
				line = line.trim();
				int colon = line.indexOf(":");
				combatItem.setUsage(line.substring(colon+1).trim());
			}
		}catch (IOException ex)
		{
			ex.getMessage();
		}catch (NumberFormatException ex)
		{
			ex.getMessage();
		}
		
		return combatItem;
	}
	
	//getter and setters
	public String getAssociatedPuzzle()
	{
		return associatedPuzzle;
	}
	
	public String getUsage()
	{
		return usage;
	}

	public void setUsage(String usage)
	{
		this.usage = usage;
	}
}
