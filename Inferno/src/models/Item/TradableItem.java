package models.Item;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class TradableItem extends Item
{
	private String NPC;
	
	public TradableItem()
	{
		
	}

	public TradableItem(String _itemID, String _itemName, String _itemType, String[] _itemDesc,
			ArrayList<String> _itemLocation, String _NPC)
	{
		super(_itemID, _itemName, _itemType, _itemDesc, _itemLocation);
		this.NPC = _NPC;
	}

	public static TradableItem readTradableItem(BufferedReader reader)
	{
		TradableItem tradableItem = new TradableItem();
		try
		{
			String line = reader.readLine();
			if(line == null)
				return null;
			tradableItem.setItemID(line);
			tradableItem.setItemName(reader.readLine());
			tradableItem.setItemType(reader.readLine());
			
			//reads description
			line = reader.readLine();
			ArrayList<String> itemDescList = new ArrayList<String>(); 
			String[] temp = null;
			itemDescList.add(line);
			temp = new String[itemDescList.size()];
			int i = 0;
			for(String descLine : itemDescList)
				temp[i++] = descLine;
			tradableItem.setItemDesc(temp);
			
			//reads location(s)
			String data = reader.readLine();
			String[] location = data.split("/",-2);
			ArrayList<String> locationList = new ArrayList<>();
			for(String a : location)
				locationList.add(a);
			tradableItem.setItemLocation(locationList);
			
			/*-------------------------------------------------------*/
			
			//reads NPC's id
			while(true)
			{
				line = reader.readLine();
				if(line == null || line.equals(""))
					break;
				line = line.trim();
				int colon = line.indexOf(":");
				tradableItem.NPC = line.substring(colon+1).trim();
			}
		}catch (IOException ex)
		{
			ex.getMessage();
		}catch (NumberFormatException ex)
		{
			ex.getMessage();
		}
		
		return tradableItem;
	}
	
	//getter
	public String getNPC()
	{
		return NPC;
	}

}
