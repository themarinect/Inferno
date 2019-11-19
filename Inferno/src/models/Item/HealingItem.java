package models.Item;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class HealingItem extends Item
{

	private String strength;
	
	public HealingItem()
	{
		
	}

	public HealingItem(String _itemID, String _itemName, String _itemType, String[] _itemDesc,
			ArrayList<String> _itemLocation, String _strength)
	{
		super(_itemID, _itemName, _itemType, _itemDesc, _itemLocation);
		this.strength = _strength;
	}

	public static HealingItem readHealingItem(BufferedReader reader)
	{
		HealingItem healingItem = new HealingItem();
		try
		{
			String line = reader.readLine();
			if(line == null)
				return null;
			healingItem.setItemID(line);
			healingItem.setItemName(reader.readLine());
			healingItem.setItemType(reader.readLine());
			
			//reads description
			line = reader.readLine();
			ArrayList<String> itemDescList = new ArrayList<String>(); 
			String[] temp = null;
			itemDescList.add(line);
			temp = new String[itemDescList.size()];
			int i = 0;
			for(String descLine : itemDescList)
				temp[i++] = descLine;
			healingItem.setItemDesc(temp);
			
			//reads location(s)
			String data = reader.readLine();
			String[] location = data.split("/",-2);
			ArrayList<String> locationList = new ArrayList<>();
			for(String a : location)
				locationList.add(a);
			healingItem.setItemLocation(locationList);
			
			/*-------------------------------------------------------*/
			
			//reads strength
			while(true)
			{
				line = reader.readLine();
				if(line == null || line.equals(""))
					break;
				line = line.trim();
				int colon = line.indexOf(":");
				healingItem.strength = line.substring(colon+1).trim();
				//healingItem.setStrength(Integer.parseInt( line.substring(colon+1).trim()));
			}
		}catch (IOException ex)
		{
			ex.getMessage();
		}catch (NumberFormatException ex)
		{
			ex.getMessage();
		}
		
		return healingItem;
	}
	
	//getters and setters
	public String getStrength()
	{
		return strength;
	}

	public void setStrength(String strength)
	{
		this.strength = strength;
	}

}
