package models.Item;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class KeyItem extends Item
{
	private String associatedMonster;

	public KeyItem()
	{
		
	}

	public KeyItem(String _itemID, String _itemName, String _itemType, String[] _itemDesc,
			ArrayList<String> _itemLocation, String _associatedMonster)
	{
		super(_itemID, _itemName, _itemType, _itemDesc, _itemLocation);
		this.setAssociatedMonster(_associatedMonster);
	}
	
	public static KeyItem readKeyItem(BufferedReader reader)
	{
		KeyItem keyItem = new KeyItem();
		try
		{
			String line = reader.readLine();
			if(line == null)
				return null;
			keyItem.setItemID(line);
			keyItem.setItemName(reader.readLine());
			keyItem.setItemType(reader.readLine());
			
			//reads description
			line = reader.readLine();
			ArrayList<String> itemDescList = new ArrayList<String>(); 
			String[] temp = null;
			itemDescList.add(line);
			temp = new String[itemDescList.size()];
			int i = 0;
			for(String descLine : itemDescList)
				temp[i++] = descLine;
			keyItem.setItemDesc(temp);
			
			//reads location(s)
			String data = reader.readLine();
			String[] location = data.split("/",-2);
			ArrayList<String> locationList = new ArrayList<>();
			for(String a : location)
				locationList.add(a);
			keyItem.setItemLocation(locationList);
			
			/*-------------------------------------------------------*/
			
			//reads associated monster
			while(true)
			{
				line = reader.readLine();
				if(line == null || line.equals(""))
					break;
				line = line.trim();
				int colon = line.indexOf(":");
				keyItem.setAssociatedMonster(line.substring(colon+1).trim());
			}
		}catch (IOException ex)
		{
			ex.getMessage();
		}catch (NumberFormatException ex)
		{
			ex.getMessage();
		}
		
		return keyItem;
	}

	//getter and setters
	public String getAssociatedMonster()
	{
		return associatedMonster;
	}

	public void setAssociatedMonster(String associatedMonster)
	{
		this.associatedMonster = associatedMonster;
	}

}
